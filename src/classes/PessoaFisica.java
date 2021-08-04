package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class PessoaFisica extends Pessoa {
	private String cpf;
	private String rg;
	private String dataNascimento;

	public PessoaFisica() {}

	public PessoaFisica(String cpf, String rg, String dataNascimento) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

	public PessoaFisica colherDadosPessoaFisica() {
		var input = new Scanner(System.in);
        var pessoa = new Pessoa();
        pessoa = pessoa.colherDadosPessoa();
        var pf = new PessoaFisica();
        pf.setNomeSocial(pessoa.getNomeSocial());
        pf.setRazaoSocial(pessoa.getRazaoSocial());
        pf.setEmail(pessoa.getEmail());
        pf.setTelefone(pessoa.getTelefone());
        pf.setRua(pessoa.getRua());
        pf.setNumero(pessoa.getNumero());
        pf.setComplemento(pessoa.getComplemento());
        pf.setBairro(pessoa.getBairro());
        pf.setCep(pessoa.getCep());
        pf.setCidadeId(pessoa.getCidadeId());
        pf.setEstadoId(pessoa.getEstadoId());

        System.out.println("Agora algumas informações pessoais");
        System.out.println("Digite os dados a seguir");
        System.out.println("CPF:");
        pf.setCpf(input.nextLine());

        System.out.println("RG:");
        pf.setRg(input.nextLine());

        System.out.println("Data de nascimento: (Digite no formato dd/MM/yyyy)");
        System.out.println("Exemplo: 02/02/2002");
        var data = "";
        var flagErroData = true;
        var dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy");
        do {
            try {
                data = input.nextLine();
                var date = dateTimeFormatter.parse(data).toString();
                pf.setDataNascimento(date.toString());
                flagErroData = false;
            } catch (ParseException  e) {
                System.out.println("Erro ao gravar data! Formato inválido");
                System.out.println("Por favor, insira o formato especificado.");
            }
        } while(flagErroData);
        return pf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
