import org.example.Aposta;
import org.example.Loteria;
import org.example.SorteioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;



public class LoteriaTest {


    Loteria loteria;

    Aposta aposta;

    SorteioService sorteioService = createMock(SorteioService.class);
    List<Integer> numJogadosQuadra = new ArrayList<>();
    List<Integer> numJogadosQuina = new ArrayList<>();
    List<Integer> numJogadosResultado = new ArrayList<>();
    List<Integer> numJogadosDerrota = new ArrayList<>();

    List<Integer> jogoMenor6 = new ArrayList<>();
    List<Integer> jogoMaior15 = new ArrayList<>();

    double quadra = 0.05;
    double quina = 0.20;


    double vlPremio = 100;

    @BeforeEach
    void setup(){
        aposta = new Aposta();
        jogoMenor6.addAll(Arrays.asList(1,2,3,4,5));
        jogoMaior15.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
        numJogadosResultado.addAll(Arrays.asList(1,2,3,4,5,60));
        numJogadosQuadra.addAll(Arrays.asList(1,2,3,4,21,12));
        numJogadosQuina.addAll(Arrays.asList(1,2,3,4,5,12));
        numJogadosDerrota.addAll(Arrays.asList(21,22,23,32,43,44));
        loteria = new Loteria();
    }


    @Test
    void deveRetornarExcecaoTamanhoJogoMenorLimiteValido(){
        try {
            aposta.setLsNumJogados(jogoMenor6);
            loteria.loteria(aposta.getLsNumJogados(), sorteioService, vlPremio);
            fail();

        }catch (IllegalArgumentException e){
            assertEquals("Tamanho do jogo e invalido", e.getMessage());
        }

    }
    @Test
    void deveRetornarExcecaoTamanhoJogoMaiorLimiteValido(){
        try {
            aposta.setLsNumJogados(jogoMaior15);
            loteria.loteria(aposta.getLsNumJogados(), sorteioService, vlPremio);
            fail();

        }catch (IllegalArgumentException e){
            assertEquals("Tamanho do jogo e invalido", e.getMessage());
        }

    }

    @Test
    void deveVencerQuadra(){
        aposta.setLsNumJogados(numJogadosQuadra);
        expect(sorteioService.getNumSorteados()).andReturn(numJogadosResultado);
        replay(sorteioService);
        assertEquals(loteria.loteria(aposta.getLsNumJogados(), sorteioService, vlPremio), vlPremio * quadra);
    }
    @Test
    void deveVencerQuina(){
        aposta.setLsNumJogados(numJogadosQuina);
        expect(sorteioService.getNumSorteados()).andReturn(numJogadosResultado);
        replay(sorteioService);
        assertEquals(loteria.loteria(aposta.getLsNumJogados(), sorteioService, vlPremio), vlPremio * quina);
    }

    @Test
    void deveVencerSena(){
        aposta.setLsNumJogados(numJogadosResultado);
        expect(sorteioService.getNumSorteados()).andReturn(numJogadosResultado);
        replay(sorteioService);
        assertEquals(loteria.loteria(aposta.getLsNumJogados(), sorteioService, vlPremio), vlPremio);
    }
    @Test
    void devePerder(){
        aposta.setLsNumJogados(numJogadosDerrota);
        expect(sorteioService.getNumSorteados()).andReturn(numJogadosResultado);
        replay(sorteioService);
        assertEquals(loteria.loteria(aposta.getLsNumJogados(), sorteioService, vlPremio), 0.0);
    }


}
