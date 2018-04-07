import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

//Load image background
        Image menuBackground = new Image(getClass().getClassLoader().getResourceAsStream("menu/background.png"));

        ImageView menuBackgroundView = new ImageView(menuBackground);
        menuBackgroundView.setFitHeight(menuBackground.getHeight());
        menuBackgroundView.setFitWidth(menuBackground.getWidth());

//Add menuBackgroundView
        root.getChildren().add(menuBackgroundView);

//Create scene
        Scene scene = new Scene(root, menuBackground.getWidth(), menuBackground.getHeight());

//Load ask image
        Image menuAsk = new Image(getClass().getClassLoader().getResourceAsStream("./menu/ask.png"));
        ImageView menuAskView = new ImageView(menuAsk);
        menuAskView.setFitHeight(menuAsk.getHeight());
        menuAskView.setFitWidth(menuAsk.getWidth());
        menuAskView.setY((int) (menuBackground.getHeight() / menuAsk.getHeight()));
        menuAskView.setX((int) (menuBackground.getWidth() / menuAsk.getWidth()));
        menuAskView.setCursor(Cursor.HAND);
        menuAskView.setOnMouseClicked((MouseEvent event) -> {
            Stage dialog = new Stage();
            Image askInfo = new Image(getClass().getClassLoader().getResourceAsStream("poker_hands.jpg"));
            ImageView askInfoView = new ImageView(askInfo);
            dialog.setWidth(askInfo.getWidth());
            dialog.setHeight(askInfo.getHeight());
            dialog.setTitle("Info");
            dialog.setResizable(false);
            Group ss = new Group();
            ss.getChildren().addAll(askInfoView);
            ss.setOnMouseClicked(event1 -> dialog.close());
            Scene lol = new Scene(ss);
            dialog.setScene(lol);
            dialog.show();
        });
        root.getChildren().add(menuAskView);

//Load start button
        Image menuStartButton = new Image(getClass().getClassLoader().getResourceAsStream("./menu/button_start.png"));
        ImageView menuStartButtonView = new ImageView(menuStartButton);
        menuStartButtonView.setFitHeight(menuStartButton.getHeight());
        menuStartButtonView.setFitWidth(menuStartButton.getWidth());
        menuStartButtonView.setX((menuBackground.getWidth() - menuStartButton.getWidth()) / 2);
        menuStartButtonView.setY((menuBackground.getHeight() - menuStartButton.getHeight()) / 3.6);
        menuStartButtonView.setCursor(Cursor.HAND);
        menuStartButtonView.setOnMouseClicked(event -> {
            Table table = new Table();
            Stage stage = new Stage();
            try {
                table.start(stage);
                primaryStage.hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!stage.isShowing()) {
                primaryStage.show();
            }
        });
        root.getChildren().add(menuStartButtonView);

//Load about button
        Image menuAboutButton = new Image(getClass().getClassLoader().getResourceAsStream("./menu/button_about.png"));
        ImageView menuAboutButtonView = new ImageView(menuAboutButton);
        menuAboutButtonView.setFitHeight(menuAboutButton.getHeight());
        menuAboutButtonView.setFitWidth(menuAboutButton.getWidth());
        menuAboutButtonView.setX((menuBackground.getWidth() - menuAboutButton.getWidth()) / 2);
        menuAboutButtonView.setY((menuBackground.getHeight() - menuAboutButton.getHeight()) / 2);
        menuAboutButtonView.setCursor(Cursor.HAND);
        menuAboutButtonView.setOnMouseClicked(event -> {
            Stage dialog = new Stage();
            dialog.setWidth(400);
            dialog.setTitle("About");
            dialog.setHeight(400);
            dialog.setResizable(false);
            Group ss = new Group();
            Scene lol = new Scene(ss);
            Button button = new Button("Close");
            button.setDefaultButton(true);
            button.setMinWidth(50);
            button.setOnMouseClicked(event1 -> dialog.close());
            ss.getChildren().add(button);

            dialog.setScene(lol);
            dialog.show();
        });
        root.getChildren().add(menuAboutButtonView);

//Load exit button
        Image menuAExitButton = new Image(getClass().getClassLoader().getResourceAsStream("./menu/button_exit.png"));
        ImageView menuExitButtonView = new ImageView(menuAExitButton);
        menuExitButtonView.setFitHeight(menuAExitButton.getHeight());
        menuExitButtonView.setFitWidth(menuAExitButton.getWidth());
        menuExitButtonView.setX((menuBackground.getWidth() - menuAExitButton.getWidth()) / 2);
        menuExitButtonView.setY((menuBackground.getHeight() - menuAExitButton.getHeight()) / 1.4);
        menuExitButtonView.setCursor(Cursor.HAND);
        menuExitButtonView.setOnMouseClicked(event -> {
            primaryStage.close();
        });
        root.getChildren().add(menuExitButtonView);

//Set title
        primaryStage.setTitle("Texas Poker");
        primaryStage.setScene(scene);

//Set min & max width and height
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
//test
