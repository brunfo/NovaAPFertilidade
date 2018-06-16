package pt.novaapfertilidade;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.apf.Utilizador;
import pt.novaapfertilidade.dao.ApfDAO;
import pt.novaapfertilidade.dao.ImplementacaoAPFDAO;
import pt.novaapfertilidade.gui.GUI;

import java.util.Objects;

public class App {

    public static void main(String[] args){
        //Configurações iniciais
        //inicializa a persistence storage
        ApfDAO armazenamento = new ImplementacaoAPFDAO("data/parceiros.json");
        //business object
        APFertilidade aPFertilidade = APFertilidade.getInstance();
        //configura o armazenamento
        aPFertilidade.setStorage (armazenamento);
        //configura a user interface
        aPFertilidade.setUserInterface("consola");
        //inicia a aplicação
        Objects.requireNonNull(GUI.getInstance()).iniciar();
    }

    private static void simular(){
//        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 1, "Farmácia Silva"));
//        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 2, "Farmácia Calado"));
//        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 2, "Farmácia Mateus"));
//        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 4, "Farmácia da Republica"));
//        Utilizador.adicionaParceiro(new Parceiro("Hotéis", 5, "Hotel Inn"));

//        Utilizador.gravaDados();
        Utilizador.leDados();

        Utilizador.verMenu();

//        Utilizador.listaParceiros();
//        Utilizador.aplicaFiltro("ID", "2");
//        Utilizador.listaParceiros();
//        Utilizador.limparFiltros();
//        Utilizador.listaParceiros();
//        Utilizador.aplicaFiltro("tipo", "farmácia");
//        Utilizador.listaParceiros();
//        //aplica filtro sobre lista filtrada
//        Utilizador.aplicaFiltro("ID", "3");
//        Utilizador.listaParceiros();
//
//        System.out.println(Utilizador.getParceiro(5));
//        System.out.println(Utilizador.getParceiro("Farmácia Silva"));
//
//        Utilizador.adicionaBeneficio(Utilizador.getParceiro(5), "5% de Desconto em tudo");
//        Utilizador.adicionaBeneficio(Utilizador.getParceiro(5), "10% de Desconto em Comparticipados");
//
//
//        System.out.println(Utilizador.getParceiro(5));
//        Utilizador.gravaDados();

        Utilizador.listaParceiros();
        Utilizador.adicionarParceiro();
        Utilizador.listaParceiros();


    }
}
