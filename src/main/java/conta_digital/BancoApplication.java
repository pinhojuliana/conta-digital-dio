package conta_digital;

import conta_digital.banco.Banco;
import conta_digital.cliente.Cliente;
import conta_digital.cliente.PessoaFisica;
import conta_digital.cliente.PessoaJuridica;
import conta_digital.conta.Conta;
import conta_digital.conta.ContaCorrente;
import conta_digital.conta.ContaPoupanca;

public class BancoApplication {
    public static void main(String[] args) {
        try {
            Banco banco = new Banco("Banco do Brasil");

            Cliente cliente1 = new PessoaFisica("Maria", "maria@gmail.com", 12345678900L);
            Cliente cliente2 = new PessoaJuridica("Casa da Empada", "empadas.loja@outlook.com", 23456789011L);

            Conta contaCorrente = new ContaCorrente(cliente1);
            Conta contaPoupanca = new ContaPoupanca(cliente2);

            banco.cadastrarCliente(cliente1);
            banco.cadastrarCliente(cliente2);
            banco.cadastrarConta(contaCorrente);
            banco.cadastrarConta(contaPoupanca);

            contaCorrente.depositar(1000);
            contaCorrente.sacar(150);
            contaCorrente.transferir(300, contaPoupanca);

            contaPoupanca.sacar(100);
            contaPoupanca.transferir(10, contaCorrente);

            contaPoupanca.imprimirExtrato();

            contaCorrente.imprimirExtrato();

            System.out.println("Clientes do banco:");
            banco.imprimirClientes();
            System.out.println("Contas do banco:");
            banco.imprimirContas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
