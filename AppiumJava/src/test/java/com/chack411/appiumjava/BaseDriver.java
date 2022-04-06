package com.chack411.appiumjava;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class BaseDriver {
    public static EnhancedAndroidDriver<MobileElement> driver;
    // private static AppiumDriverLocalService service;

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Before
    public void setUp() throws Exception {
        // service = AppiumDriverLocalService.buildDefaultService();
        // service.start();
        // if (service == null || !service.isRunning()) {
        //     throw new AppiumServerHasNotBeenStartedLocallyException(
        //             "An appium server node is not started!");
        // }

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../MauiAppDemo1/bin/Release/net6.0-android");
        File app = new File(appDir.getCanonicalPath(), "com.companyname.mauiappdemo1-Signed.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = Factory.createAndroidDriver(url, capabilities);
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.label("Stopping App");
            driver.quit();
        }
        // if (service != null) {
        //     service.stop();
        // }
    }
}
