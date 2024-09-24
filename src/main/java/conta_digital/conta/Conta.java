package conta_digital.conta;

import conta_digital.cliente.Cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 0001;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected Map<LocalDate, Double> movimentacoes;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.movimentacoes = new TreeMap<>();
    }

    @Override
    public void sacar(double valor) {
        if(valor > saldo || valor > 0){
            saldo -= valor;
            movimentacoes.put(LocalDate.now(), -valor);
        } else if (valor < 0) {
            System.out.println("Valor inválido.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0){
            saldo += valor;
            movimentacoes.put(LocalDate.now(), valor);
        } else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void transferir(double valor, Conta conta) {
       if(conta != null){
           if(valor > 0) {
               this.sacar(valor);
               conta.depositar(valor);
               this.movimentacoes.put(LocalDate.now(), -valor);
               conta.movimentacoes.put(LocalDate.now(), valor);
           } else {
               System.out.println("Valor inválido.");
           }
       } else {
           throw new NullPointerException("Não é possível realizar transferência. Conta inexistente.");
       }

    }

    @Override
    public void imprimirExtrato() {
        movimentacoes.entrySet().forEach(System.out::println);
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
