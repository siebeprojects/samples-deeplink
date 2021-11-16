package com.siebeprojects.samples.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;

public class ChromeCustomTabs {

    private final static String PACKAGE_NAME = "com.android.chrome";

    /**
     * Open the url in the custom chrome tab
     *
     * @param context in which the browser window should be opened
     * @param uri to be opened in the external browser window
     */
    public static void open(Context context, Uri uri) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.intent.setPackage(PACKAGE_NAME);
        customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK |
            Intent.FLAG_ACTIVITY_NEW_TASK |
            Intent.FLAG_ACTIVITY_CLEAR_TASK |
            Intent.FLAG_ACTIVITY_NO_HISTORY);
        customTabsIntent.launchUrl(context, uri);
    }
}
