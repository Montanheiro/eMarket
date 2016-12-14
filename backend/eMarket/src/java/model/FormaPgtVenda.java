package model;

/**
 *
 * @author Bárbara
 */
public class FormaPgtVenda {
    
    private int id;

    private int formaPgtId;
    private int vendaId;

    public FormaPgtVenda(int id, int formaPgtId, int vendaId) {
        this.id = id;
        this.formaPgtId = formaPgtId;
        this.vendaId = vendaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormaPgtId() {
        return formaPgtId;
    }

    public void setFormaPgtId(int formaPgtId) {
        this.formaPgtId = formaPgtId;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public String toString() {
        return "FormaPgtVenda{" + "id=" + id + ", formaPgtId=" + formaPgtId + ", vendaId=" + vendaId + '}';
    }
    
}
