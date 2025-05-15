package com.embryowise.Pantalla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

/** Es una clase abstracta hecha para que los otros menús del apartado de etapas del desarrollo,
 * que tienen bastantes cosas en común entre sí, hereden métodos y atributos desde esta clase,
 * para no tener códigos tan largos y repetitivos.
 */
public abstract class MenuBase {
    /** Times New Roman es la fuente que se usará en todos los botones, junto con su tamaño. */
    protected final Font fuente = Font.font("Times New Roman", 28); // (5)

    /** Es el color del texto con valores rgb. */
    protected final Color colorDeTexto = Color.rgb(92, 26, 98); // (14)

    /** Se usó el formato de CSS para aplicar un estilo predeterminado a los botones. */
    protected final String estiloPorDefecto =
            "-fx-background-color: rgba(255,215,229,0); " + "-fx-background-radius: 30px; " +
                    "-fx-border-color: #833a8a; " + "-fx-border-width: 1px; " +
                    "-fx-border-radius: 40px;";

    /** Es el estilo en formato CSS que se le da al botón cuando el cursor pasa por encima. */
    protected final String estiloSobreCursor =
            "-fx-background-color: rgba(255,215,229,0); " + "-fx-background-radius: 30px; " +
                    "-fx-border-color: #5c1a62; " + "-fx-border-width: 2px; " +
                    "-fx-border-radius: 40px;";

    /**
     * Es un método hecho para aplicar los estilos de fuente, colorDeTexto y estiloPorDefecto a los
     * botones, además de configurar cómo se verá el botón cuando el cursor pase por encima,
     * y cómo se verá cuando el cursor se retire.
     *
     * @param boton Es al atributo al que se le van a aplicar los estilos del método.
     */
    protected void aplicarEstilo(Button boton) { // (4)
        boton.setFont(fuente); // (5) (6)
        boton.setTextFill(colorDeTexto); // (6)
        boton.setStyle(estiloPorDefecto); // (7)

        /* Se les da un estilo a los botones cuando se pasa el cursor por encima y cuando sale,
        con un color de fondo transparente, un radius de fondo y de borde, y un color y
        ancho del borde. */
        boton.setOnMouseEntered(e -> boton.setStyle(estiloSobreCursor)); // (7)
        boton.setOnMouseExited(e -> boton.setStyle(estiloPorDefecto)); // (7)
    }

    /**
     * Es el método que construirá toda la apariencia del menú ya completa.
     *
     * @param stage Es la ventana desde la que se estará mostrando el menú.
     * @param titulo Es el título que aparecería en la parte superior de la ventana (no aparece por la pantalla completa).
     * @param fondoRuta Es la ruta desde la carpeta de resources que se tomará para la imagen del fondo.
     * @param botonesCentro Es el conjunto de botones que aparecerán en el centro de la pantalla.
     * @param botonRegresar Es el botón para regresar a la pantalla anterior.
     * @param accionRegresar Es la acción que se ejecuta al pulsar el botón de regresar.
     * @param paddingCentro Es el margen que contiene a los elementos centrales.
     */
    protected void mostrarMenu(Stage stage, String titulo, String fondoRuta,
            List<Button> botonesCentro, Button botonRegresar, Runnable accionRegresar,
            Insets paddingCentro) {
        /* Se crea la variable fondo, que es de tipo Image; en esta variable se
         * almacena el objeto Image; en la carpeta de resources se busca la ruta que se pasa
         * como parámetro; y se convierte a URL para usarla después. */
        Image fondo = new Image(getClass().getResource(fondoRuta).toExternalForm()); // (1)

        /* Se crea la variable imagenDeFondo, que es de tipo BackgroundImage; en esta variable se
         * almacena el objeto BackgroundImage; se le pasa el parámetro que contiene la ruta de
         * la imagen que se cargó antes; se indica que la imagen no se repita ni a lo ancho
         * ni a lo alto; se indica que la posición de la imagen sea en el centro; y se configura
         * el tamaño de la imagen, dejando el ancho y alto automáticos, dando como false
         * el uso de porcentajes para el tamaño, y como true el que la imagen se adapte al
         * contenedor. */
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
                        false, true, true)); // (2) (3)

        // Se hace un ciclo con los botones centrales y se les aplica el estilo correspondiente.
        botonesCentro.forEach(this::aplicarEstilo);

        // Se le aplica su estilo al botón de regresar.
        aplicarEstilo(botonRegresar);

        /* Se crea una caja para agrupar los botones del centro de manera horizontal;
         * se establece que se alineen al centro, y se establece la caja de manera centrada
         * y dejando un espacio de 30 px entre los botones. */
        HBox botonesCajaHorizontal = new HBox(30); // (9)
        botonesCajaHorizontal.getChildren().addAll(botonesCentro); // (9)
        botonesCajaHorizontal.setAlignment(Pos.CENTER); // (10)

        /* Se crea una caja para guardar los botones de la caja horizontal en una vertical;
         * se establece que se alineen al centro, y se establece la caja con un
         * margen central. */
        VBox contenedorCentralVertical = new VBox(botonesCajaHorizontal); // (15)
        contenedorCentralVertical.setAlignment(Pos.TOP_CENTER); // (15)
        contenedorCentralVertical.setPadding(paddingCentro); // (10)

        /* Se crea una caja para guardar el botón de regresar en vertical;
         * se establece que se alinee al centro, y se establece la caja con un
         * margen de 20px por debajo. */
        VBox contenedorInferiorVertical = new VBox(botonRegresar); // (15)
        contenedorInferiorVertical.setAlignment(Pos.CENTER); // (15)
        contenedorInferiorVertical.setPadding(new Insets(0, 0, 20, 0)); // (10)

        /* Se crea el panel principal que contiene a los botones, con la caja central en el centro
         * la inferior en la parte de abajo, y estableciendo como fondo la imagen antes cargada. */
        BorderPane planoPrincipal = new BorderPane(); // (11)
        planoPrincipal.setCenter(contenedorCentralVertical); // (11)
        planoPrincipal.setBottom(contenedorInferiorVertical); // (11)
        planoPrincipal.setBackground(new Background(imagenDeFondo)); // (10)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(planoPrincipal); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle(titulo); // (8)
        stage.setFullScreen(true); // (8)
        stage.setFullScreenExitHint(""); // (8)
        stage.show(); // (8)

        // Se ejecuta la acción del botón regresar.
        botonRegresar.setOnAction(e -> accionRegresar.run()); // (13)
    }
}