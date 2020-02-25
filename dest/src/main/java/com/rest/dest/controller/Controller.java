package com.rest.dest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dest.model.Name1;
import com.rest.dest.model.Name2;

@RestController
public class Controller {
	
	@GetMapping
	private ResponseEntity<?> fetchDetails(@RequestParam(name = "id") Integer id ){
		Name1 name1=new Name1();
		name1.setAddress("testAddress");
		name1.setFirstName("firstName");
		
		name1.setMiddleName("testname");
		Name2 name2=new Name2();
		name2.setId(id);
		name2.setPhoneNumber(343443434L);
		ResponseEntity<Name1> entity=new ResponseEntity<Name1>(name1, HttpStatus.BAD_GATEWAY);
		return entity;
	}

}
