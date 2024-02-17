/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.ConexionesDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ALEJANDRO
 */
public class Conectar {
    static String bd = "archivos";
    static String login = "SYSTEM";
    static String password = "12345";
    static String url = "jdbc:oracle:thin:@localhost:1521:XE";  // Corregido: Eliminado bd de la URL
    Connection connection = null;

    public Conectar() {
        try {
            // Corregido: Utilizar "oracle.jdbc.OracleDriver" como el nombre del controlador
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(url, login, password);
            if (connection != null) {
                System.out.println("Conexión a la base de datos " + bd + " OK\n");
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no encontrado: " + ex.getMessage());
        } catch (Exception x) {
            System.out.println("Error general: " + x.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Desconexión exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }
}
