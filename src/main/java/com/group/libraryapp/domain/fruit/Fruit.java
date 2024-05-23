package com.group.libraryapp.domain.fruit;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fruit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private LocalDate warehousingDate;
	@Column(nullable = false)
	private Long price;
	@Column(nullable = false)
	private Boolean isSold;

	public Fruit() {
	}

	public Fruit(String name, LocalDate warehousingDate, Long price) {
		this.name = name;
		this.warehousingDate = warehousingDate;
		this.price = price;
		this.isSold = false;
	}

	public Fruit(String name, Long price, Boolean isSold) {
		this.name = name;
		this.price = price;
		this.isSold = isSold;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getWarehousingDate() {
		return warehousingDate;
	}

	public Long getPrice() {
		return price;
	}

	public void sold() {
		this.isSold = true;
	}
}
