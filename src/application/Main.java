/**********************************************
Workshop #2 - Pizza Ordering App
Course: APD 545 - Winter 2024
Last Name: WU
First Name: LOMIA
ID: 116492182
Section: NAA
This assignment represents my own work in accordance with Seneca Academic Policy. 
Date: 2024-02-05
**********************************************/

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			Scene scene = new Scene(root, 850, 620);
			Image logo = new Image(getClass().getResource("/statics/pizza-toppings-50.png").toExternalForm());

			primaryStage.setResizable(false);
			primaryStage.setTitle("Pizza Ordering App");
			primaryStage.getIcons().add(logo);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
