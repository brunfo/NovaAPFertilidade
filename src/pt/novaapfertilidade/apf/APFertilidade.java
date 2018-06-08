package pt.novaapfertilidade.apf;

import pt.novaapfertilidade.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class APFertilidade {

    //Singleton
    private static APFertilidade instance = new APFertilidade();
    //Lista de Parceiros
    private static List<Parceiro> parceiros= new ArrayList<>();
    private static List<Parceiro> parceirosFiltrados = new ArrayList<>();
    //singleton

    //Objecto de armazenamento
    private DAO armazenamento;

    private APFertilidade() {
    }

    public static APFertilidade getInstance() {
        return instance;
    }

    /**
     * Define o objecto de armazenamento
     * @param armazenamento - Objecto a ser assignado como armazenamento
     */
    public void setStorage(DAO armazenamento){
        this.armazenamento=armazenamento;
    }

    /**
     * Introduz um novo parceiro na lista
     * @param novoParceiro - Parceiro a introduzir na lista
     */
      void criarParceiro(Parceiro novoParceiro){
          //TODO - criar opções se já existe parceiro na Lista
        parceiros.add(novoParceiro);

    }

    /**
     * Remove um parceiro da lista de Parceiros
     *
     * @param parceiro Parceiro a ser removido
     */
    void removerParceiro(Parceiro parceiro) {
        parceiros.remove(parceiro);
    }

    /**
     * Lista de Parceiros filtrada ou não
     * @return Lista de Parceiros
     */
    public List<Parceiro> getParceiros() {
        if (parceirosFiltrados.isEmpty()) return parceiros;
        else return parceirosFiltrados;
    }

    /**
     * Aplica um filtro à lista de Parceiros
     * @param filtro - Filtro a ser aplicado
     * @param valor - Valor do filtro a ser aplicado
     */
     void aplicarFiltro(String filtro, String valor){
         if (filtro==null || filtro.equals("") || valor == null || valor.equals("")){
            return;
        }
        List<Parceiro> parceirosTemp= new ArrayList<>();//Instancia temporaria para filtrar a lista previamente filtrada
        for(Parceiro parceiro: getParceiros()){
            if (filtro.equalsIgnoreCase("ID")){
                if (parceiro.getIdParceiro()==Integer.parseInt(valor)){
                    parceirosTemp.add(parceiro);
                }
            }
            if(filtro.equalsIgnoreCase("tipo")){
                if(parceiro.getTipoParceiro().equalsIgnoreCase(valor)){
                    parceirosTemp.add(parceiro);
                }
            }
        }
        parceirosFiltrados=parceirosTemp; //atribui lista filtrada à referência de filtragem
    }

    /**
     * Remove todos os filtros aplicados à lista de Parceiros
     */
    void removerFiltro(){ parceirosFiltrados.clear();
    }


    /**
     * Adiciona um benefício a um parceiro
     *
     * @param parceiro  O Parceiro
     * @param beneficio O Benefício
     */
    void criarBeneficio(Parceiro parceiro, Beneficio beneficio) {
        parceiro.getBeneficios().add(beneficio);
    }

    /**
     * Removo um benefício de um parceiro
     *
     * @param parceiro  O Parceiro
     * @param beneficio O Benefício
     */
    void removerBeneficio(Parceiro parceiro, Beneficio beneficio) {
        parceiro.getBeneficios().remove(beneficio);
    }
}
