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
    void testOperacions() {
        compte.ingressar(500.0);
        assertEquals(1500.0, compte.getSaldo());
        compte.retirar(200.0);
        assertEquals(1300.0, compte.getSaldo());
    }

    @Test
    void testErrors() {
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(5000.0));
    }
}