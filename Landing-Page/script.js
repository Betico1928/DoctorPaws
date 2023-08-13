let stars = document.getElementById('stars');
let moon = document.getElementById('moon');
let mountainsFront = document.getElementById('mountains_front');
let mountainsBehind = document.getElementById('mountains_behind');
let titulo = document.getElementById('titulo');
let margen = document.querySelector('.margen');

window.addEventListener('scroll', function () {
    let value = window.scrollY;

    // Calculate the desired position for the 'titulo' element
    let desiredHorizontalPosition = (window.innerWidth - titulo.offsetWidth) / 2;


    // Calculate the maximum margin-right value to stop horizontally
    let maxMarginRight = desiredHorizontalPosition + 350; // Considering initial right: -350px

    // Calculate the new margin-right value based on scroll position
    let newMarginRight = Math.min(maxMarginRight, value * 3.5);



    // Adjust the margin-right and top of the 'titulo' element
    titulo.style.marginRight = newMarginRight + 'px';


    // Adjust other animations as you did before
    stars.style.left = value * 0.25 + 'px';
    moon.style.top = value * 1.05 + 'px';
    mountainsFront.style.top = value * 0.3 + 'px';
    mountainsBehind.style.top = value * 0.5 + 'px';
});





