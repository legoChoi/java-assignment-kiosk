package menuItem;

public record BeverageMenuItemImpl(String name, double price, String description) implements MenuItem {

    public BeverageMenuItemImpl(BeverageMenuItemImpl original) {
        this(original.name, original.price, original.description);
    }

    @Override
    public String toString() {
        return String.format(
                "%s | W %.1f | %s",
                name(), price(), description());
    }
}
