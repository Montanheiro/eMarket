package model;

/**
 *
 * @author Bárbara
 */
public class Empresa {
    
    private int id;

    private String nome;
    private String razaoSocial;
    private String cnpj;
    private String dataContratacao;
    
    private Compra compra;//Associacao
    

    public Empresa(String nome, String razaoSocial, String cnpj, String dataContratacao, Compra compra) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataContratacao = dataContratacao;
        this.compra = compra;
    }

    public Empresa(int id, String nome, String razaoSocial, String cnpj, String dataContratacao, Compra compra) {
        this.id = id;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataContratacao = dataContratacao;
        this.compra = compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nome=" + nome + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataContratacao=" + dataContratacao + '}';
    }
    
}
