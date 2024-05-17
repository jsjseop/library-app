package com.group.libraryapp.controller.calculator;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorSumRequest;
import com.group.libraryapp.dto.calculator.response.CalculateResponse;
import com.group.libraryapp.dto.calculator.response.DayOfTheWeekResponse;

@RestController
public class CalculatorController {

	@GetMapping("/add")
	public int addTwoNumbers(CalculatorAddRequest request) {
		return request.getNumber1() + request.getNumber2();
	}

	@PostMapping("/multiply")
	public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
		return request.getNumber1() * request.getNumber2();
	}

	@GetMapping("/api/v1/calc")
	public CalculateResponse calculateTwoNumbers(@RequestParam int number1, @RequestParam int number2) {
		return new CalculateResponse(number1 + number2, number1 - number2, number1 * number2);
	}

	@GetMapping("/api/v1/day-of-the-week")
	public DayOfTheWeekResponse calculateDayOfTheWeek(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		return new DayOfTheWeekResponse(dayOfWeek.name());
	}

	@PostMapping("/api/v1/sum")
	public int calculateSum(@RequestBody CalculatorSumRequest request) {
		int sum = 0;
		for (Integer number : request.getNumbers()) {
			sum += number;
		}
		return sum;
	}
}
