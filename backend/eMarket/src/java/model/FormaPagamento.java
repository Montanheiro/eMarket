package model;

/**
 *
 * @author Bárbara
 */
public class FormaPagamento {
    
    private int id;

    private String nome;
    private int maxParcela;
    
    private int tipoPagamentoId;

    public FormaPagamento() {
    }

    public FormaPagamento(String nome, int maxParcela) {
        this.nome = nome;
        this.maxParcela = maxParcela;
    }

    public FormaPagamento(int id, String nome, int maxParcela, int tipoPagamentoId) {
        this.id = id;
        this.nome = nome;
        this.maxParcela = maxParcela;
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

    public int getMaxParcela() {
        return maxParcela;
    }

    public void setMaxParcela(int maxParcela) {
        this.maxParcela = maxParcela;
    }

    public int getTipoPagamentoId() {
        return tipoPagamentoId;
    }

    public void setTipoPagamentoId(int tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" + "id=" + id + ", nome=" + nome + ", maxParcela=" + maxParcela + ", tipoPagamentoId=" + tipoPagamentoId + '}';
    }
    
    
}
