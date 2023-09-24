package com.javeriana.drpaws.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeriana.drpaws.proyecto.entidad.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
