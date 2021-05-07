package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.service.AddressService;
import com.ssafy.happyhouse.model.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {

	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);

	@Autowired
	private HouseService houseservice;
	
	@Autowired
	private AddressService addressservice;
	
	@PostMapping(value = "/findApt")
	public String findApt(@RequestParam Map<String, String> map, Model model) throws Exception {
		AddressDto address = addressservice.searchPosition(map);
		List<HouseDto> list = houseservice.findApt(map.get("dong"));
		model.addAttribute("position", address);
		model.addAttribute("list", list);
		model.addAttribute("dong", map.get("dong"));
		model.addAttribute("gugun", map.get("gugun"));
		return "tradeApt";
	}

	@PostMapping(value = "/marker")
	public ResponseEntity<List<HouseDto>> setMarker(String dong) throws Exception {
		List<HouseDto> list = houseservice.setMarker(dong);
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}
}
