package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Services;
//import net.javaguides.springboot.model.Service;
import net.javaguides.springboot.repository.ServiceRepository;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {
	
	@Autowired
    private ServiceRepository serviceRepository;
 
 // create service
	@Override
 public Services createService(Services service) {
         serviceRepository.save(service);
         return service;
    }
 
 // get all service
	@Override
    public List<Services> getAllService() {
    	List<Services> servicetypenames=(List<Services>) serviceRepository.findAll();
		return servicetypenames;
 //       return this.serviceRepository.findAll();
    }
 
 // get service by id
	@Override
    public Services getServiceById(long serviceId) {

        Optional < Services > serviceDb = this.serviceRepository.findById(serviceId);

        if (serviceDb.isPresent()) {
            return serviceDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + serviceId);
        }
    }
 
 // update service
	@Override
    public Services updateService(Services service,long id) {
		Services serviceUpdate = serviceRepository.findById(id).get();
		serviceUpdate.setService_request_date(service .getService_request_date());
		serviceUpdate.setDate_Of_Service(service.getDate_Of_Service());
		serviceUpdate.setService_Desc(service .getService_Desc());
		serviceUpdate.setService_charge(service .getService_charge());
		serviceUpdate.setService_status(service .getService_status());
		serviceUpdate.setDelivery_Date(service .getDelivery_Date());
		serviceUpdate.setLast_updated_date(service .getLast_updated_date());
		serviceUpdate.setVeh_reg_Number(service .getVeh_reg_Number());  
		  serviceRepository.save(serviceUpdate);
		return serviceUpdate;
	}
   
 
 // delete service
	@Override
    public void deleteService(long serviceId) {
        Optional < Services > serviceDb = this.serviceRepository.findById(serviceId);

        if (serviceDb.isPresent()) {
            this.serviceRepository.delete(serviceDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + serviceId);
        }

    }


}
