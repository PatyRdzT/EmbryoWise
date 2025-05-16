package com.embryowise.EtapasDeDesarrollo.PeriodoEmbrionario;

import com.embryowise.EtapasDeDesarrollo.MenuEtapasDesarrollo;
import com.embryowise.Menu.MenuBase;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/* -- REFERENCIAS --
 *
 *  - https://youtu.be/1n28VRCzJho?si=DcmZNfjfO9P4intn -> Usado para ver cómo documentar.
 *
 * (1) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
 * (2) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundImage.html
 * (3) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundSize.html
 * (4) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
 * (5) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/Font.html
 * (6) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Labeled.html
 * (7) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html
 * (8) https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html
 * (9) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html
 * (10) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Region.html
 * (11) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
 * (12) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
 * (13) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonBase.html
 * (14) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
 * (15) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html
 * (16) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/package-frame.html
 * (17) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
 * (18) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Pane.html
 * (19) https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
 */

/**
 * Es el menú principal para ver las distintas semanas del periodo embrionario y acceder a ellas.
 * Tiene las siguientes opciones a elegir:
 * <ul>
 *   <li>Semana 3</li>
 *   <li>Semana 4</li>
 *   <li>Semana 5</li>
 *   <li>Semana 6</li>
 *   <li>Semana 7</li>
 * </ul>
 * Además de un botón para regresar a la pantalla anterior (Menú de Etapas del Desarrollo).
 */
public class MenuPeriodoEmbrionario extends MenuBase {
    /** Es el método para mostrar en sí todo lo que aparecerá en la pantalla de manera ya completa.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        // Es la lista de los botones centrales.
        List<Button> botonesCentrales = new ArrayList<>();

        // Creación de todos los botones con su determinada acción.
        Button botonSemana3 = new Button("Semana 3"); // (4)
        botonSemana3.setOnAction(e -> new Semana3().mostrar(stage)); // (13)

        Button botonSemana4 = new Button("Semana 4"); // (4)
        botonSemana4.setOnAction(e -> new Semana4().mostrar(stage)); // (13)

        Button botonSemana5 = new Button("Semana 5"); // (4)
        botonSemana5.setOnAction(e -> new Semana5().mostrar(stage)); // (13)

        Button botonSemana6 = new Button("Semana 6"); // (4)
        botonSemana6.setOnAction(e -> new Semana6().mostrar(stage)); // (13)

        Button botonSemana7 = new Button("Semana 7"); // (4)
        botonSemana7.setOnAction(e -> new Semana7().mostrar(stage)); // (13)

        Button botonSemana8 = new Button("Semana 8"); // (4)
        botonSemana8.setOnAction(e -> new Semana8().mostrar(stage)); // (13)

        // A la lista de botones se le añaden todos los botones creados anteriormente.
        botonesCentrales.addAll(List.of(botonSemana3, botonSemana4, botonSemana5, botonSemana6, botonSemana7, botonSemana8));

        // Se crea y establece la acción del botón de regresar.
        Button botonRegresar = new Button("Regresar"); // (4)
        Runnable accionRegresar = () -> new MenuEtapasDesarrollo().mostrar(stage); // (13)

        // Se muestra el menú heredado de la clase abstracta, con los atributos antes creados.
        mostrarMenu(stage, "Periodo Embrionario", "/Recursos/FondosMenus/FondoMenuPeriodoEmbrionario.png",
                botonesCentrales, botonRegresar, accionRegresar, new Insets(400, 0, 0, 0));
    }
}