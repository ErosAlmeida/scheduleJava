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

    public void gravar(Collection<Contato> contatos)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(ARQUIVO_AGENDA)) {
            for (Contato contato : contatos) {
                writer.print(contato.getNome());
                writer.print(",");
                writer.println(contato.getTelefone());
            }
        }
    }

    public List<Contato> ler() throws AgendaException {
        List<Contato> contatos = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(ARQUIVO_AGENDA))) {
            while (scanner.hasNextLine()) {
                String contatoStr = scanner.nextLine();

                String[] tokens = contatoStr.split(",");

                Contato contato = new Contato(tokens[0], tokens[1]);

                contatos.add(contato);
            }
        } catch (FileNotFoundException e) {
            throw new AgendaException("Agenda vazia");
        }

        return contatos;
    }
}