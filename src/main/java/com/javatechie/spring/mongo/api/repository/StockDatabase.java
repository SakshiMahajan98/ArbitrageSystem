package com.javatechie.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.StockDetails;


public interface StockDatabase extends MongoRepository<StockDetails, Integer>{

}
