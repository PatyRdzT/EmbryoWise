package com.embryowise;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

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
 * (20) https://docs.oracle.com/javase/8/javafx/api/javafx/animation/package-frame.html
 */

/** Esta clase tiene como intención mostrar mensajes de error o de aviso para inicio de sesión
 *  y registro, esto usando un label y una animación para que el texto desaparezca.
 * */
public class MensajeTemporal extends Label {
    /** Este es el constructor del mensaje, estableciendo que por default no sea visible
     *  y que su color sea rojo, además del estilo dado.
     * */
    public MensajeTemporal() {
        this.setVisible(false); // (7)
        this.setTextFill(Color.RED); // (6)
        this.setStyle("-fx-font-size: 14px; -fx-padding: 5px;"); // (7)
    }

    /** Este método muestra el mensaje por cierta cantidad de segundos, con su texto y
     *  estableciéndolo como visible.
     *
     * @param mensaje Es el mensaje que se mostrará.
     * @param segundos Es la cantidad de segundos que se mostrará el mensaje.
     * */
    public void mostrarMensaje(String mensaje, int segundos) {
        this.setText(mensaje); // (6)
        this.setVisible(true); // (7)

        PauseTransition delay = new PauseTransition(Duration.seconds(segundos)); // (20)
        delay.setOnFinished(event -> this.setVisible(false)); // (20)
        delay.play(); // (20)
    }
}