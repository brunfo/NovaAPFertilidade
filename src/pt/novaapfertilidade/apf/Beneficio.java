package pt.novaapfertilidade.apf;

public class Beneficio {

    private String beneficio;


    public Beneficio(String beneficio) {
        setBeneficio(beneficio);
    }

    private String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public String toString() {
        return getBeneficio();
    }
}
