package pt.novaapfertilidade.dao;

import pt.novaapfertilidade.apf.Parceiro;

import java.util.List;

public interface ApfDAO {
    /**
     * Lê na base de dados a lista de Parceiros
     *
     * @return Lista de Parceiros
     */
    public List<Parceiro> getParceiros();

    /**
     * Grava na base dados lista de Parceiros
     *
     * @return
     */
    public void setParceiros(List<Parceiro> parceiros);


}
