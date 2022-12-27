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
import internal.GlobalVariable

import java.util.Calendar
import org.openqa.selenium.Keys as Keys

WebUI.navigateToUrl(GlobalVariable.domain + "/login")

WebUI.setText(findTestObject('Object Repository/Login/txt_username'), GlobalVariable.username)

WebUI.setText(findTestObject("Object Repository/Login/txt_password"), GlobalVariable.password)

//Thread.sleep(75000)

WebUI.click(findTestObject("Object Repository/Login/btn_login"))

WebUI.waitForPageLoad(GlobalVariable.DEFAULT_TIMEOUT)

WebUI.waitForElementVisible(findTestObject('Object Repository/Home/Greetings'), GlobalVariable.DEFAULT_TIMEOUT)

Date date = new Date();   // given date
Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance

println(calendar.get(Calendar.HOUR_OF_DAY))

String expectedGreetings = CustomKeywords.'general.Methods.greetings'(calendar.get(Calendar.HOUR_OF_DAY).toInteger()) + ", Phu"

WebUI.verifyElementText(findTestObject('Object Repository/Home/Greetings'), expectedGreetings)
