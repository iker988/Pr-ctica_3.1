import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class CompteBancariTest {
    private CompteBancari compte;

    @BeforeEach
    void setup() {
        compte = new CompteBancari("Iker", "ES12345", 1000.0);
    }

    @Test
    void testIngressar() {
        compte.ingressar(500.0);
        assertEquals(1500.0, compte.getSaldo());
    }

    @Test
    void testRetirarMésDelQueHiHa() {
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(2000.0));
    }
}