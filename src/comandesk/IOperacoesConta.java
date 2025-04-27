package comandesk;

public interface IOperacoesConta {

    //Interface com operações comuns de uma conta.
    void abrirConta() throws CustomException;

    void fecharConta() throws CustomException;

    void registrarPedidos(Produto produto, int quantidade) throws CustomException;

    void removerPedidos() throws CustomException;

    void calcularTotal() throws CustomException;
}
