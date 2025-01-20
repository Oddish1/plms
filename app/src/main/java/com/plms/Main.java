package com.plms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Main extends Application{
		@Override
		public void start(Stage primaryStage) {

				// Create button to add new book
				Button addBookButton = new Button("Add New Book");

				// Set up table
				TableView<Book> tableBooks = new TableView<>();

				TableColumn<Book, String> columnTitle = new TableColumn<>("Title");
				TableColumn<Book, String> columnAuthor = new TableColumn<>("Author");
				TableColumn<Book, String> columnDescription = new TableColumn<>("Description");
				TableColumn<Book, Integer> columnPublicationYear = new TableColumn<>("Published");

				tableBooks.getItems().addAll(
								new Book("Book Title One", "Author One", "This is the description of the first book. It isn't very long.", 1999),
								new Book("Book Title Two", "Author Two", "The second book description is not very long either...", 2004),
								new Book("Book Title Three", "Author Three", "This is the third book description. It is very descriptive, as you can tell. It is longer than the first two, but not by a whole lot.", 2023)
						);

				columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
				columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
				columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
				columnPublicationYear.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));
				
				columnDescription.setMaxWidth(400);

				tableBooks.getColumns().addAll(columnTitle, columnAuthor, columnDescription, columnPublicationYear);

				// Set up the layout
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(10));
				vbox.setSpacing(10);
				HBox topControls = new HBox();
				topControls.getChildren().addAll(addBookButton);
				vbox.getChildren().addAll(topControls, tableBooks);

				// Create the scene and set it on the stage
				Scene scene = new Scene(vbox, 800, 600);
				primaryStage.setTitle("PLMS");
				primaryStage.setScene(scene);
				primaryStage.show();

				// Define button action
				addBookButton.setOnAction(e -> {

						// Create new stage
						Stage newBookWindow = new Stage();
						newBookWindow.setTitle("Add New Book");

						// Set up the layout
						VBox newBookLayout = new VBox();
						newBookLayout.setPadding(new Insets(10));
						newBookLayout.setSpacing(10);
						
						// Add input
						TextField titleInput = new TextField();
						TextField authorInput = new TextField();
						TextField descriptionInput = new TextField();
						TextField publicationYearInput = new TextField();

						titleInput.setPromptText("Title");
						authorInput.setPromptText("Author");
						descriptionInput.setPromptText("Description");
						publicationYearInput.setPromptText("Publication Year");

						newBookLayout.getChildren().addAll(titleInput, authorInput, descriptionInput, publicationYearInput);

						// Save button
						Button saveButton = new Button("Save");

						saveButton.setOnAction(event -> {
								// Retrieve input and add new book to table
								String title = titleInput.getText();
								String author = authorInput.getText();
								String description = descriptionInput.getText();
								int publicationYear;
								try {
										publicationYear = Integer.parseInt(publicationYearInput.getText());
								} catch (NumberFormatException ex) {
										System.out.println("Invalid year format");
										return;
								}

								tableBooks.getItems().add(new Book(title, author, description, publicationYear));
								newBookWindow.close();
						});

						// add save button to layout
						newBookLayout.getChildren().add(saveButton);

						// Create new scene with layout
						Scene newBookScene = new Scene(newBookLayout);
						// Add scene to window and set window size
						newBookWindow.setScene(newBookScene);
						newBookWindow.setWidth(600);
						newBookWindow.setHeight(400);
						// Force window sizing; javafx was auto resizing window smaller
						newBookWindow.setResizable(false);
						// Show the new window
						newBookWindow.show();
				});
		}

		public static void main(String[] args) {
				launch(args);
		}
}
