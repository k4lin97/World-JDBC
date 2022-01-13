package gui;

import dao.DatabaseConnector;

import javax.swing.*;

public class MainMenu extends JFrame {
    private static final String[] options = {"Cities", "Countries", "Languages",
            "Cities by country code", "Countries by continent", "Languages by country code"};

    public MainMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("World-JDBC");

        JComboBox optionsList = new JComboBox(options);
        optionsList.setBounds(50, 80, 200, 20);
        this.add(optionsList);
        this.setLayout(null);
        this.setSize(300, 200);

        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(300, 100);
        label.setText("What would you like to show?");
        this.add(label);

        JButton button = new JButton("Show");
        button.setBounds(50, 120, 100, 20);
        this.add(button);
        button.addActionListener(e -> display(optionsList.getSelectedIndex()));

        JButton buttonExit = new JButton("Exit");
        buttonExit.setBounds(150, 120, 100, 20);
        this.add(buttonExit);
        buttonExit.addActionListener(e -> {
            System.exit(0);
            DatabaseConnector.closeConnection();
        });

        this.setVisible(true);
    }

    private static void display(int result) {
        switch (result) {
            case 0:
                Display.displayCities();
                break;
            case 1:
                Display.displayCountries();
                break;
            case 2:
                Display.displayLanguages();
                break;
            case 3:
                String countryCode = JOptionPane.showInputDialog("Enter country code:");
                if (countryCode != null) {
                    Display.displayCitiesByCountryCode(countryCode);
                }
                break;
            case 4:
                String continent = JOptionPane.showInputDialog("Enter continent:");
                if (continent != null) {
                    Display.displayCountriesByContinent(continent);
                }
                break;
            case 5:
                countryCode = JOptionPane.showInputDialog("Enter country code:");
                if (countryCode != null) {
                    Display.displayLanguagesByCountryCode(countryCode);
                }
                break;
        }
    }

    static void goBackToMainMenu() {
        int returnValue = JOptionPane.showConfirmDialog(null, "Do you want to go back to main menu?",
                "Go back", JOptionPane.YES_NO_OPTION);

        if (returnValue == JOptionPane.YES_OPTION) {
            new MainMenu();
        } else if (returnValue == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
}
