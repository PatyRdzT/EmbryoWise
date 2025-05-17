package com.embryowise.Cuestionarios;

import com.embryowise.ManejoUsuario.OperacionesUsuario;
import com.embryowise.MensajeTemporal;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/* -- REFERENCIAS --
 *
 * (1) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
 * (2) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundImage.html
 * (3) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BackgroundSize.html
 * (4) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
 * (5) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/HBox.html
 * (6) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
 * (7) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/text/Font.html
 * (8) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html
 * (9) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/VBox.html
 * (10) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
 * (11) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ToggleGroup.html
 * (12) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/RadioButton.html
 * (13) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollPane.html
 * (14) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ProgressBar.html
 * (15) https://docs.oracle.com/javase/8/javafx/api/javafx/animation/PauseTransition.html
 * (16) https://docs.oracle.com/javase/8/javafx/api/javafx/util/Duration.html
 * (17) https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html
 * (18) https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
 * (19) https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * (20) https://docs.oracle.com/javase/8/docs/api/java/sql/SQLException.html
 * (*) Referencias internas de la aplicación
 */

/** Clase que maneja la interfaz gráfica para los cuestionarios. */
public class CuestionarioUI {
    private final Stage stage; // (17)
    private final int cuestionarioId;
    private final List<Pregunta> preguntas;
    private final String rutaFondo;
    private int preguntaActual = 0;
    private int respuestasCorrectas = 0;

    /** Constructor.
     *  @param stage Ventana principal de la aplicación // (17)
     *  @param cuestionarioId Identificador del cuestionario
     *  @param preguntas Lista de preguntas del cuestionario // (19)
     *  @param rutaFondo Ruta de la imagen de fondo // (1)
     */
    public CuestionarioUI(Stage stage, int cuestionarioId, List<Pregunta> preguntas, String rutaFondo) {
        this.stage = stage; // (17)
        this.cuestionarioId = cuestionarioId;
        this.preguntas = preguntas; // (19)
        this.rutaFondo = rutaFondo;

        try {
            this.preguntaActual = GestionCuestionario.obtenerProgreso(
                    OperacionesUsuario.getUsuarioActualId(), cuestionarioId) - 1;
        } catch (SQLException e) { // (20)
            System.err.println("Error al cargar progreso: " + e.getMessage());
            this.preguntaActual = 0;
        }
    }

    /** Muestra la interfaz completa del cuestionario.
     *  Configura el diseño, controles y manejo de eventos.
     */
    public void mostrar() {
        /* Se crea la variable fondo, que es de tipo Image; en esta variable se
         * almacena el objeto Image; en la carpeta de resources se busca la ruta que se pasa
         * como parámetro; y se convierte a URL para usarla después. */
        Image imagenFondo = new Image(Objects.requireNonNull(getClass().getResourceAsStream(rutaFondo))); // (1)

        /* Se crea la variable imagenDeFondo, que es de tipo BackgroundImage; en esta variable se
         * almacena el objeto BackgroundImage; se le pasa el parámetro que contiene la ruta de
         * la imagen que se cargó antes; se indica que la imagen no se repita ni a lo ancho
         * ni a lo alto; se indica que la posición de la imagen sea en el centro; y se configura
         * el tamaño de la imagen, dejando el ancho y alto automáticos, dando como false
         * el uso de porcentajes para el tamaño, y como true el que la imagen se adapte al
         * contenedor. */
        BackgroundImage fondoImagen = new BackgroundImage(imagenFondo,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO, false, false, true, true) // (2) (3)
        );

        Background fondo = new Background(fondoImagen); // (2)

        stage.setTitle("Cuestionario de Embriología"); // (17)

        BorderPane panelPrincipal = new BorderPane(); // (4)
        panelPrincipal.setBackground(fondo); // (2)

        HBox cajaBoton = new HBox(50); // (5)
        cajaBoton.setAlignment(Pos.CENTER); // (5)
        cajaBoton.setPadding(new Insets(0, 0, 30, 0)); // (5)

        Button submitButton = crearBotonEstilizado("Responder"); // (6)
        submitButton.setDisable(true); // (6)

        Button exitButton = crearBotonEstilizado("Salir"); // (6)
        exitButton.setOnAction(e -> { // (6)
            guardarProgreso();
            volverAlMenu();
        });

        cajaBoton.getChildren().addAll(submitButton, exitButton); // (5)
        panelPrincipal.setBottom(cajaBoton); // (4)

        VBox cajaVerticalContenido = new VBox(); // (9)
        cajaVerticalContenido.setAlignment(Pos.TOP_CENTER); // (9)
        cajaVerticalContenido.setPadding(new Insets(250, 0, 150, 0)); // (9)

        ProgressBar barraProgreso = new ProgressBar(); // (14)
        barraProgreso.setStyle("-fx-accent: #5c1a62;"); // (14)
        barraProgreso.setPrefWidth(300); // (14)
        Label barraLabel = new Label(); // (10)
        barraLabel.setFont(Font.font("Arial", 16)); // (7) (10)
        barraLabel.setTextFill(Color.rgb(92, 26, 98)); // (8) (10)
        actualizarBarraProgreso(barraProgreso, barraLabel);

        HBox cajaProgresoHorizontal = new HBox(15, barraLabel, barraProgreso); // (5)
        cajaProgresoHorizontal.setAlignment(Pos.CENTER); // (5)
        cajaVerticalContenido.getChildren().add(cajaProgresoHorizontal); // (9)

        Label textoPregunta = new Label(); // (10)
        textoPregunta.setFont(Font.font("Times New Roman", 24)); // (7) (10)
        textoPregunta.setWrapText(true); // (10)
        textoPregunta.setTextFill(Color.rgb(92, 26, 98)); // (8) (10)
        textoPregunta.setStyle("-fx-font-weight: bold; -fx-effect: dropshadow(gaussian, rgba(255,255,255,0.8), 3, 0, 0, 1);"); // (10)
        textoPregunta.setMaxWidth(800); // (10)
        textoPregunta.setPadding(new Insets(30, 50, 30, 50)); // (10)

        ToggleGroup opcionesGrupo = new ToggleGroup(); // (11)
        VBox cajaOpciones = new VBox(15); // (9)
        cajaOpciones.setAlignment(Pos.CENTER_LEFT); // (9)
        cajaOpciones.setMaxWidth(700); // (9)

        mostrarPregunta(textoPregunta, opcionesGrupo, cajaOpciones);

        submitButton.setOnAction(e -> { // (6)
            RadioButton selected = (RadioButton) opcionesGrupo.getSelectedToggle(); // (12)
            if (selected != null) {
                int selectedIndex = cajaOpciones.getChildren().indexOf(selected); // (9)
                boolean correcta = (selectedIndex == preguntas.get(preguntaActual).getRespuestaCorrecta()); // (19)

                if (correcta) respuestasCorrectas++;

                mostrarFeedbackTemporal(correcta, cajaVerticalContenido);
                siguientePregunta(textoPregunta, opcionesGrupo, cajaOpciones, barraProgreso, barraLabel);
            }
        });

        opcionesGrupo.selectedToggleProperty().addListener((obs, oldVal, newVal) -> { // (11)
            submitButton.setDisable(newVal == null); // (6)
        });

        VBox cajaPregunta = new VBox(30, textoPregunta, cajaOpciones); // (9)
        cajaPregunta.setAlignment(Pos.CENTER); // (9)
        cajaVerticalContenido.getChildren().add(cajaPregunta); // (9)

        ScrollPane scrollPane = new ScrollPane(cajaVerticalContenido); // (13)
        scrollPane.setFitToWidth(true); // (13)
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // (13)
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // (13)
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); // (13)

        panelPrincipal.setCenter(scrollPane); // (4)

        Scene scene = new Scene(panelPrincipal); // (18)
        scene.setFill(Color.TRANSPARENT); // (18)
        stage.setScene(scene); // (17)
        stage.setFullScreen(true); // (17)
        stage.setFullScreenExitHint(""); // (17)
        stage.show(); // (17)
    }

    /** Crea un botón con el estilo visual estándar de la aplicación.
     *  @param texto Texto que mostrará el botón
     *  @return Botón configurado con el estilo // (6)
     */
    private Button crearBotonEstilizado(String texto) {
        Button boton = new Button(texto); // (6)
        boton.setFont(Font.font("Times New Roman", 20)); // (7) (6)
        boton.setTextFill(Color.rgb(92, 26, 98)); // (8) (6)

        String base = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius:30px;"
                + " -fx-border-color:#833a8a; -fx-border-width:1px; -fx-border-radius:40px;";
        String encima = "-fx-background-color: rgba(255,215,229,0); -fx-background-radius:30px;"
                + " -fx-border-color:#5c1a62; -fx-border-width:2px; -fx-border-radius:40px;";

        boton.setStyle(base); // (6)
        boton.setOnMouseEntered(e -> boton.setStyle(encima)); // (6)
        boton.setOnMouseExited(e -> boton.setStyle(base)); // (6)
        boton.setPadding(new Insets(5, 15, 5, 15)); // (6)

        return boton; // (6)
    }

    /** Muestra la pregunta actual en la interfaz.
     *  @param textoPregunta Label donde se muestra el texto de la pregunta // (10)
     *  @param grupoOpciones Grupo de opciones de respuesta // (11)
     *  @param cajaOpciones Contenedor de las opciones de respuesta // (9)
     */
    private void mostrarPregunta(Label textoPregunta, ToggleGroup grupoOpciones, VBox cajaOpciones) {
        Pregunta pregunta = preguntas.get(preguntaActual); // (19)
        textoPregunta.setText((preguntaActual + 1) + ". " + pregunta.getPreguntaCadena()); // (10)

        grupoOpciones.getToggles().clear(); // (11)
        cajaOpciones.getChildren().clear(); // (9)

        for (int i = 0; i < pregunta.getOpciones().size(); i++) {
            RadioButton radioBoton = new RadioButton(pregunta.getOpciones().get(i)); // (12)
            radioBoton.setToggleGroup(grupoOpciones); // (12) (11)
            radioBoton.setFont(Font.font("Times New Roman", 20)); // (7) (12)
            radioBoton.setWrapText(true); // (12)
            radioBoton.setTextFill(Color.rgb(92, 26, 98)); // (8) (12)
            radioBoton.setStyle("-fx-effect: dropshadow(gaussian, rgba(255,255,255,0.8), 2, 0, 0, 1);"); // (12)
            cajaOpciones.getChildren().add(radioBoton); // (9)
        }
    }

    /** Muestra un mensaje temporal de feedback sobre la respuesta.
     *  @param correcta Indica si la respuesta fue correcta
     *  @param cajaVertical Contenedor donde se mostrará el mensaje // (9)
     */
    private void mostrarFeedbackTemporal(boolean correcta, VBox cajaVertical) {
        MensajeTemporal mensaje = new MensajeTemporal();
        mensaje.setTextFill(correcta ? Color.GREEN : Color.RED); // (8)
        mensaje.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
        mensaje.mostrarMensaje(correcta ? "¡Correcto!" : "Incorrecto", 2);

        if (cajaVertical.getChildren().size() > 2) { // (9)
            cajaVertical.getChildren().add(2, mensaje); // (9)
        } else {
            cajaVertical.getChildren().add(mensaje); // (9)
        }
    }

    /** Avanza a la siguiente pregunta o finaliza el cuestionario.
     *  @param textoPregunta Label de la pregunta // (10)
     *  @param grupoPregunta Grupo de opciones // (11)
     *  @param cajaOpciones Contenedor de opciones // (9)
     *  @param barraProgreso Barra de progreso // (14)
     *  @param labelProgreso Etiqueta de progreso // (10)
     */
    private void siguientePregunta(Label textoPregunta, ToggleGroup grupoPregunta,
                                   VBox cajaOpciones, ProgressBar barraProgreso, Label labelProgreso) {
        preguntaActual++;

        if (preguntaActual < preguntas.size()) { // (19)
            mostrarPregunta(textoPregunta, grupoPregunta, cajaOpciones);
            actualizarBarraProgreso(barraProgreso, labelProgreso);
        } else {
            cuestionarioCompletado();
        }
    }

    /** Actualiza la barra de progreso del cuestionario.
     *  @param barraProgreso Barra de progreso // (14)
     *  @param labelProgreso Etiqueta de progreso // (10)
     */
    private void actualizarBarraProgreso(ProgressBar barraProgreso, Label labelProgreso) {
        double progreso = (double)(preguntaActual + 1) / preguntas.size(); // (19)
        barraProgreso.setProgress(progreso); // (14)
        labelProgreso.setText(String.format("Pregunta %d de %d", // (10)
                preguntaActual + 1, preguntas.size())); // (19)
    }

    /** Guarda el progreso actual del usuario en la base de datos. */
    private void guardarProgreso() {
        try {
            if (preguntas != null && !preguntas.isEmpty()) { // (19)
                GestionCuestionario.guardarProgreso(
                        OperacionesUsuario.getUsuarioActualId(),
                        cuestionarioId,
                        Math.min(preguntaActual + 1, preguntas.size()) // (19)
                );
            }
        } catch (SQLException e) { // (20)
            System.err.println("Error al guardar progreso: " + e.getMessage());
            mostrarErrorBD();
        }
    }

    /** Muestra un mensaje de error de base de datos. */
    private void mostrarErrorBD() {
        MensajeTemporal mensajeError = new MensajeTemporal();
        mensajeError.setTextFill(Color.RED); // (8)
        mensajeError.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
        mensajeError.mostrarMensaje("Error al guardar en la base de datos", 3);
    }

    /** Maneja la finalización exitosa del cuestionario. */
    private void cuestionarioCompletado() {
        try {
            guardarProgreso();
            GestionCuestionario.registrarIntento(
                    OperacionesUsuario.getUsuarioActualId(),
                    cuestionarioId,
                    respuestasCorrectas
            );

            mostrarMensajeFinal();
        } catch (SQLException e) { // (20)
            System.err.println("Error al registrar intento: " + e.getMessage());
            mostrarFeedbackTemporal(false, (VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()); // (4) (9)
        }
    }

    /** Vuelve al menú principal de cuestionarios. */
    private void volverAlMenu() {
        stage.setFullScreen(false); // (17)
        new MenuCuestionarios().mostrar(stage);
    }

    /** Muestra el mensaje final con los resultados del cuestionario. */
    private void mostrarMensajeFinal() {
        MensajeTemporal mensajeFinal = new MensajeTemporal();
        mensajeFinal.setTextFill(Color.GREEN); // (8)
        mensajeFinal.setStyle("-fx-font-size: 18px; -fx-padding: 15px;");
        mensajeFinal.mostrarMensaje(
                String.format("¡Completado! %d/%d correctas (%.0f%%)",
                        respuestasCorrectas, preguntas.size(), // (19)
                        (respuestasCorrectas * 100.0 / preguntas.size())), // (19)
                3
        );

        PauseTransition pausa = new PauseTransition(Duration.seconds(3)); // (15) (16)
        pausa.setOnFinished(event -> volverAlMenu()); // (15)
        pausa.play(); // (15)
    }
}