package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class home_controller implements Initializable {
    private Main mainapp;

    @FXML
    private Label emp_id;

    @FXML
    private Label user_name;

    @FXML
    private Label l_taken;

    public home_controller(Main mainapp) {
        this.mainapp = mainapp;
    }

    
	@FXML
    void Manager_Login(ActionEvent event) {
        mainapp.showmanagerloginpage();
    }

    @FXML
    void home(ActionEvent event) {
        // Do something when the Home button is clicked
    }

    @FXML
    void premission(ActionEvent event) {
        mainapp.showPermissionPage();
    }

    public void updateLabels(String employeeID, String username, int numberOfLeaves) {
        emp_id.setText("Employee ID: " + employeeID);
        user_name.setText("User Name: " + username);
        l_taken.setText("Leaves Taken: " + numberOfLeaves);
    }

    
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Initialization code, if needed
    }
}
