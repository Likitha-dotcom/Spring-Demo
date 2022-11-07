package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.service.IAddressService;

@RestController
public class AddressController {
	
	@Autowired
	IAddressService addrServ;
	
	//ADD ADDRESS
	@PostMapping("/address/add")
	ResponseEntity<Address> addAddress(@RequestBody	Address addr) {
		System.out.println(addr);
		Address newAddr = addrServ.addAddress(addr);
		System.out.println(newAddr);
		return new ResponseEntity<>(newAddr,HttpStatus.CREATED); // status code 201
	}
	
	//GET ADDRESS BY ID
	@GetMapping("/address/get/{addrId}")
	ResponseEntity<Address> getAddressById(@PathVariable("addrId") int addrId) {
		Address newAddr = addrServ.getAddressById(addrId);
		return new ResponseEntity<>(newAddr,HttpStatus.OK); // status 200
	}
	
	//GET ALL ADDRESS
	@GetMapping("/address/findAll")
	ResponseEntity<List<Address>> getAllAddresses(){
		List<Address> addrList = addrServ.getAllAddresses();
		return new ResponseEntity<List<Address>>(addrList,HttpStatus.OK);
	}
	
	//DELETE ADDRESS BY ID
	@DeleteMapping("/address/delete/{addrID}")
	ResponseEntity<Address> deleteAddressById(@PathVariable("addrID") int addrId) {
		Address delAddr = addrServ.deleteAddressById(addrId);
		return new ResponseEntity<>(delAddr,HttpStatus.OK); // status 200
	}
	
}
