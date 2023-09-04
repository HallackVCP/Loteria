package org.example;

import java.util.ArrayList;
import java.util.List;

public class Aposta {
    private static final int VALOR_MINIMO_JOGO = 1;

    private static final int VALOR_MAXIMO_JOGO = 60;

    private static final int TAMANHO_MINIMO_JOGO = 6;

    private static final int TAMANHO_MAXIMO_JOGO = 15;

    private List<Integer> lsNumJogados = new ArrayList<>();

    public List<Integer> getLsNumJogados() {
        return lsNumJogados;
    }

    public void setLsNumJogados(List<Integer> lsNumJogados) {
        this.lsNumJogados = lsNumJogados;
    }

    public static List<Integer> validaNumsJogados(List<Integer> numJogados) {
        List<Integer> numValidos = new ArrayList<>();
        for (Integer n: numJogados){
            if (n < VALOR_MINIMO_JOGO || n > VALOR_MAXIMO_JOGO){
                throw new IllegalArgumentException("Numero jogado fora do limite do jogo");
            }
            if (numValidos.contains(n)){
                throw new IllegalArgumentException("Numero jogado repetido");
            }
            numValidos.add(n);
        }
        return numValidos;
    }

    public static boolean validaTamanhoJogo(List<Integer> numValidos) {
        return numValidos.size() >= TAMANHO_MINIMO_JOGO && numValidos.size() <= TAMANHO_MAXIMO_JOGO;
    }
}
