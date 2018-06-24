package pt.novaapfertilidade.apf;

import pt.novaapfertilidade.dao.ApfDAO;
import pt.novaapfertilidade.gui.Consola;
import pt.novaapfertilidade.gui.GUI;
import pt.novaapfertilidade.model.Beneficio;
import pt.novaapfertilidade.model.Parceiro;

import java.util.ArrayList;
import java.util.List;

public class APFertilidade {

    //Singleton
    private static APFertilidade instance = new APFertilidade();

    private APFertilidade() {
    }

    public static APFertilidade getInstance() {
        return instance;
    }    //Lista de Parceiros
    //singleton

    private static List<Parceiro> parceiros = new ArrayList<>();
    private static List<Parceiro> parceirosFiltrados = new ArrayList<>();

    //Objecto de armazenamento
    private ApfDAO armazenamento;

    //Definições de user interface
    private static String userInterface;

    public static String getUserInterface() {
        return userInterface;
    }

    public void setUserInterface(String userInterface) {
        APFertilidade.userInterface = userInterface;
    }

    /**
     * Define o objecto de armazenamento
     *
     * @param armazenamento - Objecto a ser assignado como armazenamento
     */
    public void setStorage(ApfDAO armazenamento) {
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
     * Metodo para criar um novo parceiro, a partir de objecto sem valores(
     */
    void criaParceiro() {
        Parceiro novoParceiro = new Parceiro();
        
        //envia para a gui a criação de novo parceiro
        GUI.criaParceiro(novoParceiro);

        criaParceiro(novoParceiro);
        gravarDados();

    }

    private void verificaUltimoId() {
        for (Parceiro iterador : parceiros) {
            int iteradorId = iterador.getIdParceiro();
            if (iteradorId >= Parceiro.getUltimoId())
                Parceiro.setUltimoId(iteradorId + 1);
        }
    }

    /**
     * Verifica se na lista de Parceiros já existe o novo Parceiro.
     * Pode conter o mesmo nome, desde que morada seja diferente.
     *
     * @param novoParceiro Novo Parceiro
     * @return Index do duplicado, ou -1 se não existir
     */
    private int verificaDuplicado(Parceiro novoParceiro) {
        for (Parceiro parceiro : parceiros)
            if (parceiro.getIdParceiro() == novoParceiro.getIdParceiro() ||
                    (parceiro.getNome().equals(novoParceiro.getNome()) &&
                            parceiro.getMorada().equals(novoParceiro.getMorada())))
                return parceiros.indexOf(parceiro);
        return -1;
    }

    /**
     * Edita um Parceiro, substituindo-o por um novo Parceiro com novos dados
     *
     * @param index        index do Parceiro a ser substituido.
     * @param novoParceiro Novo parceiro a ser inserido
     */
    private void editaParceiro(int index, Parceiro novoParceiro) {
        parceiros.set(index, novoParceiro);
    }

    /**
     * Enviar mensagem de alerta que existem um duplicado, perguntado se quer substituir e recebe resposta de utilizador.
     *
     * @param index index do elemento duplicado
     * @return false para não substituir, trua para substituir
     */
    private boolean substituiParceiro(int index) {
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
    private Parceiro clonaParceiro(Parceiro parceiro) {
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
        gravarDados();
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
            if (filtro.equalsIgnoreCase("localidade")) {
                if (parceiro.getLocalidade().equalsIgnoreCase(valor)) {
                    parceirosTemp.add(parceiro);
                }
            }
        }
        parceirosFiltrados = parceirosTemp; //atribui lista filtrada à referência de filtragem
    }

    /**
     * Remove todos os filtros aplicados à lista de Parceiros
     */
    void limparFiltros() {
        parceirosFiltrados.clear();
    }


    /**
     * Adiciona um benefício a um parceiro. Testa se o Parceiro já tem uma lista de Beneficios,
     * senão cria-a.
     * Verifica se na lista existente já existe beneficio a adicionar, só verifica strings exatas,
     * ignorando maiúsculas e minúsculas.
     *
     * @param parceiro  O Parceiro
     * @param beneficio O Benefício
     */
    void adicionaBeneficio(Parceiro parceiro, String beneficio) {
        try {
            List<Beneficio> beneficios = parceiro.getBeneficios();
            Beneficio novoBeneficio = new Beneficio(beneficio);

            boolean existe = false;
            if (beneficios == null)
                parceiro.setBeneficios(new ArrayList<>());
            else {

                for (Beneficio iterado : beneficios) {
                    existe = (iterado.toString().equalsIgnoreCase(novoBeneficio.toString()));
                }
            }
            if (!existe)
                if (beneficios != null) {
                    beneficios.add(novoBeneficio);
                }
        } catch (NullPointerException ex) {
            System.err.println("Parceiro não existe");
        }
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

    void gravarDados() {
        limparFiltros();
        armazenamento.setParceiros(getParceiros());
    }

    public void lerDados() {
        parceiros = armazenamento.getParceiros();
        verificaUltimoId();
    }

    /**
     * Procura na lista de parceiros se o parceiro existe.
     * Testa se o parametro passado é um inteiro, procurando assim pelo id, senão procura por nome.
     *
     * @param parametro ID do Parceiro ou nome.
     * @return Parceiro ou null.
     */
    Parceiro getParceiro(String parametro) {
        try {
            for (Parceiro parceiro : parceiros) {
                if (isInteger(parametro) && parceiro.getIdParceiro() == Integer.parseInt(parametro)) return parceiro;
                if (parceiro.getNome().equals(parametro)) return parceiro;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    /**
     * Verifica se uma string é um inteiro.
     *
     * @param s String a ser verificada.
     * @return true ou false.
     */
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // só returna true se a string é um inteiro
        return true;
    }


}
