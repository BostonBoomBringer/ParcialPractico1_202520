package co.edu.uniandes.dse.ParcialPractico1_202520.services;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.SistemaSolarRepository;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class SistemaSolarService {
    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;

    public SistemaSolar createSistemaSolar(SistemaSolar sistemaSolar) throws Exception {
        //Regla nombre < 31 caracteres
        if (sistemaSolar.getNombre() == null || sistemaSolar.getNombre().length() >= 31) {
            throw new Exception("El nombre del sistema solar debe tener menos de 31 caracteres.");
        }
        //Regla ratio entre 0.2 y 0.6
        Double ratio = sistemaSolar.getRatioFuerzaMinimo();
        if (ratio == null || ratio < 0.2 || ratio > 0.6) {
            throw new Exception("El ratio de fuerza debe estar entre 0.2 y 0.6.");
        }
        //Regla stormtroopers > 1000
        if (sistemaSolar.getStormtroopersAsignados() == null || sistemaSolar.getStormtroopersAsignados() <= 1000) {
            throw new Exception("El número de Stormtroopers debe ser mayor a 1000.");
        }

        return sistemaSolarRepository.save(sistemaSolar);
    }
}    

