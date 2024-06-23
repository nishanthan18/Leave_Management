package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerPageController implements Initializable {
	private Main mainApp;

	

    @FXML
    private Button home;

    @FXML
    private Button premission;

    @FXML
    private Button manager_login;

    @FXML
    private Button add_emp;

    @FXML
    private Button v_leave;

    public ManagerPageController(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code here
    }

    @FXML
    void home(ActionEvent event) {
    	
        // Handle home action
    }

    @FXML
    void premission(ActionEvent event) {
        // Handle premission action
    }

    @FXML
    void manager_login(ActionEvent event) {
        // Handle manager_login action
    }

    @FXML
    void add_emp(ActionEvent event) {
    	
        mainApp.showAddEmployeePage();

        // Handle add_emp action
    }

    @FXML
    void v_leave_request(ActionEvent event) {
    	 mainApp.showacceptpage();

        // Handle v_leave_request action
    }
}
