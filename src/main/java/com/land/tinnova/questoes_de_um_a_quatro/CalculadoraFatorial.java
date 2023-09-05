package com.land.tinnova.questoes_de_um_a_quatro;

public class CalculadoraFatorial {
     public static long calcularFatorial(int n) {
         if (n == 0) {
             return 1; // Caso base: 0! = 1
         } else if (n > 0) {
             return n * calcularFatorial(n - 1); // Caso recursivo: n! = n * (n - 1)!
         } else {
             throw new IllegalArgumentException("O fatorial não é definido para números negativos.");
         }
    }

    public static void main(String[] args) {
     int numero = 5; // Você pode alterar o número aqui para calcular o fatorial desejado
        if (numero >= 0) {
            long resultado = calcularFatorial(numero); System.out.println(numero + "! = " + resultado);

        }else {
            System.out.println("O fatorial não é definido para números negativos.");
        }
    }
}


