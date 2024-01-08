/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.ConexionesDB.Vo;

/**
 *
 * @author ALEJANDRO
 */
public class PdfVo {
    int codigopdf;
    String nombrepdf;
    byte[] archivopdf;

    public PdfVo() {
    }

    /*Todo los codigos get*/
    public int getCodigopdf() {
        return codigopdf;
    }

    public String getNombrepdf() {
        return nombrepdf;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }


    /*Todo los codigos set*/
    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public void setNombrepdf(String nombrepdf) {
        this.nombrepdf = nombrepdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }
}
