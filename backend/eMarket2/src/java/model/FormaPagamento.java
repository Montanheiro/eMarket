package model;

/**
 *
 * @author Bárbara
 */
public class FormaPagamento {
   
    private int id;

    private String nome;
    private String tipoPagamento;
    
    private int tipoPagamentoId;

    public FormaPagamento(String nome, String tipoPagamento) {
        this.nome = nome;
        this.tipoPagamento = tipoPagamento;
    }

    public FormaPagamento(int id, String nome, String tipoPagamento, int tipoPagamentoId) {
        this.id = id;
        this.nome = nome;
        this.tipoPagamento = tipoPagamento;
        this.tipoPagamentoId = tipoPagamentoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getTipoPagamentoId() {
        return tipoPagamentoId;
    }

    public void setTipoPagamentoId(int tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" + "id=" + id + ", nome=" + nome + ", tipoPagamento=" + tipoPagamento + ", tipoPagamentoId=" + tipoPagamentoId + '}';
    }

    
}
