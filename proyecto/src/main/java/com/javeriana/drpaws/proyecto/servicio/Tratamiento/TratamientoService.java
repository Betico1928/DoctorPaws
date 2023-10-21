package com.javeriana.drpaws.proyecto.servicio.Tratamiento;

import java.util.List;

import com.javeriana.drpaws.proyecto.entidad.Tratamiento;

/**
 * El contrato del servicio de tratamientos y las funciones requeridas
 */
public interface TratamientoService {

    // Se busca por ID un tratamiento
    public Tratamiento searchById(Long id);

    // Se elimina un tratamiento por su ID
    public void deleteById(Long id);

    // Se actualiza un tratamiento del sistema
    public void update(Tratamiento tratamiento);

    // Se agrega un tratamiento
    public void add(Tratamiento tratamiento);

    // Se retorna cuantos tratamientos se han hecho en el ultimo mes
    public Long countTratamientosAdminsitradosEnUltimoMes();

    // Devuelve la lista entera de tratamientos en el sistema
    public List<Tratamiento> getAll();

    // Se retorna una lista conformada por el nombre del medicamento y la cantidad de tratamientos que usan el medicamenot
    public List<Object[]> obtenerCantidadTratamientosPorMedicamentoEnUltimoMes();

    // Encuentra los tres medicamentos más usados en los tratamientos
    public List<Object[]> findTop3Treatments();

    // Se calcula el total de ventas: Multiplicar la cantidad vendida por precio de venta.
    // Se suma ese producto para todos los medicamentos vendidos
    public Object computeSales();
    
    // Se calcula el total de ganancias: Es la resta entre el producto de cantidad vendida por precio de venta y el precio de compra del medicamento.
    // Se suma esa resta para todos los medicamentos vendidos
    public Object computeProfit();
    

}
