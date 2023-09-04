package org.example;


import java.util.List;

public class Loteria {

    private static final double QUADRA_MULTIPLIER = 0.05;
    private static final double QUINA_MULTIPLIER = 0.2;

    private static final int MAX_ACERTOS = 6;

    private static final int ACERTOS_QUADRA = 4;

    private static final int ACERTOS_QUINA = 5;






    public double loteria(List<Integer> aposta, SorteioService sorteioService, double premio) {
        List<Integer> numValidos = Aposta.validaNumsJogados(aposta);
        if (Aposta.validaTamanhoJogo(numValidos)) {
            return calculaPremio(premio, calculaAcertos(aposta, sorteioService.getNumSorteados()));
        }
        throw new IllegalArgumentException("Tamanho do jogo e invalido");
    }





    private static double calculaPremio(double valor, int totalAcertos) {
        if (totalAcertos == MAX_ACERTOS){
            return valor;
        } else if (totalAcertos == ACERTOS_QUINA){
            return valor * QUINA_MULTIPLIER;
        } else if (totalAcertos == ACERTOS_QUADRA){
            return valor * QUADRA_MULTIPLIER;
        }
        return 0.0;
    }

    private static int calculaAcertos(List<Integer> numJogados, List<Integer> numSorteados) {
        int totalAcertos =0;
        for (Integer i: numJogados){
            if (numSorteados.contains(i)){
                totalAcertos++;
            }
        }
        return totalAcertos;
    }


}