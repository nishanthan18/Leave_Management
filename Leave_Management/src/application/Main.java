package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_Page.fxml"));
            ControllerClass controller = new ControllerClass(this); // Pass the Main instance to the controller
            loader.setController(controller);
            Parent root = loader.load();

            Scene scene = new Scene(root, 600, 400);

            // Set the scene to the primary stage
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUserInformationPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
           
            home_controller controller = new home_controller(this); // Pass the Main instance to the controller
            loader.setController(controller);
            Parent root = loader.load();

            Scene scene = new Scene(root, 1442, 817);

            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showPermissionPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EMP_REQ.fxml"));
            PermissionController controller = new PermissionController(this);
            loader.setController(controller);

            Scene scene = new Scene(loader.load(), 1442, 817);

            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showManagerLoginPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MANAGER_HOME.fxml"));
            ManagerPageController controller = new ManagerPageController(this);
            loader.setController(controller);

            Scene scene = new Scene(loader.load(), 1442, 817);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showAddEmployeePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddingEmployee.fxml"));
            AddEmployeeController controller = new AddEmployeeController(this); // Pass the Main instance
            loader.setController(controller);
            Scene scene = new Scene(loader.load(), 1442, 817);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showacceptpage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ACCEPT_REQUEST.fxml"));
            acceptController controller = new acceptController(this); // Pass the Main instance
            loader.setController(controller);
            Scene scene = new Scene(loader.load(), 1442, 817);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showmanagerloginpage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Manager_login.fxml"));
            managerlogin_controller controller = new managerlogin_controller(this); // Pass the Main instance
            loader.setController(controller);
            Scene scene = new Scene(loader.load(), 1442, 817);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
