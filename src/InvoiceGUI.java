import javax.swing.*;
import java.awt.*;

public class InvoiceGUI extends JFrame {
    private Invoice invoice;

    private JTextField customerNameField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipCodeField;

    private JTextField productNameField;
    private JTextField unitPriceField;
    private JTextField quantityField;
    private JTextArea displayArea;

    private JButton addItemButton;
    private JButton displayInvoiceButton;
    private JButton clearButton;

    /**
     * Constructs the InvoiceGUI application
     */
    public InvoiceGUI() {
        invoice = new Invoice();
        initializeComponents();
        setupLayout();
        setupEventHandlers();

        setTitle("Invoice Manager - Lab07A");
        setSize(750, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Initializes all GUI components
     */
    private void initializeComponents() {
        customerNameField = new JTextField(25);
        addressField = new JTextField(25);
        cityField = new JTextField(15);
        stateField = new JTextField(5);
        zipCodeField = new JTextField(10);

        productNameField = new JTextField(20);
        unitPriceField = new JTextField(10);
        quantityField = new JTextField(10);
        displayArea = new JTextArea(20, 50);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        addItemButton = new JButton("Add Line Item");
        displayInvoiceButton = new JButton("Display Invoice");
        clearButton = new JButton("Clear Invoice");
    }

    /**
     * Sets up the layout of all components
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));

        JPanel northContainer = new JPanel();
        northContainer.setLayout(new BoxLayout(northContainer, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Invoice", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        northContainer.add(titleLabel);

        JPanel mainInputPanel = new JPanel();
        mainInputPanel.setLayout(new BoxLayout(mainInputPanel, BoxLayout.Y_AXIS));

        JPanel customerPanel = new JPanel(new GridBagLayout());
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        customerPanel.add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        customerPanel.add(customerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        customerPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        customerPanel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        customerPanel.add(new JLabel("City:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        customerPanel.add(cityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        customerPanel.add(new JLabel("State:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.3;
        customerPanel.add(stateField, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0.7;
        JPanel zipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        zipPanel.add(new JLabel("Zip:"));
        zipPanel.add(zipCodeField);
        customerPanel.add(zipPanel, gbc);

        mainInputPanel.add(customerPanel);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Line Item Data"));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Product Name:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        inputPanel.add(productNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(new JLabel("Unit Price:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        inputPanel.add(unitPriceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        inputPanel.add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(addItemButton, gbc);

        mainInputPanel.add(inputPanel);

        northContainer.add(mainInputPanel);

        add(northContainer, BorderLayout.NORTH);

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Invoice Display"));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(displayInvoiceButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    /**
     * Sets up event handlers for buttons
     */
    private void setupEventHandlers() {
        addItemButton.addActionListener(e -> addLineItem());
        displayInvoiceButton.addActionListener(e -> displayInvoice());
        clearButton.addActionListener(e -> clearInvoice());
    }

    /**
     * Handles adding a new line item to the invoice
     */
    private void addLineItem() {
        try {
            String productName = productNameField.getText().trim();
            if (productName.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a product name.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double unitPrice = Double.parseDouble(unitPriceField.getText().trim());
            if (unitPrice < 0) {
                JOptionPane.showMessageDialog(this,
                        "Unit price cannot be negative.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity = Integer.parseInt(quantityField.getText().trim());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Quantity must be greater than 0.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Product product = new Product(productName, unitPrice);
            LineItem lineItem = new LineItem(product, quantity);
            invoice.addLineItem(lineItem);

            String unitPriceStr = String.format("$%.2f", unitPrice);
            String totalStr = String.format("$%.2f", quantity * unitPrice);
            displayArea.append(String.format("Added: %-25s Qty: %3d @ %10s = %10s\n",
                    productName, quantity, unitPriceStr, totalStr));

            productNameField.setText("");
            unitPriceField.setText("");
            quantityField.setText("");
            productNameField.requestFocus();

            JOptionPane.showMessageDialog(this,
                    "Line item added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for price and quantity.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays the formatted invoice
     */
    private void displayInvoice() {
        if (invoice.getLineItems().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No items in invoice. Please add items first.",
                    "Empty Invoice",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = customerNameField.getText().trim();
        String addr = addressField.getText().trim();
        String city = cityField.getText().trim();
        String state = stateField.getText().trim();
        String zip = zipCodeField.getText().trim();

        if (!name.isEmpty() || !addr.isEmpty()) {
            invoice.setCustomerInfo(name, addr, city, state, zip);
        }

        displayArea.setText(invoice.toString());
    }

    /**
     * Clears all items from the invoice
     */
    private void clearInvoice() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to clear the invoice?",
                "Confirm Clear",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            invoice.clear();
            displayArea.setText("");
            customerNameField.setText("");
            addressField.setText("");
            cityField.setText("");
            stateField.setText("");
            zipCodeField.setText("");
            productNameField.setText("");
            unitPriceField.setText("");
            quantityField.setText("");
            productNameField.requestFocus();

            JOptionPane.showMessageDialog(this,
                    "Invoice cleared.",
                    "Cleared",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Main method to launch the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvoiceGUI gui = new InvoiceGUI();
            gui.setVisible(true);
        });
    }
}