package com.group.libraryapp.dto.fruit.response;

public class FruitStatResponse {

	private Long salesAmount;
	private Long notSalesAmount;

	public FruitStatResponse(Long salesAmount, Long notSalesAmount) {
		this.salesAmount = salesAmount;
		this.notSalesAmount = notSalesAmount;
	}

	public Long getSalesAmount() {
		return salesAmount;
	}

	public Long getNotSalesAmount() {
		return notSalesAmount;
	}
}
