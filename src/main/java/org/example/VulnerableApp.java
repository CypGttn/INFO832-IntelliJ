package org.example;

import java.sql.*;
import java.util.Scanner;

public class VulnerableApp {

    // 🔥 A05 - Security Misconfiguration : Infos DB en dur, pas de SSL
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USER = "root";
    static final String PASS = "root";  // 🔥 Ne jamais stocker un mot de passe en clair

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔥 A07 - Authentification faible sans hash ni salage
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (login(username, password)) {
            System.out.println("Login successful!");
            System.out.print("Enter the ID of the user to delete: ");
            String userId = scanner.nextLine();

            // 🔥 A01 - Broken Access Control : aucun contrôle sur les rôles
            deleteUser(userId);

        } else {
            System.out.println("Login failed.");
        }
    }

    public static boolean login(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();

            // 🔥 A03 - SQL Injection
            String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            return rs.next(); // S’il trouve un utilisateur, c’est ok
        } catch (SQLException e) {
            // 🔥 A09 - Mauvaise gestion des logs : pas d’alerte, pas de log détaillé
            System.out.println("Database error.");
            return false;
        }
    }

    public static void deleteUser(String id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();

            // 🔥 A03 - Encore une injection possible ici
            String sql = "DELETE FROM users WHERE id = " + id;
            stmt.executeUpdate(sql);

            System.out.println("User deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting user.");
        }
    }
}
