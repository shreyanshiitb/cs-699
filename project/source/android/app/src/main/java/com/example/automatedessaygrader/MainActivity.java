package com.example.automatedessaygrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//this is the very first screen that appears when the app is opened


        Toast toast = new Toast(getApplicationContext());
        ImageView view = new ImageView(getApplicationContext());
        view.setImageResource(R.drawable.android);
        view.setMaxHeight(40);
        view.setMaxWidth(40);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        WebView myWebView = (WebView) findViewById(R.id.browser); //Creating a new Webview
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//Sets the chrome handler. This is an implementation of WebChromeClient for use in handling Javascript dialogs, favicons, titles, and the progress.
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl("http://codigos.herokuapp.com");//this loads the homepage of the website

    }
}
