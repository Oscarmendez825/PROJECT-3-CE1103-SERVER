package com.ce1103.p3.Usuario;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.RandomAccessFile;

/***
 * User creator in Json files.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class CreateJsonTicket {


    String direccion = "C:\\Users\\Oscar\\IdeaProjects\\RSSERVER\\JSONuser.json";

    /***
     * This method adds a new user to the respective Json file.
     * @param tiquete String
     */
    public void ticketUsuario(Tiquete tiquete) throws IOException {
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
            JSONArray fechas = new JSONArray();
/*            for (int i = 0; i< tiquete.getFechas().length; i++){
                fechas.add(tiquete.getFechas()[i]);
            }*/
            jsonObject.put("name", tiquete.getName());
            jsonObject.put("email", tiquete.getEmail());
            jsonObject.put("apellido", tiquete.getApellido());
            jsonObject.put("de", tiquete.getDe());
            jsonObject.put("a", tiquete.getA());
            jsonObject.put("fechas",fechas);
            jsonObject.put("cantidad",tiquete.getCantidad());


            randomAccessFile.writeBytes("[" + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }else{
            JSONObject jsonObject = new JSONObject();
            JSONArray fechas = new JSONArray();
/*            for (int i = 0; i< tiquete.getFechas().length; i++){
                fechas.add(tiquete.getFechas()[i]);
            }*/
            jsonObject.put("name", tiquete.getName());
            jsonObject.put("email", tiquete.getEmail());
            jsonObject.put("apellido", tiquete.getApellido());
            jsonObject.put("de", tiquete.getDe());
            jsonObject.put("a", tiquete.getA());
            jsonObject.put("fechas",fechas);
            jsonObject.put("cantidad",tiquete.getCantidad());


            randomAccessFile.writeBytes("," + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }

    }
}
