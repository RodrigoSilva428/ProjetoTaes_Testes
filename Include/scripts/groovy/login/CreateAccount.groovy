package login
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



class CreateAccount {


	@Given("the user taps the sign up button")
	def tapSignUpButton() {
		println("DEBUG: Step reached - tapping sign up button")

		// Locate Sign Up button (Back to Login is separate)
		TestObject signUpBtn = new TestObject("cardSignUpButton")
		signUpBtn.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/cardSignUpButton")


		if (Mobile.waitForElementPresent(signUpBtn, 10)) {
			Mobile.tap(signUpBtn, 10)
			println("DEBUG: Sign Up button tapped")
		} else {
			KeywordUtil.markFailed("Sign Up button not found")
		}
	}

	@When("the user enters a new unique username")
	def enterUniqueUsername() {

		// Generate a unique username
		String uniqueUsername = "user" + System.currentTimeMillis()
		GlobalVariable.createdUsername = uniqueUsername
		println("DEBUG: Entering unique username: " + uniqueUsername)

		// Locate the username EditText
		TestObject usernameField = new TestObject("etSignUpUsername")
		usernameField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etSignUpUsername")

		if (Mobile.waitForElementPresent(usernameField, 10)) {
			Mobile.setText(usernameField, uniqueUsername, 10)
			println("DEBUG: Username entered successfully")
		} else {
			Mobile.closeApplication()
			KeywordUtil.markFailed("Username field not found")
		}
	}

	@When("the user enters password {string}")
	def enterPassword(String password) {
		println("DEBUG: Entering password: " + password)

		// Password field
		TestObject passwordField = new TestObject("etSignUpPassword")
		passwordField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etSignUpPassword")

		if (Mobile.waitForElementPresent(passwordField, 10)) {
			Mobile.setText(passwordField, password, 10)
			println("DEBUG: Password entered successfully")
		} else {
			Mobile.closeApplication()
			KeywordUtil.markFailed("Password field not found")
		}

		// Confirm password field
		TestObject confirmPasswordField = new TestObject("etSignUpConfirmPassword")
		confirmPasswordField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etSignUpConfirmPassword")

		if (Mobile.waitForElementPresent(confirmPasswordField, 10)) {
			Mobile.setText(confirmPasswordField, password, 10)
			println("DEBUG: Confirm password entered successfully")
		} else {
			Mobile.closeApplication()
			KeywordUtil.markFailed("Confirm password field not found")
		}
	}


	@When("the user taps the create account button")
	def tapCreateAccount() {
		TestObject submitBtn = new TestObject("cardSignUpSubmit")
		submitBtn.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/cardSignUpSubmit")

		if (Mobile.waitForElementPresent(submitBtn, 10)) {
			Mobile.tap(submitBtn, 10)
			println("DEBUG: Create Account button tapped")
		} else {
			Mobile.closeApplication()
			KeywordUtil.markFailed("Create Account button not found")
		}
	}

	@Then("the account is successfully created")
	def accountCreated() {
		// Verify account creation was successful
		// Create a TestObject for the login button
		TestObject loginBtn = new TestObject("cardLoginButton")
		loginBtn.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/cardLoginButton")

		// Wait for the element to appear (timeout 10 seconds)
		if (Mobile.waitForElementPresent(loginBtn, 10)) {
			println("DEBUG: Account created successfully - Login button is visible")
		} else {
			KeywordUtil.markFailed("Account creation failed - Login button not found")
		}
	}

	@Given("the same username was already created")
	def useExistingUsername() {
		// Reuse the stored username for testing duplicate creation
		println("DEBUG: Reusing existing username: " + GlobalVariable.createdUsername)
	}

	@When("the user enters that username")
	def enterStoredUsername() {
		// Locate the username field
		TestObject usernameField = new TestObject("etSignUpUsername")
		usernameField.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/etSignUpUsername")

		if (Mobile.waitForElementPresent(usernameField, 10)) {
			Mobile.setText(usernameField, GlobalVariable.createdUsername, 10)
			println("DEBUG: Entered existing username successfully")
		} else {
			KeywordUtil.markFailed("Username field not found")
		}
	}

	@Then('I verify account creation wasnt sucessfull')
	def duplicateError() {
		// Verify the duplicate account error message appears
		TestObject loginBtn = new TestObject("cardLoginButton")
		loginBtn.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/cardLoginButton")

		// Wait for the element to appear (timeout 10 seconds)
		if (!Mobile.waitForElementPresent(loginBtn, 10)) {
			println("DEBUG: Account creation failed - Login button is not visible")
		} else {
			KeywordUtil.markFailed("Account creation succeeded - error")
		}



		Mobile.closeApplication()
	}
}