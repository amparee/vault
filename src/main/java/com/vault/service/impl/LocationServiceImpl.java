package com.vault.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vault.entity.Location;
import com.vault.repository.LocationRepository;
import com.vault.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<Location> listEmployee() {
		return locationRepository.findAll();
	}

}
