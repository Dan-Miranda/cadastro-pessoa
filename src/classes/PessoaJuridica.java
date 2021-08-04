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
