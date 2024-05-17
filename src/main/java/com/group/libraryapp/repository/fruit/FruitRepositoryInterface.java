package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;

public interface FruitRepositoryInterface {

	void save(Fruit fruit);

	boolean isFruitNotExist(Long id);

	void updateSold(Long id);

	FruitStatResponse getStat(String name);
}
