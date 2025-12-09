package testesPerfil
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


import buttons
import login.LoginSteps


import com.kms.katalon.core.util.KeywordUtil

class enterPerfil {
	
	
	
    @Given("the user is logged in with username {string} and password {string}")
    def login(String username, String password) {
    
		 println("DEBUG: Starting login process")

        // Open the app
        boolean appExists = new File(GlobalVariable.AppPath).exists()
        if (!appExists) {
            KeywordUtil.markFailed("APK not found at: " + GlobalVariable.AppPath)
        }
        Mobile.startApplication(GlobalVariable.AppPath, false)
        Mobile.delay(2)

        // Enter username
        TestObject usernameField = new TestObject("usernameField")
        usernameField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etUsername")
        Mobile.setText(usernameField, username, 10)

        // Enter password
        TestObject passwordField = new TestObject("passwordField")
        passwordField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etPassword")
        Mobile.setText(passwordField, password, 10)

        // Tap login
        TestObject loginBtn = new TestObject("loginButton")
        loginBtn.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/tvLogin")
        Mobile.tap(loginBtn, 10)

        println("DEBUG: Login completed for user: " + username)
        Mobile.delay(2)
    }
	
    @When("the user navigates to the profile page")
    def navigateToProfile() {
        // Replace with navigation steps to profile
         buttons.tapButton("Profile Button", "com.example.taes_bisca:id/cardProfile")
    }

    @Then("the profile details are displayed")
    def verifyProfileDetails() {
		boolean isEditProfileVisible = CheckPresence.isElementPresent(
    	"com.example.taes_bisca:id/cardEditButton",
    	"Editar Perfil Button"
		)

		if (!isEditProfileVisible) {
			KeywordUtil.markFailed("Editar Perfil button is not visible!")
		} else {
			println("DEBUG: Editar Perfil button is visible")
		}
		
		Mobile.closeApplication()
    }
}