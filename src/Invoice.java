import java.util.ArrayList;

public class Invoice {
    private ArrayList<LineItem> lineItems;
    private String customerName;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    /**
     * Constructs an empty Invoice
     */
    public Invoice() {
        lineItems = new ArrayList<>();
        customerName = "";
        address = "";
        city = "";
        state = "";
        zipCode = "";
    }

    /**
     * Sets the customer address information
     * @param name customer name
     * @param address street address
     * @param city city
     * @param state state
     * @param zipCode zip code
     */
    public void setCustomerInfo(String name, String address, String city, String state, String zipCode) {
        this.customerName = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * Gets the customer name
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Gets the street address
     * @return street address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the state
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the zip code
     * @return zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Adds a line item to the invoice
     * @param item the line item to add
     */
    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    /**
     * Gets all line items
     * @return the list of line items
     */
    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * Calculates the total amount due for the invoice
     * @return the sum of all line item totals
     */
    public double getTotalDue() {
        double total = 0.0;
        for (LineItem item : lineItems) {
            total += item.getTotal();
        }
        return total;
    }

    /**
     * Clears all line items from the invoice
     */
    public void clear() {
        lineItems.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("============================ INVOICE ============================\n\n");

        if (!customerName.isEmpty()) {
            sb.append("Bill To:\n");
            sb.append(customerName).append("\n");
            sb.append(address).append("\n");
            sb.append(city).append(", ").append(state).append(" ").append(zipCode).append("\n\n");
        }

        sb.append(String.format("%-25s %5s %16s %16s\n",
                "Product", "Qty", "Unit Price", "Total"));
        sb.append("=================================================================\n");

        for (LineItem item : lineItems) {
            String unitPrice = String.format("$%.2f", item.getProduct().getUnitPrice());
            String total = String.format("$%.2f", item.getTotal());
            sb.append(String.format("%-25s %5d %16s %16s\n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    unitPrice,
                    total));
        }

        sb.append("=================================================================\n");
        String totalDue = String.format("$%.2f", getTotalDue());
        sb.append(String.format("%48s %16s\n", "TOTAL AMOUNT DUE:", totalDue));
        sb.append("=================================================================\n");

        return sb.toString();
    }
}