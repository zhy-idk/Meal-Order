import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTP {
    private JFrame Frame;
    private JPanel MainPanel;
    private JPanel MealPanel;
    private JPanel DessertsPanel;
    private JPanel BillPanel;

    public static void main(String[] args) {
        SwingTP order = new SwingTP();
        order.Order();
    }

    public void Order() {
        Panels();
        Meal(MealPanel);
        Drinks();
    }

    public void Panels() {
        Frame = new JFrame();
        MainPanel = new JPanel();
        MealPanel = new JPanel();
        DessertsPanel = new JPanel();
        BillPanel = new JPanel();

        MainPanel.setLayout(new CardLayout());
        MainPanel.add(MealPanel, "Meal");
        MainPanel.add(DessertsPanel, "Desserts");
        MainPanel.add(BillPanel, "Bill");

        Frame.add(MainPanel);
        Frame.setSize(500, 400);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }

    public void Meal(JPanel panel) {
        Frame.setTitle("Choose your Meal and Drinks");
        JPanel food = new JPanel(new GridLayout(0, 2, 16, 10));
        JPanel labelGroup = new JPanel(new GridLayout(0, 1, 16, 10));
        JPanel buttonGroup = new JPanel(new GridLayout(0, 1, 16, 10));
        //food.setBorder(BorderFactory.createLineBorder(Color.black));
        
        MealPanel.add(food);
        food.add(labelGroup);
        food.add(buttonGroup);
        
        // Create and add the labels
        JLabel meal1 = new JLabel("Carbonara");
        JLabel meal2 = new JLabel("Spaghetti");
        JLabel meal3 = new JLabel("Palabok");
        JLabel meal4 = new JLabel("Canton");
        JLabel meal5 = new JLabel("Sisig w/ Rice");

        // Create and add the buttons
        JButton button1 = new JButton("₱60");
        JButton button2 = new JButton("₱50");
        JButton button3 = new JButton("₱80");
        JButton button4 = new JButton("₱45");
        JButton button5 = new JButton("₱50");

        button1.setEnabled(true);
        button1.setPreferredSize(new Dimension(50, 30));
        food.setBorder(new EmptyBorder(0, 0, 0, 20));

        Font labelFont = meal1.getFont().deriveFont(16f);
        meal1.setFont(labelFont);
        meal2.setFont(labelFont);
        meal3.setFont(labelFont);
        meal4.setFont(labelFont);
        meal5.setFont(labelFont);
        
        //Set foreground color of the labels
        meal1.setForeground(Color.black);
        meal2.setForeground(Color.black);
        meal3.setForeground(Color.black);
        meal4.setForeground(Color.black); 

        JLabel label1 = new JLabel("Meals: ");
        
        label1.setFont(label1.getFont().deriveFont(20f));

        labelGroup.add(label1, 0);
        buttonGroup.add(new JLabel(""));
        labelGroup.add(meal1);
        buttonGroup.add(button1);
        labelGroup.add(meal2);
        buttonGroup.add(button2);
        labelGroup.add(meal3);
        buttonGroup.add(button3);
        labelGroup.add(meal4);
        buttonGroup.add(button4);
        labelGroup.add(meal5);
        buttonGroup.add(button5);

    }

    public void Drinks() {
        JPanel drinks = new JPanel(new GridLayout(0, 2, 16, 10));
        JPanel labelGroup = new JPanel(new GridLayout(0, 1, 16, 10));
        JPanel buttonGroup = new JPanel(new GridLayout(0, 1, 16, 10));
        //drinks.setBorder(BorderFactory.createLineBorder(Color.black));
        drinks.setBorder(new EmptyBorder(0, 20, 0, 0));

        MealPanel.add(drinks);
        drinks.add(labelGroup);
        drinks.add(buttonGroup);

        JLabel label2 = new JLabel("Drinks: ");
        label2.setFont(label2.getFont().deriveFont(20f));

        JLabel drink1 = new JLabel("Buko Juice");
        JLabel drink2 = new JLabel("Iced Tea");
        JLabel drink3 = new JLabel("Lemonade");
        JLabel drink4 = new JLabel("Coca-Cola");
        JLabel drink5 = new JLabel("Pepsi Blue");

        JButton button6 = new JButton("₱10");
        JButton button7 = new JButton("₱10");
        JButton button8 = new JButton("₱10");
        JButton button9 = new JButton("₱15");
        JButton button0 = new JButton("₱15");

        button6.setPreferredSize(new Dimension(50, 30));

        Font labelFont = drink1.getFont().deriveFont(16f);
        drink1.setFont(labelFont);
        drink2.setFont(labelFont);
        drink3.setFont(labelFont);
        drink4.setFont(labelFont);
        drink5.setFont(labelFont);

        labelGroup.add(label2, 0);
        buttonGroup.add(new JLabel(""));
        labelGroup.add(drink1);
        buttonGroup.add(button6);
        labelGroup.add(drink2);
        buttonGroup.add(button7);
        labelGroup.add(drink3);
        buttonGroup.add(button8);
        labelGroup.add(drink4);
        buttonGroup.add(button9);
        labelGroup.add(drink5);
        buttonGroup.add(button0);

    }

    public void Desserts() {
        Frame.setTitle("Choose your Desserts");

    }

    public void Check() {
        Frame.setTitle("Checkout and Payment");

    }
}
