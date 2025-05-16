package com.embryowise.EtapasDeDesarrollo.PeriodoEmbrionario;

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

/** La clase explica todo lo relacionado a la semana 3 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana3 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 3";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana3.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Todo comienza con la aparición de la línea primitiva, un " +
                        "engrosamiento en el epiblasto en el extremo caudal del disco. Las células del " +
                        "epiblasto migran hacia esta línea, se invaginan y dan lugar a tres capas " +
                        "germinales:\n\n  * Ectodermo (nueva denominación del epiblasto): Formará la " +
                        "piel y el sistema nervioso.\n\n  * Endodermo: Surge cuando células epiblásticas " +
                        "desplazan al hipoblasto, originando el revestimiento del tubo digestivo y " +
                        "órganos asociados.\n\n  * Mesodermo intraembrionario: Células migratorias que " +
                        "se ubican entre ectodermo y endodermo, dando lugar a músculos, huesos y sistema" +
                        " circulatorio.\n\n",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana3Pantalla1.png"),

                new ContenidoSemana("Bajo la influencia de la notocorda, el ectodermo se engrosa " +
                        "para formar la placa neural, que posteriormente se pliega para crear el tubo " +
                        "neural (origen del sistema nervioso central) y las crestas neurales. " +
                        "Paralelamente, el mesodermo se organiza en somitas (precursores de vértebras " +
                        "y músculos) y comienza a formarse el celoma intraembrionario (futuras cavidades" +
                        " corporales). El sistema cardiovascular inicia su desarrollo con la aparición " +
                        "de vasos sanguíneos en el saco vitelino y corion, mientras dos tubos cardíacos " +
                        "se fusionan para formar un corazón tubular primitivo que comienza a latir al " +
                        "final de esta semana, estableciendo las bases del sistema circulatorio embrionario.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana3Pantalla2.png"),

                new ContenidoSemana("La tercera semana culmina con la formación de estructuras " +
                        "esenciales para el desarrollo posterior. El mesodermo se organiza en tres " +
                        "componentes principales: el paraxial (formador de somitas), el intermedio " +
                        "(precursor del sistema urogenital) y el lateral (origen de las membranas " +
                        "serosas). Simultáneamente, las vellosidades coriónicas alcanzan su etapa " +
                        "terciaria, desarrollando capilares funcionales que mejoran el intercambio " +
                        "materno-embrionario.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana3Pantalla3.png")
        );
    }

    // Se regresa al menú del periodo embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoEmbrionario().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 4 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana4 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 4";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana4.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante la cuarta semana, el embrión experimenta cambios " +
                        "drásticos en su forma, pasando de una estructura casi recta a adoptar una " +
                        "curvatura en \"C\" característica. Los somitas (entre 4 y 12 pares) forman " +
                        "elevaciones visibles en la superficie, mientras el tubo neural se cierra " +
                        "progresivamente, dejando solo aberturas temporales en los neuroporos rostral " +
                        "y caudal. El corazón, ahora prominente y funcional, bombea sangre a través de " +
                        "un sistema vascular primitivo. Los primeros arcos faríngeos aparecen, destacando " +
                        "el arco mandibular, que dará origen a la mandíbula y al maxilar. Estos cambios " +
                        "reflejan el inicio de la organización craneocaudal y la especialización de " +
                        "regiones corporales.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana4Pantalla1.png"),

                new ContenidoSemana("Hacia el día 26, el embrión muestra tres pares de arcos " +
                        "faríngeos y el neuroporo rostral se cierra completamente. El prosencéfalo forma " +
                        "una protuberancia notable en la cabeza, y se observan los primeros esbozos de los " +
                        "miembros superiores como pequeñas protrusiones ventrolaterales. Las placodas óticas " +
                        "(futuros oídos internos) y cristalinianas (precursoras de los cristalinos oculares) " +
                        "se hacen visibles, marcando el inicio del desarrollo sensorial. Al final de la semana," +
                        " aparecen el cuarto arco faríngeo y los esbozos de los miembros inferiores, mientras " +
                        "una eminencia caudal similar a una cola destaca en la región posterior.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana4Pantalla2.png"),

                new ContenidoSemana("En esta fase, se consolidan los rudimentos de múltiples sistemas, " +
                        "especialmente el cardiovascular, que ya presenta un patrón de circulación primitiva." +
                        " El tubo neural completa su cierre con el sellado del neuroporo caudal, un hito " +
                        "crítico para el desarrollo del sistema nervioso central. Los pliegues cefálico y " +
                        "caudal acentúan la curvatura embrionaria, y los arcos faríngeos continúan su " +
                        "diferenciación para formar estructuras craneofaciales. Al final de la cuarta semana," +
                        " el embrión, aunque diminuto (aproximadamente 4-5 mm), ha establecido las bases " +
                        "anatómicas para todos los órganos principales, preparando el escenario para la " +
                        "organogénesis en las semanas siguientes.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana4Pantalla3.png")
        );
    }

    // Se regresa al menú del periodo embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoEmbrionario().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 5 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana5 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 5";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana5.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante la quinta semana, el crecimiento embrionario" +
                        " se concentra principalmente en la región cefálica, donde el rápido " +
                        "desarrollo del encéfalo y las prominencias faciales provoca un aumento" +
                        " desproporcionado del tamaño de la cabeza. El segundo arco faríngeo " +
                        "experimenta un crecimiento acelerado, sobrepasando a los arcos tercero" +
                        " y cuarto y formando los senos cervicales, mientras las prominencias " +
                        "faciales establecen contacto con la protuberancia cardiaca. " +
                        "Paralelamente, las crestas mesonéfricas marcan la posición de los " +
                        "riñones mesonéfricos, que cumplirán una función excretora transitoria " +
                        "durante esta etapa del desarrollo.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana5Pantalla1.png"),

                new ContenidoSemana("Aunque los cambios externos son menos evidentes que " +
                        "en la semana anterior, internamente se consolida la base estructural " +
                        "de múltiples sistemas. El sistema nervioso central continúa su expansión," +
                        " particularmente en las regiones encefálicas, mientras los arcos faríngeos " +
                        "avanzan en su diferenciación para formar estructuras craneofaciales y " +
                        "cervicales. Esta semana representa un puente crítico entre la morfogénesis " +
                        "temprana y la posterior especialización orgánica, estableciendo las " +
                        "condiciones para el desarrollo más refinado de órganos y sistemas en las " +
                        "semanas siguientes.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana5Pantalla2.png")
        );
    }

    // Se regresa al menú del periodo embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoEmbrionario().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 6 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana6 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 6";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana6.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante la sexta semana, el embrión alcanza hitos " +
                        "significativos en su desarrollo: los miembros superiores muestran una " +
                        "clara diferenciación regional con la formación de codos y manos, donde " +
                        "comienzan a esbozarse los rayos digitales (precursores de los dedos), " +
                        "mientras los inferiores presentan un desarrollo 4-5 días más tardío. El " +
                        "sistema nervioso evidencia su progreso con movimientos espontáneos de tronco " +
                        "y extremidades, e incluso respuestas reflejas al tacto. La cabeza, aún " +
                        "desproporcionadamente grande y flexionada sobre la prominencia cardíaca," +
                        " revela estructuras sensoriales clave: los montículos auriculares (futuras" +
                        " orejas) se forman alrededor del primer surco faríngeo, y los ojos se " +
                        "hacen evidentes por el pigmento retiniano. Simultáneamente, el tronco " +
                        "comienza a enderezarse, y los intestinos experimentan una herniación " +
                        "umbilical fisiológica hacia el cordón umbilical, debido al rápido " +
                        "crecimiento intestinal y al espacio limitado en la cavidad abdominal, " +
                        "un proceso normal que se resolverá más adelante en el desarrollo.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana6Pantalla1.png")
        );
    }

    // Se regresa al menú del periodo embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoEmbrionario().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 7 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana7 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 7";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana7.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("En esta semana crucial, las extremidades alcanzan un " +
                        "notable grado de especialización: las muescas entre los rayos digitales " +
                        "se profundizan en las manos, definiendo claramente los dedos, mientras un " +
                        "proceso similar comienza en los pies, aunque con cierto retraso. El sistema " +
                        "digestivo muestra cambios significativos, reduciéndose la conexión entre el" +
                        " intestino primitivo y la vesícula umbilical a un delgado conducto" +
                        " onfaloentérico. Simultáneamente, ocurre un hito fundamental en el desarrollo" +
                        " óseo: se inicia la osificación en los huesos de los miembros superiores, " +
                        "marcando el comienzo de la formación del esqueleto apendicular. Estos avances " +
                        "coinciden con la progresiva reducción de la hernia umbilical fisiológica y" +
                        " el continuo refinamiento de las estructuras faciales y corporales, preparando " +
                        "al embrión para los rápidos cambios morfológicos de las próximas semanas.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana7Pantalla1.png")
        );
    }

    // Se regresa al menú del periodo embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoEmbrionario().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 8 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana8 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 8";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana8.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante la octava semana culmina el período embrionario" +
                        " con la diferenciación completa de los principales sistemas orgánicos. " +
                        "Los dedos de manos y pies están ahora completamente separados, aunque " +
                        "aún unidos por membranas interdigitales delgadas. La cara adquiere rasgos" +
                        " humanos reconocibles, con párpados en desarrollo, orejas externas bien " +
                        "formadas y la punta de la nariz visible. Internamente, todos los órganos" +
                        " internos han alcanzado su posición y forma básica, aunque muchos " +
                        "requerirán maduración adicional durante el período fetal.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana8Pantalla1.png"),

                new ContenidoSemana("El proceso de osificación se intensifica, extendiéndose " +
                        "ahora a los huesos de los miembros inferiores y al esqueleto axial. Los " +
                        "músculos comienzan a adquirir su organización definitiva, permitiendo " +
                        "movimientos más coordinados aunque aún involuntarios. El sistema nervioso " +
                        "central muestra una complejidad creciente, con el cerebro dividido en sus " +
                        "principales regiones: prosencéfalo, mesencéfalo y rombencéfalo. Los ojos, " +
                        "aunque aún cubiertos por párpados fusionados, presentan todas sus estructuras" +
                        " básicas.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana8Pantalla2.png"),

                new ContenidoSemana("Al final de esta semana, el embrión -que ahora mide " +
                        "aproximadamente 3 cm- completa su transformación más radical y se prepara " +
                        "para la fase fetal. La hernia umbilical fisiológica comienza su reducción " +
                        "definitiva, retrayendo los intestinos hacia la cavidad abdominal que ha " +
                        "alcanzado el tamaño suficiente. Este momento marca el fin del período " +
                        "embrionario y el inicio del fetal, donde el enfoque cambiará del desarrollo" +
                        " estructural al crecimiento y refinamiento funcional de los órganos ya formados.",
                        "/Recursos/ImagenesPeriodoEmbrionario/Semana8Pantalla3.png")
        );
    }

    // Se regresa al menú del periodo embrionario.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoEmbrionario().mostrar(stage);
    }
}