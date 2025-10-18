public class LineItem {
    private int quantity;
    private Product product;

    /**
     * Constructs a LineItem with a product and quantity
     * @param product the product for this line item
     * @param quantity the quantity ordered
     */
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Gets the quantity
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the product
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Calculates the total for this line item
     * @return quantity * unit price
     */
    public double getTotal() {
        return quantity * product.getUnitPrice();
    }

    @Override
    public String toString() {
        return String.format("%-20s  Qty: %3d  @ $%8.2f  = $%10.2f",
                product.getName(),
                quantity,
                product.getUnitPrice(),
                getTotal());
    }
}