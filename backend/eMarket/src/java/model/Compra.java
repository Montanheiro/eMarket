package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class Compra {

    private int id;

    private String data;
    private double valorTotal;
    
    private int empresaId;
    private int usuarioId;
    private int fornecedorId;

    public Compra() {
    }

    public Compra(String data, double valorTotal) {
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Compra(int id, String data, double valorTotal, int empresaId, int usuarioId, int fornecedorId) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
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

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", data=" + data + ", valorTotal=" + valorTotal + ", empresaId=" + empresaId + ", usuarioId=" + usuarioId + ", fornecedorId=" + fornecedorId + '}';
    }

}
