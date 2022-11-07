package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.repository.IAddressRepository;

@Service
public class AdressServiceImpl implements IAddressService {
	
	@Autowired
	IAddressRepository addrRepo;

	@Override
	public Address addAddress(Address addr) {
		// Add address to DB
		return addrRepo.save(addr);
	}

	@Override
	public Address deleteAddressById(int addrId) {
		Optional<Address> addrList = addrRepo.findById(addrId);
		Address delAddr = null;
		if(addrList.isPresent()) {
			//delete
			addrRepo.deleteById(addrId);
		}
		return delAddr;
	}

	@Override
	public Address getAddressById(int addrId) {
		Optional<Address> opt = addrRepo.findById(addrId);
		Address addr = null;
		if(opt.isPresent()) {
			 addr = opt.get();
		}
		return addr;
	}

	@Override
	public List<Address> getAllAddresses() {
		
		return addrRepo.findAll();
	}

}
