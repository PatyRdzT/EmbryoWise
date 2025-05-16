package com.embryowise.EtapasDeDesarrollo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
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
 * Es una clase abstracta que sirve como plantilla para mostrar el contenido de texto y
 * de imágenes de cada semana.
 * <p>
 * Subclases deben definir:
 * <ul>
 *   <li>obtenerTitulo(): título de la ventana.</li>
 *   <li>obtenerRutaFondo(): ruta de la imagen de fondo.</li>
 *   <li>obtenerContenido(): lista de pantallas con texto e imágenes.</li>
 *   <li>accionVolver(Stage): acción a ejecutar al presionar "Volver".</li>
 * </ul>
 */
public abstract class BaseSemanas {
    // Marcador de en qué pantalla estamos actualmente.
    private int pantallaActual = 0;

    /**
     * Es una clase interna que tiene como función guardar en sí el contenido informativo
     * de la semana.
     */
    public static class ContenidoSemana {
        private final String texto;
        private final String rutaImagen;

        /**
         * Constructor del contenido a mostrar en la pantalla.
         *
         * @param texto Es el texto informativo que se mostrará.
         * @param rutaImagen Es la ruta de la imagen que se mostrará.
         */
        public ContenidoSemana(String texto, String rutaImagen) {
            this.texto = texto;
            this.rutaImagen = rutaImagen;
        }

        /**
         * Método para obtener el texto que se está mostrando.
         *
         * @return Retorna la cadena de texto que se tiene.
         */
        public String obtenerTexto() {
            return texto;
        }

        /**
         * Método para obtener la ruta de la imagen que se está mostrando.
         *
         * @return Retorna la ruta de la imagen.
         */
        public String obtenerRutaImagen() {
            return rutaImagen;
        }
    }

    /**
     * Método abstracto usado para obtener el título de la ventana.
     *
     * @return Retorna el título de la ventana.
     */
    protected abstract String obtenerTitulo();

    /**
     * Método abstracto usado para obtener la ruta de la imagen de fondo.
     *
     * @return Retorna la ruta de la imagen.
     */
    protected abstract String obtenerRutaFondo();

    /**
     * Método abstracto para obtener el contenido completo a mostrar en la semana.
     *
     * @return Retorna la lista de objetos que conforman el contenido de la semana.
     */
    protected abstract List<ContenidoSemana> obtenerContenido();

    /**
     * Método abstracto para ejecutar la acción de volver a la pantalla anterior.
     *
     * @param stage Es la ventana actual en la que se mostrará la pantalla.
     * @return Retorna la acción de volver a la anterior pantalla.
     */
    protected abstract Runnable accionRegresar(Stage stage);

    /**
     * Método para mostrar todo el contenido de la pantalla.
     *
     * @param stage Es la ventana en la que se mostrará la pantalla.
     */
    public void mostrar(Stage stage) { // (8)
        // Se guarda en la lista pantallas el contenido de cada una.
        List<ContenidoSemana> pantallas = obtenerContenido();

        /* Se crea una variable texto de tipo Text con el objeto creado, se le da un ancho,
        *  un color, una fuente y un tamaño de fuente. */
        Text texto = new Text(); // (16)
        texto.setWrappingWidth(700); // (16)
        texto.setFill(Color.BLACK); // (16)
        texto.setFont(Font.font("Times New Roman", 22)); // (16)

        /* Se crea una variable enunciadoTexto de tipo TextFlow con el objeto creado,
        se le da la variable de texto, un ancho y un alineado de texto.*/
        TextFlow enunciadoTexto = new TextFlow(texto); // (16)
        enunciadoTexto.setPrefWidth(700); // (10)
        enunciadoTexto.setTextAlignment(TextAlignment.JUSTIFY); // (16)

        /* Se usa ImageView para darle formato a la imagen que se mostrará junto con el texto.
         * Se le da un determinado ancho y una proporción que no se altere. */
        ImageView vistaDeImagen = new ImageView(); // (17)
        vistaDeImagen.setFitWidth(380); // (17)
        vistaDeImagen.setPreserveRatio(true); // (17)

        /* Se crea la variable fondoSemana, que es de tipo BackgroundImage; en esta variable se
         * almacena el objeto BackgroundImage; se le pasa el parámetro que contiene la ruta de
         * la imagen que se cargó antes; se indica que la imagen no se repita ni a lo ancho
         * ni a lo alto; se indica que la posición de la imagen sea en el centro; y se configura
         * el tamaño de la imagen, dejando el ancho y alto automáticos, dando como false
         * el uso de porcentajes para el tamaño, y como true el que la imagen se adapte al
         * contenedor. */
        BackgroundImage fondoSemana = new BackgroundImage(new Image
                (getClass().getResourceAsStream(obtenerRutaFondo())),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)); // (2) (3)

        /* Se crea la variable botonAntes de la clase Button y se le asigna el objeto
         * Button con la leyenda "Anterior". */
        Button botonAntes = crearBoton("Anterior"); // (4)

        /* Se crea la variable botonSiguiente de la clase Button y se le asigna el objeto
         * Button con la leyenda "Siguiente". */
        Button botonSiguiente = crearBoton("Siguiente"); // (4)

        /* Se crea una caja para agrupar los botones de anterior y siguiente de manera
         * horizontal; se establece que se alineen al centro, y se establece una separación
         * entre los botones de 20px. */
        HBox botonesNavegarHorizontal = new HBox(20, botonAntes, botonSiguiente); // (9)
        botonesNavegarHorizontal.setAlignment(Pos.CENTER); // (9)

        /* Se crea la variable botonRegresar de la clase Button y se le asigna el objeto
         * Button con la leyenda "Regresar", además de la acción de regresar a la pantalla
         * anterior. */
        Button botonRegresar = crearBoton("Regresar"); // (4)
        botonRegresar.setOnAction(e -> accionRegresar(stage).run()); // (13)

        /* Se crea una caja para agrupar las cajas de texto e imagen de manera
         * horizontal; se establece que se alineen al centro, y se establece la caja
         * con una margen de 50px por debajo y una distancia de 80px entre ambas. */
        HBox contenedorCentralHorizontal = new HBox(80); // (9)
        contenedorCentralHorizontal.setAlignment(Pos.CENTER); // (9)
        contenedorCentralHorizontal.setPadding(new Insets(0, 0, 50, 0)); // (10)

        /* Se crea una caja para guardar el texto en vertical; se establece que se alinee
         * al centro a la izquierda, y se establece la caja con un ancho máximo de 700px. */
        VBox cajaTexto = new VBox(enunciadoTexto); // (15)
        cajaTexto.setAlignment(Pos.CENTER_LEFT); // (15)
        cajaTexto.setMaxWidth(700); // (10)

        /* Se crea una caja para guardar la imagen; y se establece que se alinee
         * al centro a la derecha. */
        VBox cajaImagen = new VBox(vistaDeImagen); // (15)
        cajaImagen.setAlignment(Pos.CENTER_RIGHT); // (15)

        // Se agregan las cajas de texto e imagen al contenedor central horizontal.
        contenedorCentralHorizontal.getChildren().addAll(cajaTexto, cajaImagen);

        // Caja vertical principal que contendrá todo el contenido.
        VBox contenedorPrincipal = new VBox(); // (15)
        contenedorPrincipal.setAlignment(Pos.TOP_CENTER); // (15)
        contenedorPrincipal.setPadding(new Insets(200, 20, 20, 20)); // (10)

        contenedorPrincipal.getChildren().add(contenedorCentralHorizontal); // (18)

        /* Se crea el panel principal que contiene el contenedor principal centrado. */
        BorderPane panelPrincipal = new BorderPane(); // (11)
        panelPrincipal.setCenter(contenedorPrincipal); // (11)

        /* Se crea el panel principal que contiene a la izquierda el botón de anterior, a
         * la derecha el de siguiente, y en medio el de regresar, todos en la parte inferior. */
        BorderPane contenedorInferior = new BorderPane(); // (11)
        contenedorInferior.setPadding(new Insets(20)); // (10)

        contenedorInferior.setLeft(botonAntes); // (11)
        BorderPane.setAlignment(botonAntes, Pos.BOTTOM_LEFT); // (11)

        contenedorInferior.setRight(botonSiguiente); // (11)
        BorderPane.setAlignment(botonSiguiente, Pos.BOTTOM_RIGHT); // (11)

        contenedorInferior.setCenter(botonRegresar); // (11)
        BorderPane.setAlignment(botonRegresar, Pos.BOTTOM_CENTER); // (11)

        /* Se añade el contenedor inferior a la parte de abajo del panel principal. */
        panelPrincipal.setBottom(contenedorInferior); // (11)

        /* Se añade el fondo al panel principal. */
        panelPrincipal.setBackground(new Background(fondoSemana)); // (10)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(panelPrincipal, 800, 600); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle(obtenerTitulo()); // (8)
        stage.setFullScreen(true); // (8)
        stage.setFullScreenExitHint(""); // (8)
        stage.show(); // (8)

        /* Se implementa la interfaz de runnable con el nombre de actualizar para poder
         * hacer el cambio entre pantallas.
         */
        Runnable actualizar = () -> { // (19)
            ContenidoSemana contenido = pantallas.get(pantallaActual);
            texto.setText(contenido.obtenerTexto()); // (16)
            vistaDeImagen.setImage(new Image(getClass().getResourceAsStream(contenido.obtenerRutaImagen()))); // (17)

            // Se desactivan los botones si estamos en los extremos de la cantidad de pantallas.
            botonAntes.setDisable(pantallaActual == 0); // (7)
            botonSiguiente.setDisable(pantallaActual == pantallas.size() - 1); // (7)
        };

        // Se les dan las acciones a los botones para navegar entre pantallas.
        botonAntes.setOnAction(e -> { // (13)
            if (pantallaActual > 0) pantallaActual--;
            actualizar.run(); // (19)
        });

        botonSiguiente.setOnAction(e -> { // (13)
            if (pantallaActual < pantallas.size() - 1) pantallaActual++;
            actualizar.run(); // (19)
        });

        // Se inicia la semana con la primer pantalla (0).
        actualizar.run(); // (19)
    }

    /**
     * Método para crear un botón con su estilo ya predefinido.
     *
     * @param texto Es el texto que tendrá el botón.
     * @return Retorna el botón con su texto y apariencia.
     */
    private Button crearBoton(String texto) {
        /* Se crea la variable boton de la clase Button y se le asigna el objeto
         * Button con la leyenda del parámetro texto. */
        Button boton = new Button(texto); // (4)

        // Se le da la apariencia al botón.
        boton.setFont(Font.font("Times New Roman", 20)); // (5) (6)
        boton.setTextFill(Color.rgb(92, 26, 98)); // (6)
        String base = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius:30px;"
                + " -fx-border-color:#833a8a; -fx-border-width:1px; -fx-border-radius:40px;";
        String encima = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius:30px;"
                + " -fx-border-color:#5c1a62; -fx-border-width:2px; -fx-border-radius:40px;";

        // Se define el estilo del botón base, cuando el cursor pasa por encima, y cuando sale.
        boton.setStyle(base); // (7)
        boton.setOnMouseEntered(e -> boton.setStyle(encima)); // (7)
        boton.setOnMouseExited(e -> boton.setStyle(base)); // (7)

        return boton;
    }
}