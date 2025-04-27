package comandesk;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Conta implements IOperacoesConta {

    private Mesa mesa;

    //Utilizando o ArrayList para adicionar pedidos.
    private ArrayList<Pedido> pedidos;

    private Garcom garcom;
    private Cliente cliente;

    //Verifica o estado da conta.
    private boolean aberta;

    //Controla a data de abertura e fechamento de uma conta.
    private LocalDateTime dataAbertura, dataFechamento;

    public Conta(Mesa novaMesa, Garcom novoGarcom, Cliente novoC1iente) {
        this.mesa = novaMesa;
        this.pedidos = new ArrayList();
        this.garcom = novoGarcom;
        this.cliente = novoC1iente;
    }

    //Métodos acessores
    public Mesa getMesa() {
        return mesa;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isAberta() {
        return aberta;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Método responsável por abrir uma conta, alterando o estado da conta e da ocupação da mesa.
    public void abrirConta() throws CustomException {

        if (!mesa.isDisponivel()) {
            throw new CustomException("Mesa está ocupada!");
        }

        if (isAberta()) {
            throw new CustomException("A conta já está aberta!");
        }

        setDataAbertura(LocalDateTime.now());
        System.out.println("\nData abertura: " + getDataAbertura());
        setAberta(true);
        this.mesa.ocuparMesa();
    }

    //Método responsável por fechar a conta, modificando a ocupação da mesa e disponibilidade da conta.
    public void fecharConta() throws CustomException {

        if (!isAberta()) {
            throw new CustomException("A conta já está fechada ou não existe!");
        }

        setAberta(false);
        this.mesa.desocuparMesa();
        setDataFechamento(LocalDateTime.now());
        exibirInformacoesFechamento();
    }

    //Método responsável por registrar pedidos.
    public void registrarPedidos(Produto produto, int quantidade) throws CustomException {

        if (produto == null) {
            throw new CustomException("Produto inválido!");
        }

        if (quantidade <= 0) {
            throw new CustomException("Quantidade deve ser maior que zero!");
        }

        if (!isAberta()) {
            throw new CustomException("A conta deve estar aberta para registrar pedidos!");
        }

        Pedido pedido = new Pedido(produto, quantidade);
        this.pedidos.add(pedido);
    }

    //Método responsável por remover o último pedido realizado.
    public void removerPedidos() throws CustomException {

        if (getPedidos().isEmpty()) {
            throw new CustomException("Lista de pedidos está vazia!");
        }

        this.pedidos.remove(this.pedidos.size() - 1);
    }

    //Método responsável por calcular o total de pedidos de uma determinada mesa/conta.
    public void calcularTotal() throws CustomException {

        if (isAberta()) {
            throw new CustomException("Conta deve ser fechada antes!");
        }

        int total = 0;

        for (Pedido pedido : getPedidos()) {
            total += pedido.calcularParcial();
        }

        System.out.println("Total da conta: " + total + "R$");
    }

    //Método responsável por imprimir informações sobre o fechamento da conta.
    private void exibirInformacoesFechamento() {
        System.out.println("\n==========Fechamento da conta==========");
        System.out.println("\nData fechamento: " + getDataFechamento());
        System.out.println("\nMesa atendida: ");
        getMesa().exibirInformacoes();
        System.out.println("\nGarçom responsável:");
        getGarcom().exibirInformacoes();
        System.out.println("\nCliente atendido:");
        getCliente().exibirInformacoes();
        System.out.println("\n=======================================");
    }
}
