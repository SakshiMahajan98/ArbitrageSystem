package com.javatechie.spring.mongo.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.spring.mongo.api.model.StockDetails;

@Repository
public interface StockDatabase extends MongoRepository<StockDetails, String>{
		//public StockDetails findBySymbol(String company);
	  //public List<Customer> findByLastName(String lastName);
}
