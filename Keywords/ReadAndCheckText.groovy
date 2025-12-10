import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement

class ReadAndCheckText {

	@Keyword
	static boolean checkText(String expectedText, String elementId) {
		// Get current Android driver
		AndroidDriver driver = MobileDriverFactory.getDriver()
		try {
			// Find the element by resource-id
			WebElement element = driver.findElementById(elementId)
			String actualText = element.getText()
			println "Expect: '${expectedText}', Found: '${actualText}'"
			if (actualText.equals(expectedText)) {
				println "Text matches: '${actualText}'"
				return true
			} else {
				println "Text does NOT match. Expected: '${expectedText}', Found: '${actualText}'"
				return false
			}
		} catch(Exception e) {
			println "Failed to find element with id '${elementId}': ${e.message}"
			return false
		}
	}
}
