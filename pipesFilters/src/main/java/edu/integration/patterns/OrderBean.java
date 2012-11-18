package edu.integration.patterns;

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
        return "username: " + username + "; password: " + password + "; itemId: " + itemId;
    }
}
