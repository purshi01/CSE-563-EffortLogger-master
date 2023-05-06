/* This class represents a person.
 *
 * Author: Saurav Sarkar
 * Date: March 26, 2023
 */
package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class Login extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextField textField_1;

    private JPanel contentPane;

    private HashMap<String, String> savedPasswords;

    // Constructor method that creates and sets up the GUI for the login form
    public Login() {
        super("Login");
        setTitle("Login Form");
        addPasswords();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new Gpanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        getContentPane().setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setName("Error");
        lblNewLabel_3.setBounds(113, 199, 331, 16);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(Color.RED);
        getContentPane().add(lblNewLabel_3);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("UserName");
        lblNewLabel.setName("UserName");
        lblNewLabel.setBounds(195, 56, 84, 16);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setName("UserNameInput");
        textField.setBounds(287, 51, 130, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setName("Password");
        lblNewLabel_1.setBounds(195, 94, 61, 16);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setName("PasswordInput");
        textField_1.setBounds(287, 89, 130, 26);
        contentPane.add(textField_1);
        textField_1.setColumns(10);


        JButton btnNewButton = new JButton("Login");
        btnNewButton.setName("Login");
        btnNewButton.setBounds(246, 164, 117, 29);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
        lblNewLabel_2.setIcon(new ImageIcon(img));
        lblNewLabel_2.setBounds(21, 56, 162, 137);
        contentPane.add(lblNewLabel_2);
        btnNewButton.addActionListener(this);
    }

    // ActionListener method that is called when the login button is clicked. Validates the input, hashes the password using SHA-256, and logs the user in if the username and password are correct
    public void actionPerformed(ActionEvent event) {
        String username = textField.getText();
        char[] password = textField_1.getText().toCharArray();

        // Validate input
        if (!validateInput(username, password)) {
            return;
        }

        // Hash the password using SHA-256
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = digest.digest(new String(password).getBytes());

            System.out.println("Password" + password);

            System.out.println("Hashed password: " + Arrays.toString(hashedPassword));

            System.out.println("Converted Hash password");

            if (savedPasswords.containsKey(username) && savedPasswords.get(username).equals(Arrays.toString(hashedPassword))) {
                EffortLogger effortLogger = new EffortLogger();
                setVisible(false);
                effortLogger.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Private method that checks if the input for the username and password fields is valid
    private boolean validateInput(String username, char[] password) {
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password == null || password.length == 0) {
            JOptionPane.showMessageDialog(this, "Please enter a password.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Private method that initializes a HashMap to store pre-saved usernames and passwords (in this case, only one)
    private void addPasswords() {
        savedPasswords = new HashMap<>();
        savedPasswords.put("abc", "[-90, 101, -92, 89, 32, 66, 47, -99, 65, 126, 72, 103, -17, -36, 79, -72, -96, 74, 31, 63, -1, 31, -96, 126, -103, -114, -122, -9, -9, -94, 122, -29]");
    }

    // Private inner class that extends JPanel and overrides its paintComponent method to draw a green background with some ovals
    private class Gpanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            for (int i = 0; i < 500; i += 10) {
                g.fillOval(i, i, i, 23 + i);
                g.fillOval(129 + i, 195 + i, i, 84 + i);

                g.fillOval(287 + i, i, 117 + i, i);
                g.fillOval(i, 287 + i, i, 117 + i);
            }


        }

    }
}
