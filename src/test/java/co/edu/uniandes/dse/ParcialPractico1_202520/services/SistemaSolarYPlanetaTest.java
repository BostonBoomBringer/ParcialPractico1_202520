package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.*;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.*;

public class SistemaSolarYPlanetaTest {

    @InjectMocks
    private SistemaSolarYPlanetaService sistemaSolarPlanetaService;

    @Mock
    private SistemaSolarRepository sistemaSolarRepository;

    @Mock
    private PlanetaRepository planetaRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAsociacionExitosa() throws Exception {
        SistemaSolar sistema = new SistemaSolar();
        sistema.setNombre("MeneaTuChapa");
        sistema.setRatioFuerzaMinimo(0.3);
        sistema.setStormtroopersAsignados(3000);
        sistema.setPlanetas(new ArrayList<>());

        PlanetaEntity planeta = new PlanetaEntity();
        planeta.setNombre("TatooineI");
        planeta.setPoblacion(5000L);

        when(sistemaSolarRepository.findById(1L)).thenReturn(Optional.of(sistema));
        when(planetaRepository.save(any())).thenReturn(planeta);

        PlanetaEntity resultado = SistemaSolarYPlanetaService.asociarPlanetaASistemaSolar(sistema, planeta);
        assertEquals("TatooineI", resultado.getNombre());
        assertEquals(sistema, resultado.getSistemaSolar());
    }
    @Test
    public void testSistemaSolarNulo() {
        PlanetaEntity planeta = new PlanetaEntity();
        planeta.setNombre("DagobahII");
        planeta.setPoblacion(4000L);

        assertThrows(Exception.class, () -> {
            /*SistemaSolar*/ sistema;
            SistemaSolarYPlanetaService.asociarPlanetaASistemaSolar(sistema, planeta);
        }
    }