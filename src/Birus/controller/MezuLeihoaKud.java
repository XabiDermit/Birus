package Birus.controller;

import Birus.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MezuLeihoaKud implements Initializable {

    //atributos FXML
    @FXML
    private ImageView ivInfo;
    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnOk;


    //otros atributos
    private Main mainApp;
    private ArrayList<String> nombres;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ivInfo.setImage(new Image("/Birus/ui/Imagenes/info.png"));
    }

    public void setMainApp(Main main) { this.mainApp=main;}

    public void setMensaje(String pMensaje) {
        lblMensaje.setText("");
        lblMensaje.setText(pMensaje);
    }

    @FXML
    public void onClickOk(ActionEvent actionEvent) {
        mainApp.mainErakutsi(nombres);
    }

    public void setNombres(ArrayList<String> pNombres) {
        nombres=pNombres;
    }
}
