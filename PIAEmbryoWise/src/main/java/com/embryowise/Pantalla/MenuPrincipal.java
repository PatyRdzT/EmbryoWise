package com.embryowise.Pantalla;

import com.embryowise.Pantalla.EtapasDeDesarrollo.MenuEtapasDesarrollo;
import com.embryowise.Pantalla.Glosario.GlosarioPantalla;
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
 * Es el menú principal de la aplicación, donde se elije a qué apartado se quiere ingresar.
 * Las opciones son:
 *
 * <ul>
 *   <li>Etapas del Desarrollo</li>
 *   <li>Glosario</li>
 *   <li>Cuestionarios</li>
 * </ul>
 * Además de un botón para salir de la aplicación.
 */
public class MenuPrincipal extends MenuBase {
    /** Es el método para mostrar en sí todo lo que aparecerá en la pantalla de manera ya completa.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        /* Se crea la variable botonEtapasDesarrollo de la clase Button y se le asigna el objeto
         * Button con la leyenda "Etapas del Desarrollo", además se le da la acción de pasar
         * a la pantalla indicada. */
        Button botonEtapasDesarrollo = new Button("Etapas del Desarrollo"); // (4)
        botonEtapasDesarrollo.setOnAction(e -> new MenuEtapasDesarrollo().mostrar(stage)); // (13)

        /* Se crea la variable botonGlosario de la clase Button y se le asigna el objeto
         * Button con la leyenda "Glosario", además se le da la acción de pasar
         * a la pantalla indicada. */
        Button botonGlosario = new Button("Glosario"); // (4)
        botonGlosario.setOnAction(e -> new GlosarioPantalla().mostrar(stage)); // (13)

        /* Se crea la variable botonCuestionarios de la clase Button y se le asigna el objeto
         * Button con la leyenda "Cuestionarios", además se le da la acción de pasar
         * a la pantalla indicada. */
        Button botonCuestionarios = new Button("Cuestionarios"); // (4)
        //botonCuestionarios.setOnAction(e -> new MenuCuestionarios().mostrar(stage)); // (8)

        /* Se crea la variable botonSalir de la clase Button y se le asigna el objeto
         * Button con la leyenda "Salir", además de la acción de salir de la aplicación. */
        Button botonSalir = new Button("Salir"); // (4)
        botonSalir.setOnAction(e -> stage.close()); // (13)

        /* Se manda a llamar al método heredado mostrarMenu y se le pasa la stage, el título
         *  de la ventana, la ruta del fondo, la lista de botones, el botón de salir con
         *  su acción, y el margen que se va a dejar. */
        mostrarMenu(stage, "Menú Principal", "/Recursos/FondosMenus/FondoMenuPrincipal.png",
                List.of(botonEtapasDesarrollo, botonGlosario, botonCuestionarios), botonSalir,
                stage::close, new Insets(400, 0, 0, 0));
    }
}