package com.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class restTemplateService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${connectionString}")
	   private String connectionString;
	@Value("${username}")
	   private String username;
	@Value("${password}")
	   private String password;
	@Value("${mainuser}")
	   private String mainuser;

	public List<Object> getAllProducts() {
//		String api = "http://dummy.restapiexample.com/api/v1/employees";
//		Object[] products = restTemplate.getForObject(api, Object[].class);
//		return Arrays.asList(products);
System.out.println("Connection String from azure "+connectionString);
System.out.println("Connection String from azure "+username);
System.out.println("Connection String from azure "+password);
System.out.println("Connection String from azure "+mainuser);
		String api = "https://jsonplaceholder.typicode.com/posts";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>(headers);
		ResponseEntity<Object[]> response = restTemplate.exchange(api, HttpMethod.GET, entity, Object[].class);
//		Object[] products = restTemplate.getForObject(api, Object[].class);
		return Arrays.asList(response.getBody());

	}

}
