package com.javatechie.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Stocks")
public class StockDetails implements Comparable<StockDetails>{
	
	private int SrNo;
	@Id
	private String Symbol;  //name of the company
	private double NSE;
	private double BSE;
	private double difference;
	private double like;
	private double noOfStocks;
	
	public StockDetails() {
		super();
	}


	@Override
	public String toString() {
		return "StockDetails [SrNo=" + SrNo + ", Symbol=" + Symbol + ", NSE=" + NSE + ", BSE=" + BSE + ", difference="
				+ difference + ", like=" + like + ", noOfStocks=" + noOfStocks + "]";
	}
	
	@Override 
	public int compareTo(StockDetails s)
	{
		return (this.getDifference()<s.getDifference()?-1:(this.getDifference()==s.getDifference()?0:1));
	}
	
	public StockDetails(int srNo, String symbol, double nSE, double bSE, double difference, double like,
			double noOfStocks) {
		super();
		SrNo = srNo;
		Symbol = symbol;
		NSE = nSE;
		BSE = bSE;
		this.difference = difference;
		this.like = like;
		this.noOfStocks = noOfStocks;
	}
	public double getNoOfStocks() {
		return noOfStocks;
	}
	public void setNoOfStocks(double noOfStocks) {
		this.noOfStocks = noOfStocks;
	}
	public double getLike() {
		return like;
	}
	public void setLike(double like) {
		this.like = like;
	}
	public int getSrNo() {
		return SrNo;
	}
	public void setSrNo(int srNo) {
		SrNo = srNo;
	}
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}
	public double getNSE() {
		return NSE;
	}
	public void setNSE(double nSE) {
		NSE = nSE;
	}
	public double getBSE() {
		return BSE;
	}
	public void setBSE(double bSE) {
		BSE = bSE;
	}
	public double getDifference() {
		return difference;
	}
	public void setDifference(double difference) {
		this.difference = difference;
	}
	public void calculate_diff() {
		double value=Math.abs(this.BSE-this.NSE);
		double difference=(double)Math.round(value * 10000d) / 10000d;
		this.setDifference(difference);
		
	}
}
