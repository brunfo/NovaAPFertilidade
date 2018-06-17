package pt.novaapfertilidade.model;

public class Beneficio {

    private String beneficio;


    public Beneficio(String beneficio) {
        setBeneficio(beneficio);
    }

    private String getBeneficio() {
        return beneficio;
    }

    void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public String toString() {
        return getBeneficio();
    }
}
