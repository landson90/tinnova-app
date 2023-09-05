package com.land.tinnova.questoes_de_um_a_quatro;

public class CalculadoraVotos {
    private int totalEleitores;
    private int votosValidos;
    private int votosBrancos;
    private int votosNulos;

    public CalculadoraVotos(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    public double calcularPercentualVotosValidos() {
        return ((double) votosValidos / totalEleitores) * 100.0;
    }

    public double calcularPercentualVotosBrancos() {
        return ((double) votosBrancos / totalEleitores) * 100.0;
    }

    public double calcularPercentualVotosNulos() {
        return ((double) votosNulos / totalEleitores) * 100.0;
    }

    public static void main(String[] args) {
        int totalEleitores = 1000;
        int votosValidos = 800;
        int votosBrancos = 150;
        int votosNulos = 50;
        CalculadoraVotos calculadora = new CalculadoraVotos(totalEleitores, votosValidos, votosBrancos, votosNulos);

        System.out.printf("Percentual de votos válidos em relação ao total: %.2f%%%n", calculadora.calcularPercentualVotosValidos());
        System.out.printf("Percentual de votos brancos em relação ao total: %.2f%%%n", calculadora.calcularPercentualVotosBrancos());
        System.out.printf("Percentual de votos nulos em relação ao total: %.2f%%%n", calculadora.calcularPercentualVotosNulos());
    }
}