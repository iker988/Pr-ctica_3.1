import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompteBancariTest {
    private CompteBancari compte;

    @BeforeEach
    void setUp() {
        // Preparem un compte estàndard abans de cada test
        compte = new CompteBancari("Joan Pere", "ES123456789", 1000.0);
    }

    @Test
    void testCreacioCorrecta() {
        assertEquals("Joan Pere", compte.getTitular());
        assertEquals(1000.0, compte.getSaldo(), 0.001);
    }

    @Test
    void testConstructorErrorTitularBuit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CompteBancari("", "ES123", 100.0);
        });
    }

    @Test
    void testConstructorErrorSaldoNegatiu() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CompteBancari("Test", "ES123", -50.0);
        });
    }

    @Test
    void testIngressarCorrecte() {
        compte.ingressar(500.0);
        assertEquals(1500.0, compte.getSaldo(), 0.001);
    }

    @Test
    void testIngressarErrorQuantitatNegativa() {
        assertThrows(IllegalArgumentException.class, () -> compte.ingressar(-10.0));
    }

    @Test
    void testRetirarCorrecte() {
        compte.retirar(300.0);
        assertEquals(700.0, compte.getSaldo(), 0.001);
    }

    @Test
    void testRetirarErrorSenseSaldo() {
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(2000.0));
    }
}