package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private AddressService addressservice;
	
	@GetMapping(value = "/sido")
	public ResponseEntity<List<AddressDto>> searchSido() throws Exception {
		List<AddressDto> list = addressservice.searchSido();
		return new ResponseEntity<List<AddressDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/gugun/{sido}")
	public ResponseEntity<List<AddressDto>> searchGugun(@PathVariable("sido") String sido) throws Exception {
		List<AddressDto> list = addressservice.searchGugun(sido);
		return new ResponseEntity<List<AddressDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/dong/{gugun}")
	public ResponseEntity<List<AddressDto>> searchDong(@PathVariable("gugun") String gugun) throws Exception {
		List<AddressDto> list = addressservice.searchDong(gugun);
		return new ResponseEntity<List<AddressDto>>(list, HttpStatus.OK);
	}
}
