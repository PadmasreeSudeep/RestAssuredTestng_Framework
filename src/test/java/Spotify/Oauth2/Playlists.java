package Spotify.Oauth2;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import com.spotify.oauth.pojo.Playlist;
import api.SpecBuilder;
import applicationApi.PlaylistApicalls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

    public  class Playlists
	{ 
    	public Playlist playlistBuilder(String name,String description,Boolean _public)
    	{
    		return new Playlist()
					.setName(name)
					.setDescription(description)
					.setPublic(_public);
    	}
    		
    	public void assertPlaylistEqual(Playlist responseplaylist,Playlist requestplaylist)
    	{
    		assertThat(responseplaylist.getName(),equalTo(requestplaylist.getName()));
			assertThat(responseplaylist.getDescription(),equalTo(requestplaylist.getDescription()));
			assertThat(responseplaylist.getPublic(),equalTo(requestplaylist.getPublic()));
    	}
    	public void assertStatuscode(int actualstatuscode,int expectedstatuscode)
    	{
    		assertThat(actualstatuscode,equalTo(expectedstatuscode));
    	}
	
		@Test
		public void CreatePlaylist()
		{
			Playlist requestplaylist=playlistBuilder("New Playlist","New Playlist Description",false);	
			Response response=PlaylistApicalls.post(requestplaylist);
			assertStatuscode(response.statusCode(),201);
			assertPlaylistEqual(response.as(Playlist.class),requestplaylist);		
			System.out.print("First Commit");
			
			
		}
		
}
