package module;


public class User {

    private int id;
    private String name;
    private String password;
    private int level;
    private Cart cart;

    public User(String name, String password) {
	this.name = name;
	this.password = password;
	this.level = CustmerLevel.Default.getDbValue();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getLevel() {
	return level;
    }

    public void setLevel(int level) {
	this.level = level;
    }

    public Cart getCart() {
	return cart;
    }

    public void setCart(Cart cart) {
	this.cart = cart;
    }

    public int getId() {
	return id;
    }

}
