package com.example.myhelloworld

import android.app.Activity
import android.content.ComponentName
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import java.io.UnsupportedEncodingException
import java.net.URLEncoder


class ShareFragment(activity: Activity) : Fragment() {

    private val mainActivity = activity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_share, container, false)

        // get reference to button
        val facebookShare = view?.findViewById(R.id.share_facebook) as GridLayout
        // set on-click listener
        facebookShare.setOnClickListener {
            this.shareFacebook(
                this.mainActivity,
                "Nightfall c'est trop cool !",
                "https://www.nightfallcards.fr/"
            ) }

        // get reference to button
        val twitterShare = view?.findViewById(R.id.share_twitter) as GridLayout
        // set on-click listener
        twitterShare.setOnClickListener {
            this.shareTwitter(
                this.mainActivity,
                "Nightfall c'est trop cool !",
                "https://www.nightfallcards.fr/",
                "",
            ""
            ) }

        // get reference to button
        val otherShare = view?.findViewById(R.id.share_other) as GridLayout
        // set on-click listener
        otherShare.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Nightfall c'est trop cool ! https://www.nightfallcards.fr/")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Partager avec"))
        }

        return view

    }

    /**
     * Share on Facebook. Using Facebook app if installed or web link otherwise.
     *
     * @param activity activity which launches the intent
     * @param text     not used/allowed on Facebook
     * @param url      url to share
     */
    private fun shareFacebook(activity: Activity, text: String?, url: String) {
        var facebookAppFound = false
        var shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, url)
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(url))
        val pm = activity.packageManager
        val activityList = pm.queryIntentActivities(shareIntent, 0)
        for (app in activityList) {
            if (app.activityInfo.packageName.contains("com.facebook.katana")) {
                val activityInfo = app.activityInfo
                val name =
                    ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name)
                shareIntent.addCategory(Intent.CATEGORY_LAUNCHER)
                shareIntent.component = name
                facebookAppFound = true
                break
            }
        }
        if (!facebookAppFound) {
            val sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=$url"
            shareIntent = Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl))
        }
        activity.startActivity(shareIntent)
    }

    /**
     * Share on Twitter. Using Twitter app if installed or web link otherwise.
     *
     * @param activity activity which launches the intent
     * @param text     text to share
     * @param url      url to share
     * @param via      twitter username without '@' who shares
     * @param hashtags hashtags for tweet without '#' and separated by ','
     */
    private fun shareTwitter(activity: Activity, text: String, url: String, via: String, hashtags: String) {
        val tweetUrl = StringBuilder("https://twitter.com/intent/tweet?text=")
        tweetUrl.append(if (TextUtils.isEmpty(text)) urlEncode(" ") else urlEncode(text))
        if (!TextUtils.isEmpty(url)) {
            tweetUrl.append("&url=")
            tweetUrl.append(urlEncode(url))
        }
        if (!TextUtils.isEmpty(via)) {
            tweetUrl.append("&via=")
            tweetUrl.append(urlEncode(via))
        }
        if (!TextUtils.isEmpty(hashtags)) {
            tweetUrl.append("&hastags=")
            tweetUrl.append(urlEncode(hashtags))
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl.toString()))
        val matches = activity.packageManager.queryIntentActivities(intent, 0)
        for (info in matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                intent.setPackage(info.activityInfo.packageName)
            }
        }
        activity.startActivity(intent)
    }

    /**
     * Convert to UTF-8 text to put it on url format
     *
     * @param s text to be converted
     * @return text on UTF-8 format
     */
    private fun urlEncode(s: String): String? {
        return try {
            URLEncoder.encode(s, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            Log.wtf("wtf", "UTF-8 should always be supported", e)
            throw RuntimeException("URLEncoder.encode() failed for $s")
        }
    }

}
