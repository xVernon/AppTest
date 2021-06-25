package com.example.apptest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class ExampleInstrumentedTest {

    AndroidDriver<AndroidElement> ad;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability("platformName","android");
        dc.setCapability("appPackage", "com.citynav.jakdojade.pl.android");
        dc.setCapability("appActivity",".main.MainActivity");

        ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
    }

    @Test
    public void useAppContext() throws InterruptedException {

        System.out.println("Start Testu");

        ad.navigate().back();

        TimeUnit.SECONDS.sleep(3);
        MobileElement el1 = (MobileElement) ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout");
        el1.click();

        TimeUnit.SECONDS.sleep(3);
        MobileElement el2 = ad.findElementById("com.citynav.jakdojade.pl.android:id/et_search_city");
        el2.click();
        el2.sendKeys("Warszawa");

        TimeUnit.SECONDS.sleep(5);
        MobileElement el3 = (MobileElement) ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        el3.click();

        TimeUnit.SECONDS.sleep(5);
        MobileElement el4 = (MobileElement) ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout");
        el4.click();

        ad.navigate().back();

        TimeUnit.SECONDS.sleep(5);
        MobileElement el5 = (MobileElement) ad.findElementById("com.android.permissioncontroller:id/permission_deny_button");
        el5.click();

        TimeUnit.SECONDS.sleep(3);
        MobileElement el6 = (MobileElement) ad.findElementByAccessibilityId("Schedules");
        el6.click();

        TimeUnit.SECONDS.sleep(3);
        MobileElement el7 = (MobileElement) ad.findElementById("com.citynav.jakdojade.pl.android:id/act_wl_search_input");
        el7.click();

        TimeUnit.SECONDS.sleep(3);
        el7.sendKeys("501");
        MobileElement el8 = (MobileElement) ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[3]");
        el8.click();

        TimeUnit.SECONDS.sleep(3);

        AndroidElement departure = ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");

        Assert.assertEquals(departure.getText(),"STEGNY");

        System.out.println("Koniec Testu");
        TimeUnit.SECONDS.sleep(3);

    }

    @AfterTest
    public void teardown(){
       ad.quit();
    }
}