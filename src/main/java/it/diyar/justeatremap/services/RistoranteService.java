package it.diyar.justeatremap.services;

import it.diyar.justeatremap.models.Ristorante;
import it.diyar.justeatremap.repository.RistoranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RistoranteService {

    @Autowired
    private RistoranteRepository ristoranteRepository;

    public List<Ristorante> getAll() {
        return ristoranteRepository.findAll();
    }

    public Optional<Ristorante> getById(String partitaIva) {
        return ristoranteRepository.findById(Long.valueOf(partitaIva));
    }

    public Ristorante save(Ristorante ristorante) {
        return ristoranteRepository.save(ristorante);
    }

    public void delete(String partitaIva) {
        ristoranteRepository.deleteById(Long.valueOf(partitaIva));
    }
}
