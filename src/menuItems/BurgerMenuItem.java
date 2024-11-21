package menuItems;

public class BurgerMenuItem implements MenuItem {
    private String name;
    private double price;
    private String description;

    public BurgerMenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
