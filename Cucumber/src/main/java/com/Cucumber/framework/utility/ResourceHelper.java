package com.Cucumber.framework.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceHelper {

	public static String getBaseResourcePath() {
		String path = ResourceHelper.class.getClass().getResource("/").getPath();
		return path;
	}

	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		return path;
	}

	public static InputStream getresourcePathInputStream(String resource) throws FileNotFoundException {
		return new FileInputStream(getResourcePath(resource));
	}
}
