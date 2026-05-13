public class CompteBancari {
    private String titular;
    private String iban;
    private double saldo;

    public CompteBancari(String titular, String iban, double saldoInicial) {
        if (titular == null || titular.isEmpty()) throw new IllegalArgumentException("Titular buit");
        if (iban == null || iban.isEmpty()) throw new IllegalArgumentException("IBAN buit");
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo negatiu");
        this.titular = titular;
        this.iban = iban;
        this.saldo = saldoInicial;
    }

    public void ingressar(double quantitat) {
        if (quantitat <= 0) throw new IllegalArgumentException("Quantitat invàlida");
        saldo += quantitat;
        imprimirEstat(); // REFACTOR: Hem tret el codi duplicat d'aquí
    }

    public void retirar(double quantitat) {
        if (quantitat <= 0 || quantitat > saldo) throw new IllegalArgumentException("Error retirada");
        saldo -= quantitat;
        imprimirEstat(); // REFACTOR: I d'aquí també
    }

    // AQUESTA ÉS LA CLAU: Un sol mètode per a tots els missatges
    private void imprimirEstat() {
        String estat = (saldo < 1000) ? "baix" : (saldo < 5000) ? "normal" : "alt";
        System.out.println("Saldo actual: " + saldo + " - Estat: " + estat);
    }

    public String getTitular() { return titular; }
    public String getIban() { return iban; }
    public double getSaldo() { return saldo; }
}