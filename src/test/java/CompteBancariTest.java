import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class CompteBancariTest {
    private CompteBancari compte;

    @BeforeEach
    void setup() {
        // Inicialitzem un compte amb 1000€ per a cada test [cite: 191]
        compte = new CompteBancari("Iker", "ES12345", 1000.0);
    }

    @Test
    void testIngressar() {
        compte.ingressar(500.0);
        // Comprovem que el saldo s'actualitza correctament [cite: 204]
        assertEquals(1500.0, compte.getSaldo(), "El saldo hauria de ser 1500 després de l'ingrés");
    }

    @Test
    void testRetirarDiners() {
        compte.retirar(500.0);
        assertEquals(500.0, compte.getSaldo(), "El saldo hauria de ser 500 després de la retirada");
    }

    @Test
    void testRetirarMesDelQueHiHa() {
        // Aquest test ha de llançar una excepció [cite: 209]
        assertThrows(IllegalArgumentException.class, () -> {
            compte.retirar(2000.0);
        }, "Hauria de llançar excepció per saldo insuficient");
    }

    @Test
    void testIngressarQuantitatNegativa() {
        // Validem que no es permetin ingressos negatius
        assertThrows(IllegalArgumentException.class, () -> {
            compte.ingressar(-100.0);
        });
    }
}