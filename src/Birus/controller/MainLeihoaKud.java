package Birus.controller;

import Birus.Main;
import Birus.model.*;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

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
    private RadioButton rBtn1;
    @FXML
    private RadioButton rBtn2;
    @FXML
    private RadioButton rBtn3;
    @FXML
    private Label lblMensaje;
    @FXML
    private TextField tfMensaje;
    @FXML
    private Button btnSeleccionar;
    @FXML
    private Label lblTurno;

    //atributos
    private Main mainApp;
    private Jokalaria [] listajugadores;
    private Tableroa tablero;
    private ArrayList<String> nombres;
    private int turno;
    private int numCartaSeleccionada;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabJugadores.getTabs().clear();
        //hacemos invisible lo que gestiona elegir viruses y tratamientos
        lblMensaje.setVisible(false);
        tfMensaje.setVisible(false);
        btnSeleccionar.setVisible(false);
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


    //############################### METODOS BOTONES ################################################3
    @FXML
    public void onClickJugar(ActionEvent actionEvent) {
        //jugamos la carta seleccionada
        //hay que comprobar que tipo de carta es y ver que accion conlleva
        //cuando se haga la accion se acaba el turno y se actualiza la mano del jugador

        Karta carta = this.cartaSeleccionada();
        Jokalaria jugador = listajugadores[turno-1];

        String aux = jugador.jokatu(carta,this.numCartaSeleccionada);
        if ("OK".equals(aux)){
            //actualizamos la mesa y pasamos de turno solo si la carta es valida
            actualizarMesa(nombres.get(turno-1));
            cambiarTurno();
        }else if ("ERROR".equals(aux)){
            //aqui se llamaria a la ventana de los mensajes porque el organo que se quiere jugar ya esta
        }else if ("CURAR".equals(aux)){
            //el jugador tiene que elegir que organo quiere curar
            //en este metodo se "dejan las cosas preparadas" pero el metodo que hace la accion es el de onCLickSeleccionar()
            jugador.bilatuLekuaBotikarentzat((Botika)carta);
            actualizarMesa(nombres.get(turno-1));
            cambiarTurno();

        }else{
            //el jugador tiene que elegir a que otro jugador le "ataca"
            //en este metodo se "dejan las cosas preparadas" pero el metodo que hace la accion es el de onCLickSeleccionar()
            lblMensaje.setVisible(true);
            lblMensaje.setText("Introduce el nombre del jugador al que quieras atacar");
            tfMensaje.setVisible(true);
            btnSeleccionar.setVisible(true);
        }

    }

    @FXML
    public void onClickDescartar(ActionEvent actionEvent) {
        //descartamos la carta seleccionada, nos dan una nueva y pasa de turno automaticamenente

        Karta carta = this.cartaSeleccionada();
        Jokalaria jugador = listajugadores[turno-1];
        jugador.descartar(numCartaSeleccionada);

        cambiarTurno();
    }

    @FXML
    public void onClickPasar(ActionEvent actionEvent) {
        //pasamos de ronda y ya
        cambiarTurno();

    }

    @FXML
    public void onClickSeleccionar(ActionEvent actionEvent) {
        Jokalaria jugador = listajugadores[turno-1];
        String objetivo = tfMensaje.getText();

        if (nombres.contains(objetivo)){
            //atacar

            if (jugador.infektatuJokalaria((Birusa) this.cartaSeleccionada(),nombres.indexOf(objetivo))){
                //una vez usada la carta
                actualizarMesa(objetivo);
                cambiarTurno();
                lblMensaje.setVisible(false);
                tfMensaje.setVisible(false);
                tfMensaje.setText("");
                btnSeleccionar.setVisible(false);
            }

        }else{
            //mostrar pantalla de errores, el jugador al que quiere atacar no existe

        }
    }

    //########################## OTROS METODOS ##############################################

    private Karta cartaSeleccionada(){
        ListaKartak manoJugador = listajugadores[turno-1].getEskua();

        if (rBtn1.isSelected()){
            numCartaSeleccionada=0;
            return manoJugador.getKarta(0);
        }else if (rBtn2.isSelected()){
            numCartaSeleccionada=1;
            return manoJugador.getKarta(1);
        }else {
            numCartaSeleccionada=2;
            return manoJugador.getKarta(2);
        }
    }

    private void actualizarMesa(String deQuien){
        int aux = nombres.indexOf(deQuien);
        Karta[] mesa = listajugadores[aux].getMahaia();
        if (aux==0){
            if(mesa[0] != null){
                ivJugador1Mesa1.setImage(mesa[0].getKarta());
            }else{
                ivJugador1Mesa1.setImage(null);
            }
            if (mesa[1] != null){
                ivJugador1Mesa2.setImage(mesa[1].getKarta());
            }else{
                ivJugador1Mesa2.setImage(null);
            }
            if (mesa[2] != null){
                ivJugador1Mesa3.setImage(mesa[2].getKarta());
            }else{
                ivJugador1Mesa3.setImage(null);
            }
            if (mesa[3] != null){
                ivJugador1Mesa4.setImage(mesa[3].getKarta());
            }else{
                ivJugador1Mesa4.setImage(null);
            }
        }else if (aux==1){
            if(mesa[0] != null){
                ivJugador2Mesa1.setImage(mesa[0].getKarta());
            }else{
                ivJugador2Mesa1.setImage(null);
            }
            if (mesa[1] != null){
                ivJugador2Mesa2.setImage(mesa[1].getKarta());
            }else{
                ivJugador2Mesa2.setImage(null);
            }
            if (mesa[2] != null){
                ivJugador2Mesa3.setImage(mesa[2].getKarta());
            }else{
                ivJugador2Mesa3.setImage(null);
            }
            if (mesa[3] != null){
                ivJugador2Mesa4.setImage(mesa[3].getKarta());
            }else{
                ivJugador2Mesa4.setImage(null);
            }
        }else if (aux==2){
            if(mesa[0] != null){
                ivJugador3Mesa1.setImage(mesa[0].getKarta());
            }else{
                ivJugador3Mesa1.setImage(null);
            }
            if (mesa[1] != null){
                ivJugador3Mesa2.setImage(mesa[1].getKarta());
            }else{
                ivJugador3Mesa2.setImage(null);
            }
            if (mesa[2] != null){
                ivJugador3Mesa3.setImage(mesa[2].getKarta());
            }else{
                ivJugador3Mesa3.setImage(null);
            }
            if (mesa[3] != null){
                ivJugador3Mesa4.setImage(mesa[3].getKarta());
            }else{
                ivJugador3Mesa4.setImage(null);
            }
        }else if (aux==3){
            if(mesa[0] != null){
                ivJugador4Mesa1.setImage(mesa[0].getKarta());
            }else{
                ivJugador4Mesa1.setImage(null);
            }
            if (mesa[1] != null){
                ivJugador4Mesa2.setImage(mesa[1].getKarta());
            }else{
                ivJugador4Mesa2.setImage(null);
            }
            if (mesa[2] != null){
                ivJugador4Mesa3.setImage(mesa[2].getKarta());
            }else{
                ivJugador4Mesa3.setImage(null);
            }
            if (mesa[3] != null){
                ivJugador4Mesa4.setImage(mesa[3].getKarta());
            }else{
                ivJugador4Mesa4.setImage(null);
            }
        }else if (aux == 4){
            if(mesa[0] != null){
                ivJugador5Mesa1.setImage(mesa[0].getKarta());
            }else{
                ivJugador5Mesa1.setImage(null);
            }
            if (mesa[1] != null){
                ivJugador5Mesa2.setImage(mesa[1].getKarta());
            }else{
                ivJugador5Mesa2.setImage(null);
            }
            if (mesa[2] != null){
                ivJugador5Mesa3.setImage(mesa[2].getKarta());
            }else{
                ivJugador5Mesa3.setImage(null);
            }
            if (mesa[3] != null){
                ivJugador5Mesa4.setImage(mesa[3].getKarta());
            }else{
                ivJugador5Mesa4.setImage(null);
            }
        }else{
            if(mesa[0] != null){
                ivJugador6Mesa1.setImage(mesa[0].getKarta());
            }else{
                ivJugador6Mesa1.setImage(null);
            }
            if (mesa[1] != null){
                ivJugador6Mesa2.setImage(mesa[1].getKarta());
            }else{
                ivJugador6Mesa2.setImage(null);
            }
            if (mesa[2] != null){
                ivJugador6Mesa3.setImage(mesa[2].getKarta());
            }else{
                ivJugador6Mesa3.setImage(null);
            }
            if (mesa[3] != null){
                ivJugador6Mesa4.setImage(mesa[3].getKarta());
            }else{
                ivJugador6Mesa4.setImage(null);
            }
        }
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