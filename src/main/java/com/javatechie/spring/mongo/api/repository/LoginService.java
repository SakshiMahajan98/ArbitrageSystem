package com.javatechie.spring.mongo.api.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.mongo.api.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Service
public class LoginService {

	private static Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	MongoDbService mongoService;

	public MongoDbService getMongoService() {
		return mongoService;
	}

	public void setMongoService(MongoDbService mongoService) {
		this.mongoService = mongoService;
	}

	public boolean validateUser(User cus) {

		logger.info("Validating the user.");

		boolean flag = false;

		DBCollection coll = mongoService.getDb().getCollection("User");

		BasicDBObject field = new BasicDBObject();
		field.put("Password", 1);
		DBCursor dbc = coll.find(new BasicDBObject("_id", cus.getUsername()));

		if (dbc.hasNext()) {
			BasicDBObject obj = (BasicDBObject) dbc.next();
			String str = obj.getString("Password");
			flag = str.equals(cus.getPassword());
		} else {
			flag = false;
		}

		logger.info("Returning from the validate user method.");
		return flag;
	}

}
