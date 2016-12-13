package model;

/**
 *
 * @author Bárbara
 */
public class TipoPagamento {
    
    private int id;

    private String descricao;

    public TipoPagamento() {
    }

    public TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public TipoPagamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoPagamento{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
}
