package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerClass {
    public String ID;


    private Main mainApp; // Reference to the Main class

    // Constructor to set the reference to the Main class
    public ControllerClass(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private TextField L_employee;

    @FXML
    private TextField L_name;

    @FXML
    private PasswordField L_password;

    @FXML
    private Button Login;

    @FXML
    void Login(ActionEvent event) {
        String username = L_name.getText().trim();
        String employeeID = L_employee.getText().trim();
        String password = L_password.getText();

        // Check credentials against the database
        if (isValidCredentials(username, employeeID, password)) {
            // Successful login, redirect to user information page
            mainApp.showUserInformationPage();
        } else {
            // Failed login, show an error message
            showErrorAlert("Invalid credentials. Please try again.");
        }
    }

    private boolean isValidCredentials(String username, String employeeID, String password) {
        // TODO: Replace these with your actual database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/Leave_Management";
        String dbUsername = "root";
        String dbPassword = "naga/888";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String query = "SELECT * FROM users WHERE username = ? AND employee_id = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, employeeID);
                preparedStatement.setString(3, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Check if any matching records were found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle the exception as needed
        }
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
