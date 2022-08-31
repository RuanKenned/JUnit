package service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    public void init(){
        this.service = new BonusService();
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        //Método 1
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Ruan", LocalDate.now(), new BigDecimal("10000.1"))));

        //Método 2
        /*try {
            service.calcularBonus(new Funcionario("Ruan", LocalDate.now(), new BigDecimal("10000.1")));
            fail("Não lançou a Exception");
        }catch (Exception e){
            assertEquals("Funcionário com salário maior que R$ 10,000.00 não pode receber bônus", e.getMessage());
        }*/
    }

    @Test
    void bonusDeveriaSerDezPorCento(){
        BigDecimal valor = service.calcularBonus(new Funcionario("Ruan", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), valor);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioExatamenteDe10000(){
        BigDecimal valor = service.calcularBonus(new Funcionario("Ruan", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), valor);
    }
}
