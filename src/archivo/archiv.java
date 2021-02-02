package archivo;

import java.io.File;
import java.io.FileWriter;

public class archiv {

    public void GenerarArchivo(String nom, String contenido) {
        try {
            File archivo = new File(nom);

            if (archivo.exists()) {
                if (archivo.delete()) {
//                    System.out.println("El fichero borrado");
                } else {
//                    System.out.println("El fichero no se pudo borrar");
                }
            }
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(contenido);
            escribir.close();
            //JOptionPane.showMessageDialog(null, "ARCHIVO CREADO");
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}
