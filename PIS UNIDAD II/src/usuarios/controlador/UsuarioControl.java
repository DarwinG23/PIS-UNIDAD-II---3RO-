/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controlador;

import lista.DynamicList;
import usuarios.modelo.Usuario;

/**
 *
 * @author Alexander
 */
public class UsuarioControl {
    private Usuario usuario;
    private DynamicList<Usuario> usuarios;
     public UsuarioControl() {
        usuario = new Usuario();
        this.usuarios = new DynamicList<>();
    }


    public Usuario getUsuario() {
        if(usuario==null){
            usuario=new Usuario();
        }
            
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DynamicList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuario(DynamicList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    //Mwtodo guardar
    public Boolean guardar(){
        usuario.setId(generarId());
        usuarios.add(usuario);
        return true;
    }
    private Integer generarId(){
        return usuarios.getLength()+1;
  }
    
     public void imprimir(){
        System.out.println(usuarios.toString());
    }
    
}
