package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
public class PlanetaEntity {
    private String nombre;
    private Long poblacion;
    private Double diametroKm;

    @ManyToOne
    @JoinColumn(name = "sistema_solar_id")
    private SistemaSolar sistemaSolar;
}
