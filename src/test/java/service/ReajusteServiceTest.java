package service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void init(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ruan", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteDeveriaSerTresPorCentoQuandoDesempenhoForADesejar(){
        service.reajusteSalario(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerQuinzePorCentoQuandoDesempenhoForBom(){
        service.reajusteSalario(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerVintePorCentoQuandoDesempenhoForOtimo(){
        service.reajusteSalario(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
