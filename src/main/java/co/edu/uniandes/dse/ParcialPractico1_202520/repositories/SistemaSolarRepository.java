package co.edu.uniandes.dse.ParcialPractico1_202520.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;

public interface SistemaSolarRepository extends JpaRepository <SistemaSolar, Long> {
    List<SistemaSolar> findByNombre(String nombre);
    List<SistemaSolar> findByRegionList(SistemaSolar region);
    List<SistemaSolar> findByRatioList(SistemaSolar ratioFuerzaMinimo);
    List<SistemaSolar> findByStormtrooopers(SistemaSolar stormtroopersAsignados);
}

