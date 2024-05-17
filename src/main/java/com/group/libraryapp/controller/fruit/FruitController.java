package com.group.libraryapp.controller.fruit;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.fruit.request.FruitSaveRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitOptionResponse;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;
import com.group.libraryapp.service.fruit.FruitService;

@RestController
public class FruitController {

	private final FruitService fruitService;

	public FruitController(FruitService fruitService) {
		this.fruitService = fruitService;
	}

	@PostMapping("/api/v1/fruit")
	public void saveFruit(@RequestBody FruitSaveRequest request) {
		fruitService.saveFruit(request);
	}

	@PutMapping("/api/v1/fruit")
	public void updateFruit(@RequestBody FruitUpdateRequest request) {
		fruitService.updateFruit(request);
	}

	@GetMapping("/api/v1/fruit/stat")
	public FruitStatResponse getStat(@RequestParam String name) {
		return fruitService.getStat(name);
	}

	@GetMapping("/api/v1/fruit/count")
	public FruitCountResponse getCount(@RequestParam String name) {
		return fruitService.getCount(name);
	}

	@GetMapping("/api/v1/fruit/list")
	public List<FruitOptionResponse> getOptionList(@RequestParam String option, @RequestParam Long price) {
		return fruitService.getOptionList(option, price);
	}
}
