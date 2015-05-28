package com.securionpay.util;

import java.io.IOException;
import java.util.Properties;

import com.securionpay.SecurionPayGateway;

public class SecurionPayUtils {

	private static final String BUILD_VERSION;

	static {
		Properties properties = new Properties();
		try {
			properties.load(SecurionPayGateway.class.getResourceAsStream("build.properties"));
		} catch (IOException ignore) {
		}

		BUILD_VERSION = properties.getProperty("securionpay.build.version");
	}

	private SecurionPayUtils() {
	}

	public static String toStringNullSafe(Object o) {
		return o != null ? o.toString() : null;
	}

	public static String getBuildVersion() {
		return BUILD_VERSION;
	}

	public static String getJavaVersion() {
		return System.getProperty("java.version");
	}
}
