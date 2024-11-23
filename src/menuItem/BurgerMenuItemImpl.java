package menuItem;

public class BurgerMenuItemImpl implements MenuItem {
    private String name;
    private double price;
    private String description;

    public BurgerMenuItemImpl(String name, double price, String description) {
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

    @Override
    public String toString() {
        return String.format(
                "%s | W %.1f | %s",
                getName(), getPrice(), getDescription());
    }
}
