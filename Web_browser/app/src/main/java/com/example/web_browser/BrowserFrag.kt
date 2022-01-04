package com.example.web_browser

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Shader
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
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.web_browser.viewmodels.activityviewmodel
import com.google.android.material.tabs.TabLayout
import java.util.concurrent.Callable


open class BrowserFrag():Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var text: EditText
    val share : viewmodels.glob by activityViewModels()
    lateinit var web:WebView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.tab1,container,false)
        var  mWebViewClient: WebViewClient
        val btn = view.findViewById<MaterialButton>(R.id.refb)
        val Web = view.findViewById<WebView>(R.id.web_view)
        text = view.findViewById<EditText>(R.id.ref)
        requireActivity().findViewById<TabLayout>(R.id.tab_view).visibility = View.VISIBLE
        web = view.findViewById<WebView>(R.id.web_view)
        web!!.settings.javaScriptEnabled = true
        web!!.settings.javaScriptCanOpenWindowsAutomatically = true
        web!!.settings.useWideViewPort = true
        web!!.settings.loadWithOverviewMode=true
        web!!.settings.allowContentAccess=true
        web!!.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    text.setText(url)
                    super.onPageFinished(view, url)
                }
            }
        if(share.bund.value !=null) web.restoreState(share.bund.value!!)
        web!!.setOnLongClickListener {
                var te = web!!.hitTestResult
                val result = (web as WebView).hitTestResult
                if(result.type == 7){
                    Thread(Runnable {
                        var nametext =""
                        for (i in (result.extra.toString().length-1) downTo 0){
                            if(result.extra.toString()[i]=='/') {
                                for (j in i+1 .. (result.extra.toString().length-1)){
                                    nametext += result.extra.toString()[j]
                                    if(result.extra.toString()[j]=='/')break
                                }
                                break
                            }
                        }
                        nametext = nametext.replace("%20",".")
                        share.history.value!!.add(data(result.extra.toString(),nametext))
                    }).start()
                    share.link.value = result.extra.toString()
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frag_view,PlayFrag()).addToBackStack("ply").commit()
                }
                true}
        web!!.setDownloadListener(DownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
           Thread(Runnable {
               var nametext =""
               var uri = Uri.parse(url)
               for (i in (uri.toString().length-1) downTo 0){
                   if(uri.toString()[i]=='/') {
                       for (j in i+1 .. (uri.toString().length-1)){
                           nametext += uri.toString()[j]
                           if(uri.toString()[j]=='/')break
                       }
                       break
                   }
               }
               nametext = nametext.replace("%20",".")
               share.history.value!!.add(data(url,nametext))
           }).start()
        })

        btn.setOnClickListener {
        web!!.loadUrl(text.text.toString())
        }

        return view
    }

    override fun onDestroy() {
        Log.d("Tag","DIS")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d("Tag","DISV")
        super.onDestroyView()
    }
    override fun onPause() {
        Log.d("Tag","Pau")
        onSaveInstanceState()
        web.saveState(share.bund.value!!)
        super.onPause()
    }

    private fun onSaveInstanceState() {

    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("Tag","Ins")
        web!!.saveState(outState)
        share.bund.value = outState
        super.onSaveInstanceState(outState)
    }


}