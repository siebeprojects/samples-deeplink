package com.siebeprojects.samples.deeplink;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

/**
 * Base class for tests
 */
public abstract class AbstractTest {

    public final static String PACKAGENAME = "com.siebeprojects.samples.deeplink";
    public final static int TIMEOUT = 5000;

    public void clickButtonInWebPage(final String packageName, final String buttonId) {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiObject2 uiObject = uiDevice.wait(Until.findObject(By.res(buttonId)), TIMEOUT);
        uiObject.wait(Until.enabled(true), TIMEOUT);
        uiObject.click();
    }

    public void waitForAppRelaunch(final String packageName) {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        uiDevice.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT);
    }
}
