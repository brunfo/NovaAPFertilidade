package pt.novaapfertilidade;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.apf.Parceiro;
import pt.novaapfertilidade.apf.Utilizador;
import pt.novaapfertilidade.dao.DAO;
import pt.novaapfertilidade.gui.JanelaPrincipal;

public class App {

    private static APFertilidade aPFertilidade=APFertilidade.getInstance();
    private static JanelaPrincipal janela=JanelaPrincipal.getInstance();

    public static void main(String[] args){
        //inicializa a persistence storage
        DAO armazenamento = new DAO();
        //business object
        aPFertilidade.setStorage (armazenamento);

        janela.visualizar();

        simular();
    }

    private static void simular(){
        Utilizador.criarParceiro(new Parceiro(1, "Farmácia Silva", "Farmácia"));
        Utilizador.criarParceiro(new Parceiro(2, "Farmácia Calado", "Farmácia"));
        Utilizador.criarParceiro(new Parceiro(3, "Farmácia Mateus", "Farmácia"));
        Utilizador.criarParceiro(new Parceiro(4, "Farmácia da Republica", "Farmácia"));
        Utilizador.criarParceiro(new Parceiro(5, "Hotel Inn", "Hotéis"));

        Utilizador.verMenu();

        Utilizador.listarParceiros();
        Utilizador.aplicarFiltro("ID", "2");
        Utilizador.listarParceiros();
        Utilizador.removerFiltro();
        Utilizador.listarParceiros();
        Utilizador.aplicarFiltro("tipo", "farmácia");
        Utilizador.listarParceiros();
        //aplica filtro sobre lista filtrada
        Utilizador.aplicarFiltro("ID", "3");
        Utilizador.listarParceiros();


        /*
        int sair=0;
        do {
            utilizador.verMenu();
            sair=utilizador.digitarOpcao();
            switch(sair){
                case 1: utilizador.listarParceiros();
                break;
            }
        }while(sair!=9);
        */
    }
}
