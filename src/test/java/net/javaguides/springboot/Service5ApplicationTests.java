package net.javaguides.springboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import net.javaguides.springboot.model.Services;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Service5Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Service5ValApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }
    
    @Test
    public void testGetAllServices() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/service5",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }
    
    @Test
    public void testGetServiceById() {
    	Services service = restTemplate.getForObject(getRootUrl() + "/service5/1", Services.class);
        System.out.println(service.getDelivery_Date());
        assertNotNull(service);
    }
    
    @Test
    public void testCreateService() {
    	Services service = new Services();
    	service.setService_request_date("2021-01-25");
    	service.setDate_Of_Service("2021-01-20");
    	service.setService_Desc("oiling");
    	service.setService_charge("4500");
    	service.setService_status("approved");
    	service.setDelivery_Date("2021-01-12");
    	service.setLast_updated_date("2021-01-24");
    	service.setVeh_reg_Number("ARH45");
        ResponseEntity<Services> postResponse = restTemplate.postForEntity(getRootUrl() + "/service5", service, Services.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
   
    public void testUpdateService() {
    	
        int id = 1;
        Services service = restTemplate.getForObject(getRootUrl() + "/service5/" + id, Services.class);
        service.setService_request_date("2021-01-24");
    	service.setDate_Of_Service("2021-01-20");
    	service.setService_Desc("parts change");
    	service.setService_charge("4500");
    	service.setService_status("pending");
    	service.setDelivery_Date("2021-01-12");
    	service.setLast_updated_date("2021-01-18");
        restTemplate.put(getRootUrl() + "/service5/" + id, service);
        Services updatedService = restTemplate.getForObject(getRootUrl() + "/service5/" + id, Services.class);
        assertNotNull(updatedService);
    }
    
    @Test
    public void testDeleteService() {
         int id = 2;
         Services service = restTemplate.getForObject(getRootUrl() + "/service5/" + id, Services.class);
         assertNotNull(service);
         restTemplate.delete(getRootUrl() + "/service5/" + id);
         try {
        	 service = restTemplate.getForObject(getRootUrl() + "/service5/" + id, Services.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }

}
