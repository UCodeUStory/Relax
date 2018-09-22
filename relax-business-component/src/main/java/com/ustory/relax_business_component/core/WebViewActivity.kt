package com.ustory.relax_business_component.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import com.ustory.relax_business_component.R


/**
 * @ Author: qiyue (ustory)
 * @ Email: qiyuekoon@foxmail.com
 * @ Data:2016/3/11
 */
class WebViewActivity : Activity() {

    private var webview: WebView? = null
    private var webviewPb: ProgressBar? = null


    private// return IntentUtils.getStringExtra(this.getIntent(), EXTRA_URL);
    // return "http://www.jianshu.com/c/5139d555c94d";
    val url: String
        get() = this.intent.getStringExtra(EXTRA_URL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webview = findViewById(R.id.webview) as WebView
        webviewPb = findViewById(R.id.webview_pb) as ProgressBar
        setWindowStatusBarColor(this, R.color.github_title)
        initCreateData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun enableCustomClients() {
        this.webview!!.webViewClient = DemoWebViewClient()
        this.webview!!.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                this@WebViewActivity.webviewPb!!.progress = progress
                setProgress(progress * PROGRESS_RATIO)
                if (progress >= 80) {
                    //                    WebViewActivity.this.webviewPb.setVisibility(View.GONE);
                } else {
                    this@WebViewActivity.webviewPb!!.visibility = View.VISIBLE
                }
            }
        }
    }

    internal inner class DemoWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return if (url.startsWith("http:") || url.startsWith("https:")) {
                false
            } else true
        }
    }

    protected fun initCreateData() {
        this.enableCustomClients()

        webview!!.settings.javaScriptCanOpenWindowsAutomatically = true//设置js可以直接打开窗口，如window.open()，默认为false
        webview!!.settings.javaScriptEnabled = true//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webview!!.settings.setSupportZoom(true)//是否可以缩放，默认true
        webview!!.settings.builtInZoomControls = true//是否显示缩放按钮，默认false
        webview!!.settings.useWideViewPort = true//设置此属性，可任意比例缩放。大视图模式
        webview!!.settings.loadWithOverviewMode = true//和setUseWideViewPort(true)一起解决网页自适应问题
        webview!!.settings.setAppCacheEnabled(true)//是否使用缓存
        webview!!.settings.domStorageEnabled = true//DOM Storage
        webview!!.settings.textSize = WebSettings.TextSize.NORMAL

        this.webview!!.loadUrl(this.url)

        val tvTitle = findViewById(R.id.tv_title) as TextView
        val titleStr = intent.getStringExtra(EXTRA_TITLE)
        if (titleStr != null) {
            tvTitle.text = titleStr
        } else {
            tvTitle.text = getString(R.string.app_name)
        }
    }

    companion object {
        private val PROGRESS_RATIO = 1000
        val EXTRA_URL = "toUrl"
        val EXTRA_TITLE = "title"


        fun setWindowStatusBarColor(activity: Activity, colorResId: Int) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val window = activity.window
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor = activity.resources.getColor(colorResId)

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        /**
         * @param context    Any context
         * @param url        A valid url to navigate to
         * @param titleResId A String resource to display as the title
         */
        @JvmOverloads
        fun toUrl(context: Context, url: String, titleResId: Int = android.R.string.untitled) {
            toUrl(context, url, context.getString(titleResId))
        }

        /**
         * @param context Any context
         * @param url     A valid url to navigate to
         * @param title   A title to display
         */
        fun toUrl(context: Context, url: String, title: String) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            context.startActivity(intent)
        }

        /**
         * @param context context
         * @param url     url
         * @param title   title
         * @param type    type
         */
        fun toUrl(context: Context, url: String, title: String, type: String) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            context.startActivity(intent)
        }
    }


}
