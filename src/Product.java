public class Product {
    private String name;
    private double unitPrice;

    /**
     * Constructs a Product with given name and unit price
     * @param name the product name
     * @param unitPrice the price per unit
     */
    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the product name
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unit price
     * @return the unit price
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%s ($%.2f)", name, unitPrice);
    }
}