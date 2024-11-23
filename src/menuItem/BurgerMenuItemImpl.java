package menuItem;

public record BurgerMenuItemImpl(String name, double price, String description) implements MenuItem, Cloneable {

    /**
     * 복사 생성자
     * @param original 복사 대상
     */
    public BurgerMenuItemImpl(BurgerMenuItemImpl original) {
        this(original.name, original.price, original.description);
    }

    @Override
    public String toString() {
        return String.format(
                "%s | W %.1f | %s",
                name(), price(), description());
    }
}
