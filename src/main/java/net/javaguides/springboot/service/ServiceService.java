package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.model.Services;

@Component
public interface ServiceService {
	
	public Services createService(Services service);

	public Services updateService(Services service,long id);

	public List < Services > getAllService();

	public Services getServiceById(long serviceId);

	public void deleteService(long id);

}
