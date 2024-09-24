package conta_digital.cliente;

import conta_digital.conta.Conta;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Cliente implements Comparable<Cliente>{
    protected String nome;
    protected LocalDate dataCadastro;
    protected String email;
    protected List<Conta> contas;

    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.dataCadastro = LocalDate.now();
        this.contas = new ArrayList<>();
    }

    @Override
    public int compareTo(Cliente c) {
        return this.nome.compareTo(c.nome);
    }
}
