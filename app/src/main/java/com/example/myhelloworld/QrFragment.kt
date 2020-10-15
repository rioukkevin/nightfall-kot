package com.example.myhelloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.budiyev.android.codescanner.*
import com.google.zxing.BarcodeFormat

class QrFragment : Fragment() {

    /**
     * Code scanner ref
     */
    private lateinit var codeScanner: CodeScanner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_qr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()


        //Configure scanner
        codeScanner = CodeScanner(activity, scannerView)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.setAutoFocusInterval(100)
        codeScanner.scanMode = ScanMode.SINGLE //Get just first qr code
        codeScanner.formats = listOf(BarcodeFormat.QR_CODE) //To react just for QR Code
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                Toast.makeText(activity, it.text, Toast.LENGTH_LONG).show()
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}
