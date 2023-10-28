package com.javeriana.drpaws.proyecto.servicio.Mascota;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javeriana.drpaws.proyecto.entidad.Mascota;
import com.javeriana.drpaws.proyecto.entidad.Tratamiento;
import com.javeriana.drpaws.proyecto.repositorio.MascotaRepository;
import com.javeriana.drpaws.proyecto.repositorio.TratamientoRepository;

@Service
public class MascotaServiceImpl implements com.javeriana.drpaws.proyecto.servicio.Mascota.MascotaService {

    @Autowired
    MascotaRepository repo;

    @Autowired
    TratamientoRepository tratamientoRepository;

    @Override
    public Mascota searchById(Long id) {
        return repo.findById(id).get();

    }

    @Override
    public List<Mascota> searchAll() {
        return repo.findAll();

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public void update(Mascota mascota, Long id) {
        // A pesar de que solo se cambian unos datos de la mascota
        // Actualizar la mascota en la base de datos con el objeto 
        // devuelto por front-end hace que se pierdan datos cruciales
        // para los usuarios y tratamientos
        Mascota mascota_previa = repo.findById(id).get();

        // Se pasa el usuario anterior a la mascota actualizada
        mascota.setUsuario(mascota_previa.getUsuario());

        // Se pasan los veterinarios (tratamientos) anteriores a la mascota actualizada
        mascota.setVeterinarios(mascota_previa.getVeterinarios());

        repo.save(mascota);

    }

    @Override
    public void add(Mascota mascota) {
        repo.save(mascota);
    }

    // Retorna el número de mascotas que hay en el sistema
    @Override
    public Long totalMascotas() {
        return repo.count();
    }

    // Retorna el número de mascotas que tienen tratamiento
    @Override
    public Long totalMascotasActivas() {
        desactivarMascotasSinTratamiento();
        return repo.countMascotasActivas();
    }

    // Esta función cambia el atributo Activo de mascotas a falso si 
    // esta mascota no tiene un registro de tratamientos.
    public void desactivarMascotasSinTratamiento() {
        List<Mascota> mascotas = repo.findAll();

        for (Mascota mascota : mascotas) {
            List<Tratamiento> tratamientos = tratamientoRepository.findTratamientosByMascota(mascota);

            if (tratamientos.isEmpty()) {
                mascota.setActivo(false);
                repo.save(mascota);
            }
        }
    }

    // Devuelve los tratamiento que se le han hecho a una mascota dado su id
    public List<Tratamiento> getTratamientosByNombreMascota(Long id) {
        Mascota mascota = repo.findById(id).get();
        if (mascota != null) {
            return tratamientoRepository.findTratamientosByMascota(mascota);
        } else {
            return null;
        }
    }

}
