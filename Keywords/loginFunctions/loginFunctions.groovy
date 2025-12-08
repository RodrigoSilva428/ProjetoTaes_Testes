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
			
			println("DEBUG: App path = " + GlobalVariable.AppPath)
			println("DEBUG: Checking APK exists: " + new File(GlobalVariable.AppPath).exists())
			
			String appPath = GlobalVariable.AppPath
			Mobile.startApplication(appPath, false)
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
