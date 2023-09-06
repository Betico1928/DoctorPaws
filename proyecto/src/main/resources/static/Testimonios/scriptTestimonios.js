let titulo = document.getElementById('titulo');
let btn = document.getElementById('btn');
let header = document.querySelector('header');

let indiceActual = 0;

// Función para inicializar las posiciones y opacidades de las diapositivas
function inicializarDiapositivas() {
    const diapositivas = document.querySelectorAll('.carrusel-diapositiva');
    const totalDiapositivas = diapositivas.length;
    const angulo = 360 / totalDiapositivas;

    diapositivas.forEach((diapositiva, index) => {
        diapositiva.style.transform = `rotateY(${angulo * index}deg) translateZ(1200px)`;
        if (index === indiceActual) {
            diapositiva.style.opacity = 1;
            diapositiva.style.zIndex = "2";  // La diapositiva activa tiene un z-index más alto
        } else {
            diapositiva.style.opacity = 0.6;
            diapositiva.style.zIndex = "1";  // Las diapositivas no activas tienen un z-index más bajo
        }
    });
}


function mover(direccion) {
    const contenedor = document.querySelector('.carrusel');
    const diapositivas = document.querySelectorAll('.carrusel-diapositiva');
    const totalDiapositivas = diapositivas.length;
    const angulo = 360 / totalDiapositivas;

    indiceActual += direccion;

    if (indiceActual < 0) {
        indiceActual = totalDiapositivas - 1;
    } else if (indiceActual >= totalDiapositivas) {
        indiceActual = 0;
    }

    contenedor.style.transform = `rotateY(${indiceActual * -angulo}deg)`;

    // Luego de ajustar el índice actual, actualizamos las opacidades
    inicializarDiapositivas();
}

document.addEventListener('DOMContentLoaded', function() {
    inicializarDiapositivas();
});
