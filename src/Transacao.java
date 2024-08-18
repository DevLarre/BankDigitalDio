import java.time.LocalDateTime;

public class Transacao {
    private String tipo;
    private double valor;
    private LocalDateTime data = LocalDateTime.now();
    
    public Transacao(String tipo, double valor, LocalDateTime data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String toString(){
        return "::::::::::::::::::::::::\nTransação: "+this.getTipo()+
               "\nValor R$ "+this.getValor()+ 
               "\nData: "+this.getData();
    }

    
}
