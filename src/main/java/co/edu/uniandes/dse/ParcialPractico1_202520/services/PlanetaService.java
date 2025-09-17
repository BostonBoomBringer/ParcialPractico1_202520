package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.PlanetaRepository;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;
    
    public PlanetaEntity createPlaneta(PlanetaEntity planeta) throws Exception {
        //Regla El nombre debe terminar en número romano 1, 2 o 3
        if (planeta.getNombre() == null || 
            !(planeta.getNombre().endsWith("I") || planeta.getNombre().endsWith("II") || planeta.getNombre().endsWith("III"))) {
            throw new IllegalOperationException("El nombre del planeta debe terminar en los números romanos I, II o III.");
        }

        //Regla 2: La población debe ser mayor a 0
        if (planeta.getPoblacion() == null || planeta.getPoblacion() <= 0) {
            throw new IllegalOperationException("La población del planeta debe ser un número positivo mayor que 0.");
        }

        return planetaRepository.save(planeta);
    }
}
