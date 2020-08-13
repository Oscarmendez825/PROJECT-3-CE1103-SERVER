package com.ce1103.p3.Grafo;

import org.json.simple.JSONObject;
import java.io.IOException;
import java.io.RandomAccessFile;
/***
 * Route creator in Json files.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class WriteGraph {
    String direccion = "C:\\Users\\Oscar\\IdeaProjects\\RSSERVER\\Graph.json";

    /***
     * This method adds a new route to the respective Json file.
     * @param ruta Ruta
     */
    public void addRoute(Ruta ruta) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(direccion, "rw");
        long pos = randomAccessFile.length();
        while (randomAccessFile.length() > 0) {
            pos--;
            randomAccessFile.seek(pos);
            if (randomAccessFile.readByte() == ']') {
                randomAccessFile.seek(pos);
                break;
            }

        }
        if(randomAccessFile.length() == 0){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", ruta.getName());
            jsonObject.put("a", ruta.getA());
            jsonObject.put("peso", ruta.getPeso());
            randomAccessFile.writeBytes("[" + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", ruta.getName());
            jsonObject.put("a", ruta.getA());
            jsonObject.put("peso", ruta.getPeso());
            randomAccessFile.writeBytes("," + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }

    }
}
