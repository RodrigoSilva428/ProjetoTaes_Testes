package testesCollection
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


import io.appium.java_client.android.AndroidDriver

import io.appium.java_client.AppiumBy

import buttons

class equiparAvatar {
	@When("the user navigates to the collection page")
	def navigateToCollection() {
		println("Navigating to the collection page")
		buttons.tapButton("Collection", "com.example.taes_bisca:id/cardCollection")
	}

	@And("the user selects avatar {string}")
	def selectAvatar(String AvatarName) {


		//buttons.tapButton(avatarName, "android:id/text1")

		println("Selecting avatar: ${avatarName}")
	}

	@And("the user taps the save collection button")
	def tapSaveCollection() {
		println("Tapping the save collection button")
		buttons.tapButton("Save Selection", "com.example.taes_bisca:id/cardSaveSelection")
	}

	@Then("the user confirms he has the right avatar equipped")
	def confirmAvatarEquipped() {
		println("Confirming the right avatar is equipped")
	}
}