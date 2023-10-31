package com.example.demo.model;

import org.springframework.core.io.Resource;

import lombok.Data;

@Data
public class ResourceResponse {
	private Resource resource;
	private String contentDisposition;

	public ResourceResponse(Resource resource, String contentDisposition) {
		this.resource = resource;
		this.contentDisposition = contentDisposition;
	}
}
