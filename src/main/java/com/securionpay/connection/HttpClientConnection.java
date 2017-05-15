package com.securionpay.connection;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.securionpay.exception.ConnectionException;

public class HttpClientConnection implements Connection {

	private static final Charset UTF8 = Charset.forName("UTF-8");

	private final CloseableHttpClient httpClient;

	public HttpClientConnection() {
		this(HttpClientBuilder.create().build());
	}

	public HttpClientConnection(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	public Response get(String url, Map<String, String> headers) {
		return execute(new HttpGet(url), headers);
	}

	@Override
	public Response post(String url, String requestBody, Map<String, String> headers) {
		HttpPost post = new HttpPost(url);
		if (requestBody != null) {
			post.setEntity(new StringEntity(requestBody, UTF8));
		}

		return execute(post, headers);
	}

	@Override
	public Response delete(String url, Map<String, String> headers) {
		return execute(new HttpDelete(url), headers);
	}

	@Override
	public Response multipart(String url, Map<String, File> files, Map<String, String> form, Map<String, String> headers) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		for (Entry<String, File> entry : files.entrySet()) {
			builder.addBinaryBody(entry.getKey(), entry.getValue());
		}

		for (Entry<String, String> entry : form.entrySet()) {
			builder.addTextBody(entry.getKey(), entry.getValue());
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(builder.build());

		headers.remove("Content-Type");
		return execute(httpPost, headers);
	}

	private Response execute(HttpUriRequest request, Map<String, String> headers) {
		for (Entry<String, String> header : headers.entrySet()) {
			String headerName = header.getKey();
			String headerValue = header.getValue();

			if ("User-Agent".equalsIgnoreCase(headerName)) {
				headerValue += " HttpClient";
			}

			request.addHeader(headerName, headerValue);
		}

		try (CloseableHttpResponse response = httpClient.execute(request)) {
			return new Response(
					response.getStatusLine().getStatusCode(),
					EntityUtils.toString(response.getEntity(), UTF8));
		} catch (IOException e) {
			throw new ConnectionException(e);
		}
	}

	@Override
	public void close() throws IOException {
		httpClient.close();
	}
}
