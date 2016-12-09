package model;

/**
 *
 * @author Bárbara
 */
public class PermissaoCargo {
    
    private int id;

    private int cargoId;
    private int permissaoId;

    public PermissaoCargo() {
    }

    public PermissaoCargo(int cargoId, int permissaoId) {
        this.cargoId = cargoId;
        this.permissaoId = permissaoId;
    }

    public PermissaoCargo(int id, int cargoId, int permissaoId) {
        this.id = id;
        this.cargoId = cargoId;
        this.permissaoId = permissaoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public int getPermissaoId() {
        return permissaoId;
    }

    public void setPermissaoId(int permissaoId) {
        this.permissaoId = permissaoId;
    }

    @Override
    public String toString() {
        return "CargoPermissao{" + "id=" + id + ", cargoId=" + cargoId + ", permissaoId=" + permissaoId + '}';
    }
    
}
