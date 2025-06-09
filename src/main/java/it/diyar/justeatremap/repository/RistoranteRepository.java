package it.diyar.justeatremap.repository;

import it.diyar.justeatremap.models.Ristorante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RistoranteRepository extends JpaRepository<Ristorante, Long> {
}