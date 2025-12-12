package testesPartidas
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
import findButtonByText
import checkPresence
class partida3 {
    
	@And("the user taps the Iniciar Bisca 3 button")
	def tapIniciarBisca3() {
		buttons.tapButton("Bisca 3", "com.example.taes_bisca:id/cardBisca3")
		
		TestObject yesButton = new TestObject("dialogYes")
		yesButton.addProperty("resource-id", ConditionType.EQUALS, "android:id/button1")
	
		boolean isPresent = Mobile.waitForElementPresent(yesButton, 5)
		println("DEBUG: 'Yes' button present? " + isPresent)
	
		if (isPresent) {
			Mobile.tap(yesButton, 10)
			println("DEBUG: 'Yes' button tapped successfully")
		} else {
			println("DEBUG: No 'Yes' button detected (no dialog shown)")
		}
	}
	
	@And("the user taps the Start Next Round button")
	def tapStartNextRound() {
		buttons.tapButton("Start Next Round", "com.example.taes_bisca:id/card_start_round")

	}

    @Then("the user verifies that a game started")
    def verifyGameStarted() {
        println("Verified that the game started")
        boolean present = checkPresence.isElementPresent("com.example.taes_bisca:id/tv_turn_indicator", "Turn Indicator")

		if(!present) {
			KeywordUtil.markFailed("Test failed: game screen not found")
		}
		
		
		Mobile.closeApplication()
    }
}