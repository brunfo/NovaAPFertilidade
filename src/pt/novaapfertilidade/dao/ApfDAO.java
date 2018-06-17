package pt.novaapfertilidade.dao;

import pt.novaapfertilidade.model.Parceiro;

import java.util.List;

public interface ApfDAO {
    /**
     * Lê na base de dados a lista de Parceiros
     *
     * @return Lista de Parceiros
     */
    List<Parceiro> getParceiros();

    /**
     * Grava na base dados lista de Parceiros
     *
     */
    void setParceiros(List<Parceiro> parceiros);


}
