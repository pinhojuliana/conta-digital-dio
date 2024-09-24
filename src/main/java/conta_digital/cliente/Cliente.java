package conta_digital.cliente;

import conta_digital.validacao.ValidacaoEmail;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Cliente implements Comparable<Cliente>{
    protected String nome;
    protected LocalDateTime dataCadastro;
    protected String email;
    //protected List<Conta> contas;

    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = ValidacaoEmail.isValidEmail(email);
        this.dataCadastro = LocalDateTime.now();
        //this.contas = new ArrayList<>();
    }

    @Override
    public int compareTo(Cliente c) {
        return this.nome.compareTo(c.nome);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", email='" + email + '\'' +
                '}';
    }
}
