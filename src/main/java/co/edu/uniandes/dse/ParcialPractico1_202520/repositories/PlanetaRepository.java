package co.edu.uniandes.dse.ParcialPractico1_202520.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;

public interface PlanetaRepository extends JpaRepository <PlanetaEntity, Long> {
    
}
