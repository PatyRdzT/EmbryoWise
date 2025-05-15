package com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoFetal;

import com.embryowise.Pantalla.EtapasDeDesarrollo.BaseSemanas;
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

/** La clase explica todo lo relacionado a la semana 9 a la 12 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana9a12 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 9 a 12";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana9a12.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante estas semanas clave, el feto experimenta un " +
                        "cambio notable en sus proporciones: aunque la cabeza sigue siendo " +
                        "grande (al inicio representa la mitad de su longitud), el cuerpo " +
                        "comienza a crecer aceleradamente, duplicando su tamaño hacia la semana " +
                        "12. Los rasgos faciales se humanizan progresivamente, con ojos aún " +
                        "separados pero más definidos, orejas que ascienden desde su posición " +
                        "inicial baja y párpados que permanecen fusionados. Las extremidades " +
                        "alcanzan hitos importantes: los brazos logran casi su longitud definitiva, " +
                        "mientras las piernas, aunque más cortas, muestran un desarrollo constante. " +
                        "Un avance crucial es la retracción completa de las asas intestinales al " +
                        "abdomen hacia la semana 10, resolviendo la hernia umbilical fisiológica " +
                        "característica de etapas anteriores.",
                        "/Recursos/ImagenesPeriodoFetal/Semana9a12Pantalla1.png"),

                new ContenidoSemana("El esqueleto fetal inicia su osificación activa, " +
                        "especialmente en cráneo y huesos largos, sentando las bases para su " +
                        "futura fortaleza. Entre las semanas 11 y 12 ocurre un hito trascendental: " +
                        "los genitales externos adquieren características sexuales diferenciadas, " +
                        "permitiendo la identificación del sexo mediante ecografía. Simultáneamente, " +
                        "los sistemas orgánicos muestran una maduración funcional: el hígado (principal " +
                        "productor de glóbulos rojos) comienza a compartir esta función con el bazo, " +
                        "el sistema urinario produce y excreta orina al líquido amniótico, y el sistema" +
                        " nervioso coordina movimientos espontáneos cada vez más complejos, aunque " +
                        "aún imperceptibles para la madre.",
                        "/Recursos/ImagenesPeriodoFetal/Semana9a12Pantalla2.png"),

                new ContenidoSemana("Al culminar la semana 12, el feto ha completado su " +
                        "transformación más crítica: todos los órganos están formados y en su posición" +
                        " definitiva, marcando el fin del período de mayor vulnerabilidad. La cara" +
                        " muestra rasgos humanos reconocibles, las extremidades tienen proporciones más" +
                        " equilibradas y los sistemas corporales funcionan de manera coordinada. Con un" +
                        " tamaño aproximado de 8-9 cm, el feto inicia la fase de crecimiento y" +
                        " refinamiento funcional que caracterizará el segundo trimestre. Este período " +
                        "también establece los circuitos metabólicos básicos, como la deglución de líquido " +
                        "amniótico y el intercambio placentario de nutrientes y desechos, fundamentales " +
                        "para su desarrollo continuo.",
                        "/Recursos/ImagenesPeriodoFetal/Semana9a12Pantalla3.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 13 a la 16 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana13a16 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 13 a 16";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana13a16.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante este período, el feto experimenta un crecimiento rápido" +
                        " y significativo, con cambios notables en sus proporciones corporales. La cabeza," +
                        " que al inicio del período aún era prominente, se vuelve relativamente más " +
                        "pequeña en comparación con el resto del cuerpo, mientras que los miembros " +
                        "inferiores se alargan considerablemente. Los movimientos fetales, que comenzaron" +
                        " a finales del período embrionario, ganan coordinación hacia la semana 14, " +
                        "aunque aún son demasiado sutiles para ser percibidos por la madre, pero ya son" +
                        " visibles mediante ecografía. La osificación del esqueleto continúa activamente," +
                        " haciendo que los huesos sean claramente distinguibles en las imágenes ecográficas" +
                        " a partir de la semana 16. Además, se observan movimientos oculares lentos desde " +
                        "la semana 14, y el patrón del cabello en el cuero cabelludo comienza a definirse.",
                        "/Recursos/ImagenesPeriodoFetal/Semana13a16Pantalla1.png"),

                new ContenidoSemana("En estas semanas, los rasgos faciales del feto se afinan: los " +
                        "ojos, que inicialmente miraban hacia los lados, se orientan hacia adelante, y las" +
                        " orejas alcanzan su posición definitiva a los lados de la cabeza. Los genitales," +
                        " ya diferenciados desde las semanas 12-14, son claramente reconocibles. En el " +
                        "caso de las fetos femeninos, los ovarios se diferencian y contienen folículos " +
                        "primordiales con ovogonias, marcando el inicio del desarrollo del sistema " +
                        "reproductivo. Estos avances, junto con la creciente complejidad de los movimientos" +
                        " y la osificación esquelética, reflejan la transición del feto hacia una fase de " +
                        "mayor madurez y preparación para el siguiente trimestre.",
                        "/Recursos/ImagenesPeriodoFetal/Semana13a16Pantalla2.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 17 a la 20 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana17a20 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 17 a 20";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana17a20.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante este período, aunque el ritmo de crecimiento " +
                        "se ralentiza, el feto aún aumenta considerablemente su longitud. La " +
                        "madre suele percibir por primera vez los movimientos fetales, un hito " +
                        "emocionante del embarazo. La piel del feto se cubre con el vérnix caseoso, " +
                        "una sustancia grasosa compuesta por células epidérmicas y secreciones " +
                        "sebáceas que protege su delicada piel de la exposición prolongada al líquido " +
                        "amniótico, evitando irritaciones y deshidratación. Además, aparece el lanugo," +
                        " un vello fino y suave que ayuda a fijar el vérnix sobre la piel. Hacia la " +
                        "semana 20, ya son visibles las cejas y el cabello, mientras que la grasa parda" +
                        " -un tejido especializado en la generación de calor- comienza a formarse en " +
                        "zonas como el cuello, el esternón y alrededor de los riñones, preparando al " +
                        "feto para la termorregulación tras el nacimiento.",
                        "/Recursos/ImagenesPeriodoFetal/Semana17a20Pantalla1.png"),

                new ContenidoSemana("En estas semanas, los órganos reproductivos alcanzan hitos " +
                        "clave: en las fetos femeninos, se forma el útero y comienza la canalización " +
                        "de la vagina, mientras los ovarios muestran numerosos folículos primordiales " +
                        "con ovogonias. En los fetos masculinos, los testículos inician su descenso, " +
                        "aunque aún permanecen cerca de la pared abdominal. Los rasgos faciales se " +
                        "afinan, con ojos y orejas en su posición definitiva, y el lanugo cubre todo " +
                        "el cuerpo. Estos avances, junto con la capacidad de producir calor mediante la" +
                        " grasa parda, reflejan una creciente preparación para la vida fuera del útero," +
                        " marcando la transición hacia la viabilidad fetal en las próximas semanas.",
                        "/Recursos/ImagenesPeriodoFetal/Semana17a20Pantalla2.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 21 a la 25 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana21a25 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 21 a 25";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana21a25.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante este período, el feto experimenta un aumento sustancial " +
                        "de peso y adquiere proporciones más armónicas, aunque su piel sigue siendo " +
                        "delgada, arrugada y de tono rosado-rojizo por la visible red capilar subyacente." +
                        " A partir de la semana 21, se detectan movimientos oculares rápidos y respuestas" +
                        " de sobresalto con parpadeo (22-23 semanas), evidenciando el desarrollo del" +
                        " sistema nervioso. Un hito crucial es la producción de surfactante pulmonar por " +
                        "los neumocitos tipo II, sustancia esencial para la función respiratoria al " +
                        "prevenir el colapso alveolar. Hacia la semana 24, aparecen las uñas y los rasgos" +
                        " se afinan, aunque la piel permanece translúcida. Pese a estos avances, los " +
                        "fetos nacidos prematuramente en este período (22-25 semanas) enfrentan altos " +
                        "riesgos por la inmadurez pulmonar y neurológica, requiriendo cuidados intensivos" +
                        " para sobrevivir y con posibilidad de secuelas por el desarrollo incompleto del " +
                        "sistema nervioso. Esta etapa marca el límite de la viabilidad fetal extrauterina" +
                        " con apoyo médico avanzado.",
                        "/Recursos/ImagenesPeriodoFetal/Semana21a25Pantalla1.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 26 a la 29 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana26a29 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 26 a 29";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana26a29.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante este período, el feto alcanza un grado de desarrollo " +
                        "que le permite sobrevivir en caso de parto prematuro, aunque requiere cuidados" +
                        " intensivos especializados. Los pulmones muestran una vascularización adecuada " +
                        "y producción suficiente de surfactante para permitir el intercambio gaseoso, " +
                        "mientras el sistema nervioso central ya puede regular movimientos respiratorios" +
                        " rítmicos y controlar parcialmente la temperatura corporal. A nivel físico, se" +
                        " observan cambios significativos: los párpados se abren (semana 26), el lanugo" +
                        " y el cabello están bien desarrollados, las uñas de los pies son visibles y el" +
                        " tejido adiposo subcutáneo -que representa alrededor del 3.5% del peso corporal-" +
                        " reduce las arrugas cutáneas. Simultáneamente, ocurre una transición " +
                        "hematopoyética importante: el bazo, que había sido órgano principal de producción" +
                        " de eritrocitos, cede esta función a la médula ósea hacia la semana 28, marcando " +
                        "un hito en el desarrollo del sistema sanguíneo.",
                        "/Recursos/ImagenesPeriodoFetal/Semana26a29Pantalla1.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 30 a la 34 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana30a34 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 30 a 34";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana30a34.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("En este período, el feto alcanza un grado notable de desarrollo:" +
                        " a las 30 semanas aparece el reflejo pupilar, demostrando la madurez del sistema" +
                        " visual para responder a estímulos luminosos. La piel adquiere un tono rosado y " +
                        "suave, perdiendo su aspecto arrugado gracias al aumento del tejido adiposo blanco," +
                        " que ya representa alrededor del 8% del peso corporal y confiere a las extremidades" +
                        " un aspecto regordete. Los pulmones continúan madurando, y aunque aún pueden " +
                        "requerir apoyo respiratorio, los fetos que nacen a partir de la semana 32 tienen" +
                        " altas probabilidades de supervivencia sin complicaciones graves. Estos avances, " +
                        "junto con la creciente acumulación de grasa que mejora la termorregulación y la " +
                        "coordinación motora más refinada, reflejan la preparación final del feto para la" +
                        " vida extrauterina, reduciendo significativamente los riesgos asociados a la" +
                        " prematuridad en esta etapa.",
                        "/Recursos/ImagenesPeriodoFetal/Semana30a34Pantalla1.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado a la semana 35 a la 38 del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Semana35a38 extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Semana 35 a 38";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Semana35a38.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Durante estas semanas cruciales, el sistema nervioso fetal alcanza" +
                        " un notable grado de maduración, evidenciado por respuestas complejas como el " +
                        "agarre firme y la orientación espontánea hacia estímulos luminosos. El cuerpo " +
                        "adquiere un aspecto rollizo característico, con una proporción equilibrada entre" +
                        " el perímetro cefálico y abdominal (aproximadamente iguales a las 36 semanas)." +
                        " Esta simetría temporal refleja la aceleración en el depósito de grasa subcutánea," +
                        " que no solo contribuye al contorno corporal sino que también fortalece la " +
                        "capacidad de termorregulación para la vida extrauterina. Paralelamente, los " +
                        "movimientos fetales pueden sentirse más espaciados debido al menor espacio " +
                        "intrauterino, pero con mayor coordinación y fuerza.",
                        "/Recursos/ImagenesPeriodoFetal/Semana35a38Pantalla1.png"),

                new ContenidoSemana("Al llegar a la semana 37, considerada ya a término, el feto" +
                        " muestra proporciones características que sirven como marcadores de desarrollo: " +
                        "la longitud del pie supera ligeramente la del fémur, convirtiéndose en un " +
                        "parámetro confiable para estimar la edad gestacional mediante ecografía. El " +
                        "perímetro abdominal comienza a superar al craneal, indicando el predominio " +
                        "del crecimiento visceral y la acumulación de reservas energéticas. Estos " +
                        "cambios coinciden con la maduración final de órganos críticos, especialmente" +
                        " los pulmones, que en esta etapa producen surfactante en cantidades suficientes" +
                        " para garantizar una función respiratoria autónoma tras el nacimiento.",
                        "/Recursos/ImagenesPeriodoFetal/Semana35a38Pantalla2.png"),

                new ContenidoSemana("En la recta final de la gestación, se observa una desaceleración" +
                        " progresiva en la velocidad de crecimiento fetal, un fenómeno adaptativo que " +
                        "facilita el parto. El feto ha alcanzado su desarrollo óptimo: la piel es lisa " +
                        "y rosada, el lanugo ha desaparecido casi por completo y el vérnix caseoso " +
                        "persiste principalmente en pliegues corporales. Los sistemas orgánicos funcionan " +
                        "coordinadamente, destacando la madurez del sistema nervioso central para integrar" +
                        " funciones vitales y respuestas al entorno. Esta etapa representa la culminación " +
                        "del proceso gestacional, donde el feto está plenamente preparado para la " +
                        "transición al mundo exterior, con altísimas probabilidades de adaptación exitosa" +
                        " sin necesidad de intervenciones especiales.",
                        "/Recursos/ImagenesPeriodoFetal/Semana35a38Pantalla3.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}

/** La clase explica todo lo relacionado al final del desarrollo prenatal.
 *  Hereda los métodos de la clase BaseSemanas y con estos mantiene su estructura
 *  con texto e imagenes.
 */
class Parto extends BaseSemanas {
    // Se le da el título a la ventana.
    @Override
    protected String obtenerTitulo() {
        return "Parto";
    }

    // Se le da la ruta para el fondo de la pantalla.
    @Override
    protected String obtenerRutaFondo() {
        return "/Recursos/FondosSemanas/Parto.png";
    }

    // Se muestran las diferentes pantallas para toda la información de la semana.
    @Override
    protected List<ContenidoSemana> obtenerContenido() {
        return List.of(
                new ContenidoSemana("Al final del embarazo, el feto alcanza su desarrollo" +
                        " completo con una longitud céfalo-caudal promedio de 360 mm y un peso " +
                        "aproximado de 3.400 gramos, donde el tejido adiposo blanco representa " +
                        "alrededor del 16% de su peso corporal, acumulándose a un ritmo de 14 " +
                        "gramos diarios en las últimas semanas. El tórax se vuelve prominente y " +
                        "las mamas pueden presentar una ligera protrusión en ambos sexos debido a " +
                        "la influencia hormonal materna. En los varones, los testículos suelen estar" +
                        " ya descendidos al escroto (aunque en prematuros frecuentemente no lo " +
                        "están), marcando otro signo de madurez. Aunque la cabeza sigue siendo una" +
                        " de las estructuras más grandes en relación al cuerpo, su proporción es " +
                        "menor comparada con etapas fetales anteriores, lo que facilita el parto.",
                        "/Recursos/ImagenesPeriodoFetal/PartoPantalla1.png")
        );
    }

    // Se regresa al menú del periodo fetal.
    @Override
    protected Runnable accionRegresar(Stage stage) {
        return () -> new MenuPeriodoFetal().mostrar(stage);
    }
}