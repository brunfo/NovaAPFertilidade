package pt.novaapfertilidade.gui;

import pt.novaapfertilidade.apf.APFertilidade;

public interface GUI {
    //metodo para definições de sistema de utilização
    static GUI getInstance() {
        if (APFertilidade.getUserInterface().equals("consola"))
            return Consola.getInstance();
        //TODO futuras interfaces de utilização
        return null;
    }

    void visualizar();

    void verMenu();

    void mostraMensagemErro(Exception ex);

    void listarParceiros();

    String mensagem(String msg);
}
