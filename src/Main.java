
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton, 1000);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.transferir(1100, poupanca);
		cc.depositar(200);
		cc.sacar(350);
		cc.verExtrato();
		poupanca.imprimirExtrato();
		poupanca.transferir(1200, cc);
		poupanca.verExtrato();
	}

}
