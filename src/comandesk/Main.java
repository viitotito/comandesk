package comandesk;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Cliente c1 = new Cliente("João", "123.456.789-10", "João@gmail.com", "00000000");
        Cliente c2 = new Cliente("Maria", "432.903.234-12", "Maria@gmail.com", "00000011");
        Cliente c3 = new Cliente("Kleber", "975.234.234-32", "Kleber@gmail.com", "00000111");

        c1.exibirInformacoes();
        c2.exibirInformacoes();
        c3.exibirInformacoes();

        Garcom g1 = new Garcom("Pedro", "222.222.222-22", "Pedro@gmail.com", "00000001", "001");
        Garcom g2 = new Garcom("Fátima", "111.111.111-11", "Fátima@gmail.com", "00000002", "002");
        Garcom g3 = new Garcom("Mônica", "333.333.333-33", "Mônica@gmail.com", "00000003", "003");

        g1.exibirInformacoes();
        g2.exibirInformacoes();
        g3.exibirInformacoes();

        Mesa m1 = new Mesa(1, "Janela", true);
        Mesa m2 = new Mesa(2, "Banheiro", false);
        Mesa m3 = new Mesa(3, "Lateral esquerda", true);

        Produto p1 = new Produto("Refrigerante", "Dolly", "L", 12.00);
        Produto p2 = new Produto("Pastel", "", "g", 5.00);
        Produto p3 = new Produto("Chocolate", "Ferreiro Rocher", "g", 24.00);

        Conta co1 = new Conta(m1, g1, c1);
        Conta co2 = new Conta(m2, g2, c2);
        Conta co3 = new Conta(m1, g1, c3);

        //Testando abertura da conta 1 sem erros.
        try {
            System.out.println("\nAbrindo conta 1...");
            co1.abrirConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da abertura conta 1.");
        }

        //Testando abertura da conta 2 com erro de ocupação mesa 2.
        try {
            System.out.println("\nAbrindo conta 2...");
            co2.abrirConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da abertura conta 2");
        }

        //Desocupando mesa 2.
        m2.desocuparMesa();

        //Testando abertura da conta 2 com erro corrigido.
        try {
            System.out.println("\nAbrindo conta 2...");
            co2.abrirConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da abertura conta 2");
        }

        //Testando abertura da conta 3 com erro de ocupação da mesa 1 pela conta 1.
        try {
            System.out.println("\nAbrindo conta 3...");
            co3.abrirConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da abertura conta 3.");
        }

        //Testando registro de pedidos na conta 1 com erro de quantidade.
        try {
            System.out.println("\nRegistrando pedidos conta 1...");
            co1.registrarPedidos(p2, 0);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 1.");
        }

        //Testando registro de pedidos na conta 1 com erro de produto nulo.
        try {
            System.out.println("\nRegistrando pedidos conta 1...");
            co1.registrarPedidos(null, 5);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 1.");
        }

        //Testando registro de pedidos na conta 1 sem erros.
        try {
            System.out.println("\nRegistrando pedidos conta 1...");
            co1.registrarPedidos(p2, 2);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 1.");
        }

        //Testando registro de pedidos na conta 1 sem erros (novamente).
        try {
            System.out.println("\nRegistrando pedidos conta 1...");
            co1.registrarPedidos(p3, 12);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 1.");
        }

        //Testando registro de pedidos na conta 2 sem erros.
        try {
            System.out.println("\nRegistrando pedidos conta 2...");
            co2.registrarPedidos(p1, 3);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 2.");
        }

        //Testando registro de pedidos na conta 2 sem erros (novamente).
        try {
            System.out.println("\nRegistrando pedidos conta 2...");
            co2.registrarPedidos(p3, 7);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 2.");
        }

        //Testando registro de pedidos na conta 2 sem erros (novamente 2).
        try {
            System.out.println("\nRegistrando pedidos conta 2...");
            co2.registrarPedidos(p3, 7);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 2.");
        }

        //Definindo lista de pedidos da conta 1 como null (ou vazio).
        co1.setPedidos(new ArrayList());

        //Testando a remoção de pedidos da conta 1.
        try {
            System.out.println("\nRemovendo pedidos conta 1...");
            co1.removerPedidos();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da remoção de pedidos");
        }

        //Testando registro de pedidos na conta 1 após zerar a lista.
        try {
            System.out.println("\nRegistrando pedidos conta 1...");
            co1.registrarPedidos(p2, 2);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 1.");
        }

        //Testando registro de pedidos na conta 3 com erro de conta fechada.
        try {
            System.out.println("\nRegistrando pedidos conta 3...");
            co3.registrarPedidos(p2, 25);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 3.");
        }

        //Modificação de mesa para evitar erro na próxima abertura.
        co3.setMesa(m3);

        //Testando abertura da conta 3 sem erros.
        try {
            System.out.println("\nAbrindo conta 3...");
            co3.abrirConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da abertura conta 3.");
        }

        //Testando registro de pedidos na conta 3 sem erros.
        try {
            System.out.println("\nRegistrando pedidos conta 3...");
            co3.registrarPedidos(p1, 25);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 3.");
        }

        //Testando registro de pedidos na conta 3 sem erros novamente.
        try {
            System.out.println("\nRegistrando pedidos conta 3...");
            co3.registrarPedidos(p3, 76);
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do registro de pedidos conta 3.");
        }

        //Testando a remoção de pedidos da conta 2.
        try {
            co2.removerPedidos();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da remoção de pedidos");
        }

        //Testando a remoção de pedidos da conta 3.
        try {
            co3.removerPedidos();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim da remoção de pedidos");
        }

        //Testando o cálculo do total de pedidos da conta 1 sem fechá-la.
        try {
            System.out.println("\nCalculando o total da conta 1...");
            co1.calcularTotal();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do cálculo total da conta 1.");
        }

        //Fechando a conta 1 e exibição de detalhes.
        try {
            System.out.println("\nFechando a conta 1...");
            co1.fecharConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do fechamento da conta 1.");
        }

        //Testando o cálculo do total de pedidos da conta 1 após fechá-la.
        try {
            System.out.println("\nCalculando o total da conta 1...");
            co1.calcularTotal();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do cálculo total da conta 1.");
        }

        //Fechando a conta 2 e exibição de detalhes.
        try {
            System.out.println("\nFechando a conta 2...");
            co2.fecharConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do fechamento da conta 2.");
        }

        //Testando o cálculo do total de pedidos da conta 2.
        try {
            System.out.println("\nCalculando o total  da conta 2...");
            co2.calcularTotal();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do cálculo total da conta 2.");
        }

        //Fechando a conta 3 e exibição de detalhes.
        try {
            System.out.println("\nFechando a conta 3...");
            co3.fecharConta();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do fechamento da conta 3.");
        }

        //Testando o cálculo do total de pedidos da conta 3.
        try {
            System.out.println("\nCalculando o total  da conta 3...");
            co3.calcularTotal();
        } catch (CustomException ce) {
            System.out.println("\n" + ce.getMessage());
        } finally {
            System.out.println("\nFim do cálculo total da conta 3.");
        }

    }

}

//SUGESTÃO DE IMPLEMENTAÇÃO: CRIAR UMA CLASSE RESPONSÁVEL PELA MOVIMENTAÇÃO E FATURAMENTO DIÁRIO, HISTÓRICO E CONTROLE DE PRODUTOS E ESTIQUE.
