package pt.novaapfertilidade;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.dao.ApfDAO;
import pt.novaapfertilidade.dao.ImplementacaoAPFDAO;
import pt.novaapfertilidade.gui.GUI;

import java.util.Objects;

public class App {
    private static String strVersion = "1.0.0-beta"; //TODO semantic versioning

    public static void main(String[] args) {
        //Configurações iniciais
        //inicializa a persistence storage
        ApfDAO armazenamento = new ImplementacaoAPFDAO("data/parceiros.json");
        //business object
        APFertilidade aPFertilidade = APFertilidade.getInstance();
        //configura o armazenamento
        aPFertilidade.setStorage(armazenamento);
        //configura a user interface
        aPFertilidade.setUserInterface("consola");
        //inicia a aplicação
        Objects.requireNonNull(GUI.getInstance()).iniciar();
    }

    public static String getVersion() {
        return App.strVersion;
    }
    
    static void simula(){
        pt.novaapfertilidade.apf.Utilizador.listaParceiros();
    }
}

