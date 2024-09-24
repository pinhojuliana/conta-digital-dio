package conta_digital.cliente;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Cliente {
    protected String nome;
    protected LocalDate dataCadastro;
    protected String email;

    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.dataCadastro = LocalDate.now();
    }
}
