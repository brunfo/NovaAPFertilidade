package pt.novaapfertilidade.gui;

import pt.novaapfertilidade.apf.APFertilidade;
import pt.novaapfertilidade.apf.Parceiro;
import pt.novaapfertilidade.apf.Utilizador;

import java.util.InputMismatchException;

import static pt.novaapfertilidade.apf.Utilizador.adicionaBeneficio;

public class Consola implements GUI {

    //Singleton
    private static GUI instance = new Consola();

    private Consola() {
        Consola.aPFertilidade = APFertilidade.getInstance();
    }

    static GUI getInstance() {
        return Consola.instance;
    }
    //singleton

    private static APFertilidade aPFertilidade;

    @Override
    public void iniciar() {
        aPFertilidade.lerDados();
        iniciaCiclo();
    }

    private void iniciaCiclo() {
        String utilizador;
        String opcao = null;
        do {
            verMenu();
            utilizador = Utilizador.responde().trim();
            if (utilizador.contains(":")) {
                opcao = utilizador.substring(utilizador.indexOf(":") + 1).trim();
                utilizador = utilizador.substring(0, utilizador.indexOf(":")).trim();
            }
            switch (utilizador) {
                case "localidade":
                    Utilizador.aplicaFiltro("localidade", opcao);
                case "listar":
                    Utilizador.listaParceiros();
                    mensagem("Prima Enter para continuar...");
                    break;
                case "limparfiltros":
                    Utilizador.limparFiltros();
                    mensagem("Prima Enter para continuar...");
                    break;
                case "novo":
                    Utilizador.adicionarParceiro();
                    break;
                case "procurar":
                    System.out.println(Utilizador.getParceiro(opcao).toString() + "\n\n");
                    mensagem("Prima Enter para continuar...");
                    break;
                case "editar":
                    mensagem("\nOpção em desenvolvimento\nPrima tecla para continuar...");
                    break;
                case "apagar":
                    Parceiro apagarParceiro = Utilizador.getParceiro(opcao);
                    if (apagarParceiro != null) {
                        if ((mensagem("Tem a certeza que quer apargar o Parceiro('sim' para apagar)?\n" +
                                apagarParceiro.toString() + "\n\n".charAt(0)).equalsIgnoreCase("sim"))) {
                            Utilizador.removeParceiro(apagarParceiro);
                            mensagem("Parceiro apagado. Enter para continuar...");
                        } else
                            mensagem("Ação cancelada. Enter para continuar...");
                    }
                    break;
            }
        } while (!utilizador.equals("sair"));
    }

    @Override
    public void verMenu() {
        System.out.println("NovaAPFertilidade - Listagem, filtragem e edição de parceiros " +
                "que atribuem benefícios e descontos a associados.");
        System.out.println("1.0.0-beta"); //TODO semantic versioning
        System.out.println("Bruno Rego@2018\n");
        System.out.println("Escolha uma opção:\n");

        System.out.println("listar\t\t\t\t\t\t\t\t\t\t\t\t- Listar os Parceiros, a totalidade ou préviamente filtrados." +
                "\nlocalidade\t\t\t\t\t\t\t\t\t\t\t- Filtrar lista de Parceiros por localidade introduzida." +
                "\nfiltrar\t\t\t\t\t\t\t\t\t\t\t\t- Filtrar lista de Parceiros." +
                "\nlimparfiltros\t\t\t\t\t\t\t\t\t\t- Limpa todos os filtros aplicados." +
                "\nnovo\t\t\t\t\t\t\t\t\t\t\t\t- Criar novo Parceiro." +
                "\neditar:[Id do Parceiro] ou [Nome do Parceiro] \t\t- Editar um Parceiro." +
                "\napagar:[Id do Parceiro] ou [Nome do Parceiro] \t\t- Apagar um Parceiro." +
                "\nprocurar:[Id do Parceiro] ou [Nome do Parceiro] \t- Procurar um Parceiro." +
                "\nsair\t\t\t\t\t\t\t\t\t\t\t\t- Sair da aplicação\n");

        System.out.print("NovaAPFertilidade$ ");
    }

    @Override
    public void mostraMensagemErro(Exception ex) {

        if (ex instanceof InputMismatchException)
            System.out.println("\n**************************ALERTA**************************\n" +
                    "A opção selecionada não é válida! Insira uma opção válida!\n" +
                    "**********************************************************\n");
        if (ex.toString() != null) {
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Lista todos os Parceiros contidos no business model
     */
    @Override
    public void listarParceiros() {

        System.out.println("\n******************\nLista de Parceiros\n");
        for (Parceiro parceiro : aPFertilidade.getParceiros()) {
            System.out.println(parceiro);
        }
        System.out.println("\n******************\n");
    }

    @Override
    public String mensagem(String msg) {
        System.out.print(msg);
        return Utilizador.responde();
    }

    public void criaParceiro(Parceiro novoParceiro) {
        String strTemp;
        do
            strTemp = mensagem("Introduza tipo de Parceiro: ");
        while (strTemp.isEmpty());
        novoParceiro.setTipoParceiro(strTemp);

        do
            strTemp = mensagem("Introduza nome:  ");
        while (strTemp.isEmpty());
        novoParceiro.setNome(strTemp);

        novoParceiro.setMorada(mensagem("Introduza a Morada:"));
        novoParceiro.setCodigoPostal(mensagem("Introduza o Código Postal: "));
        novoParceiro.setLocalidade(mensagem("Introduza a Localidade: "));
        novoParceiro.setConcelho(mensagem("Introduza o Concelho: "));
        novoParceiro.setDistrito(mensagem("Introduza o Distrito: "));
        novoParceiro.setTelefone(mensagem("Introduza o Telefone: "));
        novoParceiro.setFax(mensagem("Introduza o Fax: "));
        novoParceiro.setEmail(mensagem("Introduza o E-mail: "));
        novoParceiro.setWebSite(mensagem("Introduza a página web: "));
        boolean novoBeneficio;
        do {
            adicionaBeneficio(novoParceiro, mensagem("Introduza um benefício: "));
            try {
                novoBeneficio = mensagem("Introduzir novo benefício (s ou Enter para adicionar)?").toLowerCase().charAt(0) == 's';
            } catch (StringIndexOutOfBoundsException ex) {
                novoBeneficio = true;
            }
        } while (novoBeneficio);

    }

}
