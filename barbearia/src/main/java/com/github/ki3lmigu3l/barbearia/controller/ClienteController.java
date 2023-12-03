package com.github.ki3lmigu3l.barbearia.controller;

import com.github.ki3lmigu3l.barbearia.domain.cliente.Cliente;
import com.github.ki3lmigu3l.barbearia.domain.cliente.ClienteRepository;
import com.github.ki3lmigu3l.barbearia.domain.cliente.DadosCadastroCliente;
import com.github.ki3lmigu3l.barbearia.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente (@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente();
        BeanUtils.copyProperties(dados, cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteRepository.save(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes () {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> obterClienteById (@PathVariable Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        Cliente cliente = optionalCliente.get();
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarCliente (@PathVariable Long id, @RequestBody DadosCadastroCliente dados) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        var clienteExistente = optionalCliente.get();
        BeanUtils.copyProperties(dados, clienteExistente);
        return ResponseEntity.ok(clienteRepository.save(clienteExistente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarCliente (@PathVariable Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
