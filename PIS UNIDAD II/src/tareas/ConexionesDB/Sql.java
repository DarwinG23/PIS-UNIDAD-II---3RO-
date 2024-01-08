/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.ConexionesDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ALEJANDRO
 */
public class Sql {
    public int auto_increment(String sql){
        int id=1;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Conectar db=new Conectar();
        try {
            ps=db.getConnection().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                id=rs.getInt(1)+1;
                
            }
        } catch (Exception e) {
            System.out.println("idmaximo"+ e.getMessage());
            id=1;
        } finally{
            try {
                ps.close();
                rs.close();
                db.desconectar();
            } catch (Exception e) {
            }
        }
        return id;
    }
}
