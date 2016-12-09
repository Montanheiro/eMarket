package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class Promocao {
   
    private int id;

    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private int porcentagem;

    public Promocao() {
    }

    public Promocao(String descricao, Date dataInicio, Date dataFim, int porcentagem) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.porcentagem = porcentagem;
    }

    public Promocao(int id, String descricao, Date dataInicio, Date dataFim, int porcentagem) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.porcentagem = porcentagem;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public String toString() {
        return "Promocao{" + "id=" + id + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", porcentagem=" + porcentagem + '}';
    }

    
}
