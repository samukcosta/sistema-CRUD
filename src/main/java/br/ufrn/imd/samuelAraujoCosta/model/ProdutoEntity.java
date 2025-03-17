package br.ufrn.imd.samuelAraujoCosta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    private String marca;

    private LocalDate dataFabricacao;

    private LocalDate dataValidade;

    @Enumerated(EnumType.STRING)
    private GeneroProduto genero;

    private String lote;

    // Construtor adicional sem o ID
    public ProdutoEntity(String nomeProduto, String marca, LocalDate dataFabricacao, LocalDate dataValidade, GeneroProduto genero, String lote) {
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.genero = genero;
        this.lote = lote;
    }
}
