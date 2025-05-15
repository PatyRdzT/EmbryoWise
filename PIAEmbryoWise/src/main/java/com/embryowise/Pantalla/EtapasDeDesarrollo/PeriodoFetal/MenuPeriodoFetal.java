package com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoFetal;

import com.embryowise.Pantalla.EtapasDeDesarrollo.MenuEtapasDesarrollo;
import com.embryowise.Pantalla.MenuBase;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

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
 * Es el menú principal para ver las distintas semanas del periodo fetal y acceder a ellas.
 * Tiene las siguientes opciones a elegir:
 * <ul>
 *   <li>Semanas 9 a 12</li>
 *   <li>Semanas 13 a 16</li>
 *   <li>Semanas 17 a 20</li>
 *   <li>Semanas 21 a 24</li>
 *   <li>Semanas 25 a 28</li>
 *   <li>Semanas 29 a 32</li>
 *   <li>Semanas 33 a 36</li>
 *   <li>Semanas 37 a 40</li>
 * </ul>
 * Además de un botón para regresar a la pantalla anterior (Menú de Etapas del Desarrollo).
 */
public class MenuPeriodoFetal extends MenuBase {
    /** Es el método para mostrar en sí todo lo que aparecerá en la pantalla de manera ya completa.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        // Se crean los botones para los rangos entre semanas.
        Button botonSemana9a12 = new Button("Semanas 9 a 12"); // (4)
        Button botonSemana13a16 = new Button("Semanas 13 a 16"); // (4)
        Button botonSemana17a20 = new Button("Semanas 17 a 20"); // (4)
        Button botonSemana21a25 = new Button("Semanas 21 a 25"); // (4)
        Button botonSemana26a29 = new Button("Semanas 26 a 29"); // (4)
        Button botonSemana30a34 = new Button("Semanas 30 a 34"); // (4)
        Button botonSemana35a38 = new Button("Semanas 35 a 38"); // (4)
        Button botonParto = new Button("Parto"); // (4)

        Button botonRegresar = new Button("Regresar"); // (4)

        // Acciones de los botones.
        botonSemana9a12.setOnAction(e -> new Semana9a12().mostrar(stage)); // (13)
        botonSemana13a16.setOnAction(e -> new Semana13a16().mostrar(stage)); // (13)
        botonSemana17a20.setOnAction(e -> new Semana17a20().mostrar(stage)); // (13)
        botonSemana21a25.setOnAction(e -> new Semana21a25().mostrar(stage)); // (13)
        botonSemana26a29.setOnAction(e -> new Semana26a29().mostrar(stage)); // (13)
        botonSemana30a34.setOnAction(e -> new Semana30a34().mostrar(stage)); // (13)
        botonSemana35a38.setOnAction(e -> new Semana35a38().mostrar(stage)); // (13)
        botonParto.setOnAction(e -> new Parto().mostrar(stage)); // (13)

        // Se ejecuta la acción del botón regresar.
        botonRegresar.setOnAction(e -> new MenuEtapasDesarrollo().mostrar(stage)); // (13)

        // A todos los botones se les añade a un arreglo.
        Button[] botones = {
                botonSemana9a12, botonSemana13a16, botonSemana17a20, botonSemana21a25,
                botonSemana26a29, botonSemana30a34, botonSemana35a38, botonParto, botonRegresar
        };

        // Se recorre el arreglo para aplicarles el estilo a los botones.
        for (Button x : botones) {
            aplicarEstilo(x);
        }

        // Se almacenan 4 y 4 botones en dos filas horizontales para que puedan verse bien.
        HBox cajaFila1Horizontal = new HBox(30, botonSemana9a12, botonSemana13a16,
                botonSemana17a20, botonSemana21a25); // (9)
        cajaFila1Horizontal.setAlignment(Pos.CENTER); // (9)

        HBox cajaFila2Horizontal = new HBox(30, botonSemana26a29, botonSemana30a34,
                botonSemana35a38, botonParto); // (9)
        cajaFila2Horizontal.setAlignment(Pos.CENTER); // (9)

        // Se almacenan las dos cajas horizontales en una vertical para acomodarlas una sobre otra.
        VBox cajaCentralVertical = new VBox(30, cajaFila1Horizontal, cajaFila2Horizontal); // (15)
        cajaCentralVertical.setAlignment(Pos.TOP_CENTER); // (15)
        cajaCentralVertical.setPadding(new Insets(350, 0, 0, 0)); // (10)

        // Se carga la imagen del fondo por medio de su ruta.
        Image fondo = new Image(getClass().getResource("/Recursos" +
                "/FondosMenus/FondoMenuPeriodoFetal.png").toExternalForm()); // (1)

        // Se agrega la imagen de fondo al background.
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize
                (BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)); // (2) (3)

        // Plano principal con los contenedores y la imagen de fondo.
        BorderPane planoPrincipal = new BorderPane(); // (11)
        planoPrincipal.setBackground(new Background(imagenDeFondo)); // (10)
        planoPrincipal.setCenter(cajaCentralVertical); // (11)

        VBox contenedorInferiorVertical = new VBox(botonRegresar);// (15)
        contenedorInferiorVertical.setAlignment(Pos.CENTER); // (15)
        contenedorInferiorVertical.setPadding(new Insets(0, 0, 20, 0)); // (10)
        planoPrincipal.setBottom(contenedorInferiorVertical); // (15)

        // Se crea y se muestra la escena.
        Scene escena = new Scene(planoPrincipal); // (12)
        stage.setScene(escena); // (8)
        stage.setFullScreen(true); // (8)
        stage.setTitle("Periodo Fetal"); // (8)
        stage.setFullScreenExitHint(""); // (8)
        stage.show(); // (8)
    }
}