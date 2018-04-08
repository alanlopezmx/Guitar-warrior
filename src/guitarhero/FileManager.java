package guitarhero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class FileManager {
    String nArchivo;
    
    FileManager(String nArchivo) {
        this.nArchivo = nArchivo;
    }
    public void crear(ListaSimple lista) throws IOException{
        Nodo aux;
        FileWriter fw = new FileWriter(nArchivo);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pArchivo = new PrintWriter(bw);
        for (int i = 1; i < lista.tamaño; i++) {
            aux=lista.indexOf(i);
            pArchivo.println(aux.color + " " + aux.tiempo + " " +aux.duracion);
        }
        pArchivo.close();
    }
    
    public String[] leer() throws IOException{
        FileReader fr = new FileReader(nArchivo);
        BufferedReader rArchivo = new BufferedReader(fr);
        String texto[];
        int lineas=totalLineas();
        texto = new String[lineas];
        for (int i = 0; i < lineas; i++) {
            texto[i]=rArchivo.readLine();
        }
        rArchivo.close();
        return texto;
    }
    public int totalLineas() throws IOException{
        FileReader fr = new FileReader(nArchivo);
        BufferedReader rArchivo = new BufferedReader(fr);
        String linea;
        int lineas=0;
        while ((linea =rArchivo.readLine()) != null){
            lineas++;
        }
        rArchivo.close();
        return lineas;
    }
    public void añadir(String nombre, String ruta)throws IOException{
        FileWriter fw = new FileWriter(nArchivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pArchivo = new PrintWriter(bw);
        pArchivo.println(nombre + "-" + ruta);
        pArchivo.close();
    }
    
    public boolean busca(String nombre) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(nArchivo);
        BufferedReader rArchivo = new BufferedReader(fr);
        String texto[];
        String aux[];
        int lineas=totalLineas();
        texto = new String[lineas];
        for (int i = 0; i < lineas; i++) {
            texto[i]=rArchivo.readLine();
            aux = texto[i].split("-");
            if (aux[0].equals(nombre)){
                return true;
            }
        }
        return false;
    }
}
