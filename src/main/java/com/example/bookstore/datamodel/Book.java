package com.example.bookstore.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String author;
	private Integer year;
	private double price;
	
	public Book() {}
	
	public Book(String name, String author,Integer year,double price) {
		this.name=name;
		this.author=author;
		this.year=year;
		this.price=price;
	}
	
	public String getName(){
		return name;
	}
	public String getAuthor(){
		return author;
	}
	public Integer getYear(){
		return year;
	}
	public double getPrice() {
		return price;
	}
	
	public void setName(String newName) {
		name=newName;
	}
	public void setAuthor(String newAuthor) {
		author=newAuthor;
	}
	public void setYear(Integer newYear) {
		year=newYear;
	}
	public void setPrice(double newPrice) {
		price=newPrice;
	}
}
