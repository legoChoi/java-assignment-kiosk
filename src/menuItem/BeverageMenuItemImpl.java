package menuItem;

public record BeverageMenuItemImpl(String name, double price, String description) implements MenuItem {

    @Override
    public String toString() {
        return String.format(
                "%s | W %.1f | %s",
                name(), price(), description());
    }
}
