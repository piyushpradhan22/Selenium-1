package com.Cucumber.framework.configreader;

import java.util.Properties;
import org.apache.log4j.Level;
import com.Cucumber.framework.utility.ResourceHelper;

public class PropertyFileReader {
	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getresourcePathInputStream("configfile//config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getBrowser() {
		return prop.getProperty("Browser");
	}

	public String getWebsite() {
		return prop.getProperty("Website");
	}

	public String getPageLoadTimeOut() {
		return prop.getProperty("PageLoadTimeOut");
	}

	public String getImplicitWait() {
		return prop.getProperty("ImplicitWait");
	}

	public String getExplicitWait() {
		return prop.getProperty("ExplicitWait");
	}

	public Level getLoggerLevel() {
		switch (prop.getProperty("Logger.Level")) {
		case "DEBUG":
			return Level.DEBUG;
		case "INFO":
			return Level.INFO;
		case "WARN":
			return Level.WARN;
		case "ERROR":
			return Level.ERROR;
		case "FATAL":
			return Level.FATAL;
		}
		return Level.ALL;
	}

}
