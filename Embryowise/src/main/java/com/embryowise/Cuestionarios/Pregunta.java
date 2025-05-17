package com.embryowise.Cuestionarios;

import java.util.List;

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

/** Clase que define el formato de las preguntas creadas para cada cuestionario. */
public class Pregunta {
    // Se crea el string para la pregunta, las opciones y se indica el índice de la respuesta
    // correcta.
    private final String preguntaCadena;
    private final List<String> opciones;
    private final int respuestaCorrecta;

    /** Constructor de la clase Pregunta. */
    public Pregunta(String texto, List<String> opciones, int respuestaCorrecta) {
        this.preguntaCadena = texto;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /** Método para obtener la pregunta. */
    public String getPreguntaCadena() {
        return preguntaCadena;
    }

    /** Método para obtener la lista de opciones. */
    public List<String> getOpciones() {
        return opciones;
    }

    /** Método para obtener el índice de la respuesta correcta. */
    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}