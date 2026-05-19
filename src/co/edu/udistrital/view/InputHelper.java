package co.edu.udistrital.view;

import java.util.Scanner;

/**
 * Utilidad de soporte para la validación y captura segura de datos por consola.
 * Maneja excepciones de formateo para asegurar entradas de tipos primitivos numéricos controlados.
 *
 * @author Chrz
 */
public class InputHelper {

    /**
     * Solicita y valida la inserción de un número entero positivo restringido en un rango inclusivo cerrado.
     *
     * @param sc El lector Scanner activo de la entrada del sistema.
     * @param cot1 Límite inferior permitido.
     * @param cot2 Límite superior permitido.
     * @param message Mensaje guía que se imprime para orientar al usuario.
     * @return El número entero validado de forma exitosa.
     */
    public int requestPositiveInteger(Scanner sc, int cot1, int cot2, String message) {
        int num = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(message);
            try {
                num = Integer.parseInt(sc.nextLine());

                if (num >= cot1 && num <= cot2) {
                    valid = true;
                } else {
                    System.out.println("Error, ingrese un numero valido");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error, ingrese un numero valido");
            }
        }

        return num;
    }

    /**
     * Solicita y valida la inserción de un valor decimal (double) restringido en un rango numérico.
     *
     * @param sc El lector Scanner activo de la entrada del sistema.
     * @param cot1 Límite inferior exclusivo (debe ser mayor que este).
     * @param cot2 Límite superior inclusivo.
     * @param message Mensaje guía que se imprime para orientar al usuario.
     * @return El valor numérico decimal validado de forma exitosa.
     */
    public double requestPositiveDouble(Scanner sc, double cot1, double cot2, String message) {
        double num = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(message);

            try {
                num = Double.parseDouble(sc.nextLine());

                if (num > cot1 && num <= cot2) {
                    valid = true;
                } else {
                    System.out.println("Error, enter a valid number");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error, enter a valid number");
            }
        }

        return num;
    }
}