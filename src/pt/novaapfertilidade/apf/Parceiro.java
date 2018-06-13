package pt.novaapfertilidade.apf;

import java.util.ArrayList;
import java.util.List;

public class Parceiro {

    private String tipoParceiro;
    private int idParceiro;
    private String nome;
    private String morada;
    private String codigoPostal;
    private String localidade;
    private String concelho;
    private String distrito;
    private String telefone;
    private String fax;
    private String email;
    private String webSite;
    private List<Beneficio> beneficios = new ArrayList<>();


    public Parceiro(String tipoParceiro, int idParceiro, String nome) {
        this(tipoParceiro,
                idParceiro,
                nome,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                new ArrayList<>());
    }

    Parceiro(String tipoParceiro,
             int idParceiro,
             String nome,
             String morada,
             String codigoPostal,
             String localidade,
             String concelho,
             String distrito,
             String telefone,
             String fax,
             String email,
             String webSite,
             List<Beneficio> beneficios) {

        this.tipoParceiro = tipoParceiro;
        this.idParceiro = idParceiro;
        this.nome = nome;
        this.morada = morada;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
        this.concelho = concelho;
        this.distrito = distrito;
        this.telefone = telefone;
        this.fax = fax;
        this.email = email;
        this.webSite = webSite;
        if (beneficios != null)
            this.beneficios = beneficios;
    }

    public String toString() {
        return tipoParceiro + " => " + idParceiro + " : " + nome +
                "\tBeneficios: " + getBeneficios();
    }


    int getIdParceiro() {
        return idParceiro;
    }

    String getTipoParceiro() {
        return tipoParceiro;
    }

    public void setTipoParceiro(String tipoParceiro) {
        this.tipoParceiro = tipoParceiro;
    }

    public void setIdParceiro(int idParceiro) {
        this.idParceiro = idParceiro;
    }

    String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    List<Beneficio> getBeneficios() {
        return beneficios;
    }

    void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }
}
