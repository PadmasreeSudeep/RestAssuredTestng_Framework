package Utils;

import java.util.Properties;

public class ConfigLoader
{
	private final Properties properties;
	private static ConfigLoader configloader;
	
	private ConfigLoader() 
	{
		properties = PropertyUtils.propertyLoader("src/test/resources/Config.Properties");
	}


    public static ConfigLoader getInstance()
    {
        if (configloader == null)
        {
            configloader = new ConfigLoader();
        }
        return configloader;
    }
	
	public String getClientId()
	{
		String prop = properties.getProperty("client_id");
		if(prop!=null)
		return prop;
		else
			throw new RuntimeException("Property client_id is not Specified in the config properties File");
	}
	public String getClientSecret()
	{
		String prop = properties.getProperty("client_secret");
		if(prop!=null)
		return prop;
		else
			throw new RuntimeException("Property Client_secret is not Specified in the config properties File");
	}
	public String getRefreshToken()
	{
		String prop = properties.getProperty("refresh_token");
		if(prop!=null)
		return prop;
		else
			throw new RuntimeException("Property refresh_token is not Specified in the config properties File");
	}
	public String getGrantType()
	{
		String prop = properties.getProperty("grant_type");
		if(prop!=null)
		return prop;
		else
			throw new RuntimeException("Property grant_type is not Specified in the config properties File");
	}
	public String getUser_id()
	{
		String prop = properties.getProperty("user_id");
		if(prop!=null)
		return prop;
		else
			throw new RuntimeException("Property user_id is not Specified in the config properties File");
	}
	
	

}
