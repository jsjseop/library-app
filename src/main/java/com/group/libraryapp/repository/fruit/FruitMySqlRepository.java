package com.group.libraryapp.repository.fruit;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;

@Repository
public class FruitMySqlRepository implements FruitRepositoryInterface {

	private final JdbcTemplate jdbcTemplate;

	public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Fruit fruit) {
		String sql = "INSERT INTO fruit (name, warehousingdate, price) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice());
	}

	public boolean isFruitNotExist(Long id) {
		String sql = "SELECT * FROM fruit WHERE id = ?";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 0, id).isEmpty();
	}

	public void updateSold(Long id) {
		String sql = "UPDATE fruit SET sold = true WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	public FruitStatResponse getStat(String name) {
		String sql = "SELECT SUM(CASE WHEN sold = true THEN price ELSE 0 END) salesamount, "
			+ "SUM(CASE WHEN sold = false THEN price ELSE 0 END) notsalesamount "
			+ "FROM fruit WHERE name = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new FruitStatResponse(
				rs.getLong("salesamount"),
				rs.getLong("notsalesamount")
			), name);
	}
}
