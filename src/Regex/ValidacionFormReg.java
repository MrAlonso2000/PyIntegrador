/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regex;

/**
 *
 * @author Oscar Alonso
 */
public class ValidacionFormReg {

    public static boolean ValidaClave(String clave) {
        Boolean result = false;
        int numeroletras = clave.length();
        String uno = clave.substring(0, 1);
        String sietel = clave.substring(1, 8);
        String diez = clave.substring(8, 10);
        if (!uno.matches("[A-Z]") || !(sietel.matches("[A-Z-0-9-a-z]{7}")) || !(diez.matches("[0-9]{2}"))) {
            result = true;
        }
        return result;
    }

    public static boolean ValidaCorreo(String correo) {
        Boolean result;
        if (!correo.contains("@hotmail.com") || !correo.contains("@gmail.com") ){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    //comentario
}
