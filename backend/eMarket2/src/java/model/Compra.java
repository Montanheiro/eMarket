package model;

/**
 *
 * @author Bárbara
 */
public class Compra {

    private int id;

    private String data;
    private double valorTotal;
    private String caixa;
    
    private int empresaId;
    private int usuarioId;
    private String fornecedorId;

    public Compra(String data, double valorTotal, String caixa) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.caixa = caixa;
    }

    public Compra(int id, String data, double valorTotal, String caixa, int empresaId, int usuarioId, String fornecedorId) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.caixa = caixa;
        this.empresaId = empresaId;
        this.usuarioId = usuarioId;
        this.fornecedorId = fornecedorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(String fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", data=" + data + ", valorTotal=" + valorTotal + ", caixa=" + caixa + ", empresaId=" + empresaId + ", usuarioId=" + usuarioId + ", fornecedorId=" + fornecedorId + '}';
    }

}
