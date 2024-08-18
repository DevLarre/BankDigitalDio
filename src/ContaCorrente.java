
public class ContaCorrente extends Conta {
	private double chequeEspecial;

	public ContaCorrente(Cliente cliente, double chequeEspecial) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}
	public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
	@Override
	public void sacar(double valor) {
		if (valor > saldo) {
            double resto = valor - saldo;
			this.setChequeEspecial(getChequeEspecial() - resto);
			saldo = resto * -1;
		    System.out.println("Saque realizado. Você está em cheque especial");
			getChequeEspecial();
		}
		else {
			saldo -= valor;
			System.out.println("Saque realizado !");
		}
	}
}
