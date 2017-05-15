package com.securionpay.response;

import com.securionpay.enums.FileUploadPurpose;
import com.securionpay.enums.FileUploadType;

public class FileUpload {
	private String id;
	private Long created;
	private FileUploadPurpose purpose;
	private Integer size;
	private FileUploadType type;
	private String url;

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public FileUploadPurpose getPurpose() {
		return purpose;
	}

	public Integer getSize() {
		return size;
	}

	public FileUploadType getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}
}
