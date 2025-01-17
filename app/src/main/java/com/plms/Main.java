package com.plms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{
		@Override
		public void start(Stage primaryStage) {

				// Create Menu Buttons
				Button viewLibraryButton = new Button("View Library");
				Button addBookButton = new Button("Add Book");

				// Set up table
				TableView<Book> tableBooks = new TableView<>();

				TableColumn<Book, String> columnTitle = new TableColumn<>("Title");
				TableColumn<Book, String> columnAuthor = new TableColumn<>("Author");

				tableBooks.getItems().addAll(
								new Book("Book Title One", "Author One"),
								new Book("Book Title Two", "Author Two"),
								new Book("Book Title Three", "Author Three")
						);

				columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
				columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));

				tableBooks.getColumns().addAll(columnTitle, columnAuthor);

				// Set up the layout
				VBox vbox = new VBox();
				HBox topControls = new HBox();
				topControls.getChildren().addAll(addBookButton, viewLibraryButton);
				vbox.getChildren().addAll(topControls, tableBooks);

				// Create the scene and set it on the stage
				Scene scene = new Scene(vbox, 800, 600);
				primaryStage.setTitle("PLMS");
				primaryStage.setScene(scene);
				primaryStage.show();
		}

		public static void main(String[] args) {
				launch(args);
		}
}
