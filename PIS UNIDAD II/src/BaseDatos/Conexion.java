/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Alejandro
 */
public class Conexion {

    //Detalles de la base de datos
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USERNAME = "C##PIS";
    public static final String PASSWORD = "1234";
    public static Connection instancia;
    
    // Constructor por defecto
    
    public Conexion() {
    }
    //Método privado para establecer una conexión a la base de datos
    private Connection conectar() throws SQLException {
        
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);//retorna la conexion
    }
    
    //Método para desconectar la conexión a la base de datos
    public void desconectar(Connection conexion) {
        try {
            conexion.close();//Cierra la conexión
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());//manejo de excepcion
        }
    }
    //Cerrar resultado consulta
    public void cerrarResultado(ResultSet resultado) {
        try {
            resultado.close();//cierra el resultado de la consulta
        } catch (SQLException e) {
            System.out.println("Error al cerrar el resultado: " + e.getMessage());
        }
    }
    
    //Cerrar un statement de una consulta preparada
    public void cerrarStatment(PreparedStatement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar el statement: " + e.getMessage());
        }
    }
    //Método para obtener la conexión a la base de datos
    public Connection getConnection() throws SQLException {
        if (instancia == null)
            instancia = conectar();//conecta la instancia de conexion
        return instancia;// Retorna la instancia de la conexión
    }
    //establece conexion
    public void setConnection(Connection connection) {
        this.instancia = connection;
    }
    public static void main(String[] args) {
        // Crear instancia de la clase Conexion
        Conexion conexion = new Conexion();

        try {
            // Obtener la conexión a la base de datos
            Connection connection = conexion.getConnection();

            if (connection != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
                
              
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            // Manejar la excepción según tus necesidades
            e.printStackTrace();
        }
    }

}
