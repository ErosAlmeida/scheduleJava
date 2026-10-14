import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ArquivoAgenda {

    private static final String ARQUIVO_AGENDA = "agenda.txt";

    public void gravar(Collection<Contato> contatos) throws IOException {
        try (PrintWriter writer = new PrintWriter(ARQUIVO_AGENDA)) {
            for (Contato contato : contatos) {
                writer.println(contato.getNome() + "," + contato.getTelefone());
            }

            if (writer.checkError()) {
                throw new IOException("Não foi possível gravar os contatos.");
            }
        }
    }

    public List<Contato> ler() throws AgendaException {
        List<Contato> contatos = new ArrayList<>();
        File arquivo = new File(ARQUIVO_AGENDA);

        if (!arquivo.exists()) {
            return contatos;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            int numeroLinha = 0;

            while (scanner.hasNextLine()) {
                numeroLinha++;

                String linha = scanner.nextLine().trim();

                // Ignora linhas vazias
                if (linha.isEmpty()) {
                    continue;
                }

                String[] tokens = linha.split(",", 2);

                // Verifica se existem nome e telefone
                if (tokens.length != 2
                        || tokens[0].isBlank()
                        || tokens[1].isBlank()) {
                    throw new AgendaException(
                            "Dados inválidos na linha " + numeroLinha
                                    + " do arquivo agenda.txt."
                    );
                }

                Contato contato = new Contato(
                        tokens[0].trim(),
                        tokens[1].trim()
                );

                contatos.add(contato);
            }

        } catch (FileNotFoundException e) {
            throw new AgendaException("Não foi possível abrir o arquivo agenda.txt.");
        }

        return contatos;
    }
}