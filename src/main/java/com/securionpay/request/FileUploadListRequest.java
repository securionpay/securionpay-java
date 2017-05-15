package com.securionpay.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileUploadListRequest {
	private Integer limit;
	private String startingAfterId;
	private String endingBeforeId;
	private Boolean includeTotalCount;
	private CreatedFilter created;
	@JsonIgnore
	private Map<String, Object> other = new HashMap<>();

	public FileUploadListRequest() {
	}

	public Integer getLimit() {
		return this.limit;
	}

	public String getStartingAfterId() {
		return this.startingAfterId;
	}

	public String getEndingBeforeId() {
		return this.endingBeforeId;
	}

	public Boolean getIncludeTotalCount() {
		return this.includeTotalCount;
	}

	public CreatedFilter getCreated() {
		return this.created;
	}

	public FileUploadListRequest limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public FileUploadListRequest startingAfterId(String startingAfterId) {
		this.startingAfterId = startingAfterId;
		return this;
	}

	public FileUploadListRequest endingBeforeId(String endingBeforeId) {
		this.endingBeforeId = endingBeforeId;
		return this;
	}

	public FileUploadListRequest includeTotalCount(Boolean includeTotalCount) {
		this.includeTotalCount = includeTotalCount;
		return this;
	}

	public FileUploadListRequest includeTotalCount() {
		return this.includeTotalCount(Boolean.TRUE);
	}

	public FileUploadListRequest created(CreatedFilter created) {
		this.created = created;
		return this;
	}

	@JsonAnyGetter
	private Map<String, Object> getOtherMap() {
		return this.other;
	}

	@JsonAnySetter
	public FileUploadListRequest set(String name, Object value) {
		this.other.put(name, value);
		return this;
	}
}