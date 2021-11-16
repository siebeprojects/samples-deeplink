package com.siebeprojects.samples.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * The Activity that is launched after the browser is redirecting to the deep link URL.
 */
public class RedirectActivity extends Activity {

    public static Uri resultUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);

        final Intent intent = getIntent();
        resultUri = (intent == null) ? null : intent.getData();
        finish();
    }
}