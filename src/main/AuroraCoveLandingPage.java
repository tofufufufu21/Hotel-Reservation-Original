package main;

import javax.swing.*;
import admin.loginUI;
import manager.UserLoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class AuroraCoveLandingPage extends JFrame {

    public AuroraCoveLandingPage() {
        setTitle("Aurora Cove Hotel");
        setSize(771, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Load images using getResource
        JLabel logoLabel = new JLabel(loadImage("/resources/imageicon/navbar.png"), SwingConstants.CENTER);
        logoLabel.setBounds(0, 0, 755, 97);
        getContentPane().add(logoLabel);

        JButton adminButton = new JButton(loadImage("/resources/imageicon/1.png"));
        adminButton.setBackground(new Color(3, 91, 150));
        adminButton.setBounds(61, 108, 256, 281);
        adminButton.setToolTipText("Admin Login");
        getContentPane().add(adminButton);

        JButton receptionistButton = new JButton(loadImage("/resources/imageicon/2.png"));
        receptionistButton.setBackground(new Color(3, 91, 150));
        receptionistButton.setBounds(407, 108, 256, 281);
        receptionistButton.setToolTipText("Receptionist Login");
        getContentPane().add(receptionistButton);

        JLabel lblNewLabel = new JLabel("ADMIN");
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblNewLabel.setBounds(150, 400, 75, 32);
        getContentPane().add(lblNewLabel);

        JLabel lblAdmin = new JLabel("RECEPTIONIST");
        lblAdmin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblAdmin.setBounds(475, 400, 139, 32);
        getContentPane().add(lblAdmin);

        // Redirect to Admin Login
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new loginUI().setVisible(true);
                dispose();
            }
        });

        // Redirect to Receptionist Login
        receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserLoginUI().setVisible(true);
                dispose();
            }
        });
    }

    // Helper method to load images safely
    private ImageIcon loadImage(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AuroraCoveLandingPage landingPage = new AuroraCoveLandingPage();
            landingPage.setVisible(true);
        });
    }
}
