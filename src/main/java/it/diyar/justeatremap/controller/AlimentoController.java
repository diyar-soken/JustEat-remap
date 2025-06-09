package it.diyar.justeatremap.controller;


import it.diyar.justeatremap.models.Alimento;
import it.diyar.justeatremap.repository.AlimentoRepository;
import it.diyar.justeatremap.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alimenti")
public class AlimentoController {
    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    public List<Alimento> getAll() {
        return alimentoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimento> getById(@PathVariable Long id) {
        return alimentoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alimento create(@RequestBody Alimento alimento) {
        return alimentoService.save(alimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alimento> update(@PathVariable Long id, @RequestBody Alimento alimentoDetails) {
        Optional<Alimento> optionalAlimento = alimentoService.getById(id);
        if (optionalAlimento.isPresent()) {
            Alimento alimento = optionalAlimento.get();
            alimento.setNome(alimentoDetails.getNome());
            alimento.setCosto(alimentoDetails.getCosto());
            alimento.setIngredienti(alimentoDetails.getIngredienti());
            alimentoService.save(alimento);
            return ResponseEntity.ok(alimento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}