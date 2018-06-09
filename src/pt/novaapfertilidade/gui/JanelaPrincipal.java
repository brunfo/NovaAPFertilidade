package pt.novaapfertilidade.gui;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.apf.Parceiro;

import java.util.InputMismatchException;

public class JanelaPrincipal {

    //Singleton
    private static JanelaPrincipal instance = new JanelaPrincipal();

    public static JanelaPrincipal getInstance() {
        return instance;
    }

    private JanelaPrincipal() {
        JanelaPrincipal.aPFertilidade = APFertilidade.getInstance();
    }
    //singleton

    private static APFertilidade aPFertilidade;

    public void visualizar(){
        System.out.println("\n\nGUI em Desenvolvimento\n\n");
    }

    public void verMenu(){
        System.out.println("1 - Listar todos" +
                            "\n2 - Filtrar lista de Parceiros" +
                            "\n3 - Remover todos os filtros" +
                            "\n4 - Criar Parceiro" +
                            "\n5 - Editar Parceiro" +
                            "\n6 - Apagar Parceiro" +
                            "\n7 - Procurar Parceiro" +
                            "\n9 - Sair");
    }

    public void mostraMensagemErro(Exception ex){

        if (ex instanceof InputMismatchException)
            System.out.println("\n**************************ALERTA**************************\n" +
                                 "A opção selecionada não é válida! Insira uma opção válida!\n" +
                                 "**********************************************************\n");
        if (ex.toString() instanceof String)
            System.out.println(ex);

    }

    /**
     * Lista todos os Parceiros contidos no business model
     */
    public void listarParceiros() {

        System.out.println("\n******************\nLista de Parceiros\n");
        for (Parceiro parceiro: aPFertilidade.getParceiros()){
            System.out.println(parceiro);
        }
        System.out.println("\n******************\n\n\n");
    }


}
