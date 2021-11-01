package edu.uchicago.gerber._05dice.P10_19;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Restaurant extends JFrame implements ActionListener {
    private JButton[] PopularItems;
    private JTextField otherItemField, otherItemPrice;
    private JButton billTotal;
    private JLabel otherItem, price;
    private JTextArea showTotal;


    private double cost;

    public Restaurant() {
        initialize();
    }

    private void initialize() {
        cost = 0;
        PopularItems = new JButton[10];
        PopularItems[0] = new JButton("BBQ Brisket - $15.00");
        PopularItems[1] = new JButton("Shrimp Pad Thai - $12.00");
        PopularItems[2] = new JButton("Old Fashioned - $10.00");
        PopularItems[3] = new JButton("Cold Brew - $3.50");
        PopularItems[4] = new JButton("Spring Rolls - $5.00");
        PopularItems[5] = new JButton("Kobe Beef - $120.00");
        PopularItems[6] = new JButton("Tequila Shot - $7.00");
        PopularItems[7] = new JButton("Pepperoni Pizza - $14.00");
        PopularItems[8] = new JButton("Onion Rings - $6.00");
        PopularItems[9] = new JButton("Tikka Masala - $16.00");
        setLayout(new GridLayout(10, 2));

        for (JButton button: PopularItems) {
            button.addActionListener(this);
            add(button);
        }

        otherItem = new JLabel("Other Item:");
        add(otherItem);
        price = new JLabel("Other Item Price:");
        add(price);
        otherItemField = new JTextField();
        add(otherItemField);
        otherItemPrice = new JTextField();
        add(otherItemPrice);

        billTotal = new JButton("Calculate Bill");
        add(billTotal);
        showTotal = new JTextArea(3, 1);
        add(showTotal);
        billTotal.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Calculate Bill":
                String s = otherItemPrice.getText();
                if (s.length() > 0) {
                    double additionalCost = Double.parseDouble(s);
                    cost += additionalCost;
                }
                String showSubtotal = String.format("%.2f", cost);
                String roundTax = String.format("%.2f", cost*0.10);
                String roundTip = String.format("%.2f", cost*0.2);
                showTotal.setText("Subtotal: " + showSubtotal + "\nSales Tax: " + roundTax + "\nSuggested Tip: " + roundTip);
                showTotal.setEditable(false);
                break;

            case "BBQ Brisket - $15.00":
                cost += 15;
                break;

            case "Shrimp Pad Thai - $12.00":
                cost += 12;
                break;

            case "Old Fashioned - $10.00":
                cost += 10;
                break;

            case "Cold Brew - $3.50":
                cost += 3.50;
                break;

            case "Spring Rolls - $5.00":
                cost += 5;
                break;

            case "Kobe Beef - $120.00":
                cost += 120;
                break;

            case "Tequila Shot - $7.00":
                cost += 7;
                break;

            case "Pepperoni Pizza - $14.00":
                cost += 14;
                break;

            case "Onion Rings - $6.00":
                cost += 6;
                break;

            case "Tikka Masala - $16.00":
                cost += 16;
                break;
        }
    }
}
