package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date
 **/
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(
        Main.class.getResource("/SearchController.fxml"));
    AnchorPane page = loader.load();
    Scene scene = new Scene(page);
    primaryStage.setTitle("Title goes here");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
