import org.example.SorteioService;
import org.example.SorteioServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorteioServiceTest {

    static Integer QTD_NUM_SORTEADOS = 6;

    @Test
    void deveRetornarSorteio(){
        SorteioService sorteioService = new SorteioServiceImpl();
        sorteioService.setNumSorteados();
        assertEquals(QTD_NUM_SORTEADOS, sorteioService.getNumSorteados().size());
    }
}
