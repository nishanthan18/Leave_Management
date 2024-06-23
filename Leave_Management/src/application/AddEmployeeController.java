package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployeeController {
	 public AddEmployeeController() {
	    }

	private Main main;

    // Constructor with Main parameter
    public AddEmployeeController(Main main) {
        this.main = main;
    }
    @FXML
    private TextField name;
    @FXML
    private Button back;
    @FXML
    private Button logout;
    @FXML
    private Button manager_login;
    @FXML
    private Button permission;




    @FXML
    private TextField id;

    @FXML
    private TextField phone;

    @FXML
    private TextField password;
    

    @FXML
    private Button add;
    

    @FXML
    private Button remove;
    @FXML
    void back(ActionEvent event) {
    	main.showManagerLoginPage();


    }
    @FXML
    void logout(ActionEvent event) {
        main.showUserInformationPage();


    }
    @FXML
    void manager_login(ActionEvent event) {

    }
    @FXML
    void home(ActionEvent event) {
        main.showUserInformationPage();


    }
    @FXML
    void permission(ActionEvent event) {
        main.showPermissionPage();


    }


    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Leave_Management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "naga/888";

    

	@FXML
    void add(ActionEvent event) {
        // Handle add action
        String employeeName = name.getText();
        String employeeId = id.getText();
        
        String userPassword = password.getText(); 
        String phoneNumber = phone.getText();// Get the password from the password field

        // Database operation to add an employee
        insertEmployee(employeeName, employeeId,userPassword, phoneNumber );
    }

    private void insertEmployee(String employeeName, String employeeId, String phoneNumber, String userPassword) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO users (username, employee_id, password,phone_no) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, employeeName);
                preparedStatement.setString(2, employeeId);
                preparedStatement.setString(3, phoneNumber);
                preparedStatement.setString(4, userPassword);

                // Execute the insert statement
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    @FXML
    void remove(ActionEvent event) {
        // Your implementation for the "REMOVE" button action
        // This is where you handle the logic when the "REMOVE" button is clicked.
    }
}
