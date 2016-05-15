package com.recruitment.rest;

import org.jboss.resteasy.client.ClientRequest;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class RestRequestProducer {

	public static ClientRequest getClientRequest(String url) {
		return new ClientRequest(url);
	}

}
