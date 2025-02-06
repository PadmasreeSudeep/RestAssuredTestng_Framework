package applicationApi;

import com.spotify.oauth.pojo.Playlist;
import Utils.ConfigLoader;
import api.RestResource;
import api.Route;
import api.TokenManager;
import io.restassured.response.Response;

public class PlaylistApicalls 
{

	public static Response post(Playlist requestplaylist)
	{
		return RestResource.post(Route.USERS+"/"+ ConfigLoader.getInstance().getUser_id()+ Route.PLAYLISTS,TokenManager.getToken(),requestplaylist);
	}
		
			
}


