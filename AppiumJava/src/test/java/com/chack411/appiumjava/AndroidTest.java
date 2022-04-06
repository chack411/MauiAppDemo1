package com.chack411.appiumjava;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AndroidTest extends BaseDriver
{
    @Test
    public void TestShouldFindElementsByClassName()
    {
        List<WebElement> elements = driver.findElementsByClassName("android.widget.FrameLayout");
        assertEquals(5, elements.size());

        List<WebElement> elementsLabel = driver.findElementsByClassName("android.widget.TextView");
        assertEquals(3, elementsLabel.size());
        assertEquals("Hello, World!", elementsLabel.get(0).getText());
        assertEquals("Welcome to .NET Multi-platform App UI", elementsLabel.get(1).getText());
        assertEquals("Current count: 0", elementsLabel.get(2).getText());

        List<WebElement> elementsButton = driver.findElementsByClassName("android.widget.Button");
        assertEquals(1, elementsButton.size());
        assertEquals("Click me", elementsButton.get(0).getText());
    }

    @Test
    public void TestCounterButton()
    {
        List<WebElement> elements = driver.findElementsByClassName("android.widget.Button");
        assertEquals(1, elements.size());
        elements.get(0).click();

        List<WebElement> elementsLabel = driver.findElementsByClassName("android.widget.TextView");
        assertEquals(3, elementsLabel.size());
        assertEquals("Current count: 1", elementsLabel.get(2).getText());
    }
}
