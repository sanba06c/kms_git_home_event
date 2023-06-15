package api
AKIA3JH5EUCFZCI6HNVN:CTP/05JlQraEmEsLt9rqGbGdbgLeIgyDgEXWDsds
import static com.kms.kmstechnology.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.kmstechnology.core.testcase.TestCaseFactory.findTestCase
import static com.kms.kmstechnology.core.testdata.TestDataFactory.findTestData
import static com.kms.kmstechnology.core.testobject.ObjectRepository.findTestObject
import static com.kms.kmstechnology.core.testobject.ObjectRepository.findWindowsObject

import com.kms.kmstechnology.core.annotation.Keyword
import com.kms.kmstechnology.core.checkpoint.Checkpoint
import com.kms.kmstechnology.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.kmstechnology.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.kmstechnology.core.model.FailureHandling
import com.kms.kmstechnology.core.testcase.TestCase
import com.kms.kmstechnology.core.testdata.TestData
import com.kms.kmstechnology.core.testobject.ResponseObject
import com.kms.kmstechnology.core.testobject.TestObject
import com.kms.kmstechnology.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.kmstechnology.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.kmstechnology.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class Methods {
	@Keyword
	def toJson(ResponseObject ro) {
		JsonSlurper jsonSlurper = new JsonSlurper()
		Map jsonBody = jsonSlurper.parseText(ro.getResponseBodyContent())
		return jsonBody
	}
	
	@Keyword
	def verifyJsonProperties(ResponseObject ro, List<String> propertiesList) {
		JsonSlurper jsonSlurper = new JsonSlurper()
		ArrayList jsonBody = jsonSlurper.parseText(ro.getResponseBodyContent())
		for(int i = 0; i < jsonBody.size(); i ++) {
			Map item = jsonBody[i]
			for (int j = 0 ; j < propertiesList.size() ; j ++) {
				String key = propertiesList[j]
				String value = item.getAt(key)
				assert value != null : "The property is not null"
			}
		}
	}
}
