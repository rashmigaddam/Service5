package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Services;

@Repository
public interface ServiceRepository extends CrudRepository<Services, Long>{

}
