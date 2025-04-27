package comandesk;

public class Cliente extends Pessoa {

    //Atributos herdados da classe abstrata pessoa.
    public Cliente(String nome, String cpf, String email, String telefone) {
        super(nome, cpf, email, telefone);
    }

    //Sobreescrita da interface IInfoGerais implementada na classe mãe Pessoa.
    @Override
    public void exibirInformacoes() {
        System.out.println("\nNome Cliente: " + getNome() + "\nCpf Cliente: " + getCpf() + "\nEmail Cliente: " + getEmail() + "\nTelefone Cliente: " + getTelefone());
    }
}
