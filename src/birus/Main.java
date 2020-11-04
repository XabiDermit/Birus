package birus;

import birus.controller.HasieraLeihoaKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;

    private Parent hasieraLeihoaUI;

    private HasieraLeihoaKud hasieraLeihoaKud;

    private Scene hasieraLeihoaScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        pantailakKargatu();
        stage.setTitle("Birus");
        hasieraLeihoaScene = new Scene(hasieraLeihoaUI);
        stage.setScene(hasieraLeihoaScene);

        stage.show();
    }

    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderHasieraLeihoa = new FXMLLoader(getClass().getResource("/birus/ui/hasieraLeihoa.fxml"));
        hasieraLeihoaUI = (Parent) loaderHasieraLeihoa.load();
        hasieraLeihoaKud = loaderHasieraLeihoa.getController();
        hasieraLeihoaKud.setMainApp(this);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
