package com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoPreEmbrionario;

import com.embryowise.Pantalla.EtapasDeDesarrollo.MenuEtapasDesarrollo;
import com.embryowise.Pantalla.MenuBase;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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
 * Es el menú principal para ver las distintas semanas del periodo pre-embrionario y acceder a ellas.
 * Tiene las siguientes opciones a elegir:
 * <ul>
 *   <li>Semana 1</li>
 *   <li>Semana 2</li>
 * </ul>
 * Además de un botón para regresar a la pantalla anterior (Menú de Etapas del Desarrollo).
 */
public class MenuPeriodoPreEmbrionario extends MenuBase {
    /** Es el método para mostrar en sí todo lo que aparecerá en la pantalla de manera ya completa.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        // Creación de todos los botones con su determinada acción.
        Button botonSemana1 = new Button("Semana 1"); // (4)
        botonSemana1.setOnAction(e -> new Semana1().mostrar(stage)); // (13)
        Button botonSemana2 = new Button("Semana 2"); // (4)
        botonSemana2.setOnAction(e -> new Semana2().mostrar(stage)); // (13)

        Button regresar = new Button("Regresar"); // (4)
        Runnable accionRegresar = () -> new MenuEtapasDesarrollo().mostrar(stage); // (13)

        // Se muestra el menú heredado de la clase abstracta, con los atributos antes creados.
        mostrarMenu(stage, "Menú Periodo Pre-Embrionario", "/Recursos/FondosMenus/FondoMenuPeriodoPreEmbrionario.png",
                List.of(botonSemana1, botonSemana2), regresar, accionRegresar, new Insets(400, 0, 0, 0));
    }
}