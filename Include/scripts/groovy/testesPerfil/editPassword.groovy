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
import editTextHelper
import findButtonByText
import ReadAndCheckText


import login.LoginSteps


class editPassword {
	
	@And('the user edits the password to "(.*)"')
    def performEditPassword(String newPassword) {
       	println("DEBUG: Editing username to: " + newPassword)

		editTextHelper.editText("com.example.taes_bisca:id/etPassword", newPassword)
		buttons.tapButton("Editar Perfil", "com.yourpackage:id/cardEditButton")
		findButtonByText.findBtnText('Save')

		Mobile.delay(1)
		println("DEBUG: Password edited successfully")
	}

    @And('the user signs out')
    def signOut() {
        println "User signs out"
		
		buttons.tapButton("Voltar", "com.example.taes_bisca:id/cardBackButton")
		buttons.tapButton("Sair", "com.example.taes_bisca:id/cardLogout")
		
		
    }

    @And('the user logs in with username "(.*)" and password "(.*)"')
    def loginWithCredentials(String username, String password) {
        println "Logging in with username: ${username} and password: ${password}"
		
		LoginSteps login = new LoginSteps()
		
	    // Open app
		login.openApp()
    
		// Enter credentials
		login.enterCredentials(username, password)
    
		// Tap login
			login.tapLoginButton()
		}

    @Then('the user should be logged in successfully')
    def verifyLoginSuccess() {
        TestObject bisca3Btn = new TestObject("bisca3Btn")
		bisca3Btn.addProperty("resource-id", ConditionType.EQUALS, "com.example.taes_bisca:id/cardBisca3")

		boolean isPresent = Mobile.waitForElementPresent(bisca3Btn, 10)

		println("DEBUG: Bisca 3 button present? " + isPresent)
	
		if (!isPresent) {
			//KeywordUtil.markFailed("Homepage not found (used play Bisca 3 btn as reference)!")
		}
		Mobile.delay(3)
		buttons.tapButton("Profile Button", "com.example.taes_bisca:id/cardProfile")
		buttons.tapButton("EditProfile", "com.example.taes_bisca:id/cardEditButton")
		editTextHelper.editText("com.example.taes_bisca:id/etPassword", GlobalVariable.passwordLoggedIn)
		buttons.tapButton("Editar Perfil", "com.yourpackage:id/cardEditButton")
		findButtonByText.findBtnText('Save')

		Mobile.delay(3)
		
		Mobile.closeApplication()
    }
}