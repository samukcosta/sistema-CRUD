package br.ufrn.imd.samuelAraujoCosta.controllers;

import br.ufrn.imd.samuelAraujoCosta.dto.ClienteDTO;
import br.ufrn.imd.samuelAraujoCosta.model.ClienteEntity;
import br.ufrn.imd.samuelAraujoCosta.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteEntity> getAll() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getById(@PathVariable Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> postCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteEntity novoCliente = new ClienteEntity(
                clienteDTO.nome(),
                clienteDTO.cpf(),
                clienteDTO.genero(),
                clienteDTO.dataNascimento()
        );
        ClienteEntity clienteSalvo = clienteRepository.save(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> putCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Optional<ClienteEntity> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            ClienteEntity cliente = clienteExistente.get();

            // Atualizando os dados do cliente
            cliente.setNome(clienteDTO.nome());
            cliente.setCpf(clienteDTO.cpf());
            cliente.setGenero(clienteDTO.genero());
            cliente.setDataNascimento(clienteDTO.dataNascimento());

            // Salvando no banco
            ClienteEntity clienteAtualizado = clienteRepository.save(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
