package com.embryowise.Cuestionarios;

import com.embryowise.ManejoUsuario.OperacionesUsuario;
import com.embryowise.Menu.MenuBase;
import com.embryowise.Menu.MenuPrincipal;
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
import java.util.List;
import java.util.Objects;

/* -- REFERENCIAS --
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
 * (13) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Alert.html
 * (14) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
 * (15) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html
 * (16) https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * (17) https://docs.oracle.com/javase/8/docs/api/java/sql/SQLException.html
 * (18) https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Modality.html
 * (*) Otras referencias internas de la aplicación
 */

/** Clase que contiene el menú principal de cuestionarios, oermite acceder a los
 * diferentes cuestionarios y ver el progreso y calificaciones del usuario.
 */
public class MenuCuestionarios extends MenuBase {
    // Listas de preguntas para cada cuestionario.
    private static final List<Pregunta> PREGUNTAS_PRE_EMBRIONARIO = List.of(
            new Pregunta("¿Qué ocurre durante la fecundación?",
                    List.of("División del óvulo", "Unión de óvulo y espermatozoide", "Formación del embrión"), 1),
            new Pregunta("¿Cuánto dura el periodo pre-embrionario?",
                    List.of("1 semana", "2 semanas", "3 semanas"), 1),
            new Pregunta("¿Dónde ocurre normalmente la fecundación?",
                    List.of("Útero", "Ovario", "Trompa de Falopio"), 2),
            new Pregunta("¿Cómo se llama la primera célula tras la fecundación?",
                    List.of("Blastocito", "Cigoto", "Mórula"), 1),
            new Pregunta("¿Qué proceso ocurre primero en el desarrollo preembrionario?",
                    List.of("Gastrulación", "Segmentación", "Implantación"), 1),
            new Pregunta("¿Qué estructura permite la implantación del embrión?",
                    List.of("Trofoblasto", "Epiblasto", "Saco vitelino"), 0),
            new Pregunta("¿En qué día se implanta el blastocisto aproximadamente?",
                    List.of("Día 3", "Día 6-7", "Día 14"), 1),
            new Pregunta("¿Qué estructura origina al embrión?",
                    List.of("Trofoblasto", "Embrioblasto", "Sincitiotrofoblasto"), 1),
            new Pregunta("¿Qué nombre recibe el embrión al alcanzar 16-32 células?",
                    List.of("Blastocito", "Mórula", "Gástrula"), 1),
            new Pregunta("¿Qué líquido protege al embrión desde los primeros días?",
                    List.of("Líquido sinovial", "Líquido amniótico", "Líquido cefalorraquídeo"), 1)
    );

    private static final List<Pregunta> PREGUNTAS_EMBRIONARIO = List.of(
            new Pregunta("¿Qué proceso forma las tres capas germinativas?",
                    List.of("Segmentación", "Gastrulación", "Implantación"), 1),
            new Pregunta("¿Qué capa germinativa forma el sistema nervioso?",
                    List.of("Mesodermo", "Endodermo", "Ectodermo"), 2),
            new Pregunta("¿Qué estructura aparece como un surco en el dorso del embrión?",
                    List.of("Surco neural", "Línea primitiva", "Notocorda"), 0),
            new Pregunta("¿En qué semana comienza a latir el corazón embrionario?",
                    List.of("Semana 4", "Semana 6", "Semana 8"), 0),
            new Pregunta("¿Qué forma el mesodermo?",
                    List.of("La piel", "Huesos y músculos", "Sistema digestivo"), 1),
            new Pregunta("¿Qué evento inicia el desarrollo del sistema nervioso?",
                    List.of("Formación del tubo neural", "Formación del corazón", "Formación de somitos"), 0),
            new Pregunta("¿Qué son los somitos?",
                    List.of("Células sanguíneas", "Segmentos que formarán músculos y vértebras", "Células de la placenta"), 1),
            new Pregunta("¿Qué estructura conecta al embrión con la placenta?",
                    List.of("Cordón umbilical", "Trofoblasto", "Vellosidades coriónicas"), 0),
            new Pregunta("¿Qué sistemas se desarrollan en el periodo embrionario?",
                    List.of("Sistema digestivo", "Todos los sistemas principales", "Sistema reproductor"), 1),
            new Pregunta("¿Qué ocurre al finalizar la semana 8?",
                    List.of("Se forma el embrión", "Inicia la organogénesis", "Empieza el periodo fetal"), 2)
    );

    private static final List<Pregunta> PREGUNTAS_FETAL = List.of(
            new Pregunta("¿Qué caracteriza al periodo fetal?",
                    List.of("Formación de capas germinativas", "Desarrollo y maduración de órganos", "Implantación del cigoto"), 1),
            new Pregunta("¿En qué semana se escucha el latido fetal con doppler?",
                    List.of("Semana 6", "Semana 12", "Semana 20"), 1),
            new Pregunta("¿Qué se desarrolla intensamente en el tercer trimestre?",
                    List.of("Formación del tubo neural", "Desarrollo del corazón", "Aumento de peso y tamaño"), 2),
            new Pregunta("¿Qué función tiene el líquido amniótico?",
                    List.of("Nutrir al feto", "Proteger y mantener temperatura", "Eliminar desechos"), 1),
            new Pregunta("¿Qué indica la viabilidad fetal?",
                    List.of("Capacidad de sobrevivir fuera del útero", "Capacidad de moverse", "Capacidad de recibir oxígeno"), 0),
            new Pregunta("¿Cuándo se puede conocer el sexo fetal con más precisión por ultrasonido?",
                    List.of("Semana 8", "Semana 12", "Semana 16-20"), 2),
            new Pregunta("¿Qué órgano madura en el tercer trimestre para permitir la respiración?",
                    List.of("Hígado", "Pulmones", "Corazón"), 1),
            new Pregunta("¿Qué sucede en la semana 24?",
                    List.of("Desarrollo ocular", "El feto responde a sonidos", "Inicia la gastrulación"), 1),
            new Pregunta("¿Qué ocurre en la piel fetal en el último trimestre?",
                    List.of("Se vuelve más transparente", "Desaparece el lanugo y se engruesa", "Se vuelve más delgada"), 1),
            new Pregunta("¿Qué evento marca el fin del periodo fetal?",
                    List.of("Inicio del trabajo de parto", "Desarrollo pulmonar", "Madurez digestiva"), 0)
    );

    /** Fuente utilizada en los elementos de la interfaz. */
    protected final Font fuente = Font.font("Times New Roman", 25); // (5)

    /** Color del texto en formato RGB. */
    protected final Color colorDeTexto = Color.rgb(92, 26, 98); // (1)

    /** Se usó el formato de CSS para aplicar un estilo predeterminado a los botones. */
    protected final String estiloPorDefecto = "-fx-background-color: rgba(255,215,229,0); " +
            "-fx-background-radius: 30px; " +
            "-fx-border-color: #833a8a; " +
            "-fx-border-width: 1px; " +
            "-fx-border-radius: 40px;";

    /** Es el estilo en formato CSS que se le da al botón cuando el cursor pasa por encima. */
    protected final String estiloSobreCursor = "-fx-background-color: rgba(255,215,229,0); " +
            "-fx-background-radius: 30px; " +
            "-fx-border-color: #5c1a62; " +
            "-fx-border-width: 2px; " +
            "-fx-border-radius: 40px;";

    /**
     * Muestra el menú principal de cuestionarios.
     * @param stage El Stage principal donde se mostrará el contenido de la pantalla.
     */
    public void mostrar(Stage stage) {
        // Se lanza una excepción si no se logra inicializar el cuestionario.
        try {
            GestionCuestionario.inicializarCuestionarios();
        } catch (Exception e) {
            System.err.println("Error al inicializar cuestionarios: " + e.getMessage());
        }

        // Creación de botones principales.
        Button botonCuesPreE = new Button("Cuestionario Periodo Pre-Embrionario"); // (4)
        Button botonCuesEmb = new Button("Cuestionario Periodo Embrionario"); // (4)
        Button botonCuesFetal = new Button("Cuestionario Periodo Fetal"); // (4)
        Button botonRegresar = new Button("Regresar"); // (4)
        Button botonVerCalificaciones = new Button("Ver Mis Calificaciones"); // (4)
        Button botonVerProgreso = new Button("Ver Mi Progreso"); // (4)

        // Se aplican los estilos a los botones.
        aplicarEstiloBoton(botonCuesPreE);
        aplicarEstiloBoton(botonCuesEmb);
        aplicarEstiloBoton(botonCuesFetal);
        aplicarEstiloBoton(botonRegresar);
        aplicarEstiloBoton(botonVerCalificaciones);
        aplicarEstiloBoton(botonVerProgreso);

        // Se establecen las acciones de los botones.
        botonCuesPreE.setOnAction(e -> new CuestionarioUI(stage, 1, PREGUNTAS_PRE_EMBRIONARIO,
                "/Recursos/FondosMenus/FondoCuestionarios.png").mostrar());
        botonCuesEmb.setOnAction(e -> new CuestionarioUI(stage, 2, PREGUNTAS_EMBRIONARIO,
                "/Recursos/FondosMenus/FondoCuestionarios.png").mostrar());
        botonCuesFetal.setOnAction(e -> new CuestionarioUI(stage, 3, PREGUNTAS_FETAL,
                "/Recursos/FondosMenus/FondoCuestionarios.png").mostrar());
        botonRegresar.setOnAction(e -> new MenuPrincipal().mostrar(stage));
        botonVerCalificaciones.setOnAction(e -> mostrarCalificaciones(stage));
        botonVerProgreso.setOnAction(e -> mostrarProgreso(stage));

        /* Se crea una caja para agrupar los botones del centro de manera horizontal;
         * se establece que se alineen al centro, y se establece la caja de manera centrada
         * y dejando un espacio de 30 px entre los botones. Esto tanto para estadísticas
         * como para cuestionarios. */
        HBox botonesEstadisticas = new HBox(30, botonVerCalificaciones, botonVerProgreso); // (9)
        botonesEstadisticas.setAlignment(Pos.CENTER); // (9)

        HBox botonesCuestionarios = new HBox(30, botonCuesPreE, botonCuesEmb, botonCuesFetal); // (9)
        botonesCuestionarios.setAlignment(Pos.CENTER); // (9)

        /* Se crea una caja para guardar los botones de las cajas horizontales en una vertical;
         * se establece que se alineen al centro, y se establece la caja con un
         * margen inferior de 80px. */
        VBox contenidoCompleto = new VBox(80); // (15)
        contenidoCompleto.getChildren().addAll(botonesCuestionarios, botonesEstadisticas); // (15)
        contenidoCompleto.setAlignment(Pos.CENTER); // (15)
        contenidoCompleto.setPadding(new Insets(0,0,80,0)); // (10)

        // Se llama al método para mostrar el menú personalizado.
        mostrarMenuPersonalizado(stage, "Menú Cuestionarios",
                "/Recursos/FondosMenus/FondoMenuCuestionarios.png", contenidoCompleto,
                botonRegresar, () -> new MenuPrincipal().mostrar(stage),
                new Insets(200, 0, 50, 0)
        );
    }

    /** Muestra un menú personalizado con fondo y disposición específica.
     *
     *  @param stage El Stage donde se mostrará el menú.
     *  @param titulo El título de la ventana.
     *  @param rutaFondo Ruta de la imagen de fondo.
     *  @param contenidoCompleto Contenedor con los elementos a mostrar.
     *  @param botonRegresar Botón para regresar al menú anterior.
     *  @param accionRegresar Acción a ejecutar al presionar el botón de regresar.
     *  @param padding Relleno para el contenedor principal.
     */
    public void mostrarMenuPersonalizado(Stage stage, String titulo, String rutaFondo, VBox contenidoCompleto,
                                         Button botonRegresar, Runnable accionRegresar, Insets padding) {
        /* Se crea la variable imagenDeFondo, que es de tipo BackgroundImage; en esta variable se
         * almacena el objeto BackgroundImage; se le pasa el parámetro que contiene la ruta de
         * la imagen que se cargó antes; se indica que la imagen no se repita ni a lo ancho
         * ni a lo alto; se indica que la posición de la imagen sea en el centro; y se configura
         * el tamaño de la imagen, dejando el ancho y alto automáticos, dando como false
         * el uso de porcentajes para el tamaño, y como true el que la imagen se adapte al
         * contenedor. */
        BackgroundImage fondo = new BackgroundImage(
                new Image(Objects.requireNonNull(getClass().getResourceAsStream(rutaFondo))),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
                        false, true, true) // (2) (3)
        );

        /* Se crea una caja para guardar todos los elementos en una misma caja vertical;
         * se establece que se alineen al centro, y se establece la caja con un
         * margen del parámetor. */
        VBox contenedorCentral = new VBox(20); // (15)
        contenedorCentral.setPadding(padding); // (10)
        contenedorCentral.setAlignment(Pos.CENTER); // (15)
        contenedorCentral.getChildren().addAll(contenidoCompleto, botonRegresar); // (15)

        /* Se crea el panel principal que contiene a los botones, con la caja central en el centro
         * la inferior en la parte de abajo, y estableciendo como fondo la imagen antes cargada. */
        BorderPane panelPrincipal = new BorderPane(); // (11)
        panelPrincipal.setBackground(new Background(fondo)); // (10)
        panelPrincipal.setCenter(contenedorCentral); // (11)

        /* Se crea la variable escena de tipo Scene y se le asigna el objeto con el parámetro
         *  del panel principal; al parámetro stage se le asigna la escena, un título de
         *  ventana, el modo de pantalla completa, y se define como vacío el texto que se
         *  muestra en pantalla para salir del modo completo; finalmente se muestra la stage. */
        Scene escena = new Scene(panelPrincipal, 1366, 768); // (12)
        stage.setScene(escena); // (8)
        stage.setTitle(titulo); // (8)
        stage.setFullScreen(true); // (8)
        stage.setFullScreenExitHint(""); // (8)
        stage.show(); // (8)
    }

    /** Método que muestra las calificaciones del usuario actual.
     *  @param stage Esel Stage donde se mostrarán las calificaciones.
     */
    private void mostrarCalificaciones(Stage stage) {
        // Se usa un try-catch por si no se puede obtener la información de SQL.
        try {
            List<String> calificaciones = GestionCuestionario.obtenerCalificacionesUsuario(
                    OperacionesUsuario.getUsuarioActualId()
            );

            // Se muestra lo obtenido en la pantalla.
            PantallaResultados pantalla = new PantallaResultados(stage);
            pantalla.mostrar("Calificaciones", calificaciones);

        } catch (SQLException e) { // (17)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al obtener calificaciones.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();        }
    }

    /** Método que muestra el progreso del usuario actual.
     *  @param stage Es el Stage donde se mostrará el progreso.
     */
    private void mostrarProgreso(Stage stage) {
        // Se usa un try-catch por si no se puede obtener la información de SQL.
        try {
            List<String> progreso = GestionCuestionario.obtenerProgresoUsuario(
                    OperacionesUsuario.getUsuarioActualId()
            );

            // Se muestra lo obtenido en la pantalla.
            PantallaResultados pantalla = new PantallaResultados(stage);
            pantalla.mostrar("Progreso", progreso);

        } catch (SQLException e) { // (17)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al obtener progreso.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();        }
    }

    /* Se les da un estilo a los botones cuando se pasa el cursor por encima y cuando sale,
     * con un color de fondo transparente, un radius de fondo y de borde, y un color y
     * ancho del borde. */
    protected void aplicarEstiloBoton(Button boton) {
        boton.setFont(fuente); // (5) (6)
        boton.setTextFill(colorDeTexto); // (6) (7)
        boton.setStyle(estiloPorDefecto); // (7)

        boton.setOnMouseEntered(e -> boton.setStyle(estiloSobreCursor)); // (7)
        boton.setOnMouseExited(e -> boton.setStyle(estiloPorDefecto)); // (7)
    }
}