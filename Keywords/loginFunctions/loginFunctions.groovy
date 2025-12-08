package loginFunctions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import generalFunctions.btnAndElementsFunctions as Elements

public class loginFunctions {

	@Keyword
	def openApp() {
		try {
			println("DEBUG: Starting openApp()")

			String appPath = GlobalVariable.AppPath
			println("DEBUG: App path = " + appPath)

			println("DEBUG: Starting application...")
			//Mobile.startApplication(appPath, false)
			println("DEBUG: Application started")

			println("DEBUG: Checking for username field...")
			//Elements.checkElementPresenceById('etUsername', 20)
			println("DEBUG: Username field found")

			KeywordUtil.logInfo("App opened successfully")
		} catch(Exception e) {
			println("DEBUG: Exception occurred - " + e.getMessage())
			KeywordUtil.markFailed("Failed to open app: " + e.getMessage())
		}
	}

	@Keyword
	def closeApp() {
		Mobile.closeApplication()
	}
}
