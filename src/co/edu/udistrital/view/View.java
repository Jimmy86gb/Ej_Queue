package co.edu.udistrital.view;

import java.util.Scanner;

/**
 * vista unificada minima por consola con manejo de excepciones.
 *
 * @author Jimmy86gb
 */
public class View {
    private Scanner sc;

    /**
     * inicializa el scanner de consola.
     */
    public View() { sc = new Scanner(System.in); }

    /**
     * muestra un texto con salto de linea.
     *
     * @param msg mensaje a mostrar
     */
    public void showMsg(String msg) { System.out.println(msg); }

    /**
     * muestra un texto en la misma linea.
     *
     * @param msg mensaje a mostrar
     */
    public void showMsgInline(String msg) { System.out.print(msg); }

    /**
     * solicita y lee una cadena de texto.
     *
     * @param msg indicacion al usuario
     * @return texto ingresado
     */
    public String readString(String msg) {
        showMsgInline(msg);
        return sc.nextLine();
    }

    /**
     * solicita un entero controlando errores de formato.
     *
     * @param msg indicacion al usuario
     * @param min limite inferior aceptado
     * @return numero entero verificado
     */
    public int readInt(String msg, int min) {
        int num = -1;
        while (true) {
            showMsgInline(msg);
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= min) { break; }
                showMsg("Error, ingrese un numero mayor o igual a " + min);
            } catch (NumberFormatException e) {
                showMsg("Error, entrada invalida");
            }
        }
        return num;
    }

    /**
     * solicita un decimal positivo controlando errores de formato.
     *
     * @param msg indicacion al usuario
     * @param min limite inferior exclusivo
     * @return numero decimal verificado
     */
    public double readDouble(String msg, double min) {
        double num = -1;
        while (true) {
            showMsgInline(msg);
            try {
                num = Double.parseDouble(sc.nextLine());
                if (num > min) { break; }
                showMsg("Error, ingrese un numero positivo");
            } catch (NumberFormatException e) {
                showMsg("Error, entrada invalida");
            }
        }
        return num;
    }
}