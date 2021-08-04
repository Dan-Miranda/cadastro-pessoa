package classes;

import java.util.Date;

public class Funcionario {
	private long pessoaId;
	private double salario;
	private double comissao;
	private Date dataContratacao;
	
	public Funcionario() {}
	
	public Funcionario(double salario, double comissao, Date dataContratacao) {
		super();
		this.salario = salario;
		this.comissao = comissao;
		this.dataContratacao = dataContratacao;
	}

	public long getPessoaId() {
		return pessoaId;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getComissao() {
		return comissao;
	}
	
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	public Date getDataContratacao() {
		return dataContratacao;
	}
	
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
	
}
