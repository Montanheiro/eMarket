package model;

/**
 *
 * @author Bárbara
 */
public class Status {

    private int id;
    
    private String descricao;

    public Status() {
    }

    public Status(String descricao) {
        this.descricao = descricao;
    }
    
    public Status(int id, String descricao) {
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
        return "Status{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
}
