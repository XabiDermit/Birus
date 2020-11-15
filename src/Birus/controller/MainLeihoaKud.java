package Birus.controller;

import Birus.Main;
import Birus.model.Jokalaria;
import Birus.model.ListaJokalariak;
import Birus.model.ListaKartak;
import Birus.model.Tableroa;
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
    private Jokalaria [] listajugadores;
    private Tableroa tablero;
    private ArrayList<String> nombres;
    private int turno;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabJugadores.getTabs().clear();

    }

    //pone el nombre de cada jugardor en el tab
    private void setPestañas(ArrayList<String> pNombres){
        int aux = pNombres.size();
        nombres = pNombres;
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
        //jugamos la carta seleccionada
        //hay que comprobar que tipo de carta es y ver que accion conlleva
        //cuando se haga la accion se acaba el turno
        cambiarTurno();
    }

    @FXML
    public void onClickDescartar(ActionEvent actionEvent) {
        //descartamos la carta seleccionada, nos dan una nueva y pasa de turno automaticamenente
        cambiarTurno();
    }

    @FXML
    public void onClickPasar(ActionEvent actionEvent) {
        //pasamos de ronda y ya
        cambiarTurno();

    }

    private void cambiarTurno(){
        if (turno==1){
            turno=2;
            lblTurno.setText("");
            lblTurno.setText("Mano de " + nombres.get(1));
        }else if (turno==2){
            if(3<= nombres.size()){
                turno=3;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(2));
            }else{
                turno=1;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(0));
            }

        }else if (turno==3){
            if(4<=nombres.size()) {
                turno = 4;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(3));
            }else{
                turno=1;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(0));
            }
        }else if (turno==4){
            if(5<=nombres.size()) {
                turno = 5;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(4));
            }else{
                turno=1;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(0));
            }
        }else if (turno==5){
            if (6<=nombres.size()) {
                turno = 6;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(5));
            }else{
                turno=1;
                lblTurno.setText("");
                lblTurno.setText("Mano de " + nombres.get(0));
            }
        }else{
            turno=1;
            lblTurno.setText("");
            lblTurno.setText("Mano de " + nombres.get(0));
        }
        actualizarMano();
    }

    private boolean comprobarPartida(){
        return true;
    }

    private void actualizarMano(){
        ivMano1.setImage(listajugadores[turno-1].getEskua().getKarta(0).getKarta());
        ivMano2.setImage(listajugadores[turno-1].getEskua().getKarta(1).getKarta());
        ivMano3.setImage(listajugadores[turno-1].getEskua().getKarta(2).getKarta());
    }

    public void empezarJuego(ArrayList<String> pNombres){
        setPestañas(pNombres);                                      //pone los nombres a los tabs
        this.listajugadores = ListaJokalariak.getNireListaJokalariak(pNombres.size()).getLista();//crea la lista de los jugadores
        this.tablero = Tableroa.getNiretableroa();              //crea las cartas
        tablero.kartakBanatu();                                 //ahora las reparte

        //poner las 3 cartas del primer jugador en su mano
        lblTurno.setText("Mano de " + pNombres.get(0));
        turno= 1;
        actualizarMano();
    }
}