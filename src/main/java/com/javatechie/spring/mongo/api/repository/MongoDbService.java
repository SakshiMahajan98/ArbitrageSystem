package com.javatechie.spring.mongo.api.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Service
public class MongoDbService {

	private static Logger logger = LoggerFactory.getLogger(MongoDbService.class);

	public DB getDb() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoClient client = (MongoClient) context.getBean("mongoClient");
		DB db = client.getDB("citi");
		
		return db;
	}

}
