package pt.novaapfertilidade.gui;

public interface GUI {
    //GUI getInstance();

    void visualizar();

    void verMenu();

    void mostraMensagemErro(Exception ex);

    void listarParceiros();

    String mensagem(String msg);
}
