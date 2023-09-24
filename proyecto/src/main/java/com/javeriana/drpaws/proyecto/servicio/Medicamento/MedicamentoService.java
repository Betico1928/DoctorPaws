package com.javeriana.drpaws.proyecto.servicio.Medicamento;

import com.javeriana.drpaws.proyecto.entidad.Medicamento;

public interface MedicamentoService {
    public Medicamento searchById(Long id);

    public void deleteById(Long id);

    public void update(Medicamento medicamento);

    public void add(Medicamento medicamento);

}
