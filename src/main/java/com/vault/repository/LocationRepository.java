package com.vault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vault.entity.Location;


@Repository
public interface LocationRepository  extends JpaRepository<Location, Long>{
	
	public List<Location> findAll();

	
}
