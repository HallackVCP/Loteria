package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SorteioServiceImpl implements SorteioService{

    private static final int MAIOR_VALOR = 59;

    private static final int TAMANHO_MINIMO_JOGO = 6;

    private List<Integer> numSorteados;

    public SorteioServiceImpl() {
        setNumSorteados();
    }

    @Override
    public List<Integer> sorteio() {
        List<Integer> numSorteados = new ArrayList<>();
        int numSorteado;
        while (numSorteados.size() < TAMANHO_MINIMO_JOGO) {
            numSorteado = new Random().nextInt(MAIOR_VALOR) + 1;
            if (!numSorteados.contains(numSorteado)) {
                numSorteados.add(numSorteado);
            }
        }
        return numSorteados;
    }

    @Override
    public List<Integer> getNumSorteados() {
        return this.numSorteados;
    }

    @Override
    public void setNumSorteados() {
        this.numSorteados = sorteio();
    }


}
