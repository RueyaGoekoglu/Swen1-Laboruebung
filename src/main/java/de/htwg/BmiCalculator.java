package de.htwg;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BmiCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BmiCalculator::createAndShowGui);
    }

    private static void createAndShowGui() {
        // Erstellen des Hauptfensters
        JFrame frame = new JFrame("BMI-Rechner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout());

        // GUI-Komponenten
        JLabel heightLabel = new JLabel("Größe (m):");
        JTextField heightField = new JTextField(10);
        JLabel weightLabel = new JLabel("Gewicht (kg):");
        JTextField weightField = new JTextField(10);
        JLabel resultLabel = new JLabel("Ihr BMI: ");
        JButton calculateButton = new JButton("Berechne BMI");

        // Layout-Konfiguration
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(heightLabel, gbc);

        gbc.gridx = 1;
        frame.add(heightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(weightLabel, gbc);

        gbc.gridx = 1;
        frame.add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(calculateButton, gbc);

        gbc.gridy = 3;
        frame.add(resultLabel, gbc);

        // ActionListener für den Button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());
                    double bmi =  Bmi.calc(weight, height);
                    resultLabel.setText(String.format("Ihr BMI: %.2f", bmi));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Bitte geben Sie gültige Zahlen ein.");
                }
            }
        });

        // Fenster sichtbar machen
        frame.setLocationRelativeTo(null); // zentriert das Fenster
        frame.setVisible(true);
    }

}
