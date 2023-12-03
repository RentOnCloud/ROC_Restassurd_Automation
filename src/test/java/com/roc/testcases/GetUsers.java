package com.roc.testcases;

import org.testng.annotations.Test;


import com.roc.qa.API_Base;

public class GetUsers  extends API_Base {
	
	@Test
	public void test01_getalluser() {
		
		//Validatable<ValidatableResponse, Response> response = TestBase.GetCall();
		
//		Assert.assertEquals(200, response.statusCode());
//	    String resBody = response.getBody().toString();
//	    Assert.assertTrue(resBody.contains("michael"));
		
		API_Base.GetCall()
	    .then()
		.statusCode(200)//body("firstname[1]", containsString("David"))
		.log().all();
	 
	    
	    
		
	}
	

	

}
