package conta_digital.cliente;

import lombok.Getter;

@Getter
public class PessoaFisica extends Cliente {
    private long cpf;

    public PessoaFisica(String nome, String email, long cpf){
        super(nome, email);
        this.cpf = cpf;
    }
}
