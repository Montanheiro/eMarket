package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class Promocao {
   
    private int id;

    private String descricao;
    private String dataInicio;
    private String dataFim;
    private int porcentagem;

    public Promocao() {
    }

    public Promocao(String descricao, String dataInicio, String dataFim, int porcentagem) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.porcentagem = porcentagem;
    }

    public Promocao(int id, String descricao, String dataInicio, String dataFim, int porcentagem) {
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
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
