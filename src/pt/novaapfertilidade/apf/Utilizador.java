package pt.novaapfertilidade.apf;

import pt.novaapfertilidade.gui.JanelaPrincipal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilizador {

    private static APFertilidade aPFertilidade= APFertilidade.getInstance();
    private static JanelaPrincipal janela=JanelaPrincipal.getInstance();

    public static void verMenu(){
        janela.verMenu();
    }

    public static int digitarOpcao(){
        //TODO ver forma de seleçao do opçoes do menu
        Scanner scan = new Scanner(System.in);
        try{
            return scan.nextInt();
        } catch( InputMismatchException ex){
            janela.mostraMensagemErro(ex);

        }
        return -1;
    }

    public static void criarParceiro(Parceiro parceiro) {
        aPFertilidade.criarParceiro(parceiro);
    }

    public static void removerParceiro(Parceiro parceiro) {
        aPFertilidade.removerParceiro(parceiro);
    }


    public static void criarBeneficio(Parceiro parceiro, Beneficio beneficio) {
        aPFertilidade.criarBeneficio(parceiro, beneficio);
    }

    public static void removerBeneficio(Parceiro parceiro, Beneficio beneficio) {
        aPFertilidade.removerBeneficio(parceiro, beneficio);
    }

    public static void listarParceiros(){janela.listarParceiros();}

    public static void aplicarFiltro(String filtro, String valor){
        aPFertilidade.aplicarFiltro(filtro, valor);
    }

    public static void removerFiltro(){
        aPFertilidade.removerFiltro();
    }
}
