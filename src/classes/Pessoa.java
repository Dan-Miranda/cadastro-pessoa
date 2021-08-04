package classes;

import java.util.Scanner;

import controllers.CidadeController;
import controllers.EstadoController;
import repositories.CidadeRepository;

public class Pessoa {
	private long id;
	private String razaoSocial;
	private String nomeSocial;
	private String email;
	private String telefone;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private long cidadeId;
	private long estadoId;

	public Pessoa() {}

	public Pessoa(final String razaoSocial, final String nomeSocial, final String email, final String telefone, final String rua,
			final String numero, final String complemento,final String bairro, final String cep, final long cidadeId, final long estadoId) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeSocial = nomeSocial;
		this.email = email;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidadeId = cidadeId;
		this.estadoId = estadoId;
	}

	public Pessoa colherDadosPessoa() {
		var input = new Scanner(System.in);
		var pessoa = new Pessoa();

		System.out.println("\nDigite os dados a seguir:\n");
		System.out.println("Razão Social:");
		pessoa.setRazaoSocial(input.nextLine());

		System.out.println("Nome Social:");
		pessoa.setNomeSocial(input.nextLine());

		System.out.println("Email:");
		pessoa.setEmail(input.nextLine());

		System.out.println("Telefone:");
		pessoa.setTelefone(input.nextLine());

		System.out.println("\nAgora os dados de endereco:");

		System.out.println("Rua:");
		pessoa.setRua(input.nextLine());

		System.out.println("Número:");
		pessoa.setNumero(input.nextLine());

		System.out.println("Complemento:");
		pessoa.setComplemento(input.nextLine());

		System.out.println("Bairro:");
		pessoa.setBairro(input.nextLine());

		System.out.println("CEP:");
		pessoa.setCep(input.nextLine());
		var estadoController = new EstadoController();
		var estados = estadoController.listar();

		if (estados.size() > 0) {
			System.out.println("Digite o ID do seu estado a partir dos estados abaixo:");
			estados.forEach(estado -> {
				System.out.println("" + estado.getId() + " - " + estado.getNome());
			});
            System.out.println("0 - Cadastrar Estado");
            var valor = Long.parseLong(input.nextLine());
            if (valor == 0) {
                estadoController.inserir(input);
                estados = estadoController.listar();
                var estadoId = estados.get(estados.size() - 1).getId();
                pessoa.setEstadoId(estadoId);
            } else {
                pessoa.setEstadoId(valor);
            }
		} else {
            estadoController.inserir(input);
            estados = estadoController.listar();
            var estadoId = estados.get(estados.size() - 1).getId();
            pessoa.setEstadoId(estadoId);
		}
        var cidadeController = new CidadeController();
        var cidades = cidadeController.listar();
        if (cidades.size() > 0) {
            System.out.println("Digite o ID da sua cidade a partir das cidades abaixo:");
            cidades.forEach(cidade -> {
                System.out.println("" + cidade.getId() + " - " + cidade.getNome());
            });
            System.out.println("0 - Cadastrar Cidade");
            var valor = Long.parseLong(input.nextLine());
            if (valor == 0) {
                cidadeController.inserir(input);
                cidades = cidadeController.listar();
                var cidadeId = cidades.get(cidades.size() - 1).getId();
                pessoa.setCidadeId(cidadeId);
            } else {
                pessoa.setEstadoId(valor);
            }

        } else {
            cidadeController.inserir(input);
            cidades = cidadeController.listar();
            var cidadeId = cidades.get(cidades.size() - 1).getId();
            pessoa.setCidadeId(cidadeId);
        }

		return pessoa;
	}

	public long getId() {
		return this.id;
	}

    public void setId(long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		this.cidadeId = cidadeId;
	}

	public long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(long estadoId) {
		this.estadoId = estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}



}
