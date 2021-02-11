package com.demo.springmongo.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("book")
public class Book {
	@Id
	private String id;
	@Field("name")
	@Indexed(unique=true)
	private String title;
	@Field("category")
	private BookCategory bookCategory;
	@Field("price")
	private BigDecimal sellingPrice;
	
	public Book() {}

	public Book(String id, String title, BookCategory bookCategory, BigDecimal sellingPrice) {
		super();
		this.id = id;
		this.title = title;
		this.bookCategory = bookCategory;
		this.sellingPrice = sellingPrice;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}
