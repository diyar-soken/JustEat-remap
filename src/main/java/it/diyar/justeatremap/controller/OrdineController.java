package it.diyar.justeatremap.controller;

import it.diyar.justeatremap.models.Ordine;
import it.diyar.justeatremap.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordini")
public class OrdineController {

    @Autowired
    private OrdineService ordineService;

    @GetMapping
    public List<Ordine> getAll() {
        return ordineService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordine> getById(@PathVariable Long id) {
        return ordineService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ordine create(@RequestBody Ordine ordine) {
        return ordineService.save(ordine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ordine> update(@PathVariable Long id, @RequestBody Ordine ordineDetails) {
        return ordineService.getById(id)
                .map(ordine -> {
                    ordine.setAlimenti(ordineDetails.getAlimenti());
                    ordine.setCliente(ordineDetails.getCliente());
                    ordine.setRistorante(ordineDetails.getRistorante());
                    ordine.setIndirizzoConsegna(ordineDetails.getIndirizzoConsegna());
                    ordine.setDataCreazione(ordineDetails.getDataCreazione());
                    ordine.setDataAccettazione(ordineDetails.getDataAccettazione());
                    ordine.setDataRicezione(ordineDetails.getDataRicezione());
                    ordineService.save(ordine);
                    return ResponseEntity.ok(ordine);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
