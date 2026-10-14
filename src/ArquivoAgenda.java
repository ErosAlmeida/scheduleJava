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

    /**
     * Gravar os contatos no arquivo.
     * @param contatos Contatos a serem gravados.
     */
    public void gravar(Collection<Contato> contatos) throws IOException{
        PrintWriter write = null;
        try {
            write = new PrintWriter(ARQUIVO_AGENDA);
            for (Contato contato: contatos){
                write.print(contato.getNome());
                write.print(",");
                write.println(contato.getTelefone());
            }
        }finally {
            if (write != null){
                write.close();
            }
        }
    }

    public List<Contato> ler() {
        List<Contato> contatos = new ArrayList<Contato>();

        Scanner scanner = null;

        try {
            // Utiliza um scanner para ler os dados do arquivo
            scanner = new Scanner(new File(ARQUIVO_AGENDA));
            while (scanner.hasNextLine()) {
                String contatoStr = scanner.nextLine();

                // Divide cada linha do arquivo em tokens, onde o caractere ',' é o delimitador
                String[] tokens = contatoStr.split(",");

                // Cria o objeto de Contato com base nos tokens
                Contato contato = new Contato(tokens[0], tokens[1]);

                // Adiciona o contato à lista de contatos
                contatos.add(contato);
            }

            return contatos;
        } catch (FileNotFoundException e) {
            // Se o arquivo de contatos não for encontrado, retorna a lista vazia
            return contatos;

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}