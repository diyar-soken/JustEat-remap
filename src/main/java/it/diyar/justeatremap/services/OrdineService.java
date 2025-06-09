package it.diyar.justeatremap.services;

import it.diyar.justeatremap.models.Ordine;
import it.diyar.justeatremap.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;

    public List<Ordine> getAll() {
        return ordineRepository.findAll();
    }

    public Optional<Ordine> getById(Long id) {
        return ordineRepository.findById(id);
    }

    public Ordine save(Ordine ordine) {
        return ordineRepository.save(ordine);
    }

    public void delete(Long id) {
        ordineRepository.deleteById(id);
    }
}
