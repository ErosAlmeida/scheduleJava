import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contato {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String nome;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    private String telefone;

    public void validarDados() throws AgendaException {
        validarDados();
        validarTelefone();
    }

    private void validarNome() throws AgendaException{
        if(nome == null || nome.trim().length() == 0){
            throw new AgendaException("O nome da agenda não é valido");
        }
    }

    private void validarTelefone() throws AgendaException {
        String regex = "\\d\\d\\d\\d-\\d\\d\\d\\d";
        Pattern p = Pattern.compile(regex);
        Matcher m =  p.matcher(telefone);

        if(!m.matches()){
            throw new AgendaException("O telefone " + telefone + " não é válido");
        }
    }


    public String toString() {
        return nome + " -> " + telefone;
    }
}