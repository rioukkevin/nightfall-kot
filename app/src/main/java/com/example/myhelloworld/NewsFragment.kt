package com.example.myhelloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myhelloworld.model.News

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val news : Array<News> = arrayOf<News>( News("News 1"), News("News 2"))

        return inflater.inflate(R.layout.fragment_news,container,false)
    }
}


