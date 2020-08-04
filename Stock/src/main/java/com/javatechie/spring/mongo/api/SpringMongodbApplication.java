package com.javatechie.spring.mongo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.model.StockDetails;
import com.javatechie.spring.mongo.api.model.User;
import com.javatechie.spring.mongo.api.repository.StockDatabase;
import com.javatechie.spring.mongo.api.repository.StockService;
@RestController
@SpringBootApplication
public class SpringMongodbApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}
	
}
