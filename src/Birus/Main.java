package Birus;

import Birus.controller.HasieraLeihoaKud;
import Birus.controller.MainLeihoaKud;
import Birus.model.Exekutagarria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private Stage stage;

    private Parent hasieraLeihoaUI;
    private Parent mainLeihoaUI;

    private HasieraLeihoaKud hasieraLeihoaKud;
    private MainLeihoaKud mainLeihoaKud;

    private Scene hasieraLeihoaScene;
    private Scene mainLeihoaScene;

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

        FXMLLoader loaderHasieraLeihoa = new FXMLLoader(getClass().getResource("/Birus/ui/hasieraLeihoa.fxml"));
        hasieraLeihoaUI = (Parent) loaderHasieraLeihoa.load();
        hasieraLeihoaKud = loaderHasieraLeihoa.getController();
        hasieraLeihoaKud.setMainApp(this);

        FXMLLoader loaderMainLeihoa = new FXMLLoader(getClass().getResource("/Birus/ui/mainLeihoa.fxml"));
        mainLeihoaUI = (Parent) loaderMainLeihoa.load();
        mainLeihoaKud = loaderMainLeihoa.getController();
        mainLeihoaKud.setMainApp(this);

    }

    public void mainErakutsi(ArrayList<String> pNombres){
        if (mainLeihoaScene==null) {
            mainLeihoaScene = new Scene(mainLeihoaUI);
        }
        stage.setScene(mainLeihoaScene);
        stage.show();
        mainLeihoaKud.setPestañas(pNombres);
        Exekutagarria.getNireExekutagarria().jugar(pNombres);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
