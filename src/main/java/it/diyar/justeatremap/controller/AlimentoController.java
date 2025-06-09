package it.diyar.justeatremap.controller;


import it.diyar.justeatremap.models.Alimento;
import it.diyar.justeatremap.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/alimento")
public class AlimentoController {
    @Autowired
    private AlimentoRepository repo;

    @GetMapping
    private List<Alimento> getAllAlimenti(){
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAlimento(@PathVariable Long id, @RequestBody Alimento alimento){
        Alimento alimentoToUpdate = repo.findById(id).orElseThrow();
        alimentoToUpdate.setNome(alimento.getNome());
        alimentoToUpdate.setCosto(alimento.getCosto());
        alimentoToUpdate.setIngredienti(alimento.getIngredienti());
        repo.save(alimentoToUpdate);
        return ResponseEntity.ok(alimentoToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAlimento(@PathVariable Long id){
        Alimento alimentoToDelete = repo.findById(id).orElseThrow();
        repo.delete(alimentoToDelete);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public Alimento aggiungiAlimento(@RequestBody Alimento alimento){
        return repo.save(alimento);
    }
}
