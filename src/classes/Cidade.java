package classes;

import java.util.Scanner;

public class Cidade {
	private long id;
	private String nome;

	public Cidade() {}

	public Cidade(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

    public Cidade colherDados(Scanner input) {
        var cidade = new Cidade();
        System.out.println("\nAgora os dados de cidade");
		System.out.println("Digite os dados a seguir:");

		System.out.println("Nome:");
		cidade.setNome(input.nextLine());

		return cidade;
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

}
