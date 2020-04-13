package com.javatechie.spring.mongo.api.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.model.StockDetails;
import com.javatechie.spring.mongo.api.model.User;
import com.javatechie.spring.mongo.api.repository.StockDatabase;
import com.javatechie.spring.mongo.api.repository.UserRepository;

@RestController
public class StockController {

	@Autowired
	private StockDatabase DB;

	@GetMapping("/findAllStocks")
	public List<StockDetails> getUsers() {
		return DB.findAll();
	}

	@GetMapping("/findAllStocks/{id}")
	public Optional<StockDetails> getUser(@PathVariable int id) {
		return DB.findById(id);
	}

	

	//@Autowired
	private ArrayList<StockDetails> StockList;
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:8080")   //use 4200 for angular
	public Collection<StockDetails> home() throws IOException, JSONException{		
		StockList=new ArrayList<StockDetails>();
		String Stocks[]= {"yesbank","wipro","tatamotors","hcltech","coalindia","bajaj-auto","zeel","ioc","bpcl","cipla","techm","icicibank","sunpharma","itc","tcs","heromotoco","hindunilvr","ntpc","maruti","axisbank","infratel","powergrid","ongc","indusindbk","reliance","lt","sbin","hdfc","hindalco","m&m","kotakbank","infy","eichermot","drreddy","hdfcbank","vedl","bajajfinsv","adaniports","gail","upl","tatasteel","grasim","titan","britannia","bajfinance","jswsteel","ultracemco","bhartiartl","ibulhsgfin","asianpaint"};
		String ip="";
		String Data="";
		String Api="https://query1.finance.yahoo.com/v7/finance/quote?symbols=";
		for(int i=0;i<50;i++) {
			Api="https://query1.finance.yahoo.com/v7/finance/quote?symbols=";
			Api=Api+Stocks[i]+".ns";   //preparing URL to be hit for each and every company listed in the array above
			Data=getDataFromURL(Api);
			JSONObject myResponse= new JSONObject(Data);
			JSONObject Object=(JSONObject)myResponse.get("quoteResponse");
			Data="";
			JSONArray dataarray=(JSONArray) Object.get("result");  //it is an embedded json array about the region etc
			Object=dataarray.getJSONObject(0);  // @ 0 th position is the complete stock data
			
			StockDetails s=new StockDetails();
			s.setSrNo(i+1);
			s.setSymbol(Stocks[i]);
        	s.setNSE(Double.valueOf(Object.get("regularMarketPrice").toString()));  //avg value of the stock
        	
        	Api="https://query1.finance.yahoo.com/v7/finance/quote?symbols=";
        	Api=Api+s.getSymbol()+".bo";
        	String Data1=getDataFromURL(Api);
			JSONObject myResponse1= new JSONObject(Data1);
			JSONObject Object1=(JSONObject)myResponse1.get("quoteResponse");
			JSONArray dataarray1=(JSONArray) Object1.get("result");
			Object=dataarray1.getJSONObject(0);
			s.setBSE(Double.valueOf(Object.get("regularMarketPrice").toString()));
			
			s.calculate_diff();
			StockList.add(s);
			
			DB.save(s);
		}
		return StockList;
	}
	
	public String getDataFromURL(String U) throws IOException {
        URL obj = new URL(U);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	response.append(inputLine);
        }
        in.close();
        String d=response.toString();
        return d;
	}
	
	
	

	/*
	 * @GetMapping("/sorted")
	 * 
	 * @CrossOrigin(origins = "http://localhost:4200") public
	 * Collection<StockDetails> getSort(){ StockService s=new StockService(); return
	 * s.SortStocks(StockList); }
	 */
 

}
