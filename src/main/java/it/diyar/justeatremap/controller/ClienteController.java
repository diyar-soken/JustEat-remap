package it.diyar.justeatremap.controller;

import it.diyar.justeatremap.models.Cliente;
import it.diyar.justeatremap.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("/{codiceFiscale}")
    public ResponseEntity<Cliente> getById(@PathVariable String codiceFiscale) {
        return clienteService.getById(codiceFiscale)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{codiceFiscale}")
    public ResponseEntity<Cliente> update(@PathVariable String codiceFiscale, @RequestBody Cliente clienteDetails) {
        return clienteService.getById(codiceFiscale)
                .map(cliente -> {
                    cliente.setNome(clienteDetails.getNome());
                    cliente.setCognome(clienteDetails.getCognome());
                    cliente.setDataNascita(clienteDetails.getDataNascita());
                    cliente.setLuogoNascita(clienteDetails.getLuogoNascita());
                    cliente.setIndirizzo(clienteDetails.getIndirizzo());
                    cliente.setEmail(clienteDetails.getEmail());
                    cliente.setPassword(clienteDetails.getPassword());
                    clienteService.save(cliente);
                    return ResponseEntity.ok(cliente);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codiceFiscale}")
    public ResponseEntity<Void> delete(@PathVariable String codiceFiscale) {
        clienteService.delete(codiceFiscale);
        return ResponseEntity.noContent().build();
    }
}
