package co.edu.udistrital.view;

import java.util.Scanner;

/**
 * vista unificada minima por consola con manejo de excepciones.
 *
 * @author Jimmy86gb
 */
public class View {
    private Scanner sc;

    public View() { sc = new Scanner(System.in); }

    public void showMsg(String msg) { System.out.println(msg); }
    public void showMsgInline(String msg) { System.out.print(msg); }

    public String readString(String msg) {
        showMsgInline(msg);
        return sc.nextLine();
    }

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

    public double readDouble(String msg, double min) {
        double num = -1;
        while (true) {
            showMsgInline(msg);
            try {
                num = Double.parseDouble(sc.nextLine());
                if (num >= min) { break; }
                showMsg("Error, ingrese un numero positivo");
            } catch (NumberFormatException e) {
                showMsg("Error, entrada invalida");
            }
        }
        return num;
    }
}