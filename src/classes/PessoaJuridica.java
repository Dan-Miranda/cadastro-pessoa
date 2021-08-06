package classes;

public class PessoaJuridica extends Pessoa {
	private String cnpj;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String fax;
	private String webSite;
	
	public PessoaJuridica() {}
	
	public PessoaJuridica(String cnpj, String inscricaoEstadual, 
			String inscricaoMunicipal, String fax, String webSite) {
		super();
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.fax = fax;
		this.webSite = webSite;
	}

	public PessoaJuridica colherDadosPessoaJuridica() {
		var input = new Scanner(System.in);
        var pessoa = new Pessoa();
        
		pessoa = pessoa.colherDadosPessoa();
        
		var pj = new PessoaJuridica();
        
		pj.setNomeSocial(pessoa.getNomeSocial());
        pj.setRazaoSocial(pessoa.getRazaoSocial());
        pj.setEmail(pessoa.getEmail());
        pj.setTelefone(pessoa.getTelefone());
        pj.setRua(pessoa.getRua());
        pj.setNumero(pessoa.getNumero());
        pj.setComplemento(pessoa.getComplemento());
        pj.setBairro(pessoa.getBairro());
        pj.setCep(pessoa.getCep());
        pj.setCidadeId(pessoa.getCidadeId());
        pj.setEstadoId(pessoa.getEstadoId());

        System.out.println("Agora algumas informações pessoais");
        System.out.println("Digite os dados a seguir");
        System.out.println("CPF:");
        
		pj.setCpf(input.nextLine());

        System.out.println("RG:");
        
		pj.setRg(input.nextLine());

        System.out.println("Data de nascimento: (Digite no formato dd/MM/yyyy)");
        System.out.println("Exemplo: 02/02/2002");
        
		var data = "";
        var flagErroData = true;
        var dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy");

        do {
            try {
                data = input.nextLine();
                var date = dateTimeFormatter.parse(data).toString();
                pj.setDataNascimento(date.toString());
                flagErroData = false;
            } catch (ParseException  e) {
                System.out.println("Erro ao gravar data! Formato inválido");
                System.out.println("Por favor, insira o formato especificado.");
            }
        } while(flagErroData);

        return pj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	

}
