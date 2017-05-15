package com.securionpay.connection;

import java.io.Closeable;
import java.io.File;
import java.util.Map;

public interface Connection extends Closeable {

	Response get(String url, Map<String, String> headers);

	Response post(String url, String requestBody, Map<String, String> headers);

	Response delete(String url, Map<String, String> headers);

	Response multipart(String url, Map<String, File> files, Map<String, String> form, Map<String, String> headers);
}
