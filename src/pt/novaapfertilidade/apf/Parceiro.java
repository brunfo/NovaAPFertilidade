package pt.novaapfertilidade.apf;

public class Parceiro {


    private int idParceiro;
    private String nome;
    private String tipoParceiro;

    public Parceiro(int idParceiro, String nome, String tipoParceiro) {
        this.idParceiro = idParceiro;
        this.nome = nome;
        this.tipoParceiro = tipoParceiro;
    }

    public String toString(){
        return tipoParceiro + " => " + idParceiro + " : " + nome;
    }

     int getIdParceiro() {
        return idParceiro;
     }

    String getTipoParceiro() {
        return tipoParceiro;
    }
}
