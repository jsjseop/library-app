package com.group.libraryapp.service.fruit;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.fruit.request.FruitSaveRequest;
import com.group.libraryapp.dto.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.fruit.response.FruitCountResponse;
import com.group.libraryapp.dto.fruit.response.FruitOptionResponse;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;

@Service
public class FruitService {

	private final FruitRepository fruitRepository;

	public FruitService(FruitRepository fruitRepository) {
		this.fruitRepository = fruitRepository;
	}

	@Transactional
	public void saveFruit(FruitSaveRequest request) {
		Fruit fruit = new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice());
		fruitRepository.save(fruit);
	}

	@Transactional
	public void updateFruit(FruitUpdateRequest request) {
		Fruit fruit = fruitRepository.findById(request.getId())
			.orElseThrow(IllegalArgumentException::new);
		fruit.sold();
	}

	@Transactional(readOnly = true)
	public FruitStatResponse getStat(String name) {
		Long salesAmount = fruitRepository.findAllByNameAndIsSold(name, true).stream()
			.mapToLong(Fruit::getPrice)
			.sum();
		Long notSalesAmount = fruitRepository.findAllByNameAndIsSold(name, false).stream()
			.mapToLong(Fruit::getPrice)
			.sum();

		return new FruitStatResponse(salesAmount, notSalesAmount);
	}

	@Transactional(readOnly = true)
	public FruitCountResponse getCount(String name) {
		return new FruitCountResponse(fruitRepository.countByName(name));
	}

	@Transactional
	public List<FruitOptionResponse> getOptionList(String option, Long price) {
		List<Fruit> fruits;
		if (option.equals("GTE")) {
			fruits = fruitRepository.findAllByIsSoldIsFalseAndPriceGreaterThanEqual(price);
		} else if (option.equals("LTE")){
			fruits = fruitRepository.findAllByIsSoldIsFalseAndPriceLessThanEqual(price);
		} else {
			throw new IllegalArgumentException();
		}
		return fruits.stream()
			.map(fruit -> new FruitOptionResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()))
			.collect(Collectors.toList());
	}
}
