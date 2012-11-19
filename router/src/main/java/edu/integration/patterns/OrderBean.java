package edu.integration.patterns;

import java.io.Serializable;

/**
 * Immutable bean which encapsulates an order
 * 
 * @author Diyan Yordanov
 */
public class OrderBean implements Serializable {
	
	private static final long serialVersionUID = 3859799485102469917L;
	private final String username;
    private final String password;
    private final String manufacturer;
    private final long itemId;
    
	public OrderBean(String username, String password, long itemId,
			String manufacturer) {
		this.username = username;
		this.password = password;
		this.itemId = itemId;
		this.manufacturer = manufacturer;
	}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getItemId() {
        return itemId;
    }

    public String getManufacturer() {
		return manufacturer;
	}
    
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("username: ").append(username).append("; password: ")
				.append(password).append("; itemId: ").append(itemId)
				.append("; manufacturer: ").append(manufacturer);
		return result.toString();
	}
}
