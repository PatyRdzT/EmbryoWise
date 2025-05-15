package com.embryowise.Pantalla.Glosario;

import com.embryowise.Pantalla.MenuBase;
import com.embryowise.Pantalla.MenuPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.SQLException;

/* -- REFERENCIAS --
 *
 *  - https://youtu.be/1n28VRCzJho?si=DcmZNfjfO9P4intn -> Usado para ver cómo documentar.
 *  - https://www.youtube.com/watch?v=Adzq7k6rlDY&t=1658s -> Usado paa establecer la conexión con la BD.
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
 * (20) https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html
 * (21) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
 * (22) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextArea.html
 * (23) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextInputControl.html
 */

/** Esta clase tiene como función manejar la apariencia de la pantalla del glosario,
 *  además de crear una instancia de Glosario para ejecutar la búsqueda de palabras.
 * */
public class GlosarioPantalla {
    /** Times New Roman es la fuente que se usará en todos los botones, junto con su tamaño. */
    private final Font fuente = Font.font("Times New Roman", 24); // (5)

    /** Es el color del texto con valores rgb. */
    private final Color colorDeTexto = Color.rgb(92, 26, 98); // (14)

    /** Es el color del texto con valores rgb. */
    private final String fondoRuta = "/Recursos/FondosMenus/FondoGlosario.png";

    /** Se usó el formato de CSS para aplicar un estilo predeterminado a los botones. */
    private final String estiloPorDefecto =
            "-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
                    "-fx-border-color: #833a8a; -fx-border-width: 1px; -fx-border-radius: 40px;";

    /** Es el estilo en formato CSS que se le da al botón cuando el cursor pasa por encima. */
    private final String estiloSobreCursor =
            "-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
                    "-fx-border-color: #5c1a62; -fx-border-width: 2px; -fx-border-radius: 40px;";

    /** Método usado para aplicar el estilo ya creado a un botón. */
    public void aplicarEstilo(Button boton) {
        boton.setFont(fuente);
        boton.setTextFill(colorDeTexto);
        boton.setStyle(estiloPorDefecto);
        boton.setOnMouseEntered(e -> boton.setStyle(estiloSobreCursor));
        boton.setOnMouseExited(e -> boton.setStyle(estiloPorDefecto));
    }

    /** Es el método para mostrar en sí todo lo que aparecerá en la pantalla de manera ya completa.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        // Se crea una instancia de botón con el texto Regresar.
        Button botonRegresar = new Button("Regresar"); // (4)
        // Se le da el estilo creado al botón.
        aplicarEstilo(botonRegresar);

        // Se le da la acción de volver al menú principalal botón de Regresar.
        botonRegresar.setOnAction(e -> new MenuPrincipal().mostrar(stage)); // (13)

        /* Se crea una caja para guardar el botón de regresar, alinearlo en el centro,
        *  y establecerle un margen inferior de 20 px. */
        VBox contenedorInferiorVertical = new VBox(botonRegresar); // (15)
        contenedorInferiorVertical.setAlignment(Pos.CENTER); // (15)
        contenedorInferiorVertical.setPadding(new Insets(0, 0, 20, 0)); // (10)

        /* Se crea el área de búsqueda y como por defecto se le da la oración de buscar
         * una palabra; se le da una fuente, un estilo, una altura máxima, y una alineación
         * al centro. */
        TextField cuadroBusqueda = new TextField(); // (21)
        cuadroBusqueda.setPromptText("Busca una palabra..."); // (23)
        cuadroBusqueda.setFont(fuente); // (23)
        cuadroBusqueda.setStyle("-fx-background-color: transparent; " +
                "-fx-text-fill: #5c1a62; -fx-border-radius: 20px; " +
                "-fx-border-color: #833a8a;"); // (7)
        cuadroBusqueda.setMaxWidth(400); // (10)
        cuadroBusqueda.setAlignment(Pos.CENTER); // (21)

        // Se crea una instancia de botón con el texto Buscar.
        Button botonBuscar = new Button("Buscar"); // (4)
        // Se le da el estilo creado al botón.
        aplicarEstilo(botonBuscar); // (13)

        /* Se crea el área de definición y se establece que no pueda ser editable, se le
        * da una fuente, un estilo, y un área máxima. */
        TextArea areaDefinicion = new TextArea(); // (22)
        areaDefinicion.setEditable(false); // (23)
        areaDefinicion.setWrapText(true); // (22)
        areaDefinicion.setFont(Font.font("Times New Roman", 18)); // (23)
        areaDefinicion.setStyle("-fx-control-inner-background: #e4b8fe;" + "-fx-background-color: #e4b8fe;" +
                        "-fx-text-fill: #5c1a62;" + "-fx-border-color: transparent;"); // (7)
        areaDefinicion.setMaxWidth(500); // (10)
        areaDefinicion.setMaxHeight(50); // (10)

        // Se establece la acción del botón de búsqueda.
        botonBuscar.setOnAction(e -> {
            // Se guarda la palabra escrita en el cuadro de búsqueda.
            String palabra = cuadroBusqueda.getText();
            // Se inicia la definición como nula.
            String definicion = null;

            // Se crea un bloque try-catch para atrapar alguna excepción de sql, y se llama
            // al método de buscar palabra en la instancia de glosario, pasándole el parámetro.
            try {
                definicion = buscarPalabraEnGlosario(palabra);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            // Se muestra el texto de la definición en el área de definición.
            areaDefinicion.setText(definicion);
        });

        /* Se crea una caja para guardar el botón de buscar y los cuadros, alinearlos en
         * el centro, y establecerles un margen superior de 350 px. */
        VBox contenedorBusqueda = new VBox(30, cuadroBusqueda, botonBuscar, areaDefinicion); // (15)
        contenedorBusqueda.setAlignment(Pos.CENTER); // (15)
        contenedorBusqueda.setPadding(new Insets(350, 0, 0, 0)); // (10)

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
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true, true)); // (2) (3)

        /* Se crea el panel principal que contiene a los botones, con la caja central en el centro
         * la inferior en la parte de abajo, y estableciendo como fondo la imagen antes cargada. */
        BorderPane planoPrincipal = new BorderPane(); // (11)
        planoPrincipal.setBackground(new Background(imagenDeFondo)); // (11)
        planoPrincipal.setTop(contenedorBusqueda); // (11)
        planoPrincipal.setBottom(contenedorInferiorVertical); // (10)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(planoPrincipal); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle("Glosario"); // (8)
        stage.setFullScreen(true); // (8)
        stage.setFullScreenExitHint(""); // (8)
        stage.show(); // (8)
    }

    /** Este método crea una instancia de glosario y retorna la llamada al método de
     *  buscarDefinicion con el parámetro de palabra.*/
    private String buscarPalabraEnGlosario(String palabra) throws SQLException {
        Glosario glosario = new Glosario();

        return glosario.buscarDefinicion(palabra);
    }
}