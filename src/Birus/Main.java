package Birus;

import Birus.controller.HasieraLeihoaKud;
import Birus.controller.MainLeihoaKud;
import Birus.controller.MezuLeihoaKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private Stage stage;
    private Stage segundoStage;

    private Parent hasieraLeihoaUI;
    private Parent mainLeihoaUI;
    private Parent mezuLeihoaUI;

    private HasieraLeihoaKud hasieraLeihoaKud;
    private MainLeihoaKud mainLeihoaKud;
    private MezuLeihoaKud mezuLeihoaKud;

    private Scene hasieraLeihoaScene;
    private Scene mainLeihoaScene;
    private Scene mezuLeihoaScene;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        pantailakKargatu();
        stage.setTitle("Birus");

        segundoStage = new Stage();
        segundoStage.setTitle("Info.");

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

        FXMLLoader loaderMezuLeihoa = new FXMLLoader(getClass().getResource("/Birus/ui/mezuLeihoa.fxml"));
        mezuLeihoaUI = (Parent) loaderMezuLeihoa.load();
        mezuLeihoaKud = loaderMezuLeihoa.getController();
        mezuLeihoaKud.setMainApp(this);

    }

    public void mainErakutsi(ArrayList<String> pNombres){
        if (mainLeihoaScene==null) {
            mainLeihoaScene = new Scene(mainLeihoaUI);
        }
        stage.setScene(mainLeihoaScene);
        stage.show();
        mainLeihoaKud.empezarJuego(pNombres);

    }

    public void mezuLeihoaErakutsi(String pMensaje){
        if(mezuLeihoaScene==null){
            mezuLeihoaScene = new Scene(mezuLeihoaUI);
        }
        segundoStage.setScene(mezuLeihoaScene);
        segundoStage.show();
        mezuLeihoaKud.setMensaje(pMensaje);
    }

    public void esconderMezuLeihoa(){
        segundoStage.hide();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
