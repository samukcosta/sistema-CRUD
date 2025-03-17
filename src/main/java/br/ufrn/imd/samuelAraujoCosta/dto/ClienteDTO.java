package br.ufrn.imd.samuelAraujoCosta.dto;

import java.time.LocalDate;
import br.ufrn.imd.samuelAraujoCosta.model.GeneroCliente;

public record ClienteDTO(
        String nome,
        String cpf,
        GeneroCliente genero,
        LocalDate dataNascimento
) {}
