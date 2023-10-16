package com.javeriana.drpaws.proyecto.servicio.Tratamiento;

import java.util.List;

import com.javeriana.drpaws.proyecto.entidad.Tratamiento;

public interface TratamientoService {
    public Tratamiento searchById(Long id);

    public void deleteById(Long id);

    public void update(Tratamiento tratamiento);

    public void add(Tratamiento tratamiento);

    public Long countTratamientosAdminsitradosEnUltimoMes();

    public List<Tratamiento> getAll();

    public List<Object[]> obtenerCantidadTratamientosPorMedicamentoEnUltimoMes();

    public List<Object[]> findTop3Treatments();

    public Object computeSales();

    public Object computeProfit();
    

}
