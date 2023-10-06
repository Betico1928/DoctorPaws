package com.javeriana.drpaws.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javeriana.drpaws.proyecto.entidad.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    public Veterinario findByEmail(String email);

    // private Map<String, Veterinario> veterinarios = new HashMap<>();

    // public VeterinarioRepository() {
    // veterinarios.put("veterinario1@example.com", new
    // Veterinario("veterinario1@example.com", "password1"));
    // veterinarios.put("veterinario2@example.com", new
    // Veterinario("veterinario2@example.com", "password2"));
    // // Puedes agregar más datos de ejemplo aquí
    // }

    // public Veterinario findByEmail(String email) {
    // return veterinarios.get(email);
    // }
}
