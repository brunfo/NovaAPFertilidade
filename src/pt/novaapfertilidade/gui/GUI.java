package pt.novaapfertilidade.gui;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.model.Parceiro;

public interface GUI {
    /**
     * Mmetodo para definições de sistema de utilização
    */
    static GUI getInstance() {
        if (APFertilidade.getUserInterface().equals("consola"))
            return Consola.getInstance();
        //TODO futuras interfaces de utilização
        return null;
    }
    
    /**
     * Cria um novo parceiro, através de inputs do utilizador.
     * Avalia quais as configurações de interação com utilizador.
     */
    static void criaParceiro(Parceiro novoParceiro){
        if (getInstance() instanceof Consola)
            ((Consola) getInstance()).criaParceiro(novoParceiro);
    }

    void iniciar();

    void verMenu();

    void mostraMensagemErro(Exception ex);

    void listarParceiros();

    String mensagem(String msg);
}
