package model;

/**
 *
 * @author Bárbara,Mateus
 */
public class Empresa {
    
    private int id;

    private String Nome;
    private String RazaoSocial;
    private String CNPJ;
    private String DataContratacao;
    
    
    //private Compra compra;//Associacao
    

    public Empresa(String nome, String razaoSocial, String cnpj, String dataContratacao/*, Compra compra*/) {
        this.Nome = nome;
        this.RazaoSocial = razaoSocial;
        this.CNPJ = cnpj;
        this.DataContratacao = dataContratacao;
       // this.compra = compra;
    }

    public Empresa(int id, String nome, String razaoSocial, String cnpj, String dataContratacao/*, Compra compra*/) {
        this.id = id;
        this.Nome = nome;
        this.RazaoSocial = razaoSocial;
        this.CNPJ = cnpj;
        this.DataContratacao = dataContratacao;
       // this.compra = compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.RazaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return CNPJ;
    }

    public void setCnpj(String cnpj) {
        this.CNPJ = cnpj;
    }

    public String getDataContratacao() {
        return DataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.DataContratacao = dataContratacao;
    }

//    public Compra getCompra() {
//        return compra;
//    }

//    public void setCompra(Compra compra) {
//        this.compra = compra;
//    }
    
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nome=" + Nome + ", razaoSocial=" + RazaoSocial + ", cnpj=" + CNPJ + ", dataContratacao=" + DataContratacao + '}';
    }
    
}
