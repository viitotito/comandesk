package comandesk;

public class Garcom extends Pessoa {

    //Atributo exclusiva da classe garcom.
    private String id;

    //Atributos herdados da classe abstrata pessoa.
    public Garcom(String nome, String cpf, String email, String telefone, String id) {
        super(nome, cpf, email, telefone);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Sobreescrita da interface IInfoGerais implementada na classe mãe Pessoa.
    @Override
    public void exibirInformacoes() {
        System.out.println("\nId Garçom: " + getId() + "\nNome Garçom: " + getNome() + "\nCpf Garçom: " + getCpf() + "\nEmail Garçom: " + getEmail() + "\nTelefone Garçom: " + getTelefone());
    }

}
