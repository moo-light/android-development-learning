package com.example.binhnt_lab_premission_1;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webview);
        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript (optional)
        webView.setWebViewClient(new WebViewClient()); // To stay within the app

        String url = "https://lms-hcmuni.fpt.edu.vn/course/view.php?id=1190"; // Replace with your desired URL
        webView.loadUrl(url);
    }
}
