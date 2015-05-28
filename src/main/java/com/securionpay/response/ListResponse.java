package com.securionpay.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListResponse<T> implements Iterable<T> {

	private List<T> list = new ArrayList<>();

	private Integer totalCount;

	public List<T> getList() {
		return list;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
}
