package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Bárbara
 */
public class Venda {

    private int id;

    private String dataVenda;
    private double valorTotal;

    private Empresa empresa;
    private Usuario usuario;
    private Cliente cliente;
    private ArrayList<ItemVenda> itemVenda;

    private int clienteId;
    private int empresaId;
    private int usuarioId;

    public Venda() {
    }

    public Venda(String dataVenda, double valorTotal) {
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public Venda(int id, String dataVenda, double valorTotal, int empresaId, int usuarioId, int clienteId) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.empresaId = empresaId;
        this.usuarioId = usuarioId;
        this.clienteId = clienteId;
    }

    public Venda(int id, String dataVenda, double valorTotal, Empresa empresa, Usuario usuario, Cliente cliente, ArrayList<ItemVenda> itemVenda) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
        this.empresa = empresa;
        this.usuario = usuario;
        this.cliente = cliente;
        this.itemVenda = itemVenda;
    }

    public void addItem(ItemVenda iv) {
        if (itemVenda == null) {
            itemVenda = new ArrayList<>();
        }
        itemVenda.add(iv);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public ArrayList<ItemVenda> getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ArrayList<ItemVenda> itemVenda) {
        this.itemVenda = itemVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", valorTotal=" + valorTotal + ", empresa=" + empresa + ", usuario=" + usuario + ", empresaId=" + empresaId + ", usuarioId=" + usuarioId + '}';
    }

}
