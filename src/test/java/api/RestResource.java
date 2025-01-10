	package api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.spotify.oauth.pojo.Playlist;

import api.SpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestResource 
{
	public static Response post(String path,String token,Object requestplaylist)
	{
		return given(SpecBuilder.getrequestSpec()).body(requestplaylist)
				.header("Authorization","Bearer "+ token)
				.when()
				.post(path)
				.then()
				.spec(SpecBuilder.getresponseSpec())
				.extract().response();
	}
	public static Response postAccount(HashMap<String,String> formParams)
	{
		 return given(SpecBuilder.getAccountrequestSpec())
	        		.formParams(formParams)
	        		.when().post(Route.API+Route.TOKEN)
	        		.then()
	        		.spec(SpecBuilder.getresponseSpec()).extract().response();
	}
		
			
}
