package login

import static com.kms.kmstechnology.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.kmstechnology.core.testcase.TestCaseFactory.findTestCase
import static com.kms.kmstechnology.core.testdata.TestDataFactory.findTestData
import static com.kms.kmstechnology.core.testobject.ObjectRepository.findTestObject
import static com.kms.kmstechnology.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.kmstechnology.core.annotation.Keyword
import com.kms.kmstechnology.core.checkpoint.Checkpoint
import com.kms.kmstechnology.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.kmstechnology.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.kmstechnology.core.model.FailureHandling
import com.kms.kmstechnology.core.testcase.TestCase
import com.kms.kmstechnology.core.testdata.TestData
import com.kms.kmstechnology.core.testobject.TestObject
import com.kms.kmstechnology.core.util.KeywordUtil
import com.kms.kmstechnology.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.kmstechnology.core.webui.driver.DriverFactory
import com.kms.kmstechnology.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.kmstechnology.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Methods {
	@Keyword
	def verifyBlankTooltip(String username, String password) {
		WebDriver driver = DriverFactory.getWebDriver()
		String errorMessageXpath = "//i[contains(@class, 'icon-error')]"

		if (username.equals("") && password.equals("")) {

			List<WebElement> iconList = driver.findElements(By.xpath(errorMessageXpath))
			assert iconList.size() == 2 : "There should be 2 icons, 1 for blank username, 1 for blank password"

			String tooltipUsername = iconList.get(0).getAttribute("title")
			String tooltipPassword = iconList.get(1).getAttribute("title")

			WebUI.verifyMatch(tooltipUsername, "Username is required", false)
			WebUI.verifyMatch(tooltipPassword, "Password is required", false)
		} else if (username.equals("")) {

			List<WebElement> iconList = driver.findElements(By.xpath(errorMessageXpath))
			assert iconList.size() == 1 : "There should be 1 error icon for username"

			String tooltipUsername = iconList.get(0).getAttribute("title")
			WebUI.verifyMatch(tooltipUsername, "Username is required", false)
		} else if (password.equals("")) {
			List<WebElement> iconList = driver.findElements(By.xpath(errorMessageXpath))
			assert iconList.size() == 1 : "There should be 1 error icon for password"

			String tooltipPassword = iconList.get(0).getAttribute("title")
			WebUI.verifyMatch(tooltipPassword, "Password is required", false)
		} else {
			KeywordUtil.logInfo("Username and Password is not blank")
		}
	}
}
