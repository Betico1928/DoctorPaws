package com.javeriana.drpaws.proyecto.servicio.Medicamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Medicamento;
import com.javeriana.drpaws.proyecto.repositorio.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public Medicamento searchById(Long id) {
        // TODO: Implement method to search for a Medicamento by id
        // Example:
        return medicamentoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        // TODO: Implement method to delete a Medicamento by id
        // Example:
        medicamentoRepository.deleteById(id);
    }

    @Override
    public void update(Medicamento medicamento) {
        // TODO: Implement method to update a Medicamento
        // Example:
        medicamentoRepository.save(medicamento);
    }

    @Override
    public void add(Medicamento medicamento) {
        // TODO: Implement method to add a new Medicamento
        // Example:
        medicamentoRepository.save(medicamento);
    }

    @Override
    public List<Medicamento> getAll() {
        return medicamentoRepository.findAll();

    }

}
