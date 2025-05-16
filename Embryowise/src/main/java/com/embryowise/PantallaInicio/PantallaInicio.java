package com.embryowise.PantallaInicio;

import com.embryowise.InicioSesion.PantallaInicioSesion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

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

/** Esta es la clase que contiene a los elementos que se mostrarán en la pantalla de inicio
 *  al entrar a la aplicación.
 */
public class PantallaInicio {
    /** Este es el método que mostrará los elementos de la pantalla de inicio.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        /* Se crea la variable fondoPantallaInicio, que es de tipo Image; en esta variable se
         * almacena el objeto Image; en la carpeta de resources se busca la ruta que se pasa
         * como parámetro; y se convierte a URL para usarla después. */
        Image fondoPantallaInicio = new Image(Objects.requireNonNull(getClass().getResource("/Recursos" +
                "/FondosMenus/FondoPantallaInicio.png")).toExternalForm()); // (1)

        /* Se crea la variable imagenDeFondo, que es de tipo BackgroundImage; en esta variable se
         * almacena el objeto BackgroundImage; se le pasa el parámetro que contiene la ruta de
         * la imagen que se cargó antes; se indica que la imagen no se repita ni a lo ancho
         * ni a lo alto; se indica que la posición de la imagen sea en el centro; y se configura
         * el tamaño de la imagen, dejando el ancho y alto automáticos, dando como false
         * el uso de porcentajes para el tamaño, y como true el que la imagen se adapte al
         * contenedor. */
        BackgroundImage imagenDeFondo = new BackgroundImage(fondoPantallaInicio,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO, false, false, true, true)); // (2) (3)

        /* Se crea la variable botonIniciar de la clase Button y se le asigna el objeto
         * Button con la leyenda "Iniciar". */
        Button botonIniciar = new Button("Iniciar"); // (4)

        /* Se crea la variable botonSalir de la clase Button y se le asigna el objeto
         * Button con la leyenda "Salir". */
        Button botonSalir = new Button("Salir"); // (4)

        // Se le asigna una fuente y tamaño de fuente a los botones.
        botonIniciar.setFont(Font.font("Times New Roman", 28)); // (5) (6)
        botonSalir.setFont(Font.font("Times New Roman", 28)); // (5) (6)

        // Se les da un color a los textos de los botones.
        botonIniciar.setTextFill(Color.rgb(92, 26, 98)); // (6)
        botonSalir.setTextFill(Color.rgb(92, 26, 98)); // (6)

        /* Se les da un estilo a los botones, con un color de fondo transparente, un radius
         * de fondo y de borde, y un color y ancho del borde. */
        botonIniciar.setStyle("-fx-background-color: rgba(255,215,229,0); " +
                "-fx-background-radius: 30px; -fx-border-color: #833a8a; " +
                "-fx-border-width: 1px; -fx-border-radius: 40px;"); // (7)
        botonSalir.setStyle("-fx-background-color: rgba(255,215,229,0); " +
                "-fx-background-radius: 30px; -fx-border-color: #833a8a; " +
                "-fx-border-width: 1px; -fx-border-radius: 40px;"); // (7)

        /* Se les da un estilo a los botones cuando se pasa el cursor por encima,
         * con un color de fondo transparente, un radius de fondo y de borde, y un color y
         * ancho del borde, siendo el ancho un poco más grueso. */
        botonIniciar.setOnMouseEntered(e -> botonIniciar.setStyle
                ("-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
                        "-fx-border-color: #5c1a62; -fx-border-width: 1px; " +
                        "-fx-border-radius: 40px;")); // (7)
        botonSalir.setOnMouseEntered(e -> botonSalir.setStyle
                ("-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
                        "-fx-border-color: #5c1a62; -fx-border-width: 1px; " +
                        "-fx-border-radius: 40px;")); // (7)

        /* Se les da un estilo a los botones cuando sale el cursor de encima, volviendo
         * al estilo por defecto. */
        botonIniciar.setOnMouseExited(e -> botonIniciar.setStyle
                ("-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
                        "-fx-border-color: #833a8a; -fx-border-width: 1px; " +
                        "-fx-border-radius: 40px;")); // (7)
        botonSalir.setOnMouseExited(e -> botonSalir.setStyle
                ("-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
                        "-fx-border-color: #833a8a; -fx-border-width: 1px; " +
                        "-fx-border-radius: 40px;")); // (7)

        /* Se crea una caja para agrupar los botones de iniciar y salir de manera
         * horizontal; se establece que se alineen al centro, y se establece la caja
         * con una margen de 70px por debajo. */
        HBox cajaBotonesHorizontal = new HBox(160, botonIniciar, botonSalir); // (9)
        cajaBotonesHorizontal.setAlignment(Pos.CENTER); // (9)
        cajaBotonesHorizontal.setPadding(new Insets(0, 0, 70, 0)); // (10)

        /* Se crea el panel principal que contiene a los botones, con un margen inferior
        *  de 70px, y estableciendo como fondo la imagen antes cargada. */
        BorderPane panelPrincipal = new BorderPane(); // (11)
        panelPrincipal.setBottom(cajaBotonesHorizontal); // (11)
        panelPrincipal.setPadding(new Insets(0, 0, 70, 0)); // (10)
        panelPrincipal.setBackground(new Background(imagenDeFondo)); // (10)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(panelPrincipal, 1366, 768); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle("Pantalla de Inicio"); // (8)
        stage.setFullScreen(true); // (8)
        stage.setFullScreenExitHint(""); // (8)
        stage.show(); // (8)

        /* Se establece la acción de los botones Iniciar y Salir, que sería pasar al
         * menú principa, y salir de la aplicación, respectivamente. */
        botonIniciar.setOnAction(e -> new PantallaInicioSesion().mostrar(stage)); // (13)

        botonSalir.setOnAction(e -> stage.close()); // (13)
    }
}