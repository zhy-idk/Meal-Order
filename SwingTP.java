import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SwingTP {
    private JFrame Frame;
    private JPanel MainPanel, MealPanel, DessertsPanel, BillPanel;
    private JPanel food, drinks, sweets;
    private List<JCheckBox> mealList, drinkList, dessertList;
    private String[] order1, order2, order3;

    public SwingTP() {
        Frame = new JFrame();
        MainPanel = new JPanel();
        MealPanel = new JPanel();
        DessertsPanel = new JPanel();
        BillPanel = new JPanel();

        food = new JPanel(new GridLayout(0, 1, 16, 10));
        drinks = new JPanel(new GridLayout(0, 1, 16, 10));
        sweets = new JPanel(new GridLayout(0, 2, 16, 10));

        MealPanel.add(food);
        MealPanel.add(drinks);
        DessertsPanel.add(sweets);

        order1 = new String[2];
        order2 = new String[2];
        order3 = new String[2];

        order1[0] = "Carbonara";
        order1[1] = "60";
        order2[0] = "Buko Juice";
        order2[1] = "10";
        order3[0] = "";
        order3[1] = "";

        MainPanel.setLayout(new CardLayout());
        MainPanel.add(MealPanel, "Meal");
        MainPanel.add(DessertsPanel, "Desserts");
        MainPanel.add(BillPanel, "Bill");

        MealPanel.setLayout(new GridBagLayout());
        DessertsPanel.setLayout(new GridBagLayout());
        BillPanel.setLayout(new GridBagLayout());

        Frame.add(MainPanel);
        Frame.setSize(500, 400);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);

        MealsAndDrinks();
        Desserts();
    }

    public void MealsAndDrinks() {
        Frame.setTitle("Choose your Meal and Drinks");
        food.setBorder(new EmptyBorder(1, 1, 1, 50));
        
        JCheckBox meal1 = new JCheckBox("Carbonara (₱60)");
        JCheckBox meal2 = new JCheckBox("Spaghetti (₱50)");
        JCheckBox meal3 = new JCheckBox("Palabok (₱80)");
        JCheckBox meal4 = new JCheckBox("Canton (₱45)");
        JCheckBox meal5 = new JCheckBox("Lasagna (₱65)");

        meal1.setSelected(true);

        mealList = new ArrayList<>();
        mealList.add(meal1);
        mealList.add(meal2);
        mealList.add(meal3);
        mealList.add(meal4);
        mealList.add(meal5);

        Font labelFont = meal1.getFont().deriveFont(17f);
        meal1.setFont(labelFont);
        meal2.setFont(labelFont);
        meal3.setFont(labelFont);
        meal4.setFont(labelFont);
        meal5.setFont(labelFont);

        JLabel label1 = new JLabel("Meals: ");
        
        label1.setFont(label1.getFont().deriveFont(20f));

        food.add(label1);
        food.add(meal1);
        food.add(meal2);
        food.add(meal3);
        food.add(meal4);
        food.add(meal5);

        drinks.setBorder(new EmptyBorder(1, 50, 1, 1));

        JLabel label2 = new JLabel("Drinks: ");
        label2.setFont(label2.getFont().deriveFont(20f));

        JCheckBox drink1 = new JCheckBox("Buko Juice (₱10)");
        JCheckBox drink2 = new JCheckBox("Iced Tea (₱10)");
        JCheckBox drink3 = new JCheckBox("Lemonade (₱10)");
        JCheckBox drink4 = new JCheckBox("Coca-Cola (₱15)");
        JCheckBox drink5 = new JCheckBox("Pepsi Blue (₱15)");

        drink1.setSelected(true);

        drinkList = new ArrayList<>();
        drinkList.add(drink1);
        drinkList.add(drink2);
        drinkList.add(drink3);
        drinkList.add(drink4);
        drinkList.add(drink5);
        
        drink1.setFont(labelFont);
        drink2.setFont(labelFont);
        drink3.setFont(labelFont);
        drink4.setFont(labelFont);
        drink5.setFont(labelFont);

        drinks.add(label2);
        drinks.add(drink1);
        drinks.add(drink2);
        drinks.add(drink3);
        drinks.add(drink4);
        drinks.add(drink5);

        JPanel buttons = new JPanel(new GridLayout(0, 2, 70, 0));
        JButton skip = new JButton("Checkout");
        JButton next = new JButton("Desserts");

        skip.setPreferredSize(new Dimension(100, 30));
        next.setPreferredSize(new Dimension(100, 30));

        buttons.add(skip);
        buttons.add(next);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(30, 0, 0, 0);

        MealPanel.add(buttons, constraints);

        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == skip) {
                    cardLayout.show(MainPanel, "Bill");
                    Check();
                }
                else if (e.getSource() == next) {
                    cardLayout.next(MainPanel);
                }
            }
        };

        skip.addActionListener(buttonListener);
        next.addActionListener(buttonListener);

        ActionListener mealListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JCheckBox checkbox : mealList) {
                    if (checkbox != e.getSource()) {
                        checkbox.setSelected(false);
                    } else {
                        checkbox.setSelected(true);
                        String order = checkbox.getText();
                        order1[0] = order.substring(0, order.indexOf("(") - 1);
                        order1[1] = order.substring(order.indexOf("₱") + 1, order.indexOf(")"));
                    }
                }
            }
        };

        ActionListener drinkListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JCheckBox checkbox : drinkList) {
                    if (checkbox != e.getSource()) {
                        checkbox.setSelected(false);
                    } else {
                        checkbox.setSelected(true);
                        String order = checkbox.getText();
                        order2[0] = order.substring(0, order.indexOf("(") - 1);
                        order2[1] = order.substring(order.indexOf("₱") + 1, order.indexOf(")"));
                    }
                }
            }
        };

        for (JCheckBox checkbox : mealList) {
            checkbox.addActionListener(mealListener);
        }
        
        for (JCheckBox checkbox : drinkList) {
            checkbox.addActionListener(drinkListener);
        }
    }

    public void Desserts() {
        Frame.setTitle("Choose your Desserts");

        JLabel label3 = new JLabel("Desserts: ");
        label3.setFont(label3.getFont().deriveFont(20f));

        JCheckBox sweet1 = new JCheckBox("Halo-halo (₱40)");
        JCheckBox sweet2 = new JCheckBox("Leche Flan (₱30)");
        JCheckBox sweet3 = new JCheckBox("Ice Cream (₱30)");
        JCheckBox sweet4 = new JCheckBox("Milk Shake (₱40)");
        JCheckBox sweet5 = new JCheckBox("Maja Blanca (₱30)");
        JCheckBox sweet6 = new JCheckBox("Choco Pudding (₱35)");
        JCheckBox sweet7 = new JCheckBox("Cake Slice (₱35)");
        JCheckBox sweet8 = new JCheckBox("Glazed Doughnut (₱35)");
        JCheckBox sweet9 = new JCheckBox("Egg Custard Tart (₱40)");
        JCheckBox sweet0 = new JCheckBox("Strawberry Taho (₱30)");

        dessertList = new ArrayList<>();
        dessertList.add(sweet1);
        dessertList.add(sweet2);
        dessertList.add(sweet3);
        dessertList.add(sweet4);
        dessertList.add(sweet5);
        dessertList.add(sweet6);
        dessertList.add(sweet7);
        dessertList.add(sweet8);
        dessertList.add(sweet9);
        dessertList.add(sweet0);

        Font labelFont = sweet1.getFont().deriveFont(17f);
        sweet1.setFont(labelFont);
        sweet2.setFont(labelFont);
        sweet3.setFont(labelFont);
        sweet4.setFont(labelFont);
        sweet5.setFont(labelFont);
        sweet6.setFont(labelFont);
        sweet7.setFont(labelFont);
        sweet8.setFont(labelFont);
        sweet9.setFont(labelFont);
        sweet0.setFont(labelFont);

        sweets.add(label3);
        sweets.add(new JLabel(""));
        sweets.add(sweet1);
        sweets.add(sweet2);
        sweets.add(sweet3);
        sweets.add(sweet4);
        sweets.add(sweet5);
        sweets.add(sweet6);
        sweets.add(sweet7);
        sweets.add(sweet8);
        sweets.add(sweet9);
        sweets.add(sweet0);

        JPanel buttons = new JPanel(new GridLayout(0, 2, 70, 0));
        JButton back = new JButton("Back");
        JButton next = new JButton("Checkout");

        back.setPreferredSize(new Dimension(100, 30));
        next.setPreferredSize(new Dimension(100, 30));

        buttons.add(back);
        buttons.add(next);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(30, 0, 0, 0);

        DessertsPanel.add(buttons, constraints);

        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == back) {
                    cardLayout.show(MainPanel, "Meal");
                }
                else if (e.getSource() == next) {
                    cardLayout.next(MainPanel);
                    Check();
                }
            }
        };

        back.addActionListener(buttonListener);
        next.addActionListener(buttonListener);

        ActionListener sweetListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JCheckBox checkbox : dessertList) {
                    if (checkbox != e.getSource()) {
                        checkbox.setSelected(false);
                    } else {
                        if (checkbox.isSelected()) {
                            String order = checkbox.getText();
                            order3[0] = order.substring(0, order.indexOf("(") - 1);
                            order3[1] = order.substring(order.indexOf("₱") + 1, order.indexOf(")"));
                        } else {
                            order3[0] = "";
                            order3[1] = "";
                        }
                    }
                }
            }
        };

        for (JCheckBox checkbox : dessertList) {
            checkbox.addActionListener(sweetListener);
        }
    }

    public void Check() {
        Frame.setTitle("Checkout and Payment");
        BillPanel.removeAll();
    
        int price1 = Integer.parseInt(order1[1]);
        int price2 = Integer.parseInt(order2[1]);
        final int price3;
    
        JPanel check = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0);
    
        JPanel itemNames = new JPanel(new GridLayout(0, 1, 0, 10));
        JPanel itemAmount = new JPanel(new GridLayout(0, 1, 0, 10));
        itemNames.setBorder(new EmptyBorder(1, 1, 1, 50));
        itemAmount.setBorder(new EmptyBorder(1, 50, 1, 1));

        JLabel label4 = new JLabel("Amount: ");
        label4.setFont(label4.getFont().deriveFont(20f));
    
        JLabel item1 = new JLabel(order1[0]);
        JLabel item2 = new JLabel(order2[0]);
        JLabel item3 = new JLabel(order3[0]);
    
        String[] amount = {"1", "2", "3"};
    
        JComboBox<String> amount1 = new JComboBox<>(amount);
        JComboBox<String> amount2 = new JComboBox<>(amount);
        JComboBox<String> amount3 = new JComboBox<>(amount);
    
        Font labelFont = item1.getFont().deriveFont(17f);
        item1.setFont(labelFont);
        item2.setFont(labelFont);
        item3.setFont(labelFont);
    
        itemNames.add(label4);
        itemAmount.add(new JLabel(""));
        itemNames.add(item1);
        itemAmount.add(amount1);
        itemNames.add(item2);
        itemAmount.add(amount2);
        itemNames.add(item3);
        itemAmount.add(amount3);
    
        if (order3[0].equals("")) {
            item3.setVisible(false);
            amount3.setVisible(false);
            price3 = 0;
        } else {
            price3 = Integer.parseInt(order3[1]);
        }
    
        JLabel total = new JLabel("Total: ₱" + (price1 + price2 + price3));
        total.setFont(label4.getFont().deriveFont(20f));
    
        check.add(itemNames, gbc);
    
        gbc.gridx = 1;
        check.add(itemAmount, gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        check.add(total, gbc);

        ActionListener amountListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedAmount1 = Integer.parseInt(amount1.getSelectedItem().toString());
                int selectedAmount2 = Integer.parseInt(amount2.getSelectedItem().toString());
                int selectedAmount3 = Integer.parseInt(amount3.getSelectedItem().toString());
    
                int newTotal = price1 * selectedAmount1 + price2 * selectedAmount2 + price3 * selectedAmount3;
                total.setText("Total: ₱" + newTotal);
            }
        };
    
        amount1.addActionListener(amountListener);
        amount2.addActionListener(amountListener);
        amount3.addActionListener(amountListener);

        KeyListener NumberKeyListener = new KeyListener()  {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
    
            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
    
        JPanel billPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel billLabel = new JLabel("Bill: ");
        JTextField billField = new JTextField(15);
        billField.addKeyListener(NumberKeyListener);
        billField.setPreferredSize(new Dimension(200, 30));
        billField.setFont(labelFont);
        billPanel.add(billLabel);
        billPanel.add(billField);

        billLabel.setFont(labelFont);
    
        JPanel buttons = new JPanel(new GridLayout(0, 2, 70, 0));
        JButton back = new JButton("Back");
        JButton next = new JButton("Pay");
    
        back.setPreferredSize(new Dimension(100, 30));
        next.setPreferredSize(new Dimension(100, 30));
    
        CardLayout cardLayout = (CardLayout) MainPanel.getLayout();
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(MainPanel, "Meal");
            }
        };

        ActionListener payButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalPrice = price1 + price2 + price3;
                int billAmount = Integer.parseInt(billField.getText());
                int change = billAmount - totalPrice;
        
                JLabel insufficient = new JLabel("Insufficient payment!");
                JPanel thanks = new JPanel(new GridLayout(2, 1, 0, 0));
                JLabel message1 = new JLabel("Thank you!");
                JLabel message2 = new JLabel("Your Change Amount: ₱" + change);

                thanks.add(message1);
                thanks.add(message2);
        
                message1.setFont(labelFont);
                message2.setFont(labelFont);
                insufficient.setFont(labelFont);
        
                if (change < 0) {
                    JOptionPane.showMessageDialog(Frame, insufficient, "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Frame, thanks, "Payment Complete", JOptionPane.INFORMATION_MESSAGE);
                    Frame.dispose();
                }
            }
        };
        
        back.addActionListener(buttonListener);
        next.addActionListener(payButtonListener);
        billField.addKeyListener(NumberKeyListener);
    
        buttons.add(back);
        buttons.add(next);
    
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 15, 0);
        BillPanel.add(check, constraints);
    
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 0, 35, 0);
        BillPanel.add(billPanel, constraints);
    
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        BillPanel.add(buttons, constraints);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingTP x = new SwingTP();
                x.Frame.setVisible(true);
            }
        });
    }
}