package com.rest.source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.source.model.Name;

@Service
public class RestCallService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;
	
	private String url= "http://localhost:3000/";
	
	public void getService() throws JsonProcessingException {
		//HttpClientErrorException
		//HttpServerErrorException
		//ResourceAccessException
		UriComponentsBuilder builder= UriComponentsBuilder.fromUriString(url);
		builder.queryParam("id", 1);
		ResponseEntity<Name> response=null;
		try {
		response=restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Name.class);
		}catch (HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
			System.out.println("Dont't retry");
		} catch (HttpServerErrorException ex) {
			System.out.println(ex.getStatusCode());
			System.out.println(ex.getResponseBodyAsString());
			System.out.println("retry");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("retry this too");
		}
		if(response!=null) {
		System.err.println(mapper.writeValueAsString(response.getBody()));
		}
	}

}
