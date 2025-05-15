package com.embryowise.Pantalla.Glosario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 */

/** En en esta clase donde se da el manejo lógico del glosario, para buscar palabras por medio
 *  de consultas sql y obtener su definición.
 * */
public class Glosario {
    /** En este método se busca la definición de la palabra que se pasa al parámetro, y lanza
     *  una excepción sql en caso de haberla.
     *
     * @param palabra Es la palabra que el usuario ingresa para buscar su definición.
     * */
    public String buscarDefinicion(String palabra) throws SQLException {
        // Por default se establece la definición como vacía.
        String definicion = "";
        // Se genera la consulta para encontrar la definición.
        String consulta = "SELECT definicion FROM palabras WHERE palabra = ?";

        // Se establece la conexión con la base de datos.
        Connection con = ConexionBaseDeDatos.getConnection();

        // Al statement se le pasa la consulta antes creada.
        PreparedStatement statement = con.prepareStatement(consulta);

        // Se pasa el índice del parámetro, en este caso 1, ya que no hay más, y también se
        // pasa el parámetro.
        statement.setString(1, palabra);

        // Se ejecuta la consulta para ir buscando por rows con ResultSet.
        ResultSet resultado = statement.executeQuery(); // (20)

        // Se revisa si hay algún resultado, y en caso de que sí, se obtiene la cadena desde
        // la columna de definicion. Si no hay resultado, se muestra un mensaje de que la palabra
        // no fue encontrada.
        if (resultado.next()) {
            definicion = resultado.getString("definicion");
        } else {
            definicion = "Palabra no encontrada.";
        }

        return definicion;
    }
}