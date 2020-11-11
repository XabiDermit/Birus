package Birus.controller;

import Birus.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainLeihoaKud implements Initializable {

    //atributos FXMl

    @FXML
    private TabPane tabJugadores;
    @FXML
    private Tab tabJugador1;
    @FXML
    private Tab tabJugador2;
    @FXML
    private Tab tabJugador3;
    @FXML
    private Tab tabJugador4;
    @FXML
    private Tab tabJugador5;
    @FXML
    private Tab tabJugador6;
    @FXML
    private ImageView ivMano1;
    @FXML
    private ImageView ivMano2;
    @FXML
    private ImageView ivMano3;
    @FXML
    private ImageView ivJugador1Mesa1;
    @FXML
    private ImageView ivJugador1Mesa2;
    @FXML
    private ImageView ivJugador1Mesa3;
    @FXML
    private ImageView ivJugador1Mesa4;
    @FXML
    private ImageView ivJugador2Mesa1;
    @FXML
    private ImageView ivJugador2Mesa2;
    @FXML
    private ImageView ivJugador2Mesa3;
    @FXML
    private ImageView ivJugador2Mesa4;
    @FXML
    private ImageView ivJugador3Mesa1;
    @FXML
    private ImageView ivJugador3Mesa2;
    @FXML
    private ImageView ivJugador3Mesa3;
    @FXML
    private ImageView ivJugador3Mesa4;
    @FXML
    private ImageView ivJugador4Mesa1;
    @FXML
    private ImageView ivJugador4Mesa2;
    @FXML
    private ImageView ivJugador4Mesa3;
    @FXML
    private ImageView ivJugador4Mesa4;
    @FXML
    private ImageView ivJugador5Mesa1;
    @FXML
    private ImageView ivJugador5Mesa2;
    @FXML
    private ImageView ivJugador5Mesa3;
    @FXML
    private ImageView ivJugador5Mesa4;
    @FXML
    private ImageView ivJugador6Mesa1;
    @FXML
    private ImageView ivJugador6Mesa2;
    @FXML
    private ImageView ivJugador6Mesa3;
    @FXML
    private ImageView ivJugador6Mesa4;


    @FXML
    private Label lblTurno;

    //atributos
    private Main mainApp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabJugadores.getTabs().clear();

    }

    public void setPestañas(ArrayList<String> pNombres){
        int aux = pNombres.size();
        if (aux==2){
            tabJugador1.setText(pNombres.get(0));
            tabJugadores.getTabs().add(tabJugador1);
            tabJugador2.setText(pNombres.get(1));
            tabJugadores.getTabs().add(tabJugador2);
        }else if (aux==3){
            tabJugador1.setText(pNombres.get(0));
            tabJugadores.getTabs().add(tabJugador1);
            tabJugador2.setText(pNombres.get(1));
            tabJugadores.getTabs().add(tabJugador2);
            tabJugador3.setText(pNombres.get(2));
            tabJugadores.getTabs().add(tabJugador3);
        }else if (aux==4){
            tabJugador1.setText(pNombres.get(0));
            tabJugadores.getTabs().add(tabJugador1);
            tabJugador2.setText(pNombres.get(1));
            tabJugadores.getTabs().add(tabJugador2);
            tabJugador3.setText(pNombres.get(2));
            tabJugadores.getTabs().add(tabJugador3);
            tabJugador4.setText(pNombres.get(3));
            tabJugadores.getTabs().add(tabJugador4);
        }else if (aux==5){
            tabJugador1.setText(pNombres.get(0));
            tabJugadores.getTabs().add(tabJugador1);
            tabJugador2.setText(pNombres.get(1));
            tabJugadores.getTabs().add(tabJugador2);
            tabJugador3.setText(pNombres.get(2));
            tabJugadores.getTabs().add(tabJugador3);
            tabJugador4.setText(pNombres.get(3));
            tabJugadores.getTabs().add(tabJugador4);
            tabJugador5.setText(pNombres.get(4));
            tabJugadores.getTabs().add(tabJugador5);
        }else{
            tabJugador1.setText(pNombres.get(0));
            tabJugadores.getTabs().add(tabJugador1);
            tabJugador2.setText(pNombres.get(1));
            tabJugadores.getTabs().add(tabJugador2);
            tabJugador3.setText(pNombres.get(2));
            tabJugadores.getTabs().add(tabJugador3);
            tabJugador4.setText(pNombres.get(3));
            tabJugadores.getTabs().add(tabJugador4);
            tabJugador5.setText(pNombres.get(4));
            tabJugadores.getTabs().add(tabJugador5);
            tabJugador6.setText(pNombres.get(5));
            tabJugadores.getTabs().add(tabJugador6);
        }

    }

    public void setMainApp(Main main) {
        mainApp=main;
    }

    @FXML
    public void onClickJugar(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickDescartar(ActionEvent actionEvent) {
    }

    @FXML
    public void onClickPasar(ActionEvent actionEvent) {
    }
}