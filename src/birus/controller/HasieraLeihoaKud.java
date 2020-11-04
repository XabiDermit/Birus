package birus.controller;

import birus.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HasieraLeihoaKud implements Initializable {

    //atributos
    private Main mainApp;
    @FXML
    private Label lblNumJugadores;
    @FXML
    private ComboBox cbNumJugadores;
    @FXML
    private Label lblNombreJugador1;
    @FXML
    private TextField tfJugador1;
    @FXML
    private Label lblNombreJugador2;
    @FXML
    private TextField tfJugador2;
    @FXML
    private Label lblNombreJugador3;
    @FXML
    private TextField tfJugador3;
    @FXML
    private Label lblNombreJugador4;
    @FXML
    private TextField tfJugador4;
    @FXML
    private Label lblNombreJugador5;
    @FXML
    private TextField tfJugador5;
    @FXML
    private Label lblNombreJugador6;
    @FXML
    private TextField tfJugador6;
    @FXML
    private Button btnJugar;
    @FXML
    private ImageView ivBirus;
    @FXML
    private Label lblError;

    private int numJugadores;

    //metodos de botones
    @FXML
    public ArrayList<String> onClickJugar(ActionEvent actionEvent) {
        ArrayList<String> nombres = new ArrayList<>();
        if (numJugadores==2){
            if( !tfJugador1.getText().equals("") && !tfJugador2.getText().equals("")){
                nombres.add(tfJugador1.getText());
                nombres.add(tfJugador2.getText());
                return nombres;
            }else{
                lblError.setVisible(true);
            }
        }else if (numJugadores==3){
            if( !tfJugador1.getText().equals("") && !tfJugador2.getText().equals("") && !tfJugador3.getText().equals("")) {
                nombres.add(tfJugador1.getText());
                nombres.add(tfJugador2.getText());
                nombres.add(tfJugador3.getText());
                return nombres;
            }else{
                lblError.setVisible(true);
            }
        }else if (numJugadores==4){
            if( !tfJugador1.getText().equals("") && !tfJugador2.getText().equals("") && !tfJugador3.getText().equals("")
                    && !tfJugador4.getText().equals("")) {
                nombres.add(tfJugador1.getText());
                nombres.add(tfJugador2.getText());
                nombres.add(tfJugador3.getText());
                nombres.add(tfJugador4.getText());
                return nombres;
            }else{
                lblError.setVisible(true);
            }

        }else if (numJugadores==5){
            if( !tfJugador1.getText().equals("") && !tfJugador2.getText().equals("") && !tfJugador3.getText().equals("")
                    && !tfJugador4.getText().equals("") && !tfJugador5.getText().equals("")) {
                nombres.add(tfJugador1.getText());
                nombres.add(tfJugador2.getText());
                nombres.add(tfJugador3.getText());
                nombres.add(tfJugador4.getText());
                nombres.add(tfJugador5.getText());
                return nombres;
            }else{
                lblError.setVisible(true);
            }
        }else{
            if( !tfJugador1.getText().equals("") && !tfJugador2.getText().equals("") && !tfJugador3.getText().equals("")
                    && !tfJugador4.getText().equals("") && !tfJugador5.getText().equals("") && !tfJugador6.getText().equals("")) {
                nombres.add(tfJugador1.getText());
                nombres.add(tfJugador2.getText());
                nombres.add(tfJugador3.getText());
                nombres.add(tfJugador4.getText());
                nombres.add(tfJugador5.getText());
                nombres.add(tfJugador6.getText());
                return nombres;
            }else{
                lblError.setVisible(true);
            }
        }
        return nombres;
    }


    //combobox
    private void llenarCB(){
        ObservableList<Integer> jugadores = FXCollections.observableArrayList(2,3,4,5,6);
        cbNumJugadores.setItems(jugadores);
        //por defecto empieza con 2 jugadores
        cbNumJugadores.setValue(2);
        this.numJugadores=2;

        //se deja al combobox 'escuchando' para cuando el jugador seleccione un nuevo numero de jugadores
        cbNumJugadores.setOnAction(e -> {actualizarTextFields((Integer) cbNumJugadores.getValue());});

    }

    public void setMainApp(Main main) {mainApp=main;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //llenamos el combobox y ponemos la imagen del juego
        llenarCB();
        ivBirus.setImage(new Image("/birus/ui/Imagenes/BirusLogo.jpeg"));

        //ocultar 4 de los 6 textfields (el minimo de jugadores es 2 y partimos de esa base)
        tfJugador1.clear();
        tfJugador2.clear();
        lblNombreJugador3.setVisible(false);
        tfJugador3.setVisible(false);
        tfJugador3.clear();
        lblNombreJugador4.setVisible(false);
        tfJugador4.setVisible(false);
        tfJugador4.clear();
        lblNombreJugador5.setVisible(false);
        tfJugador5.setVisible(false);
        tfJugador5.clear();
        lblNombreJugador6.setVisible(false);
        tfJugador6.setVisible(false);
        tfJugador6.clear();
        lblError.setVisible(false);

    }

    private void actualizarTextFields(int pNumJugadores) {

        //cada vez que se selecciona un nuevo valor en el combobox, se ponen visibles los TextField donde van los
        //nombres de los jugadorses, y se actualiza el valor del atributo numJugadores
        if (pNumJugadores==2){

            tfJugador1.clear();
            tfJugador2.clear();
            lblNombreJugador3.setVisible(false);
            tfJugador3.setVisible(false);
            tfJugador3.clear();
            lblNombreJugador4.setVisible(false);
            tfJugador4.setVisible(false);
            tfJugador4.clear();
            lblNombreJugador5.setVisible(false);
            tfJugador5.setVisible(false);
            tfJugador5.clear();
            lblNombreJugador6.setVisible(false);
            tfJugador6.setVisible(false);
            tfJugador6.clear();
            lblError.setVisible(false);
            numJugadores=2;

        }else if (pNumJugadores == 3){

            tfJugador1.clear();
            tfJugador2.clear();
            lblNombreJugador3.setVisible(true);
            tfJugador3.setVisible(true);
            tfJugador3.clear();
            lblNombreJugador4.setVisible(false);
            tfJugador4.setVisible(false);
            tfJugador4.clear();
            lblNombreJugador5.setVisible(false);
            tfJugador5.setVisible(false);
            tfJugador5.clear();
            lblNombreJugador6.setVisible(false);
            tfJugador6.setVisible(false);
            tfJugador6.clear();
            lblError.setVisible(false);
            numJugadores=3;

        }else if (pNumJugadores == 4) {

            tfJugador1.clear();
            tfJugador2.clear();
            lblNombreJugador3.setVisible(true);
            tfJugador3.setVisible(true);
            tfJugador3.clear();
            lblNombreJugador4.setVisible(true);
            tfJugador4.setVisible(true);
            tfJugador4.clear();
            lblNombreJugador5.setVisible(false);
            tfJugador5.setVisible(false);
            tfJugador5.clear();
            lblNombreJugador6.setVisible(false);
            tfJugador6.setVisible(false);
            tfJugador6.clear();
            lblError.setVisible(false);
            numJugadores=4;

        }else if(pNumJugadores == 5){

            tfJugador1.clear();
            tfJugador2.clear();
            lblNombreJugador3.setVisible(true);
            tfJugador3.setVisible(true);
            tfJugador3.clear();
            lblNombreJugador4.setVisible(true);
            tfJugador4.setVisible(true);
            tfJugador4.clear();
            lblNombreJugador5.setVisible(true);
            tfJugador5.setVisible(true);
            tfJugador5.clear();
            lblNombreJugador6.setVisible(false);
            tfJugador6.setVisible(false);
            tfJugador6.clear();
            lblError.setVisible(false);
            numJugadores=5;

        }else {

            tfJugador1.clear();
            tfJugador2.clear();
            lblNombreJugador3.setVisible(true);
            tfJugador3.setVisible(true);
            tfJugador3.clear();
            lblNombreJugador4.setVisible(true);
            tfJugador4.setVisible(true);
            tfJugador4.clear();
            lblNombreJugador5.setVisible(true);
            tfJugador5.setVisible(true);
            tfJugador5.clear();
            lblNombreJugador6.setVisible(true);
            tfJugador6.setVisible(true);
            tfJugador6.clear();
            lblError.setVisible(false);
            numJugadores=6;

        }

    }
}
