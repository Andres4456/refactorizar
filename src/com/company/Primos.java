package com.company;

import java.util.Scanner;

public class Primos {

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max) {
        int i,j;
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            extracted1(dim, esPrimo);
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            extracted(dim, esPrimo);
            // ¿Cuántos primos hay?
            int cuenta = getCuenta(dim, esPrimo);
            // Rellenar el vector de números primos
            int[] primos = getInts(dim, esPrimo, cuenta);
            return primos;
        }
        else { // max < 2
            return new int[0];
            // Vector vacío
        }
    }

    private static void extracted1(int dim, boolean[] esPrimo) {
        int i;
        for (i=0; i< dim; i++) {
            esPrimo[i] = true;
        }
    }

    private static void extracted(int dim, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    private static int[] getInts(int dim, boolean[] esPrimo, int cuenta) {
        int j;
        int i;
        int[] primos = new int[cuenta];
        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    private static int getCuenta(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }
}