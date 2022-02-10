package com.securionpay.response;

import com.securionpay.enums.FileUploadPurpose;
import com.securionpay.enums.FileUploadType;

public class FileUpload {
	private String id;
	private Long created;
	private String purpose;
	private Integer size;
	private String type;
	private String url;

	public String getId() {
		return id;
	}

	public Long getCreated() {
		return created;
	}

	public FileUploadPurpose getPurpose() {
		return FileUploadPurpose.fromValue(purpose);
	}

	public String getPurposeAsString() {
		return purpose;
	}

	public Integer getSize() {
		return size;
	}

	public FileUploadType getType() {
		return FileUploadType.fromValue(type);
	}

	public String getTypeAsString() {
		return type;
	}

	public String getUrl() {
		return url;
	}
}
