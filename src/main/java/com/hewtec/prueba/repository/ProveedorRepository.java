package com.hewtec.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hewtec.prueba.model.ProveedorModel;

public interface ProveedorRepository extends JpaRepository<ProveedorModel,Long>{
	

}
