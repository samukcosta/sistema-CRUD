package br.ufrn.imd.samuelAraujoCosta.controllers;

import br.ufrn.imd.samuelAraujoCosta.dto.ProdutoDTO;
import br.ufrn.imd.samuelAraujoCosta.model.ProdutoEntity;
import br.ufrn.imd.samuelAraujoCosta.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoEntity> getAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> getById(@PathVariable Long id) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoEntity produto = new ProdutoEntity(
                produtoDTO.nomeProduto(),
                produtoDTO.marca(),
                produtoDTO.dataFabricacao(),
                produtoDTO.dataValidade(),
                produtoDTO.genero(),
                produtoDTO.lote()
        );

        ProdutoEntity produtoSalvo = produtoRepository.save(produto);
        return ResponseEntity.ok(produtoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<ProdutoEntity> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            ProdutoEntity produto = produtoExistente.get();

            produto.setNomeProduto(produtoDTO.nomeProduto());
            produto.setMarca(produtoDTO.marca());
            produto.setDataFabricacao(produtoDTO.dataFabricacao());
            produto.setDataValidade(produtoDTO.dataValidade());
            produto.setGenero(produtoDTO.genero());
            produto.setLote(produtoDTO.lote());

            ProdutoEntity produtoAtualizado = produtoRepository.save(produto);

            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
