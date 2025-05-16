package com.embryowise.Registro;

import com.embryowise.InicioSesion.PantallaInicioSesion;
import com.embryowise.Menu.MenuPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
 */

/** Esta clase tiene como función ser la que muestre la pantalla de registro
 *  para el usuario. */
public class PantallaRegistro {
    /** Times New Roman es la fuente que se usará en todos los botones, junto con su tamaño. */
    private final Font fuenteNormal = Font.font("Times New Roman", 28); // (5)
    private final Font fuentePequena = Font.font("Times New Roman", 18); // (5)

    /** Es el color del texto con valores rgb. */
    private final Color colorDeTexto = Color.rgb(92, 26, 98); // (14)

    /** Se usó el formato de CSS para aplicar un estilo predeterminado a los botones. */
    private final String estiloBoton = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
            "-fx-border-color: #833a8a; -fx-border-width: 1px; -fx-border-radius: 40px;";

    /** Es el estilo en formato CSS que se le da al botón cuando el cursor pasa por encima. */
    private final String estiloBotonHover = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
            "-fx-border-color: #5c1a62; -fx-border-width: 2px; -fx-border-radius: 40px;";

    /** Es el estilo en formato CSS que se le da al campo de texto. */
    private final String estiloCampoTexto = "-fx-font-size: 15px; -fx-padding: 15px; " + estiloBoton;

    /** Este es el método que mostrará los elementos de la pantalla de registro.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        /* Se crea la variable fondo, que es de tipo Image; en esta variable se
         * almacena el objeto Image; en la carpeta de resources se busca la ruta que se pasa
         * como parámetro; y se convierte a URL para usarla después. */
        Image fondo = new Image(Objects.requireNonNull(getClass().getResource("/Recursos" +
                "/FondosMenus/FondoRegistro.png")).toExternalForm()); // (1)

        /* Se crea la variable imagenDeFondo, que es de tipo BackgroundImage; en esta variable se
         * almacena el objeto BackgroundImage; se le pasa el parámetro que contiene la ruta de
         * la imagen que se cargó antes; se indica que la imagen no se repita ni a lo ancho
         * ni a lo alto; se indica que la posición de la imagen sea en el centro; y se configura
         * el tamaño de la imagen, dejando el ancho y alto, automáticos, dando como false
         * el uso de porcentajes para el tamaño, y como true el que la imagen se adapte al
         * contenedor. */
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
                        false, true, true)); // (2) (3)

        /* Se crea el campo para ingresar el nombre de usuario y se le da un texto
         * default, un tamaño y el estilo antes creado. */
        TextField campoNombre = new TextField(); // (21)
        campoNombre.setPromptText("Nombre de usuario"); // (23)
        campoNombre.setPrefSize(300, 60); // (10)
        campoNombre.setStyle(estiloCampoTexto); // (7)

        /* Se crea el campo para ingresar la contraseña y se le da un texto
         * default, un tamaño y el estilo antes creado. */
        PasswordField campoContrasena = new PasswordField(); // (21)
        campoContrasena.setPromptText("Contraseña"); // (23)
        campoContrasena.setPrefSize(300, 60); // (10)
        campoContrasena.setStyle(estiloCampoTexto); // (7)

        // Se crea una instancia de botón con el texto Registrarse.
        Button botonRegistro = new Button("Registrarse");

        // Se le aplica su apariencia y tamaño al botón.
        botonRegistro.setPrefSize(200, 50);
        aplicarEstilo(botonRegistro);

        // Se le da la acción de crear el registro al botón de registro.
        botonRegistro.setOnAction(e -> {
            new MenuPrincipal().mostrar(new Stage());
            stage.close();
        });

        // Se crea un hipervínculo de solo texto para ir a la pantalla de registro. Y a
        // este texto se le da su apariencia.
        Hyperlink linkLogin = new Hyperlink("¿Ya tienes cuenta? Inicia sesión"); // (13)
        linkLogin.setFont(fuentePequena); // (6)
        linkLogin.setTextFill(colorDeTexto); // (6)
        linkLogin.setBorder(Border.EMPTY); // (10)
        linkLogin.setUnderline(true); // (6)

        // Se le da la acción al hipervínculo.
        linkLogin.setOnAction(e -> {
            new PantallaInicioSesion().mostrar(new Stage());
            stage.close();
        });

        /* Se crea una caja para guardar los campos y el hipervínculo de login. Además de
         *  alinearlo al centro. */
        VBox campos = new VBox(15, campoNombre, campoContrasena, linkLogin); // (15)
        campos.setAlignment(Pos.CENTER); // (15)

        /* Se crea una caja para guardar los campos y el botón de registro. Además de
         *  alinearlo al centro y dar margenes superior de 200px e inferior de 40px. */
        VBox contenedorCentral = new VBox(40, campos, botonRegistro); // (15)
        contenedorCentral.setAlignment(Pos.CENTER); // (15)
        contenedorCentral.setPadding(new Insets(200, 0, 40, 0)); // (20)

        /* Se crea el panel principal que contiene a la caja final, la centra, y establece como
         * fondo la imagen antes cargada. */
        BorderPane panelPrincipal = new BorderPane(); // (11)
        panelPrincipal.setCenter(contenedorCentral); // (11)
        panelPrincipal.setBackground(new Background(imagenDeFondo)); // (10)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(panelPrincipal, 1366, 768); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle("Registro de Usuario"); // (8)
        stage.setFullScreen(true); // (8)
        stage.setFullScreenExitHint(""); // (8)
        stage.show(); // (8)
    }

    /**
     * Es un método hecho para aplicar los estilos de fuente, colorDeTexto y estiloPorDefecto a los
     * botones, además de configurar cómo se verá el botón cuando el cursor pase por encima,
     * y cómo se verá cuando el cursor se retire.
     *
     * @param boton Es al atributo al que se le van a aplicar los estilos del método.
     */
    private void aplicarEstilo(Button boton) { // (4)
        boton.setFont(fuenteNormal); // (5) (6)
        boton.setTextFill(colorDeTexto); // (6)
        boton.setStyle(estiloBoton); // (7)

        /* Se les da un estilo a los botones cuando se pasa el cursor por encima y cuando sale,
         * con un color de fondo transparente, un radius de fondo y de borde, y un color y
         * ancho del borde. */
        boton.setOnMouseEntered(e -> boton.setStyle(estiloBotonHover)); // (7)
        boton.setOnMouseExited(e -> boton.setStyle(estiloBoton)); // (7)
    }
}
