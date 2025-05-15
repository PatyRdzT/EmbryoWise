package com.embryowise.Pantalla.EtapasDeDesarrollo;

import com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoEmbrionario.MenuPeriodoEmbrionario;
import com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoFetal.MenuPeriodoFetal;
import com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoPreEmbrionario.MenuPeriodoPreEmbrionario;
import com.embryowise.Pantalla.MenuBase;
import com.embryowise.Pantalla.MenuPrincipal;
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
 * Es el menú principal para ver las distintas etapas del desarrollo y acceder a ellas.
 * Tiene las siguientes opciones a elegir:
 * <ul>
 *   <li>Periodo Pre-Embrionario</li>
 *   <li>Periodo Embrionario</li>
 *   <li>Periodo Fetal</li>
 * </ul>
 * Además de un botón para regresar a la pantalla anterior (Menú Principal).
 */
public class MenuEtapasDesarrollo extends MenuBase {
    /** Es el método para mostrar en sí todo lo que aparecerá en la pantalla de manera ya completa.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        // Son los botones para elegir a qué opción entrar a ver su contenido.
        Button botonPreE = new Button("Periodo Pre-Embrionario"); // (4)
        Button botonEmb = new Button("Periodo Embrionario"); // (4)
        Button botonFetal = new Button("Periodo Fetal"); // (4)
        Button botonRegresar = new Button("Regresar"); // (4)

        // Son las acciones que se realizarán con cada botón.
        botonPreE.setOnAction(e -> new MenuPeriodoPreEmbrionario().mostrar(stage)); // (13)
        botonEmb.setOnAction(e -> new MenuPeriodoEmbrionario().mostrar(stage)); // (13)
        botonFetal.setOnAction(e -> new MenuPeriodoFetal().mostrar(stage)); // (13)
        botonRegresar.setOnAction(e -> new MenuPrincipal().mostrar(stage)); // (13)

        // Se muestra el menú heredado de la clase abstracta, con los atributos antes creados.
        mostrarMenu(stage, "Menú Etapas de Desarrollo", "/Recursos/FondosMenus/FondoMenuEtapasDesarrollo.png",
                List.of(botonPreE, botonEmb, botonFetal), botonRegresar, () -> new MenuPrincipal().mostrar(stage),
                new Insets(400, 0, 0, 0));
    }
}