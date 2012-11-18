package edu.integration.patterns;

/**
 * Immutable bean which encapsulates an order
 * 
 * @author Diyan Yordanov
 * 
 */
public class OrderBean {

    private final String username;
    private final String password;
    private final long itemId;

    public OrderBean(String username, String password, long itemId) {
        this.username = username;
        this.password = password;
        this.itemId = itemId;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("username: ").append(username).append("; password: ").append(password)
                .append("; itemId: ").append(itemId);
        return result.toString();
    }
}
