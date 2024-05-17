package com.group.libraryapp.dto.calculator.response;

public class CalculateResponse {

	private int add;
	private int minus;
	private int multiply;

	public CalculateResponse(int add, int minus, int multiply) {
		this.add = add;
		this.minus = minus;
		this.multiply = multiply;
	}

	public int getAdd() {
		return add;
	}

	public int getMinus() {
		return minus;
	}

	public int getMultiply() {
		return multiply;
	}
}
