package com.securionpay.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expand {

	@JsonValue
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> paths = new ArrayList<>();

	public Expand() {
	}

	public Expand(List<String> paths) {
		this.paths = paths;
	}

	public Expand(String... paths) {
		this(Arrays.asList(paths));
	}

	public Expand add(String path) {
		paths.add(path);
		return this;
	}
}
