package edu.integration.patterns;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Martin
 */
public class OrderResult {
	
	private String manufacturer;

	private Integer resellerOrderNumber;
	
	private Long itemId;

	private BigDecimal price;

	public OrderResult(Long itemId, BigDecimal price,
			Integer resellerOrderNumber, String manufacturer) {
		this.itemId = itemId;
		this.price = price;
		this.resellerOrderNumber = resellerOrderNumber;
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public Long getItemId() {
		return itemId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getResellerOrderNumber() {
		return resellerOrderNumber;
	}
	
	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();
		result.append("manufacturer: ").append(manufacturer)
				.append("; itemId: ").append(itemId).append("; price: ")
				.append(price);
		return result.toString();
	}
}
