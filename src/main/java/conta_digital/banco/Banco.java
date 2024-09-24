package conta_digital.banco;

import conta_digital.cliente.Cliente;
import conta_digital.conta.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Banco {
    private String nome;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String name){
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void cadastrarConta(Conta conta){
        contas.add(conta);
    }

    public void imprimirContas(){
        contas.forEach(System.out::println);
    }

    public void imprimirClientes(){
        System.out.println(clientes.stream().sorted().map(Cliente::getNome)
                .collect(Collectors.joining("\n")));
    }

}
