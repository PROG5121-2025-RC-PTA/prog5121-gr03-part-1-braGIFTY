/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10476487_prog5121_poe;
import javax.swing.*;
// OpenAI. (2025). ChatGPT (GPT-4) [Large language model]. https://chat.openai.com/
import java.io.FileWriter;
import java.io.IOException;

public class st10476487_prog5121_poe {

    // Global Variables
    // Max number of users
    static final int MAX_USERS = 5;
    static String[] usernames = new String[MAX_USERS];
    static String[] phoneNumbers = new String[MAX_USERS];
    static String[] passwords = new String[MAX_USERS];
    static int userCount = 0;

    // Main method
    public static void main(String[] args) {
        while (userCount < MAX_USERS) {
            int choice = JOptionPane.showConfirmDialog(null, "Would you like to register a new user?");
            if (choice == JOptionPane.YES_OPTION) {
                registerUser();
            } else {
                break;
            }
        }

        loginUser();
    }

    // Method to register a user
    public static void registerUser() {
        String userName = "";
        String phoneNm = "";
        String passWrd = "";

        while (true) {
            userName = JOptionPane.showInputDialog(null, "Create a Username (must be at least 5 characters and contain an underscore)");
            if (userName == null) {
                return;
            }

            if (userName.length() >= 5 && userName.contains("_")) {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted.");
            }
        }

        while (true) {
            phoneNm = JOptionPane.showInputDialog(null, "Enter your 10-digit South African phone number:");
            if (phoneNm == null) {
                return;
            }

            if (phoneNm.matches("^(\\+27|27|0)[6-8][0-9]{8}$")) {
                JOptionPane.showMessageDialog(null, "Cell phone number successfully added");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect phone number format.");
            }
        }

        while (true) {
            passWrd = JOptionPane.showInputDialog(null, "Create a password (8+ chars, 1 uppercase, 1 number, 1 special char)");
            if (passWrd == null) {
                return;
            }

            // OpenAI. (2025). ChatGPT (GPT-4) [Large language model]. https://chat.openai.com/
            boolean hasUppercase = passWrd.matches(".*[A-Z].*");
            boolean hasDigit = passWrd.matches(".*\\d.*");
            boolean hasSpecialChar = passWrd.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
            boolean longEnough = passWrd.length() >= 8;

            if (longEnough && hasUppercase && hasDigit && hasSpecialChar) {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password format is incorrect.");
            }
        }

        usernames[userCount] = userName;
        phoneNumbers[userCount] = phoneNm;
        passwords[userCount] = passWrd;
        userCount++;

        // Saving user information to a file
        saveUser(userName, phoneNm, passWrd);
    }

    // registered message
    public static boolean loginUser() {
        int userLogin = JOptionPane.showConfirmDialog(null, "Welcome, would you like to login?");
        if (userLogin == JOptionPane.YES_OPTION) {
            boolean valid = false;
            while (!valid) {
                String loginUsername = JOptionPane.showInputDialog(null, "Enter your username");
                String loginPassword = PassWrdInput("Enter your password");

                for (int i = 0; i < userCount; i++) {
                    if (usernames[i].equals(loginUsername) && passwords[i].equals(loginPassword)) {          // OpenAI. (2025). ChatGPT (GPT-4) [Large language model]. https://chat.openai.com/
                        JOptionPane.showMessageDialog(null, "Welcome " + loginUsername + ", nice to see you!");
                        valid = true;
                        break;
                    }
                }

                if (!valid) {
                    JOptionPane.showMessageDialog(null, "Username or password incorrect. Try again.");
                }
            }
        }

        return false;
    }

    // password entry
    public static String PassWrdInput(String message) {

        JPasswordField pf = new JPasswordField();
        // OpenAI. (2025). ChatGPT (GPT-4) [Large language model]. https://chat.openai.com/fmmfmff

        int okCxl = JOptionPane.showConfirmDialog(null, pf, message, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (okCxl == JOptionPane.OK_OPTION) {
            return new String(pf.getPassword());
        }
        return null;
    }

    // user information 
    // OpenAI. (2025). ChatGPT (GPT-4) [Large language model]. https://chat.openai.com/
    public static void saveUser(String username, String phone, String password) {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write(username + "," + phone + "," + password + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user to file: " + e.getMessage());
        }
    }
}
