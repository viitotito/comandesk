package comandesk;

public class Produto implements IInfoGerais {

    private String nome, marca, unidadeMedida;
    private double preco;

    public Produto(String nome, String marca, String unidadeMedida, double preco) {
        this.nome = nome;
        this.marca = marca;
        this.unidadeMedida = unidadeMedida;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    //Sobreescrita diretamente da interface IInfoGerais.
    @Override
    public void exibirInformacoes() {
        System.out.println("\nNome Produto: " + getNome() + "\nMarca Produto: " + getMarca() + "\nUnidade Medida: " + getUnidadeMedida() + "\nPreço: " + getPreco());
    }
}
