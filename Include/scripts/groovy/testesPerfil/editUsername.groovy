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

class editUsername {

	
	@And("the user navigates to the edit profile page")
	def userNavigatesToProfile() {
		// Tap the "Editar Perfil" button using your helper
		buttons.tapButton("EditProfile", "com.example.taes_bisca:id/cardEditButton")

		
	}
	
	@And("the user edits the username to {string}")
	def performEditUsername(String newUsername) {
		println("DEBUG: Editing username to: " + newUsername)


		editTextHelper.editText("com.example.taes_bisca:id/etUsername", newUsername)
		buttons.tapButton("Editar Perfil", "com.yourpackage:id/cardEditButton")
		findButtonByText.findBtnText('Save')

		Mobile.delay(1)
		println("DEBUG: Username edited successfully")
	}

	

	@Then("the updated username {string} is displayed in the profile")
	def verifyUpdatedUsername(String expectedUsername) {
		println("DEBUG: Verifying that the username is now: " + expectedUsername)
		Mobile.delay(1)
		println("DEBUG: Verification complete")
		
		boolean isCorrect = ReadAndCheckText.checkText(expectedUsername, "com.example.taes_bisca:id/etUsername")
		
		
		
		buttons.tapButton("EditProfile", "com.example.taes_bisca:id/cardEditButton")
		editTextHelper.editText("com.example.taes_bisca:id/etUsername", "correctUser")
		buttons.tapButton("Editar Perfil", "com.yourpackage:id/cardEditButton")
		findButtonByText.findBtnText('Save')
		
		if(!isCorrect) { KeywordUtil.markFailed("Username verification FAILED! Expected: " + expectedUsername)}
		Mobile.closeApplication()
	}
}