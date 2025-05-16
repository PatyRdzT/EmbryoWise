package com.embryowise.EtapasDeDesarrollo.PeriodoPreEmbrionario;

import com.embryowise.EtapasDeDesarrollo.BaseSemanas;
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

/** La clase explica todo lo relacionado a la semana 1 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
*/
class Semana1 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 1";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana1.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante la primera semana, el ovocito es producido " +
                        "en el ovario mediante ovogénesis y liberado en la ovulación. Las " +
                        "fimbrias de las trompas uterinas lo captan y lo desplazan hacia la " +
                        "ampolla, donde puede ser fecundado. Mientras tanto, los " +
                        "espermatozoides, producidos en los testículos (espermatogénesis) y " +
                        "almacenados en epidídimo, son eyaculados en la vagina. Solo unos " +
                        "cientos logran atravesar el útero y llegar a las trompas, donde uno " +
                        "de ellos puede penetrar el ovocito.",
                        "/Recursos/ImagenesPeriodoPreEmbrionario/Semana1Pantalla1.png"),

                new ContenidoSemana("Al ser fecundado, el ovocito completa su segunda " +
                        "división meiótica, formando un ovocito maduro y un segundo corpúsculo " +
                        "polar. La cabeza del espermatozoide se transforma en el pronúcleo " +
                        "masculino, mientras que el núcleo del ovocito se convierte en el " +
                        "pronúcleo femenino. La fusión de ambos pronúcleos marca el inicio del " +
                        "cigoto, que inicia su segmentación mientras avanza por la trompa " +
                        "uterina. En tres días, se forma una mórula de 12 o más células " +
                        "(blastómeros), que luego desarrolla una cavidad interna y se convierte" +
                        " en un blastocisto.",
                        "/Recursos/ImagenesPeriodoPreEmbrionario/Semana1Pantalla2.png"),

                new ContenidoSemana("El blastocisto está compuesto por el embrioblasto " +
                        "(futuro embrión), el blastocele (cavidad llena de líquido) y el trofoblasto " +
                        "(capa externa que dará lugar a la placenta). Entre los días 4 y 5, el " +
                        "blastocisto se libera de la zona pelúcida y el trofoblasto se adhiere al " +
                        "endometrio. El sincitiotrofoblasto (capa externa del trofoblasto) invade el " +
                        "endometrio, mientras el citotrofoblasto (capa interna) lo sostiene. Hacia el " +
                        "final de la primera semana, el blastocisto se implanta superficialmente en el " +
                        "útero, marcando el inicio de la gestación.",
                        "/Recursos/ImagenesPeriodoPreEmbrionario/Semana1Pantalla3.png")
        );
    }

    // Se regresa al menú del periodo pre-embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoPreEmbrionario().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 2 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana2 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 2";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana2.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante la segunda semana, el blastocisto completa su" +
                        " implantación en el endometrio uterino, un proceso clave para el " +
                        "desarrollo embrionario. El trofoblasto sufre una rápida proliferación " +
                        "y diferenciación, formando dos capas: el sincitiotrofoblasto externo, " +
                        "que invade el endometrio y establece conexiones con los vasos " +
                        "sanguíneos maternos, y el citotrofoblasto interno, que mantiene una " +
                        "estructura celular definida. Simultáneamente, el endometrio experimenta" +
                        " la reacción decidual, un conjunto de cambios que preparan el tejido " +
                        "uterino para albergar y nutrir al embrión en desarrollo.",
                        "/Recursos/ImagenesPeriodoPreEmbrionario/Semana2Pantalla1.png"),

                new ContenidoSemana("En esta etapa, se forman estructuras extraembrionarias" +
                        " esenciales. La vesícula umbilical primaria (saco vitelino) surge del" +
                        " hipoblasto, pero pronto es reemplazada por la vesícula umbilical " +
                        "secundaria, más funcional. Al mismo tiempo, el mesodermo extraembrionario" +
                        " se desarrolla y origina espacios que se fusionan para formar el celoma" +
                        " extraembrionario, futuro precursor de la cavidad coriónica. Además, " +
                        "aparece la cavidad amniótica, un espacio lleno de líquido que rodea al " +
                        "embrión y lo protege durante su desarrollo.",
                        "/Recursos/ImagenesPeriodoPreEmbrionario/Semana2Pantalla2.png"),

                new ContenidoSemana("El embrioblasto se organiza en un disco embrionario " +
                        "bilaminar, compuesto por el epiblasto (superior) y el hipoblasto " +
                        "(inferior). El epiblasto, asociado a la cavidad amniótica, será la " +
                        "fuente de todas las células del embrión, mientras que el hipoblasto " +
                        "contribuye al saco vitelino. En esta fase, un engrosamiento llamado " +
                        "placa precordal se forma en el hipoblasto, marcando la futura región " +
                        "craneal y la ubicación de la boca. Al final de la segunda semana, el " +
                        "embrión ya está implantado y comienza a definir su estructura básica, " +
                        "sentando las bases para la gastrulación en la tercera semana.",
                        "/Recursos/ImagenesPeriodoPreEmbrionario/Semana2Pantalla3.png")
        );
    }

    // Se regresa al menú del periodo pre-embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoPreEmbrionario().mostrar(stage);
    }
}