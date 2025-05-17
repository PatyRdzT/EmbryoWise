package com.embryowise.Cuestionarios;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.List;
import java.util.Objects;

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
 * (24) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html
 */

/** Esta clase es la que pretende ser plantilla para mostrar las calificaciones y progresos del usuario. */
public class PantallaResultados {
    // Se crean variables de  stage para manejar la actual y la anterior.
    private final Stage stage; // (8)
    private final Stage previousStage; // (8)

    /** Times New Roman es la fuente que se usará en todos los botones, junto con su tamaño. */
    private final Font fuente = Font.font("Times New Roman", 25); // (5)

    /** Es el color del texto con valores rgb. */
    private final Color colorDeTexto = Color.rgb(92, 26, 98); // (1)

    /** Constuctor de la clase PnatallaResultados. Recibe el valor de la stage anterior, y
     *  crea una nueva. */
    public PantallaResultados(Stage previousStage) {
        this.previousStage = previousStage;
        this.stage = new Stage();
    }

    /** Método usado para mostrar los elementos de la pantalla. */
    public void mostrar(String titulo, List<String> elementos) {
        /* Se crea la variable fondo, que es de tipo Image; en esta variable se
         * almacena el objeto Image; en la carpeta de resources se busca la ruta que se pasa
         * como parámetro; y se convierte a URL para usarla después. */
        Image fondo = new Image(Objects.requireNonNull(getClass().getResource
                ("/Recursos/FondosMenus/FondoMenuCuestionarios.png")).toExternalForm()); // (1)

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
                        false, false, true, true));  // (2) (3)

        /* Se crea una caja para guardar los elementos principales a mostrar en la pantalla. */
        VBox contenedorPrincipal = new VBox(20); // (15)
        contenedorPrincipal.setAlignment(Pos.TOP_CENTER); // (15)
        contenedorPrincipal.setPadding(new Insets(50, 20, 50, 20)); // (10)
        contenedorPrincipal.setMaxWidth(1000); // (10)

        // Se crea un label para dar información.
        Label tituloLabel = new Label(titulo); // (6)
        tituloLabel.setFont(Font.font("Times New Roman", 30)); // (6)
        tituloLabel.setTextFill(colorDeTexto); // (6)
        tituloLabel.setPadding(new Insets(0, 0, 20, 0)); // (10)

        /* Se crea una caja para guardar los elementos a mostrar en la pantalla, se centra
         * a la izquierda y se le da un amrgen. */
        VBox cajaVerticalElementos = new VBox(10); // (15)
        cajaVerticalElementos.setAlignment(Pos.CENTER_LEFT); // (15)
        cajaVerticalElementos.setPadding(new Insets(0, 0, 20, 0)); // (10)
        cajaVerticalElementos.setFillWidth(true); // (15)

        // Si la lista de elementos está vacía, se manda el mensaje de que no hay información
        // disponible y se le da una apariencia. Finalmente se añade a la caja de elementos.
        if (elementos.isEmpty()) {
            Label noHayRegistros = new Label("No hay información disponible.");
            noHayRegistros.setFont(Font.font("Times New Roman", 20)); // (6) // (6)
            noHayRegistros.setTextFill(colorDeTexto); // (6)
            cajaVerticalElementos.getChildren().add(noHayRegistros); // (18)
            cajaVerticalElementos.setAlignment(Pos.CENTER); // (15)
        } else {
            // Se recorren los elementos y se van mostrando uno a uno con el formato dado,
            // añadiéndolos a la caja de elementos.
            for (String x : elementos) {
                Label label = new Label("• " + x);
                label.setFont(Font.font("Times New Roman", 18));
                label.setTextFill(colorDeTexto);
                label.setWrapText(true);
                cajaVerticalElementos.getChildren().add(label);
            }
        }

        // Se usar un scrollpane por si hay demasiados registros.
        ScrollPane scrollPane = new ScrollPane(cajaVerticalElementos); // (24)
        scrollPane.setFitToWidth(true); // (24)
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // (24)
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); // (24)
        scrollPane.setMaxHeight(500); // (24)

        // Secrea el botón de regresar y se le da su apariencia y acción.
        Button botonRegresar = new Button("Regresar");
        botonRegresar.setFont(fuente); // (5) (6)
        botonRegresar.setTextFill(colorDeTexto); // (6)
        botonRegresar.setStyle("-fx-background-color: rgba(255,215,229,0); " +
                "-fx-background-radius: 30px; " + "-fx-border-color: #833a8a; " +
                "-fx-border-width: 1px; " + "-fx-border-radius: 40px;"); // (7)
        botonRegresar.setPadding(new Insets(10, 30, 10, 30)); // (10)

        botonRegresar.setOnAction(e -> {
            stage.close();
            previousStage.show();
        });

        // Se añaden todos los elementos al contenedor principal.
        contenedorPrincipal.getChildren().addAll(tituloLabel, scrollPane, botonRegresar); // (18)
        contenedorPrincipal.setPadding(new Insets(250, 0, 0, 0)); // (10)

        /* Se crea el panel principal que contiene a los botones, con la caja central en el centro
         * la inferior en la parte de abajo, y estableciendo como fondo la imagen antes cargada. */
        BorderPane planoPrincipal = new BorderPane(); // (11)
        planoPrincipal.setBackground(new Background(imagenDeFondo)); // (10)
        BorderPane.setAlignment(contenedorPrincipal, Pos.CENTER); // (11)
        planoPrincipal.setCenter(contenedorPrincipal); // (11)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(planoPrincipal, 1366, 768); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle(titulo); // (8)
        stage.setFullScreen(true); // (8)
        stage.setFullScreenExitHint(""); // (8)
        previousStage.hide(); // (8)
        stage.show(); // (8)
    }
}
