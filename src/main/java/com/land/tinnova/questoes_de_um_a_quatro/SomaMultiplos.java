package com.land.tinnova.questoes_de_um_a_quatro;

public class SomaMultiplos {
    public static int somaMultiplos(int x) {
        int soma = 0;
        for (int i = 1; i < x; i++) {

            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;

            }
        }
        return soma;
    }
    public static void main(String[] args) {
        int numeroX = 10; // Você pode alterar o valor de X aqui
        int resultado = somaMultiplos(numeroX);
        System.out.println("A soma de todos os múltiplos de 3 ou 5 abaixo de " + numeroX + " é: " + resultado);
    }}
