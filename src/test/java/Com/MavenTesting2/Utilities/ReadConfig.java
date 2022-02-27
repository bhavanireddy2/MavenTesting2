package Com.MavenTesting2.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File file=new File("./Configurations/config.properties");
		try{
		FileInputStream fis=new FileInputStream(file);
		pro=new Properties();
		pro.load(fis);
	}catch(Exception e) {
		System.out.println("Exception is"+e.getMessage());
	}
	}
		public String getApplicationURL() {
			String url=pro.getProperty("baseUrl");
			return url;
		}
		public String getUsername() {
			String username=pro.getProperty("username");
			return username;
		}
		public String getPassword() {
			String password=pro.getProperty("password");
			return password;
		}
		public String getChromePath() {
			String chromepath=pro.getProperty("chromepath");
			return chromepath;
		}
		public String getFirefoxPath() {
			String firefox=pro.getProperty("firefox");
			return firefox;
		}
		}
		
	


