package application;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class managerlogin_controller {

    private Main main;

    // Constructor with Main parameter
    public managerlogin_controller(Main main) {
        this.main = main;
    }

    @FXML
    private TextField L_employee;
    @FXML
    private Button Home;
    @FXML
    private TextField L_name;
    @FXML
    private Button login;
    @FXML
    private Button logout;
    @FXML
    private Button m_login;
    @FXML
    private Button prenission;



    @FXML
    private PasswordField L_password;

    @FXML
    void Home(ActionEvent event) {
        main.showUserInformationPage();

        // Handle Home button action if needed
    }

    @FXML
    void Login(ActionEvent event) {
        // Assuming you have a manager ID and password to check against
        String managerId = L_employee.getText(); // Retrieve entered manager ID
        String password = L_password.getText(); // Retrieve entered password

        // Replace these with your actual manager ID and password
        String correctManagerId = "M123";
        String correctPassword = "Leave";

        // Check if entered credentials are correct
        if (managerId.equals(correctManagerId) && password.equals(correctPassword)) {
            // Manager login successful, you can navigate to the manager page
            main.showManagerLoginPage();
        } else {
            // Manager login failed, you might show an error message
            System.out.println("Login failed. Please check your credentials.");
        }
    }

    @FXML
    void logout(ActionEvent event) {           
    	main.showUserInformationPage();

    	
        // Handle Logout button action if needed
    }

    @FXML
    void m_login(ActionEvent event) {
        // Handle Manager Login button action if needed
    }

    @FXML
    void prenission(ActionEvent event) {
        main.showPermissionPage();

        // Handle Permission button action if needed
    }
}
