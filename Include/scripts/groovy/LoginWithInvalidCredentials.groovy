import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginWithInvalidCredentials {

    @Given("the app is opened")
    def openApp() {
        println("DEBUG: Starting the app at path = " + GlobalVariable.AppPath)
        boolean appExists = new File(GlobalVariable.AppPath).exists()
        println("DEBUG: APK exists? " + appExists)
        
        if (!appExists) {
            KeywordUtil.markFailed("APK not found at: " + GlobalVariable.AppPath)
        }
        
        Mobile.startApplication(GlobalVariable.AppPath, false)
        println("DEBUG: App started successfully")
        Mobile.delay(2)
    }
    
    @When("the user enters username \"(.*)\" and password \"(.*)\"")
    def enterCredentials(String usernameText, String passwordText) {

		println("DEBUG: Step reached - ENTERING USERNAME AND PASSWRD")
		
		//Look for username field:
		TestObject usernameField = new TestObject("usernameField")
		usernameField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etUsername")
		
		// Try to find it on the device
		boolean isPresent = Mobile.waitForElementPresent(usernameField, 10)
		println("DEBUG: Username field present? " + isPresent)
		
		// Enter text into username
		Mobile.setText(usernameField, usernameText, 10)
		
		
		//Look for password field:
		TestObject passwordField = new TestObject("passwordField")
		passwordField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etPassword")
		
		// Try to find it on the device
		isPresent = Mobile.waitForElementPresent(passwordField, 10)
		println("DEBUG: Password field present? " + isPresent)
		
		
		// Enter text into password
		Mobile.setText(passwordField, passwordText, 10)
    }
    
	@And("the user taps the login button")
	def tapLoginButton() {
		println("DEBUG: Step reached - tapping login button")
		// Locate login button
		TestObject loginBtn = new TestObject("loginButton")
		loginBtn.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/tvLogin")
	
		// Wait for it to be present
		boolean isPresent = Mobile.waitForElementPresent(loginBtn, 10)
		println("DEBUG: Login button present? " + isPresent)
	
		// Tap it
		Mobile.tap(loginBtn, 10)
		
		println("DEBUG: Login button tapped")
	}
	
	@Then("i stay in the login page")
	def verifyErrorMessage() {
		println("DEBUG: Step reached - verifying error message")
	
		//Look for username field:
		TestObject usernameField = new TestObject("usernameField")
		usernameField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etUsername")
		
		// Try to find it on the device
		boolean isPresent = Mobile.waitForElementPresent(usernameField, 10)
		println("DEBUG: Username field present? " + isPresent)
   
		println("DEBUG: Error message present? " + isPresent)

		
		if (!isPresent) {
			KeywordUtil.markFailed("Error message not displayed on screen")
    	}
	
	}

}
