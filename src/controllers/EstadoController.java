package controllers;

import java.util.List;
import java.util.Scanner;

import classes.Estado;
import repositories.EstadoRepository;

public class EstadoController {
    public void inserir(Scanner input) {
        var estadoRepository = new EstadoRepository();
        var estado = new Estado();
        estado = estado.colherDados(input);
        estadoRepository.inserir(estado);
    }

    public List<Estado> listar() {
        var estadoRepository = new EstadoRepository();
        return estadoRepository.listar();
    }
}
