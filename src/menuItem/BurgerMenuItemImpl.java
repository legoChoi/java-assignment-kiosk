package menuItem;

public record BurgerMenuItemImpl(String name, double price, String description) implements MenuItem, Cloneable {

    public BurgerMenuItemImpl(BurgerMenuItemImpl original) {
        this(original.name, original.price, original.description);
    }

    @Override
    public String toString() {
        return String.format(
                "%s | W %.1f | %s",
                name(), price(), description());
    }

    @Override
    public MenuItem clone() throws CloneNotSupportedException {
        return (MenuItem) super.clone();
    }
}
