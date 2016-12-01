package model;

/**
 *
 * @author Bárbara
 */
public class Funcionario {

    private int id;

    private double salario;
    private int comissao;
    private String dataAdimissao;
    private String dataDemissao;

    private int cargoId;
    private int pessoaId;

    public Funcionario(double salario, int comissao, String dataAdimissao, String dataDemissao) {
        this.salario = salario;
        this.comissao = comissao;
        this.dataAdimissao = dataAdimissao;
        this.dataDemissao = dataDemissao;
    }

    public Funcionario(int id, double salario, int comissao, String dataAdimissao, String dataDemissao, int cargoId, int pessoaId) {
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

    public String getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(String dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
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

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", salario=" + salario + ", comissao=" + comissao + ", dataAdimissao=" + dataAdimissao + ", dataDemissao=" + dataDemissao + ", cargoId=" + cargoId + ", pessoaId=" + pessoaId + '}';
    }

}
