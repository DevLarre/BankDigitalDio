import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private List<Transacao> transacoes;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.transacoes = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		adicionarTransacao("Saque", valor, LocalDateTime.now());
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Deposito realizado!");
		adicionarTransacao("Deposito", valor, LocalDateTime.now());
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		adicionarTransacao("Trasferencia", valor, LocalDateTime.now());
	}
	

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public void renderJuros(double d) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'renderJuros'");
	}
	public void adicionarTransacao(String tipo, double valor, LocalDateTime data) {
        Transacao novaTransacao = new Transacao(tipo, valor, LocalDateTime.now());
        transacoes.add(novaTransacao);
    }
	public void verExtrato() {
        for (Transacao novaTransacao : transacoes) {
            System.out.println(novaTransacao.toString());
        }
    }
}
