package pt.novaapfertilidade.apf;

import pt.novaapfertilidade.gui.JanelaPrincipal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilizador {

    private static APFertilidade aPFertilidade = APFertilidade.getInstance();
    private static JanelaPrincipal janela = JanelaPrincipal.getInstance();

    public static void verMenu() {
        janela.verMenu();
    }

    public static int digitarOpcao() {
        //TODO ver forma de seleçao do opçoes do menu
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        } catch (InputMismatchException ex) {
            janela.mostraMensagemErro(ex);

        }
        return -1;
    }

    public static void adicionaParceiro(Parceiro parceiro) {
        aPFertilidade.criaParceiro(parceiro);
    }

    public static void removeParceiro(Parceiro parceiro) {
        aPFertilidade.removeParceiro(parceiro);
    }

    public static Parceiro getParceiro(String parametro) {
        return aPFertilidade.getParceiro(parametro);
    }

    public static Parceiro getParceiro(int parametro) {
        return getParceiro(Integer.toString(parametro));
    }

    public static void adicionaBeneficio(Parceiro parceiro, Beneficio beneficio) {
        aPFertilidade.adicionaBeneficio(parceiro, beneficio);
    }

    public static void removeBeneficio(Parceiro parceiro, Beneficio beneficio) {
        aPFertilidade.removeBeneficio(parceiro, beneficio);
    }

    public static void listaParceiros() {
        janela.listarParceiros();
    }

    public static void aplicaFiltro(String filtro, String valor) {
        aPFertilidade.aplicaFiltro(filtro, valor);
    }

    public static void removeFiltro() {
        aPFertilidade.removeFiltros();
    }

    public static void gravarDados() {
        aPFertilidade.gravarDados();
    }

    public static void lerDados() {
        aPFertilidade.lerDados();
    }
}
