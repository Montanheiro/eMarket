package model;

/**
 *
 * @author Bárbara
 */
public class MovimentacaoFinanceira {

    private int id;

    private double realizado;
    private double aReceber;

    public MovimentacaoFinanceira() {
    }

    public MovimentacaoFinanceira(double realizado) {
        this.realizado = realizado;
    }

    public MovimentacaoFinanceira(int id, double realizado, double aReceber) {
        this.id = id;
        this.realizado = realizado;
        this.aReceber = aReceber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRealizado() {
        return realizado;
    }

    public void setRealizado(double realizado) {
        this.realizado = realizado;
    }

    public double getaReceber() {
        return aReceber;
    }

    public void setaReceber(double aReceber) {
        this.aReceber = aReceber;
    }

    @Override
    public String toString() {
        return "MovimentacaoFinanceira{" + "id=" + id + ", realizado=" + realizado + ", aReceber=" + aReceber + '}';
    }
    
    
}
