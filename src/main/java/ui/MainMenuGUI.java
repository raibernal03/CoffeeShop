package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuGUI  extends JFrame {
    ;
    JTextArea textArea;
    JButton newOrderButton, addDrinkButton, addPastryButton, checkoutButton, backButton, viewCartButton;
    MainMenuGUI() {
        init();
    }
    public void init(){
        this.setTitle("Galileo's Coffee Shop");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        ImageIcon logo = new ImageIcon("src/main/resources/Starbucks.png");
        this.setIconImage(logo.getImage());
    }


}
