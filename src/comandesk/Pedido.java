package comandesk;

public class Pedido {

    //Atributos da classe pedido.
    //Utiliza-se uma classe chamada produto.
    private Produto produto;
    private int quantidade;

    public Pedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //Controla o cálculo de cada pedido.
    public double calcularParcial() {

        return produto.getPreco() * quantidade;

    }
}
