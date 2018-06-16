package pt.novaapfertilidade.apf;

import pt.novaapfertilidade.gui.Consola;
import pt.novaapfertilidade.gui.GUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilizador {

    private static APFertilidade aPFertilidade = APFertilidade.getInstance();
    private static GUI janela = GUI.getInstance();

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

    public static void adicionarParceiro() {
        aPFertilidade.criaParceiro();
    }


    public static void removeParceiro(Parceiro parceiro) {
        aPFertilidade.removeParceiro(parceiro);
    }

    private static Parceiro getParceiro(String parametro) {
        return aPFertilidade.getParceiro(parametro);
    }

    public static Parceiro getParceiro(int parametro) {
        return getParceiro(Integer.toString(parametro));
    }

    public static void adicionaBeneficio(Parceiro parceiro, String beneficio) {
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

    public static void gravaDados() {
        aPFertilidade.gravarDados();
    }

    public static void leDados() {
        aPFertilidade.lerDados();
    }


    public static String reponde() {

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
