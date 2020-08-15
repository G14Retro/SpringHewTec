package com.hewtec.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hewtec.prueba.model.ProveedorModel;
import com.hewtec.prueba.repository.ProveedorRepository;


@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public ProveedorModel create (ProveedorModel proveedor) {
		return proveedorRepository.save(proveedor);
	}
	
	public List<ProveedorModel> getProveedores(){
		return proveedorRepository.findAll();
	}
	
	public void deleteProveedor(ProveedorModel proveedor) {
		proveedorRepository.delete(proveedor);
	}
	
	public Optional<ProveedorModel> findById (Long id) {
		return proveedorRepository.findById(id);
	}

}
