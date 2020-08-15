package com.hewtec.prueba.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hewtec.prueba.model.ProveedorModel;
import com.hewtec.prueba.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorRest {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping
	private ResponseEntity<ProveedorModel> guardar (@RequestBody ProveedorModel proveedor){
		ProveedorModel temporalp = proveedorService.create(proveedor);
		try {
			return ResponseEntity.created(new URI("/api/proveedor"+temporalp.getId())).body(temporalp);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<ProveedorModel>> listarProveedores (){
		return ResponseEntity.ok(proveedorService.getProveedores());
	}
	
	@PutMapping
	private ResponseEntity<Void> eliminarProveedor(@RequestBody ProveedorModel proveedor){
		proveedorService.deleteProveedor(proveedor);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<ProveedorModel>> buscarProveedor (@PathVariable("id") Long id){
		return ResponseEntity.ok(proveedorService.findById(id));
	}
}
