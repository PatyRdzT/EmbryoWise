package com.embryowise.InicioSesion;

import com.embryowise.ManejoUsuario.OperacionesUsuario;
import com.embryowise.MensajeTemporal;
import com.embryowise.Menu.MenuPrincipal;
import com.embryowise.Registro.PantallaRegistro;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;
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

/** Esta clase tiene como función ser la que muestre la pantalla de inicio de sesión
 *  para el usuario. */
public class PantallaInicioSesion {
    /** Times New Roman es la fuente que se usará en todos los botones, junto con su tamaño. */
    private final Font fuenteNormal = Font.font("Times New Roman", 28); // (5)
    private final Font fuentePequena = Font.font("Times New Roman", 18); // (5)

    /** Es el color del texto con valores rgb. */
    private final Color colorDeTexto = Color.rgb(92, 26, 98); // (14)
    private final Color colorLink = Color.rgb(70, 20, 120); // (14)

    /** Se usó el formato de CSS para aplicar un estilo predeterminado a los botones. */
    private final String estiloBoton = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
            "-fx-border-color: #833a8a; -fx-border-width: 1px; -fx-border-radius: 40px;";

    /** Es el estilo en formato CSS que se le da al botón cuando el cursor pasa por encima. */
    private final String estiloBotonHover = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius: 30px; " +
            "-fx-border-color: #5c1a62; -fx-border-width: 2px; -fx-border-radius: 40px;";

    /** Es el estilo en formato CSS que se le da al campo de texto. */
    private final String estiloCampoTexto = "-fx-font-size: 15px; -fx-padding: 15px; " + estiloBoton;

    /** Este es el método que mostrará los elementos de la pantalla de inicio de sesión.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        /* Se crea la variable fondo, que es de tipo Image; en esta variable se
         * almacena el objeto Image; en la carpeta de resources se busca la ruta que se pasa
         * como parámetro; y se convierte a URL para usarla después. */
        Image fondo = new Image(Objects.requireNonNull(getClass().getResource("/Recursos" +
                "/FondosMenus/FondoInicioSesion.png")).toExternalForm()); // (1)

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

        // Se crea la instancia de mensaje temporal para usarla con el botón de login.
        MensajeTemporal mensajeError = new MensajeTemporal();

        /* Se crea el campo para ingresar el nombre de usuario y se le da un texto
         * default, un tamaño y el estilo antes creado. */
        TextField campoUsuario = new TextField(); // (21)
        campoUsuario.setPromptText("Ingrese su nombre de usuario"); // (23)
        campoUsuario.setPrefSize(300, 60); // (10)
        campoUsuario.setStyle(estiloCampoTexto); // (7)

        /* Se crea el campo para ingresar la contraseña y se le da un texto
         * default, un tamaño y el estilo antes creado. */
        PasswordField campoContrasena = new PasswordField(); // (21)
        campoContrasena.setPromptText("Ingrese su contraseña"); // (23)
        campoContrasena.setPrefSize(300, 60); // (10)
        campoContrasena.setStyle(estiloCampoTexto); // (7)

        // Se crea una instancia de botón con el texto Iniciar sesión.
        Button botonLogin = new Button("Iniciar Sesión");

        // Se crea una instancia de botón con el texto Salir.
        Button botonSalir = new Button("Salir");

        // Se les aplica su apariencia y tamaño a los botones.
        botonLogin.setPrefSize(200, 50); // (10)
        aplicarEstilo(botonLogin);

        botonSalir.setPrefSize(200, 50); // (10)
        aplicarEstilo(botonSalir);

        // Se le da la acción de mostrar el menú principal al botón de login, siempre
        // y cuando las credenciales sean correctas.
        botonLogin.setOnAction(e -> {
            // Se obtiene el texto de ambos campos.
            String usuario = campoUsuario.getText(); // (23)
            String contrasena = campoContrasena.getText(); // (23)

            // Si alguno de los campos está vacío, se pide al usuario que los complete,
            // y esto se muestra por 3 segundos.
            if(usuario.isEmpty() || contrasena.isEmpty()) {
                mensajeError.mostrarMensaje("Favor de completar todos los campos.", 3);

                return;
            }

            // Si las credenciales son válidas, se pasa al menú principal, si no, se muestra
            // el mensaje de que el usuario o la contraseña están incorrectos.
            try {
                if(OperacionesUsuario.validarCredenciales(usuario, contrasena)) {
                    new MenuPrincipal().mostrar(new Stage());
                    stage.close();
                } else {
                    mensajeError.mostrarMensaje("El nombre de usuario o la " +
                            "contraseña son incorrectos.", 3);
                }
            } catch (SQLException ex) {
                mensajeError.mostrarMensaje("Error al conectar con la base de datos.", 3);
            }
        });

        // Se le da la acción de cerrar la stage al botón de salir.
        botonSalir.setOnAction(e -> stage.close());

        // Se crea un hipervínculo de sólo texto para ir a la pantalla de registro. Y a
        // este texto se le da su apariencia.
        Hyperlink linkRegistro = new Hyperlink("Registrarse"); // (13)
        linkRegistro.setFont(fuentePequena); // (6)
        linkRegistro.setTextFill(colorLink); // (6)
        linkRegistro.setBorder(Border.EMPTY); // (10)
        linkRegistro.setUnderline(true); // (6)

        // Se le da la acción al hipervínculo.
        linkRegistro.setOnAction(e -> {
            new PantallaRegistro().mostrar(new Stage());
            stage.close();
        });

        /* Se crea una caja para agrupar los botones del centro de manera horizontal;
         * se establece que se alineen al centro, y se establece la caja de manera centrada. */
        HBox cajaHorizontalBotones = new HBox(50, botonLogin, botonSalir);
        cajaHorizontalBotones.setAlignment(Pos.CENTER);

        /* Se crea una caja para guardar los campos y el hipervínculo de registro. Además de
         *  alinearlo al centro y dar margenes superior de 200px e inferior de 40px. */
        VBox cajaVerticalCampos = new VBox(40, campoUsuario, campoContrasena, linkRegistro); // (15)
        cajaVerticalCampos.setAlignment(Pos.CENTER); // (15)
        cajaVerticalCampos.setPadding(new Insets(300, 0, 40, 0)); // (10)

        /* Se crea una caja para guardar los campos, el mensaje de error y los botones. Además de
         *  alinearla al centro y dar margen inferior de 40px. */
        VBox cajaFinal = new VBox(50, cajaVerticalCampos, mensajeError, cajaHorizontalBotones); // (15)
        cajaFinal.setAlignment(Pos.CENTER); // (15)
        cajaFinal.setPadding(new Insets(0, 0, 40, 0)); // (10)

        /* Se crea el panel principal que contiene a la caja final, la centra, y establece como
         * fondo la imagen antes cargada. */
        BorderPane panelPrincipal = new BorderPane(); // (11)
        panelPrincipal.setCenter(cajaFinal); // (11)
        panelPrincipal.setBackground(new Background(imagenDeFondo)); // (10)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(panelPrincipal, 1366, 768); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle("Inicio de Sesión"); // (8)
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