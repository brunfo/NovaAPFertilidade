package pt.novaapfertilidade.apf;

import pt.novaapfertilidade.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class APFertilidade {

    //Singleton
    private static APFertilidade instance = new APFertilidade();
    //Lista de Parceiros
    private static List<Parceiro> parceiros = new ArrayList<>();
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
     *
     * @param armazenamento - Objecto a ser assignado como armazenamento
     */
    public void setStorage(DAO armazenamento) {
        this.armazenamento = armazenamento;
    }

    /**
     * Introduz um novo parceiro na lista
     *
     * @param novoParceiro - Parceiro a introduzir na lista
     */
    void criaParceiro(Parceiro novoParceiro) {
        int index = verificaDuplicado(novoParceiro);
        if (index == -1)
            parceiros.add(novoParceiro);
        else if (substituiParceiro(index))
            editaParceiro(index, novoParceiro);
    }

    /**
     * Verifica se na lista de Parceiros já existe o novo Parceiro
     *
     * @param novoParceiro Novo Parceiro
     * @return Index do duplicado, ou -1 se não existir
     */
    private int verificaDuplicado(Parceiro novoParceiro) {
        for (Parceiro parceiro : parceiros)
            if (parceiro.getIdParceiro() == novoParceiro.getIdParceiro() ||
                    parceiro.getNome().equals(novoParceiro.getNome()) &&
                            parceiro.getMorada().equals(novoParceiro.getMorada()))
                return parceiros.indexOf(parceiro);
        return -1;
    }

    /**
     * Edita um Parceiro, substituindo-o por um novo Parceiro com novos dados
     *
     * @param index index do Parceiro a ser substituido.
     * @param novoParceiro Novo parceiro a ser inserido
     */
    void editaParceiro(int index, Parceiro novoParceiro) {
        parceiros.set(index, novoParceiro);
    }

    /**
     * Enviar mensagem de alerta que existem um duplicado, perguntado se quer substituir e recebe resposta de utilizador.
     *
     * @param index index do elemento duplicado
     * @return false para não substituir, trua para substituir
     */
    boolean substituiParceiro(int index) {
        //TODO enviar mensagem de alerta para janela que existem um duplicado, perguntando se quer substituir
        //TODO receber resposta de utilizador se quer substituir
        System.out.println("\n\nALERTA - Duplicado encontrado, processo de susbtituição em desenvolvimento\n\n");
        return false;
    }

    /**
     * Cria um clone de um Parceiro através da criação de uma nova instancia pelo metodo de contrutor
     *
     * @param parceiro Parceiro a ser clonado
     * @return Clone do Parceiro
     */
    Parceiro clonaParceiro(Parceiro parceiro) {
        List<Beneficio> beneficios = new ArrayList<>();

        parceiro.getBeneficios().addAll(beneficios);

        return new Parceiro(parceiro.getTipoParceiro(),
                parceiro.getIdParceiro(),
                parceiro.getNome(),
                parceiro.getMorada(),
                parceiro.getCodigoPostal(),
                parceiro.getLocalidade(),
                parceiro.getConcelho(),
                parceiro.getDistrito(),
                parceiro.getTelefone(),
                parceiro.getFax(),
                parceiro.getEmail(),
                parceiro.getWebSite(),
                beneficios);
    }

    /**
     * Remove um parceiro da lista de Parceiros
     *
     * @param parceiro Parceiro a ser removido
     */
    void removeParceiro(Parceiro parceiro) {
        parceiros.remove(parceiro);
    }

    /**
     * Lista de Parceiros filtrada ou não
     *
     * @return Lista de Parceiros
     */
    public List<Parceiro> getParceiros() {
        if (parceirosFiltrados.isEmpty()) return parceiros;
        else return parceirosFiltrados;
    }

    /**
     * Aplica um filtro à lista de Parceiros
     *
     * @param filtro - Filtro a ser aplicado
     * @param valor  - Valor do filtro a ser aplicado
     */
    void aplicaFiltro(String filtro, String valor) {
        if (filtro == null || filtro.equals("") || valor == null || valor.equals("")) {
            return;
        }
        List<Parceiro> parceirosTemp = new ArrayList<>();//Instancia temporaria para filtrar a lista previamente filtrada
        for (Parceiro parceiro : getParceiros()) {
            if (filtro.equalsIgnoreCase("ID")) {
                if (parceiro.getIdParceiro() == Integer.parseInt(valor)) {
                    parceirosTemp.add(parceiro);
                }
            }
            if (filtro.equalsIgnoreCase("tipo")) {
                if (parceiro.getTipoParceiro().equalsIgnoreCase(valor)) {
                    parceirosTemp.add(parceiro);
                }
            }
        }
        parceirosFiltrados = parceirosTemp; //atribui lista filtrada à referência de filtragem
    }

    /**
     * Remove todos os filtros aplicados à lista de Parceiros
     */
    void removeFiltros() {
        parceirosFiltrados.clear();
    }


    /**
     * Adiciona um benefício a um parceiro
     *
     * @param parceiro  O Parceiro
     * @param beneficio O Benefício
     */
    void adicionaBeneficio(Parceiro parceiro, Beneficio beneficio) {
        parceiro.getBeneficios().add(beneficio);
    }

    /**
     * Removo um benefício de um parceiro
     *
     * @param parceiro  O Parceiro
     * @param beneficio O Benefício
     */
    void removeBeneficio(Parceiro parceiro, Beneficio beneficio) {
        parceiro.getBeneficios().remove(beneficio);
    }
}
