import java.util.List;

public class Menu {

    public static final int OPCAO_INSERIR = 1;
    public static final int OPCAO_ALTERAR = 2;
    public static final int OPCAO_EXCLUIR = 3;
    public static final int OPCAO_LISTAR_LETRA = 4;
    public static final int OPCAO_PROCURAR = 5;
    public static final int OPCAO_SAIR = 6;

    private static final List<String> OPCOES = List.of(
            "Inserir contato",
            "Alterar contato",
            "Excluir contato",
            "Listar contatos por letra",
            "Procurar contatos",
            "Sair"
    );

    public int exibirOpcoes() throws AgendaException {
        System.out.println("""
                ==========================
                      AGENDA DE CONTATOS
                ==========================
                """);

        for (int i = 0; i < OPCOES.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, OPCOES.get(i));
        }

        System.out.print("\nEscolha uma opção: ");

        int opcao = Console.readInt();

        if (opcao < OPCAO_INSERIR || opcao > OPCAO_SAIR) {
            throw new AgendaException("Opção inválida.");
        }

        return opcao;
    }
}