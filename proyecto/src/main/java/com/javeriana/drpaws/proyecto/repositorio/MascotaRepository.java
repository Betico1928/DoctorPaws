package com.javeriana.drpaws.proyecto.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javeriana.drpaws.proyecto.entidad.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> mascotas = new HashMap<>();

    public MascotaRepository() {
        mascotas.put(1, new Mascota(1, "Toby", "Dachshund (Salchicha)", 4, 20.5f, " La propietaria trajo a Toby después de encontrarlo repetidamente 'escondido' con solo su cabeza bajo el sofá y el resto de su largo cuerpo claramente visible. A pesar de los repetidos intentos de mostrarle cómo esconder todo su cuerpo, Toby insistía en que su método era el mejor.",
                "toby.jpg"));
        mascotas.put(2, new Mascota(2, "Bella", "Bulldog Francés", 2, 36.5f, "Bella ha comenzado a roncar tan fuerte que incluso despertó a los vecinos a través de las paredes del departamento. La dueña sospecha que Bella podría estar tratando de competir con el ronquido del abuelo.",
                "Bella.png"));
        mascotas.put(3, new Mascota(3, "Sparky", "Border Collie", 7, 30.5f, "Sparky ha estado persiguiendo sombras por toda la casa, especialmente las que genera el movimiento de las aspas del ventilador de techo. Recientemente, la propietaria encontró a Sparky sentado en el centro de la sala, mirando fijamente la lámpara durante horas, esperando que se moviera.",
                "Sparky.jpg"));
        mascotas.put(4, new Mascota(4, "Lulu", "Chihuahua", 3, 6.5f, "Cada vez que alguien intenta ponerse zapatos en la casa, Lulu se interpone, ladrando y defendiendo los zapatos como si fueran suyos. Incluso se ha observado que duerme dentro de ellos.",
                "Lulu.png"));
    }

    public Mascota findById(int id) {
        return mascotas.get(id);

    }

    public Collection<Mascota> findAll() {
        return mascotas.values();

    }

    public void deleteById(int id) {
        mascotas.remove(id);
    }

    public void updatebyId(Mascota mascota) {
        mascotas.put(mascota.getId(), mascota);
    }

    public void add(Mascota mascota) {
        int tam = mascotas.size();
        int lastId = mascotas.get(tam).getId();
        mascota.setId(lastId + 1);
        mascotas.put(lastId + 1, mascota);

    }

}
