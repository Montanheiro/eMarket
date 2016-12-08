package model;

import java.sql.Date;

/**
 *
 * @author Bárbara
 */
public class Funcionario{

    private int id;

    private double salario;
    private int comissao;
    private Date dataAdimissao;
    private Date dataDemissao;
    
    private Pessoa pessoa;
    private Cargo cargo;
   
    private int cargoId;
    private int pessoaId;

    public Funcionario() {
    }

    public Funcionario(double salario, int comissao, Date dataAdimissao, Date dataDemissao, int cargoId, Pessoa pessoa) {
        this.salario = salario;
        this.comissao = comissao;
        this.dataAdimissao = dataAdimissao;
        this.dataDemissao = dataDemissao;
        this.cargoId = cargoId;
        this.pessoa = pessoa;
    }

    public Funcionario(int id, double salario, int comissao, Date dataAdimissao, Date dataDemissao, int cargoId, int pessoaId) {
        this.id = id;
        this.salario = salario;
        this.comissao = comissao;
        this.dataAdimissao = dataAdimissao;
        this.dataDemissao = dataDemissao;
        this.cargoId = cargoId;
        this.pessoaId = pessoaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getComissao() {
        return comissao;
    }

    public void setComissao(int comissao) {
        this.comissao = comissao;
    }

    public Date getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(Date dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", salario=" + salario + ", comissao=" + comissao + ", dataAdimissao=" + dataAdimissao + ", dataDemissao=" + dataDemissao + ", cargoId=" + cargoId + ", pessoaId=" + pessoaId + '}';
    }

}
