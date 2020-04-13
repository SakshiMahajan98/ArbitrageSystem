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
public class StockDetails {
	@Id
	private int SrNo;
	private String Symbol;  //name of the company
	private double NSE;
	private double BSE;
	private double difference;
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
		double difference=Math.abs(this.BSE-this.NSE);
		this.setDifference(difference);
	}
}
