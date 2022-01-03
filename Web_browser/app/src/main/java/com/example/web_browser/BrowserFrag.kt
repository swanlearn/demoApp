package com.example.web_browser

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import android.view.View.OnLongClickListener
import android.webkit.DownloadListener
import android.webkit.ValueCallback
import java.util.concurrent.Callable


open class BrowserFrag:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var web:WebView
    lateinit var text: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.tab1,container,false)
        web = view.findViewById<WebView>(R.id.web_view)
        val btn = view.findViewById<MaterialButton>(R.id.refb)
        text = view.findViewById<EditText>(R.id.ref)
        val mWebViewClient: WebViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                text.setText(url)
                super.onPageFinished(view, url)
            }
            

        }
        web.settings.javaScriptEnabled = true
        web.settings.javaScriptCanOpenWindowsAutomatically = true
        web.settings.useWideViewPort = true
        web.settings.loadWithOverviewMode=true
        web.settings.allowContentAccess=true
        web.webViewClient = mWebViewClient
        w
        btn.setOnClickListener {
            web.loadUrl(text.text.toString())
        }
        web.setOnLongClickListener {
            var te = web.hitTestResult
            val result=(view as WebView).hitTestResult
            true        }
        web.setDownloadListener(DownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
        history.add(data(url))
        })
        return view
    }


    open class webcline() :WebViewClient() {
        override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
            super.doUpdateVisitedHistory(view, url, isReload)
        }
   }


}