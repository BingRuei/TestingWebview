package com.ray.test.testingwebview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    private WebView webView;
    private EditText editText;
    private Button button, btnBack, btnForward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("YanRay APP");

        String url = "http://www.google.com";
        String edtUrl = //"http://mrraybox.blogspot.tw/";
                    "http://www.yanray.com.tw/";

        editText = (EditText) this.findViewById(R.id.edt);
        editText.setText(edtUrl);

        button = (Button) this.findViewById(R.id.btn);
        btnBack = (Button) this.findViewById(R.id.btn_back);
        btnForward = (Button) this.findViewById(R.id.btn_forward);
        btnBack.setText("<");
        btnForward.setText(">");
        button.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnForward.setOnClickListener(this);

        webView = (WebView) this.findViewById(R.id.wv);
        WebSettings ws = webView.getSettings();
        ws.setSupportZoom(true);
        ws.setBuiltInZoomControls(true);
        ws.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        loadingWeb(url);
    }

    private void loadingWeb(String url){
        webView.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                String url = editText.getText().toString();
                loadingWeb(url);
                editText.setText(null);
                break;
            case R.id.btn_back:
                webView.goBack();
                break;
            case R.id.btn_forward:
                webView.goForward();
                break;
        }
    }
}
