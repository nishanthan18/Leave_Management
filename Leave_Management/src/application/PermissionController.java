package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PermissionController {

    @FXML
    private Button back;

    @FXML
    private DatePicker date;

    @FXML
    private TextField emmp_name;

    @FXML
    private TextField emp_id;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button manager_login;

    @FXML
    private Button premission;

    @FXML
    private TextArea reason;

    @FXML
    private Button submit;

    private Main mainApp;

    public PermissionController() {
        // Default constructor
    }
    @FXML
    void LOGOUT(ActionEvent event) {
        mainApp.showUserInformationPage();


    }


    public PermissionController(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    void home(ActionEvent event) {
        mainApp.showUserInformationPage();

        // Handle home action if needed
    }

    @FXML
    void manager_login(ActionEvent event) {
		mainApp.showmanagerloginpage();

        // Handle manager_login action if needed
    }

    @FXML
    void on_back(ActionEvent event) {
    	mainApp.showUserInformationPage();
        // Handle on_back action if needed
    }
    @FXML
    void calender(ActionEvent event) {
        // Handle calender action

        // Accessing the selected date
        date.setOnAction(datePickerEvent -> {
            // Perform actions when a date is selected
            String selectedDate = date.getValue().toString();
            System.out.println("Selected Date: " + selectedDate);

            // You can add more actions here based on the selected date
        });
    }

    

    @FXML
    void on_submit(ActionEvent event) {
        // Handle on_submit action

        // Get values from fields
        String employeeName = emmp_name.getText();
        String employeeId = emp_id.getText();
        String reasonText = reason.getText();
        String selectedDate = date.getValue().toString(); // assuming date is not null

        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/Leave_Management";
        String username = "root";
        String password = "naga/888";

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // SQL statement to insert data into the database
            String sql = "INSERT INTO employee_leave_request (employee_name, employee_id, reason, selected_date) VALUES (?, ?, ?, ?)";

            // Prepare the statement
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, employeeName);
                preparedStatement.setString(2, employeeId);
                preparedStatement.setString(3, reasonText);
                
                // Format the date to match the database date format (assuming it's a DATE type in the database)
                java.sql.Date sqlDate = java.sql.Date.valueOf(selectedDate);
                preparedStatement.setDate(4, sqlDate);

                // Execute the insert statement
                preparedStatement.executeUpdate();
            }

            // Close the connection
            connection.close();

            // You may want to show a success message or perform other actions after storing to the database
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage()); // Print the SQL exception message for debugging
            // Handle exceptions (show an error message, log the error, etc.)
        }
    }


    @FXML
    void premission(ActionEvent event) {
        // Handle premission action if needed
    }
}
