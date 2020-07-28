package com.javatechie.spring.mongo.api.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.mongo.api.model.StockDetails;
import com.javatechie.spring.mongo.api.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Service
public class StockService {

	private static Logger logger = LoggerFactory.getLogger(StockService.class);

	@Autowired
	MongoDbService mongoService;

	public MongoDbService getMongoService() {
		return mongoService;
	}

	public void setMongoService(MongoDbService mongoService) {
		this.mongoService = mongoService;
	}

	public Collection<StockDetails> SortStocks(ArrayList<StockDetails> stockList) {
		logger.info("Validating the stocks.");
		DBCollection coll = mongoService.getDb().getCollection("Stocks");
		
		
		return null;
	}

}
