package model;

/**
 *
 * @author Bárbara
 */
public class Permissao {

    private int id;

    private String descricao;
    private String moduloURL;

    public Permissao(String descricao, String moduloURL) {
        this.descricao = descricao;
        this.moduloURL = moduloURL;
    }

    public Permissao(int id, String descricao, String moduloURL) {
        this.id = id;
        this.descricao = descricao;
        this.moduloURL = moduloURL;
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

    public String getModuloURL() {
        return moduloURL;
    }

    public void setModuloURL(String moduloURL) {
        this.moduloURL = moduloURL;
    }

    @Override
    public String toString() {
        return "Permissao{" + "id=" + id + ", descricao=" + descricao + ", moduloURL=" + moduloURL + '}';
    }
    
    
}
