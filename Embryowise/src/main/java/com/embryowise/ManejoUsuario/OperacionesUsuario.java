package com.embryowise.ManejoUsuario;

import com.embryowise.ConexionBaseDeDatos;
import java.sql.*;

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
 */

public class OperacionesUsuario {

    // Método para registrar un nuevo usuario
    public static boolean registrarUsuario(String nombre, String contrasena) throws SQLException {
        // Se genera la consulta para registrar al usuario.
        String sql = "INSERT INTO usuarios (nombre, contrasena) VALUES (?, ?)";

        // Se establece la conexión con la base de datos.
        Connection con = ConexionBaseDeDatos.getConnection();

        // Al statement se le pasa la consulta antes creada.
        PreparedStatement statement = con.prepareStatement(sql);

        // Se pasa el índice del parámetro, en este caso 1 y 2 y también se
        // pasa el parámetro.
        statement.setString(1, nombre);
        statement.setString(2, contrasena);

        // Si alguna fila fue afectada, se devuelve verdadero.
        int filasAfectadas = statement.executeUpdate();
        return filasAfectadas > 0;
    }

    // Método para verificar credenciales de login
    public static boolean validarCredenciales(String nombre, String contrasena) throws SQLException {
        // Se genera la consulta para verificar si el usuario existe y es correcto.
        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";

        // Se establece la conexión con la base de datos.
        Connection con = ConexionBaseDeDatos.getConnection();

        // Al statement se le pasa la consulta antes creada.
        PreparedStatement statement = con.prepareStatement(sql);

        // Se pasa el índice del parámetro, en este caso 1 y 2 y también se
        // pasa el parámetro.
        statement.setString(1, nombre);
        statement.setString(2, contrasena);

        // Se ejecuta la consulta para ir buscando por rows con ResultSet, y se devuelve
        // true si encuentra al usuario.
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }

    // Método para verificar si un usuario ya existe
    public static boolean usuarioExiste(String nombre) throws SQLException {
        // Se genera la consulta para verificar si el usuario existe y es correcto.
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";

        // Se establece la conexión con la base de datos.
        Connection con = ConexionBaseDeDatos.getConnection();

        // Al statement se le pasa la consulta antes creada.
        PreparedStatement statement = con.prepareStatement(sql);

        // Se pasa el índice del parámetro, en este caso 1, y también se
        // pasa el parámetro.
        statement.setString(1, nombre);

        // Se ejecuta la consulta para ir buscando por rows con ResultSet, y se devuelve
        // true si un usuario existe.
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }
}