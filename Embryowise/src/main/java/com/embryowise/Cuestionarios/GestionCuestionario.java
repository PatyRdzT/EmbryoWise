package com.embryowise.Cuestionarios;

import com.embryowise.ConexionBaseDeDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Clase creada para gestionar lo relacionado a las consultas del cuestionario.*/
public class GestionCuestionario {
    /** Método que inicializa los cuestionarios en la base de datos si no existen y crea tres
     *  cuestionarios por defecto: Pre-Embrionario, Embrionario y Fetal. */
    public static void inicializarCuestionarios() {
        String consulta = "INSERT IGNORE INTO cuestionarios (id, nombre, total_preguntas) VALUES " +
                "(1, 'Periodo Pre-Embrionario', 10), " +
                "(2, 'Periodo Embrionario', 10), " +
                "(3, 'Periodo Fetal', 10)";

        try (Connection con = ConexionBaseDeDatos.getConnection();
            Statement statement = con.createStatement()) {
            statement.executeUpdate(consulta);
        } catch (SQLException e) {
            System.err.println("Error al inicializar cuestionarios: " + e.getMessage());
        }
    }

    /** Método que obtiene el progreso de un usuario en un cuestionario específico.
     *  @param usuarioId Es el ID del usuario.
     *  @param cuestionarioId Es el ID del cuestionario.
     *  @return Es el número de la última pregunta respondida (1 si no hay progreso).
     *  @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static int obtenerProgreso(int usuarioId, int cuestionarioId) throws SQLException {
        inicializarCuestionarios(); // Asegurar que existe el cuestionario

        String consulta = "SELECT ultima_pregunta FROM progreso_usuario " +
                "WHERE usuario_id = ? AND cuestionario_id = ?";

        try (Connection con = ConexionBaseDeDatos.getConnection();
            PreparedStatement statement = con.prepareStatement(consulta)) {
            statement.setInt(1, usuarioId);
            statement.setInt(2, cuestionarioId);
            ResultSet resultado = statement.executeQuery();

            return resultado.next() ? resultado.getInt("ultima_pregunta") : 1;
        }
    }

    /** Método que guarda el progreso de un usuario en un cuestionario.
     *  @param usuarioId Es el ID del usuario.
     *  @param cuestionarioId Es el ID del cuestionario.
     *  @param ultimaPregunta Número de la última pregunta respondida.
     *  @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static void guardarProgreso(int usuarioId, int cuestionarioId, int ultimaPregunta) throws SQLException {
        String consulta = "INSERT INTO progreso_usuario (usuario_id, cuestionario_id, ultima_pregunta) " +
                "VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE ultima_pregunta = ?";

        try (Connection con = ConexionBaseDeDatos.getConnection();
            PreparedStatement statement = con.prepareStatement(consulta)) {
            con.setAutoCommit(false);

            statement.setInt(1, usuarioId);
            statement.setInt(2, cuestionarioId);
            statement.setInt(3, ultimaPregunta);
            statement.setInt(4, ultimaPregunta);
            statement.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            System.err.println("Error en guardarProgreso: " + e.getMessage());
            throw e;
        }
    }

    /** Método que registra un intento de cuestionario completado por un usuario.
     *  @param usuarioId Es el ID del usuario.
     *  @param cuestionarioId Es el ID del cuestionario.
     *  @param respuestasCorrectas Número de respuestas correctas.
     *  @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static void registrarIntento(int usuarioId, int cuestionarioId, int respuestasCorrectas) throws SQLException {
        String consulta = "INSERT INTO intentos_cuestionario " +
                "(usuario_id, cuestionario_id, calificacion, respuestas_correctas) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBaseDeDatos.getConnection();
            PreparedStatement statement = con.prepareStatement(consulta)) {
            con.setAutoCommit(false);

            int totalPreguntas = obtenerTotalPreguntas(cuestionarioId);
            double calificacion = (respuestasCorrectas * 100.0) / totalPreguntas;

            statement.setInt(1, usuarioId);
            statement.setInt(2, cuestionarioId);
            statement.setDouble(3, calificacion);
            statement.setInt(4, respuestasCorrectas);
            statement.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            System.err.println("Error en registrarIntento: " + e.getMessage());
            throw e;
        }
    }

    /** Método que obtiene el número total de preguntas de un cuestionario.
     * @param cuestionarioId ID del cuestionario.
     * @return Número total de preguntas (10 por defecto si no se encuentra).
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static int obtenerTotalPreguntas(int cuestionarioId) throws SQLException {
        String consulta = "SELECT total_preguntas FROM cuestionarios WHERE id = ?";
        try (Connection con = ConexionBaseDeDatos.getConnection();
            PreparedStatement statement = con.prepareStatement(consulta)) {
            statement.setInt(1, cuestionarioId);
            ResultSet resultado = statement.executeQuery();
            return resultado.next() ? resultado.getInt("total_preguntas") : 10;
        }
    }

    /** Método que obtiene las calificaciones históricas de un usuario en todos los cuestionarios.
     *  @param usuarioId ID del usuario.
     *  @return Lista de strings con formato "Nombre cuestionario: Calificación% (Fecha)".
     *  @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static List<String> obtenerCalificacionesUsuario(int usuarioId) throws SQLException {
        String consulta = "SELECT c.nombre, i.calificacion, i.fecha " +
                "FROM intentos_cuestionario i " +
                "JOIN cuestionarios c ON i.cuestionario_id = c.id " +
                "WHERE i.usuario_id = ? " +
                "ORDER BY i.calificacion DESC, i.fecha DESC";

        List<String> resultados = new ArrayList<>();

        try (Connection con = ConexionBaseDeDatos.getConnection();
            PreparedStatement statement = con.prepareStatement(consulta)) {
            statement.setInt(1, usuarioId);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                String linea = String.format("%s: %.0f%% (%s)",
                        resultado.getString("nombre"),
                        resultado.getDouble("calificacion"),
                        resultado.getTimestamp("fecha").toLocalDateTime().toLocalDate()
                );
                resultados.add(linea);
            }
        }

        return resultados;
    }

    /** Método que obtiene el progreso general de un usuario en todos los cuestionarios.
     *  @param usuarioId ID del usuario.
     *  @return Lista de strings con el estado de cada cuestionario y la mejor calificación.
     *  @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static List<String> obtenerProgresoUsuario(int usuarioId) throws SQLException {
        String consulta = "SELECT c.id, c.nombre, " +
                "MAX(i.calificacion) as max_calificacion, " +
                "COUNT(i.id) as intentos " +
                "FROM cuestionarios c " +
                "LEFT JOIN intentos_cuestionario i ON c.id = i.cuestionario_id AND i.usuario_id = ? " +
                "GROUP BY c.id, c.nombre " +
                "ORDER BY c.id";

        List<String> resultados = new ArrayList<>();

        try (Connection con = ConexionBaseDeDatos.getConnection();
            PreparedStatement statement = con.prepareStatement(consulta)) {
            statement.setInt(1, usuarioId);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                double maxCalificacion = resultado.getDouble("max_calificacion");
                int intentos = resultado.getInt("intentos");

                String estado;
                if (intentos == 0) {
                    estado = "Sin intentos";
                } else if (maxCalificacion >= 90) {
                    estado = "Completado (Excelente)";
                } else if (maxCalificacion >= 70) {
                    estado = "Completado (Aprobado)";
                } else {
                    estado = "En progreso (Mejorable)";
                }

                resultados.add(String.format("%s: %s (Mejor calificación: %.0f%%)",
                        nombre, estado, maxCalificacion));
            }
        }

        return resultados;
    }
}