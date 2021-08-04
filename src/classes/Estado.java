package classes;

import java.util.Scanner;

public class Estado {
	private long id;
	private String nome;
	private String sigla;

	public Estado() {}

	public Estado(String nome, String sigla) {
		super();
		this.nome = nome;
		this.sigla = sigla;
	}

	public Estado colherDados(Scanner input) {
		var estado = new Estado();

		System.out.println("\nAgora os dados de estado\n");
		System.out.println("Digite os dados a seguir:");

		System.out.println("Nome:");
		estado.setNome(input.nextLine());

		System.out.println("Sigla:");
		estado.setSigla(input.nextLine());
		return estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}



}
