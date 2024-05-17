package com.group.libraryapp.domain.fruit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

	List<Fruit> findAllByNameAndIsSold(String name, boolean isSold);

	long countByName(String name);

	List<Fruit> findAllByIsSoldIsFalseAndPriceGreaterThanEqual(Long price);

	List<Fruit> findAllByIsSoldIsFalseAndPriceLessThanEqual(Long price);
}
