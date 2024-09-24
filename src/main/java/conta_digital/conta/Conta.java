package conta_digital.conta;

import conta_digital.cliente.Cliente;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected Map<LocalDateTime, Double> movimentacoes;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.movimentacoes = new TreeMap<>();
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }
        if (this.saldo < valor) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        saldo -= valor;
        movimentacoes.put(LocalDateTime.now(), -valor);
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }
        saldo += valor;
        movimentacoes.put(LocalDateTime.now(), valor);
    }

    @Override
    public void transferir(double valor, Conta conta) {
        if (conta == null) {
            throw new NullPointerException("Conta inexistente.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }

        if (this.saldo < valor) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        this.sacar(valor);
        conta.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentação registrada.");
            return;
        }
        movimentacoes.forEach((data, valor) ->
                System.out.printf("Data: %s - Valor: %.2f%n", data, valor)
        );
        System.out.printf("Saldo atual: %.2f%n", saldo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                '}';
    }

}
