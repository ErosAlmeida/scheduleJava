import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contato {
    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    private String nome;
    private String telefone;


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void validarDados() throws AgendaException {
        validarNome();
        validarTelefone();
    }


    private void validarNome() throws AgendaException {
        if (nome == null || nome.trim().length() == 0) {
            throw new AgendaException("O nome do contato não pode ser vazio");
        }
    }


    private void validarTelefone() throws AgendaException {
        // Utiliza uma expressão regular para fazer a validação
        String regex = "\\d\\d\\d\\d-\\d\\d\\d\\d";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(telefone);

        if (!m.matches()) {
            throw new AgendaException("O telefone " + telefone + " não é válido");
        }
    }
    public String toString() {
        return nome + " -> " + telefone;
    }
}
