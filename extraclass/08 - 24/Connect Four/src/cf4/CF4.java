/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf4;

import java.awt.Label;
import static java.awt.SystemColor.window;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Yopuesquienmás
 */
public class CF4 extends Application {

    private static int Tamaño = 80;
    private static final int Columnas = 7;
    private static final int Filas = 6;
    private static final String Tablero[][] = new String[6][7];
    private Ficha[][] grid = new Ficha[Columnas][Filas];
    boolean player1move = true;
    /*private Label label = new Label("Player turn");*/
    private Pane ficharoot = new Pane();

    private Parent createContent() {
        Pane pane = new Pane();
        Shape gridShape = crearTablero();
        pane.getChildren().add(gridShape);
        pane.getChildren().addAll(makeColumns());
        pane.getChildren().add(ficharoot);
       

        return pane;
    }

    private Shape crearTablero() { //A traves de una forma especificada (en este caso, un rectangulo, se crea un tablero)
        Shape forma = new Rectangle((Columnas + 1) * Tamaño, (Filas + 1) * Tamaño);

        for (int i = 0; i < Filas; i++) {

            for (int j = 0; j < Columnas; j++) {
                Circle circle = new Circle(Tamaño / 2);
                circle.setCenterX(Tamaño / 2);
                circle.setCenterY(Tamaño / 2);
                circle.setTranslateX(j * (Tamaño + 5) + (Tamaño / 4));
                circle.setTranslateY(i * (Tamaño + 5) + (Tamaño / 4));
                forma = forma.subtract(forma, circle);
            }
        }
        forma.setFill(Color.DARKCYAN);
        return forma;

    }

    private List<Rectangle> makeColumns() {
        List<Rectangle> preview = new ArrayList<>();
        for (int i = 0; i < Columnas; i++) {
            Rectangle rectangulo = new Rectangle((Tamaño), (Filas + 1) * Tamaño);
            rectangulo.setTranslateX(i * (Tamaño + 5) + (Tamaño / 4));
            rectangulo.setFill(Color.TRANSPARENT);
            rectangulo.setOnMouseEntered(e -> rectangulo.setFill(player1move ? Color.rgb(255, 0, 0, 0.25) : Color.rgb(0, 0, 255, 0.25))); //Una preview que indica el turno del siguiente jugador (ROJO O AZUL)
            rectangulo.setOnMouseExited(e -> rectangulo.setFill(Color.TRANSPARENT));

            int columna = i;
            rectangulo.setOnMouseClicked(e -> ColocarFicha(new Ficha(player1move), columna));

            preview.add(rectangulo);
        }
        return preview;
    }

    private void ColocarFicha(Ficha ficha, int columna) {
        int fila = Filas - 1;
        while (fila >= 0) {
            if (!getFicha(columna, fila).isPresent()) { //Si no hay ficha presente en la seleccion, entonces se coloca una ficha, de lo contrario, no coloca ficha

                break;

            }
            fila--;
        }
        if (fila < 0) {
            return;
        }
        grid[columna][fila] = ficha;
        ficharoot.getChildren().add(ficha);
        ficha.setTranslateX(columna * (Tamaño + 5) + (Tamaño / 4));
        ficha.setTranslateY(fila * (Tamaño + 5) + (Tamaño / 4));
        final int filaActual = fila;
        if(checkGameEnd(columna, filaActual)) {
            findelJuego();
            System.exit(0);
        }
        player1move = !player1move;
        

        /*
        *
        *
        Alert msgturno = new Alert(Alert.AlertType.INFORMATION);
        msgturno.setTitle("Siguiente Turno");
        msgturno.setHeaderText("Es el turno del Jugador " + (player1move ? "1(FICHA ROJA)":"2(FICHA NEGRA)"));
        msgturno.show();
         */
    }
    
    private boolean checkGameEnd(int columna, int fila) { //Revisa si se cumple alguna condicion de victoria para el jugador que coloco su ficha
        List <Point2D> vertical = IntStream.rangeClosed(fila - 3, fila + 3).mapToObj(r -> new Point2D(columna, r)).collect(Collectors.toList());
        List <Point2D> horizontal = IntStream.rangeClosed(columna - 3, columna + 3).mapToObj(c -> new Point2D(c, fila)).collect(Collectors.toList());
        Point2D SuperiorIzq = new Point2D(columna -3, fila - 3);
        List <Point2D> diagonal1 = IntStream.rangeClosed(0, 6).mapToObj(i -> SuperiorIzq.add(i, i)).collect(Collectors.toList());
        Point2D InferiorIzq = new Point2D(columna -3, fila + 3);
        List <Point2D> diagonal2 = IntStream.rangeClosed(0, 6).mapToObj(i -> SuperiorIzq.add(i, -i)).collect(Collectors.toList());
        /*Point2D SuperiorDer = new Point2D(columna + 3, fila - 3);
        List <Point2D> diagonal3 = IntStream.rangeClosed(0, 6).mapToObj(i -> SuperiorDer.add(-i, -i)).collect(Collectors.toList());*/
        
        return checkRange(vertical) || checkRange(horizontal) || checkRange(diagonal1) || checkRange(diagonal2);
    }
    
    private boolean findelJuego() { //Envia el mensaje de fin del juego, avisando cual jugador gano
        Alert msggameover = new Alert(Alert.AlertType.INFORMATION);
        msggameover.setTitle("FIN DEL JUEGO");
        msggameover.setHeaderText("¡Tenemos un ganador! " + " El jugador "+(player1move ? "1(FICHA ROJA) ":"2(FICHA AZUL) ") +" Ha ganado la partida");
        msggameover.showAndWait(); //Espera a que el usuario clickee en aceptar, y cierra el programa
    
        
        System.out.println("¡Tenemos un ganador! " + " El jugador "+(player1move ? "1(FICHA ROJA) ":"2(FICHA AZUL) ") +" Ha ganado la partida");
        return true;
    }
    
    private boolean checkRange(List <Point2D> points) { //obtiene cordenadas de columna y fila en "x" y "y", para luego corroborar si existe una cadena de cuatro fichas consecutivas
        int cadena = 0;
        
        for (Point2D p : points) {
            int columna = (int) p.getX();
            int fila = (int) p.getY();
            
            Ficha ficha = getFicha(columna, fila).orElse(new Ficha(!player1move));
            if (ficha.red == player1move) {
                cadena++;
                if (cadena == 4) {
                    return true;
                }
            } else {
                cadena = 0;
            }
        } return false;
    }

    public Optional<Ficha> getFicha(int columna, int fila) {
        if (columna < 0 || columna >= Columnas || fila < 0 || fila >= Filas) {
            return Optional.empty();
        }
        return Optional.ofNullable(grid[columna][fila]);
    }

    public class Ficha extends Circle {

        private final boolean red;

        public Ficha(boolean red) {
            super(Tamaño / 2, red ? Color.RED : Color.BLUE);
            this.red = red;
            setCenterX(Tamaño / 2);
            setCenterY(Tamaño / 2);
        }
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("CONNECT FOUR");
        stage.setScene(new Scene(createContent()));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
   
}
