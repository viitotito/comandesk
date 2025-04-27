package comandesk;

public class Mesa {

    //Atributos da classe mesa.
    private int numero;
    private String localizacao;
    private boolean disponivel;

    public Mesa(int numero, String localizacao, boolean disponivel) {
        this.numero = numero;
        this.localizacao = localizacao;
        this.disponivel = disponivel;
    }

    public int getNumero() {
        return numero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //Controla a disponibilidade da mesa.
    public void ocuparMesa() {
        setDisponivel(false);
    }

    //Controla a disponibilidade da mesa.
    public void desocuparMesa() {
        setDisponivel(true);
    }

    //Sobreescrita diretamente da interface IInfoGerais.
    public void exibirInformacoes() {
        System.out.println("\nNúmero mesa: " + getNumero() + "\nLocalização: " + getLocalizacao() + "\nDisponibilidade atual: " + (isDisponivel() ? "Aberta" : "Fechada"));
    }
}
