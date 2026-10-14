import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Agenda {

    private final Map<String, Contato> contatosMap = new TreeMap<>();
    private final Map<Character, List<Contato>> contatosPorLetrasMap =
            new TreeMap<>();

    private final ArquivoAgenda arquivo = new ArquivoAgenda();

    public Agenda() throws IOException {
        List<Contato> contatos = null;
        try {
            contatos = arquivo.ler();
        } catch (AgendaException e) {
            throw new RuntimeException(e);
        }

        for (Contato contato : contatos) {
            try {
                adicionarEmMemoria(contato);
            } catch (AgendaException e) {
                throw new IOException(
                        "Não foi possível carregar um contato do arquivo.",
                        e
                );
            }
        }
    }

    public void inserir(Contato contato)
            throws AgendaException, IOException {

        adicionarEmMemoria(contato);
        arquivo.gravar(contatosMap.values());
    }

    public void alterar(Contato novoContato)
            throws AgendaException, IOException {

        Objects.requireNonNull(novoContato, "O contato não pode ser nulo.");
        novoContato.validarDados();

        String chave = normalizarNome(novoContato.getNome());

        Contato contatoAntigo = contatosMap.get(chave);

        if (contatoAntigo == null) {
            throw new AgendaException(
                    "Contato " + novoContato.getNome() + " não encontrado."
            );
        }

        // Atualiza o contato principal.
        contatosMap.put(chave, novoContato);

        // Atualiza também a lista agrupada pela letra inicial.
        char letra = letraInicial(contatoAntigo.getNome());
        List<Contato> contatosDaLetra = contatosPorLetrasMap.get(letra);

        int indice = contatosDaLetra.indexOf(contatoAntigo);

        if (indice >= 0) {
            contatosDaLetra.set(indice, novoContato);
        }

        arquivo.gravar(contatosMap.values());
    }

    public void excluir(String nome)
            throws AgendaException, IOException {

        String chave = normalizarNome(nome);

        Contato contato = contatosMap.get(chave);

        if (contato == null) {
            throw new AgendaException("Contato " + nome + " não encontrado.");
        }

        contatosMap.remove(chave);

        char letra = letraInicial(contato.getNome());
        List<Contato> contatosDaLetra = contatosPorLetrasMap.get(letra);

        contatosDaLetra.remove(contato);

        if (contatosDaLetra.isEmpty()) {
            contatosPorLetrasMap.remove(letra);
        }

        arquivo.gravar(contatosMap.values());
    }

    public List<Contato> listarContatosPorLetra(char letra) {
        List<Contato> contatos =
                contatosPorLetrasMap.get(Character.toUpperCase(letra));

        return contatos == null ? List.of() : List.copyOf(contatos);
    }

    public List<Contato> listarContatosPorParteNome(String parteNome) {
        Objects.requireNonNull(parteNome, "O texto da busca não pode ser nulo.");

        String busca = normalizarNome(parteNome);
        List<Contato> encontrados = new ArrayList<>();

        Collection<Contato> contatos = contatosMap.values();

        for (Contato contato : contatos) {
            String nome = normalizarNome(contato.getNome());

            if (nome.contains(busca)) {
                encontrados.add(contato);
            }
        }

        return List.copyOf(encontrados);
    }

    public Contato obterContato(String nome) {
        return contatosMap.get(normalizarNome(nome));
    }

    private void adicionarEmMemoria(Contato contato)
            throws AgendaException {

        Objects.requireNonNull(contato, "O contato não pode ser nulo.");
        contato.validarDados();

        String chave = normalizarNome(contato.getNome());

        if (contatosMap.containsKey(chave)) {
            throw new AgendaException(
                    "O contato " + contato.getNome() + " já existe."
            );
        }

        contatosMap.put(chave, contato);

        char letra = letraInicial(contato.getNome());

        contatosPorLetrasMap
                .computeIfAbsent(letra, k -> new ArrayList<>())
                .add(contato);
    }

    private String normalizarNome(String nome) {
        return Objects.requireNonNull(nome)
                .trim()
                .toLowerCase(Locale.ROOT);
    }

    private char letraInicial(String nome) {
        return Character.toUpperCase(nome.trim().charAt(0));
    }
}