package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.Button;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class acceptController implements Initializable {
	private Main main;

    // Constructor with Main parameter
    public acceptController(Main main) {
        this.main = main;
    }

	@FXML
    private Button logout;

    @FXML
    private Button manager_login;

    @FXML
    private Button permission;

    

    @FXML
    void accept(ActionEvent event) {
        // Get the selected item from the TableView
        LeaveRequest selectedLeaveRequest = tableView.getSelectionModel().getSelectedItem();

        if (selectedLeaveRequest != null) {
            int selectedId = selectedLeaveRequest.getId();
            System.out.println("Selected ID: " + selectedId);

            // Now you can use the selected ID to send a message or perform any other action
        } else {
            System.out.println("No item selected");
        }
    }



    @FXML
    void back(ActionEvent event) {
        main.showManagerLoginPage();


    }

    @FXML
    void decline(ActionEvent event) {
    	 // Get the selected item from the TableView
        LeaveRequest selectedLeaveRequest = tableView.getSelectionModel().getSelectedItem();

        if (selectedLeaveRequest != null) {
            int selectedId = selectedLeaveRequest.getId();
            System.out.println("Selected ID: " + selectedId);

            // Now you can use the selected ID to send a message or perform any other action
        } else {
            System.out.println("No item selected");
        }

    }

    @FXML
    void home(ActionEvent event) {
        main.showUserInformationPage();


    }

    @FXML
    void logout(ActionEvent event) {
        main.showUserInformationPage();


    }

    @FXML
    void manager_login(ActionEvent event) {

    }

    @FXML
    void permission(ActionEvent event) {
        main.showPermissionPage();


    }


    @FXML
    private TableView<LeaveRequest> tableView;

    @FXML
    private TableColumn<LeaveRequest, Integer> s_no;

    @FXML
    private TableColumn<LeaveRequest, String> empId;

    @FXML
    private TableColumn<LeaveRequest, String> empName;

    @FXML
    private TableColumn<LeaveRequest, String> l_reason;

    @FXML
    private TableColumn<LeaveRequest, LocalDate> l_date;

    private ObservableList<LeaveRequest> leaveRequests;

    

	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initializeColumns();

        // Fetch data from the database or any other data source
        fetchLeaveRequestsFromDatabase();
    }

    private void initializeColumns() {
        s_no.setCellValueFactory(cellData -> cellData.getValue().sNoProperty().asObject());
        empId.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty());
        empName.setCellValueFactory(cellData -> cellData.getValue().employeeNameProperty());
        l_reason.setCellValueFactory(cellData -> cellData.getValue().leaveReasonProperty());
        l_date.setCellValueFactory(cellData -> cellData.getValue().leaveDateProperty());
    }

    private void fetchLeaveRequestsFromDatabase() {
        // Replace the following code with your database logic
        leaveRequests = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Leave_Management", "root", "naga/888");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_leave_request")) {

            while (resultSet.next()) {
                LeaveRequest leaveRequest = new LeaveRequest(
                        resultSet.getInt("id"),
                         0, resultSet.getString("employee_name"),
                        resultSet.getString("employee_id"),
                        resultSet.getString("reason"),
                        resultSet.getDate("selected_date").toLocalDate()
                );

                leaveRequests.add(leaveRequest);
            }

            // Set the data in the TableView
            tableView.setItems(leaveRequests);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
