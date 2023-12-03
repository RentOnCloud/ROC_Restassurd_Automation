package com.roc.qa;



import static io.restassured.RestAssured.when;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class API_Base {
	public static Properties prop;
	public static String baseURI;
	public static String baseURIdelete;
	public static String bearerToken="live_SSvswYtsjaJf-7dwchsLjBsQcoyksEmIhDj3Xlma";
	
	public API_Base(){
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources"
					+ "/config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Validatable<ValidatableResponse,Response> GetCall() {
		
		baseURI = prop.getProperty("BASE_URI");
		String URL = baseURI + "customers/";
		RequestSpecification httpRequest = RestAssured.given(); 
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.contentType(ContentType.JSON).headers("Authorization","Bearer "+bearerToken).headers("Accept", "application/json").headers("GoCardless-Version", "2015-07-06").get(URL);
		return response;	
		
	}
	
	public static void DeleteCall(){
		baseURI = prop.getProperty("BASE_URI");
		baseURIdelete = baseURI+"customers/CU0032R66CCP7G";
		String URL = baseURIdelete;
					
		when().
		    delete(URL).
		   then().
		      statusCode(200).
		      log().all();
		      
			
	}
	
public static Validatable<ValidatableResponse,Response> GetparticularUserCall(String customer_no) {
		
		baseURI = prop.getProperty("BASE_URI");;
		String URL = baseURI + "customers/{customer_id}";
		RequestSpecification httpRequest = RestAssured.given(); 
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.contentType(ContentType.JSON).headers("Authorization","Bearer "+bearerToken).headers("Accept", "application/json").headers("GoCardless-Version", "2015-07-06").pathParam("customer_id", customer_no).get(URL);
		return response;	
		
	}


}
