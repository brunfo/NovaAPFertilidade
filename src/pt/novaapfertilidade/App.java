package pt.novaapfertilidade;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.apf.Parceiro;
import pt.novaapfertilidade.apf.Utilizador;
import pt.novaapfertilidade.dao.ApfDAO;
import pt.novaapfertilidade.dao.ImplementacaoAPFDAO;
import pt.novaapfertilidade.gui.JanelaPrincipal;

public class App {

    private static APFertilidade aPFertilidade=APFertilidade.getInstance();
    private static JanelaPrincipal janela=JanelaPrincipal.getInstance();

    public static void main(String[] args){
        //inicializa a persistence storage
        ApfDAO armazenamento = new ImplementacaoAPFDAO("data/parceiros.json");
        //business object
        aPFertilidade.setStorage (armazenamento);

        janela.visualizar();

        simular();
    }

    private static void simular(){
        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 1, "Farmácia Silva"));
        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 2, "Farmácia Calado"));
        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 2, "Farmácia Mateus"));
        Utilizador.adicionaParceiro(new Parceiro("Farmácia", 4, "Farmácia da Republica"));
        Utilizador.adicionaParceiro(new Parceiro("Hotéis", 5, "Hotel Inn"));

        Utilizador.gravarDados();
        Utilizador.lerDados();

        Utilizador.verMenu();

        Utilizador.listaParceiros();
        Utilizador.aplicaFiltro("ID", "2");
        Utilizador.listaParceiros();
        Utilizador.removeFiltro();
        Utilizador.listaParceiros();
        Utilizador.aplicaFiltro("tipo", "farmácia");
        Utilizador.listaParceiros();
        //aplica filtro sobre lista filtrada
        Utilizador.aplicaFiltro("ID", "3");
        Utilizador.listaParceiros();


    }
}
