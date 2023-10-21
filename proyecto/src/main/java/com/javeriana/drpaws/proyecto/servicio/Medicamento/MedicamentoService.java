package com.javeriana.drpaws.proyecto.servicio.Medicamento;

import java.util.List;

import com.javeriana.drpaws.proyecto.entidad.Medicamento;

public interface MedicamentoService {
    public Medicamento searchById(Long id);

    public List<Medicamento> getAll();

    public void deleteById(Long id);

    public void update(Medicamento medicamento);

    public void add(Medicamento medicamento);

}
