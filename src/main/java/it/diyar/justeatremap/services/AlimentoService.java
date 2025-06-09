package it.diyar.justeatremap.services;

import it.diyar.justeatremap.models.Alimento;
import it.diyar.justeatremap.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentoService {
    @Autowired
    private AlimentoRepository alimentoRepository;

    public List<Alimento> getAll() {
        return alimentoRepository.findAll();
    }

    public Optional<Alimento> getById(Long id) {
        return alimentoRepository.findById(id);
    }

    public Alimento save(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public void delete(Long id) {
        alimentoRepository.deleteById(id);
    }
}
