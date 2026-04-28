public class CompteBancari {
    private String titular;
    private String iban;
    private double saldo;
 
    public CompteBancari(String titular, String iban, double saldoInicial) {
        if (titular == null || titular.equals("")) { throw new IllegalArgumentException("Error titular"); }
        if (iban == null || iban.equals("")) { throw new IllegalArgumentException("Error iban"); }
        if (saldoInicial < 0) { throw new IllegalArgumentException("Error saldo"); }
        this.titular = titular;
        this.iban = iban;
        this.saldo = saldoInicial;
    }
 
    public void ingressar(double q) {
        if (q <= 0) { throw new IllegalArgumentException("Error"); }
        else {
            saldo = saldo + q;
            if (saldo < 1000) { System.out.println("Saldo baix"); }
            else if (saldo >= 1000 && saldo < 5000) { System.out.println("Saldo normal"); }
            else { System.out.println("Saldo alt"); }
        }
    }
 
    public void retirar(double q) {
        if (q <= 0 || q > saldo) { throw new IllegalArgumentException("Error"); }
        else {
            saldo = saldo - q;
            if (saldo < 1000) { System.out.println("Saldo baix"); }
            else { System.out.println("Saldo normal"); }
        }
    }
 
    public String getTitular() { return titular; }
    public String getIban() { return iban; }
    public double getSaldo() { return saldo; }
 }