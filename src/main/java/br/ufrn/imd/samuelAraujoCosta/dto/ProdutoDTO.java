package br.ufrn.imd.samuelAraujoCosta.dto;

import java.time.LocalDate;
import br.ufrn.imd.samuelAraujoCosta.model.GeneroProduto;

public record ProdutoDTO(
        String nomeProduto,
        String marca,
        LocalDate dataFabricacao,
        LocalDate dataValidade,
        GeneroProduto genero,
        String lote
) {}
