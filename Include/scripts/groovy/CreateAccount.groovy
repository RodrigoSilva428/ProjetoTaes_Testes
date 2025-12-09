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
        // Navigate to the sign up / create account screen
    }

    @When("the user enters a new unique username")
    def enterUniqueUsername() {
        // Generate a unique username and enter it in the username field
    }

    @When("the user enters password {string}")
    def enterPassword(String password) {
        // Enter the provided password in the password field
    }

    @When("the user taps the create account button")
    def tapCreateAccount() {
        // Tap the button to submit the new account
    }

    @Then("the account is successfully created")
    def accountCreated() {
        // Verify account creation was successful
    }

    @Given("the same username was already created")
    def useExistingUsername() {
        // Reuse the stored username for testing duplicate creation
    }

    @When("the user enters that username")
    def enterStoredUsername() {
        // Enter the previously created username
    }

    @Then('I see an error "Account already exists"')
    def duplicateError() {
        // Verify the duplicate account error message appears
        Mobile.closeApplication()
    }
}

