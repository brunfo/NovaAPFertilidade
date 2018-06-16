package pt.novaapfertilidade.gui;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.apf.Parceiro;
import pt.novaapfertilidade.apf.Utilizador;

import java.util.InputMismatchException;

import static pt.novaapfertilidade.apf.Utilizador.adicionaBeneficio;

public class Consola implements GUI {

    //Singleton
    private static GUI instance = new Consola();

    private Consola() {
        Consola.aPFertilidade = APFertilidade.getInstance();
    }

    static GUI getInstance() {
        return Consola.instance;
    }
    //singleton

    private static APFertilidade aPFertilidade;

    @Override
    public void visualizar(){
        System.out.println("\n\nGUI em Desenvolvimento\n\n");
    }

    @Override
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

    @Override
    public void mostraMensagemErro(Exception ex){

        if (ex instanceof InputMismatchException)
            System.out.println("\n**************************ALERTA**************************\n" +
                    "A opção selecionada não é válida! Insira uma opção válida!\n" +
                    "**********************************************************\n");
        if (ex.toString() != null) {
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Lista todos os Parceiros contidos no business model
     */
    @Override
    public void listarParceiros() {

        System.out.println("\n******************\nLista de Parceiros\n");
        for (Parceiro parceiro: aPFertilidade.getParceiros()){
            System.out.println(parceiro);
        }
        System.out.println("\n******************\n\n\n");
    }

    @Override
    public String mensagem(String msg) {
        System.out.println(msg);
        return Utilizador.reponde();
    }


    public void criaParceiro(Parceiro novoParceiro) {
        String strTemp;
        do
            strTemp = mensagem("Introduza tipo de Parceiro: ");
        while (strTemp.isEmpty());
        novoParceiro.setTipoParceiro(strTemp);

        do
            strTemp = mensagem("Introduza nome:  ");
        while (strTemp.isEmpty());
        novoParceiro.setNome(strTemp);

        novoParceiro.setMorada(mensagem("Introduza a Morada:"));
        novoParceiro.setCodigoPostal(mensagem("Introduza o Código Postal: "));
        novoParceiro.setLocalidade(mensagem("Introduza a Localidade: "));
        novoParceiro.setConcelho(mensagem("Introduza o Concelho: "));
        novoParceiro.setDistrito(mensagem("Introduza o Distrito: "));
        novoParceiro.setTelefone(mensagem("Introduza o Telefone: "));
        novoParceiro.setFax(mensagem("Introduza o Fax: "));
        novoParceiro.setEmail(mensagem("Introduza o E-mail: "));
        novoParceiro.setWebSite(mensagem("Introduza a página web: "));
        boolean novoBeneficio;
        do {
            adicionaBeneficio(novoParceiro, mensagem("Introduza um benefício: "));
            try {
                novoBeneficio = mensagem("Introduzir novo benefício (s ou Enter para adicionar)?").toLowerCase().charAt(0) == 's';
            } catch (StringIndexOutOfBoundsException ex) {
                novoBeneficio = true;
            }
        } while (novoBeneficio);

    }


}
