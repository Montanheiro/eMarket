package model;

/**
 *
 * @author Bárbara
 */
public class Permissao {

    private int id;

    private String descricao;
    private String moduloURL;
    private String icon;

    public Permissao() {
    }

    public Permissao(String descricao, String moduloURL, String icon) {
        this.descricao = descricao;
        this.moduloURL = moduloURL;
        this.icon = icon;
    }

    public Permissao(int id, String descricao, String moduloURL, String icon) {
        this.id = id;
        this.descricao = descricao;
        this.moduloURL = moduloURL;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Permissao{" + "id=" + id + ", descricao=" + descricao + ", moduloURL=" + moduloURL + ", icon=" + icon + '}';
    }

    
}
