package it.diyar.justeatremap.controller;

import it.diyar.justeatremap.models.Ristorante;
import it.diyar.justeatremap.services.RistoranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ristoranti")
public class RistoranteController {

    @Autowired
    private RistoranteService ristoranteService;

    @GetMapping
    public List<Ristorante> getAll() {
        return ristoranteService.getAll();
    }

    @GetMapping("/{partitaIva}")
    public ResponseEntity<Ristorante> getById(@PathVariable String partitaIva) {
        return ristoranteService.getById(partitaIva)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ristorante create(@RequestBody Ristorante ristorante) {
        return ristoranteService.save(ristorante);
    }

    @PutMapping("/{partitaIva}")
    public ResponseEntity<Ristorante> update(@PathVariable String partitaIva, @RequestBody Ristorante ristoranteDetails) {
        return ristoranteService.getById(partitaIva)
                .map(ristorante -> {
                    ristorante.setNomeAttivita(ristoranteDetails.getNomeAttivita());
                    ristorante.setIndirizzo(ristoranteDetails.getIndirizzo());
                    ristorante.setEmail(ristoranteDetails.getEmail());
                    ristorante.setPassword(ristoranteDetails.getPassword());
                    ristorante.setMenu(ristoranteDetails.getMenu());
                    ristoranteService.save(ristorante);
                    return ResponseEntity.ok(ristorante);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{partitaIva}")
    public ResponseEntity<Void> delete(@PathVariable String partitaIva) {
        ristoranteService.delete(partitaIva);
        return ResponseEntity.noContent().build();
    }
}
