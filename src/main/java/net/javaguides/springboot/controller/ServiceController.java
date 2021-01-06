package net.javaguides.springboot.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Services;
import net.javaguides.springboot.service.ServiceService;


@RestController

public class ServiceController {
	@Autowired
    private ServiceService serviceService;
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	// get all service
	 @GetMapping("/service5")
	    public ResponseEntity < List < Services >> getAllService() {
		 LOGGER.log(Level.INFO, "Get all  service:");
	        return ResponseEntity.ok().body(serviceService.getAllService());
	    }
	 
	 // get service by id
	 @GetMapping("/service5/{id}")
	    public ResponseEntity < Services > getServiceById(@PathVariable long id) {
		 LOGGER.log(Level.INFO, "Get service by id:");
	        return ResponseEntity.ok().body(serviceService.getServiceById(id));
	    }
	 
	 // create service
	 @PostMapping("/service5")
	    public ResponseEntity < Services > createService(@Valid @RequestBody Services service) {
		 LOGGER.log(Level.INFO, "Create service:");
	        return ResponseEntity.ok().body(this.serviceService.createService(service));
	    }

	 // update service
	 @PutMapping("/service5/{id}")
	    public ResponseEntity < Services > updateService(@Valid @PathVariable long id, @RequestBody Services service) {
		 LOGGER.log(Level.INFO, "Update service:");
		 service.setId(id);
	        return ResponseEntity.ok().body(this.serviceService.updateService(service,id));
	    }
	 
	 // delete service
	 @DeleteMapping("/service5/{id}")
	    public HttpStatus deleteService(@PathVariable long id) {
		 LOGGER.log(Level.INFO, "Delete service:");
	        this.serviceService.deleteService(id);
	        return HttpStatus.OK;
	    }
}
