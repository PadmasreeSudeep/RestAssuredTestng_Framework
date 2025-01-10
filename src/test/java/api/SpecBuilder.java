	package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder 
{
	public static RequestSpecification getrequestSpec()
	{
		return new RequestSpecBuilder()
				.setBaseUri("https://api.spotify.com")
				.setBasePath(Route.BASE_PATH)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL).build();
	}
	public static RequestSpecification getAccountrequestSpec()
	{
		return new RequestSpecBuilder()
				.setBaseUri("https://accounts.spotify.com")
				.setContentType(ContentType.URLENC)
				.log(LogDetail.ALL).build();
	}
	
	public static ResponseSpecification getresponseSpec()
	{
		return new ResponseSpecBuilder()
				.expectContentType("application/json")
		        .log(LogDetail.ALL).build();
	}
}
