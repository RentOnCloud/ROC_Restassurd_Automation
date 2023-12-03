package com.roc.testcases;

import org.testng.annotations.Test;

import com.roc.qa.API_Base;

public class GetParticularUser extends API_Base{
	
	@Test
	public void test03_GetParticularUser() {
	String cust_no="CU0032R66CCP7G";
	API_Base.GetparticularUserCall(cust_no)
    .then()
	.statusCode(200)//body("firstname[1]", containsString("David"))
	.log().all();

}
}