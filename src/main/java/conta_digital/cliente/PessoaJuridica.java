package conta_digital.cliente;

import lombok.Getter;

@Getter
public class PessoaJuridica extends Cliente{
    private long cnpj;

    public PessoaJuridica(String nome, String email, long cnpj){
        super(nome, email);
        this.cnpj = cnpj;
    }
}
