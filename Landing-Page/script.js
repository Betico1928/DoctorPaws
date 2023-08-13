let stars = document.getElementById('stars');
let moon = document.getElementById('moon');
let mountainsBehind = document.getElementById('mountains_behind');
let titulo = document.getElementById('titulo');
let btn = document.getElementById('btn');
let mountainsFront = document.getElementById('mountains_front');
let header = this.document.querySelector('header');

window.addEventListener('scroll', function () {
    let value = window.scrollY;
    stars.style.left = value * 0.25 + 'px';
    moon.style.top = value * 1.05 + 'px';
    mountainsBehind.style.top = value * 0.5 + 'px';
    mountainsFront.style.top = value * 0 + 'px';
    titulo.style.marginRight = value * 3 + 'px';
    titulo.style.marginTop = value * 1.5 + 'px';
    btn.style.marginTop = value * 1.5 + 'px';
    header.style.top = value * 0.5 + 'px';

    let desiredHorizontalPosition = (window.innerWidth - titulo.offsetWidth) / 2;


    // Calculate the maximum margin-right value to stop horizontally
    let maxMarginRight = desiredHorizontalPosition + 350; // Considering initial right: -350px

    // Calculate the new margin-right value based on scroll position
    let newMarginRight = Math.min(maxMarginRight, value * 3.5);



    // Adjust the margin-right and top of the 'titulo' element
    titulo.style.marginRight = newMarginRight + 'px';



    /*
        // Calculate the desired position for the 'titulo' element
    let desiredHorizontalPosition = (window.innerWidth - titulo.offsetWidth) / 2;


    // Calculate the maximum margin-right value to stop horizontally
    let maxMarginRight = desiredHorizontalPosition + 350; // Considering initial right: -350px

    // Calculate the new margin-right value based on scroll position
    let newMarginRight = Math.min(maxMarginRight, value * 3.5);



    // Adjust the margin-right and top of the 'titulo' element
    titulo.style.marginRight = newMarginRight + 'px';


    // Adjust other animations as you did before
    mountainsFront.style.top = value * 0.3 + 'px';
    mountainsBehind.style.top = value * 0.5 + 'px'; */
});





