package com.hhs.learning.Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BugGameApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        BorderPane mainPane = createBorderPane();
        Scene scene = new Scene(root);
        root.getChildren().addAll(mainPane);

        stage.setScene(scene);
        stage.setTitle("Spider Meets Fly");
        stage.show();
    }

    /*
        Main Layout
     */
    public BorderPane createBorderPane() throws FileNotFoundException {
        BorderPane mainPane = new BorderPane();
        final int BORDER_PANE_WIDTH = 500;
        final int BORDER_PANE_HEIGHT = 500;
        mainPane.setMinSize(BORDER_PANE_WIDTH, BORDER_PANE_HEIGHT);
        mainPane.setStyle("-fx-background-color: darkgrey");

        GridPane controlPane = createControls();
        GridPane gridPane = createGameScreen();

        mainPane.setBottom(controlPane);
        mainPane.setCenter(gridPane);

        return mainPane;
    }

    /*
        Returns pane with controls
     */
    public GridPane createControls() throws FileNotFoundException {
        GridPane controlPane = new GridPane();

        final int GRID_PANE_WIDTH = 500;
        final int GRID_PANE_HEIGHT = 100;

        Button leftButton = new Button("<");
        Button rightButton = new Button(">");
        Button upButton = new Button("v");
        Button downButton = new Button("^");
        Button moveButton = new Button("MOVE");

        controlPane.setMinSize(GRID_PANE_WIDTH, GRID_PANE_HEIGHT);
        controlPane.add(leftButton, 0, 1);
        controlPane.add(rightButton, 2, 1);
        controlPane.add(upButton, 1, 2);
        controlPane.add(downButton, 1, 0);
        controlPane.add(moveButton, 3, 1);

        controlPane.setPadding(new Insets(10));
        controlPane.setHgap(10);
        controlPane.setVgap(10);
        controlPane.setAlignment(Pos.CENTER);

        // FileInputStream + ImageView + try - catch
        FileInputStream input = new FileInputStream("res/spiderUp.png");
        Image test = new Image(input);

        ImageView testView = new ImageView(test);
        controlPane.add(testView, 4, 1);

        return controlPane;
    }

    /*
        Return gridpane with grids (has to be implemented)
     */
    public GridPane createGameScreen() {
        GridPane gameScreen = new GridPane();

        gameScreen.setGridLinesVisible(true);

        return gameScreen;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
