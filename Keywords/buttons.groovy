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

public class buttons {

	def tapButton(String buttonName, String resourceId) {
		println("DEBUG: Step reached - tapping ${buttonName} button")
		
		// Create a TestObject dynamically
		TestObject button = new TestObject(buttonName)
		button.addProperty("resource-id", ConditionType.EQUALS, resourceId)
		
		// Wait for the element to be present
		boolean isPresent = Mobile.waitForElementPresent(button, 10)
		println("DEBUG: ${buttonName} button present? " + isPresent)
		
		if (isPresent) {
			// Tap the button
			Mobile.tap(button, 10)
			println("DEBUG: ${buttonName} button tapped successfully")
		} else {
			println("ERROR: ${buttonName} button not found!")
		}
	
	}
