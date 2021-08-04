package controllers;

import java.util.List;
import java.util.Scanner;

import classes.Cidade;
import repositories.CidadeRepository;

public class CidadeController {
    public CidadeController() {}

    public void inserir(Scanner input) {
        var cidadeRepository = new CidadeRepository();
        var cidade = new Cidade();
        cidade = cidade.colherDados(input);
        cidadeRepository.inserir(cidade);
    }

    public List<Cidade> listar() {
        var cidadeRepository = new CidadeRepository();
        return cidadeRepository.listar();
    }
}
