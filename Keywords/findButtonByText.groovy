import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.AppiumBy

class findButtonByText {

    @Keyword
    static void findBtnText(String buttonText) {
        try {
            AndroidDriver driver = MobileDriverFactory.getDriver()
            String selector = "new UiSelector().className(\"android.widget.Button\").text(\"${buttonText}\")"
            driver.findElement(AppiumBy.androidUIAutomator(selector)).click()
            println "Tapped button with text: '${buttonText}'"
        } catch(Exception e) {
            println "Failed to find or tap button with text '${buttonText}': ${e.message}"
            throw e
        }
    }
}
