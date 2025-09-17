package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
public class SistemaSolar {
    private String nombre;
    @Enumerated(EnumType.STRING)
    private RegionType region;
    private Double ratioFuerzaMinimo;
    private Integer stormtroopersAsignados;

    @OneToMany(mappedBy = "sistemaSolar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanetaEntity> planetas;

    }

