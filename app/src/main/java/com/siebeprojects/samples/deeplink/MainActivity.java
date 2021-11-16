package com.siebeprojects.samples.deeplink;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.manualdeeplinkbutton);
        button.setOnClickListener(v -> manualDeepLink());

        button = findViewById(R.id.autodeeplinkbutton);
        button.setOnClickListener(v -> autoDeepLink());

        resultView = findViewById(R.id.resultview);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (RedirectActivity.resultUri != null) {
            resultView.setVisibility(View.VISIBLE);
            RedirectActivity.resultUri = null;
        }
    }

    private void manualDeepLink() {
        resultView.setVisibility(View.GONE);
        Uri uri = Uri.parse("https://siebeprojects.com/test/manualdeeplink.html?appId=com.siebeprojects.samples.deeplink");
        ChromeCustomTabs.open(this, uri);
    }

    private void autoDeepLink() {
        resultView.setVisibility(View.GONE);
        Uri uri = Uri.parse("https://siebeprojects.com/test/autodeeplink.html?appId=com.siebeprojects.samples.deeplink");
        ChromeCustomTabs.open(this, uri);
    }
}