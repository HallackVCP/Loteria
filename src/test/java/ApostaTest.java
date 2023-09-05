import org.example.Aposta;
import org.example.Loteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ApostaTest {

    List<Integer> jogoMenor6 = new ArrayList<>();
    List<Integer> jogoMaior15 = new ArrayList<>();

    List<Integer> numJogadosMaior60 = new ArrayList<>();
    List<Integer> numJogadosMenor1 = new ArrayList<>();
    List<Integer> numJogadosRepetidos = new ArrayList<>();

    List<Integer> apostaValida = new ArrayList<>();

    Aposta aposta;

    @BeforeEach
    void setup(){
        int i = 0;
        while(i < 7){
            numJogadosMaior60.add(55+i);
            numJogadosMenor1.add(6-i);
            numJogadosRepetidos.add(1);
            i++;
        }
        aposta = new Aposta();
        jogoMenor6.addAll(Arrays.asList(1,2,3,4,5));
        jogoMaior15.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
        apostaValida.addAll(Arrays.asList(1,2,3,4,5,6));

    }



    @Test
    void deveRetornarExcecaoNumeroRepetido(){
        try {
            aposta.setLsNumJogados(numJogadosRepetidos);
            Aposta.validaNumsJogados(aposta.getLsNumJogados());
            fail();

        }catch (IllegalArgumentException e){
            assertEquals("Numero jogado repetido", e.getMessage());
        }

    }

    @Test
    void deveRetornarExcecaoNumeroMaiorQueLimiteValido(){
        try {
            aposta.setLsNumJogados(numJogadosMaior60);
            Aposta.validaNumsJogados(aposta.getLsNumJogados());
            fail();

        }catch (IllegalArgumentException e){
            assertEquals("Numero jogado fora do limite do jogo", e.getMessage());
        }

    }
    @Test
    void deveRetornarExcecaoNumeroMenorQueLimiteValido(){
        try {
            aposta.setLsNumJogados(numJogadosMenor1);
            Aposta.validaNumsJogados(aposta.getLsNumJogados());
            fail();

        }catch (IllegalArgumentException e){
            assertEquals("Numero jogado fora do limite do jogo", e.getMessage());
        }

    }
    @Test
    void deveRetornarTamanhoJogoMenorLimiteValido(){
        aposta.setLsNumJogados(jogoMenor6);
        assertFalse(Aposta.validaTamanhoJogo(aposta.getLsNumJogados()));


    }
    @Test
    void deveRetornarTamanhoJogoMaiorLimiteValido(){
        aposta.setLsNumJogados(jogoMaior15);
        assertFalse(Aposta.validaTamanhoJogo(aposta.getLsNumJogados()));

    }
    @Test
    void deveRetornarTamanhoJogoValido(){
        aposta.setLsNumJogados(apostaValida);
        assertTrue(Aposta.validaTamanhoJogo(aposta.getLsNumJogados()));

    }
}
