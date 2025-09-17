package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.SistemaSolarRepository;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.PlanetaRepository;

@Service
public class SistemaSolarYPlanetaService {

    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    public static PlanetaEntity asociarPlanetaASistemaSolar(SistemaSolar sistemaSolar, PlanetaEntity nuevoPlaneta) throws IllegalOperationException {

        //Calcular población total incluyendo el nuevo planeta
        Long poblacionTotal = nuevoPlaneta.getPoblacion();
        for (PlanetaEntity planeta : sistemaSolar.getPlanetas()) {
            poblacionTotal += planeta.getPoblacion();
        }

        //Calcular ratio actual
        double ratioActual = (double) sistemaSolar.getStormtroopersAsignados() / poblacionTotal;

        //Validar que el ratio actual no sea menor al mínimo
        if (ratioActual < sistemaSolar.getRatioFuerzaMinimo()) {
            throw new IllegalOperationException("No se puede asociar el planeta: el ratio actual sería menor al mínimo permitido.");
        }

        //Asociar el planeta
        nuevoPlaneta.setSistemaSolar(sistemaSolar);
        return PlanetaRepository.save(nuevoPlaneta);
    }
}
