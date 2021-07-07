package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	//here main() method is optional,because compiler internally create the main() method
	public static void main(String[] args){
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("Initialize the application");
		super.init();
	}
	//1.Here start() is the abstract method & it is basically the part of abstract class "Application"
	//2.Here "Stage" is the outer most container of output application
	//3.Here "Scene" is inner container of the layout or visible
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Application has been started");
		//This statement connect the MyMain.java file(visible to developer)& app_layout.fxml file(visible to user) with each other
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();//here object loader load the root node of our.fxml file(i.e Pane is the root node)
		//MenuBar menuBar=createMenu();
		//rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);//size of the scene
		primaryStage.setScene(scene);//we are setting the scene to the stage
		primaryStage.setTitle("First Java App by Subhajit");////title of the stage
		primaryStage.show();//for display the output application
	}
	private MenuBar createMenu(){
		//File menu
		Menu fileMenu=new Menu("File");
		MenuItem newMenuItem=new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New item clicked"));
		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuItem=new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		//Help menu
		Menu helpMenu=new Menu("Help");
		MenuBar menuBar = new MenuBar();
		MenuItem aboutApp=new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialogue=new Alert(Alert.AlertType.INFORMATION);
		alertDialogue.setTitle("My First Desktop App");
		alertDialogue.setHeaderText("Learning JavaFX");
		alertDialogue.setContentText("I am just beginner but soon i will be pro and start awesome java game");
		ButtonType yesBtn=new ButtonType("Yes");
		ButtonType noBtn=new ButtonType("No");
		alertDialogue.getButtonTypes().setAll(yesBtn,noBtn);
		Optional<ButtonType> clickBtn= alertDialogue.showAndWait();
		if(clickBtn.isPresent() &&clickBtn.get()==yesBtn)
		{
			System.out.println("Yes Button clicked");
		}
		if(clickBtn.isPresent() && clickBtn.get()==noBtn)
		{
			System.out.println("No button clicked");

		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Application is finished");
		super.stop();

	}
}
