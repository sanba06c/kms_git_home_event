import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String newName = "Jeff"

WebUI.click(findTestObject('Object Repository/Home/Avatar'))

WebUI.click(findTestObject('Home/tab_Account settings'))

WebUI.setText(findTestObject('Home/My Account/input_Profile name'), newName)

WebUI.click(findTestObject('Home/My Account/icon_Close'))

WebUI.verifyElementVisible(findTestObject("Object Repository/Home/My Account/alert_Update successfully"))

String alertMessage = WebUI.getText(findTestObject("Object Repository/Home/My Account/alert_Update successfully")).trim()

WebUI.verifyMatch(alertMessage, "Update successfully", false)

WebUI.waitForElementNotPresent(findTestObject("Object Repository/Home/My Account/alert_Update successfully")
	, GlobalVariable.DEFAULT_TIMEOUT)

Date date = new Date();   // given date
Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance

println(calendar.get(Calendar.HOUR_OF_DAY))

String expectedGreetings = CustomKeywords.'general.Methods.greetings'(calendar.get(Calendar.HOUR_OF_DAY).toInteger()) + ", "  + newName

WebUI.verifyElementText(findTestObject('Object Repository/Home/Greetings'), expectedGreetings)