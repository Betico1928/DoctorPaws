console.log("Script enlazado");

const popup = document.querySelector(".popup");
outside_clicks = 0

function togglePopup() {
    document.getElementById("popup-1").classList.toggle("active");
    console.log("Ventana activada");
}

const search_bar = document.getElementById("search_bar");

search_bar.addEventListener("keydown", function (e) {
    if (e.code == "Enter") {
        console.log("El valor ingresado fue" + search_bar.value);
        applyFilter("Nombre", search_bar.value);
        document.getElementById("search_bar").value = "";
        togglePopup();
    }
}
)


filas_escondidas = [];







function applyFilter(filtro, texto) {
    removeFilter()
    table = document.getElementById("Mascotas");
    column_head = [];
    first_row = table.rows[0];
    for (var k = 0, col; col = first_row.cells[k]; k++) {
        console.log(col.textContent)
        column_head.push(col.textContent);
    }

    index = 0;
    for (var i = 0; i < column_head.length; i++) {
        if (column_head[i].includes(filtro)) {
            index = i;
        }
    }

    for (var i = 1, row; row = table.rows[i]; i++) {
        valor = row.cells[index].innerText;
        if (!valor.toString().toLowerCase().includes(texto.toString().toLowerCase())) {
            console.log(valor);
            filas_escondidas.push(i);
            row.style.display = 'none';
        }
    }

    console.log(filas_escondidas.length);
    console.log(table.rows.length);

    if(filas_escondidas.length == table.rows.length-1){
        console.log("No se encontraron resultados")
        console.log(document.getElementById("message"));
        document.getElementById("message").style.fontSize="50px";
        document.getElementById("message").style.visibility="visible";
        document.getElementById("error_result").style.padding="30px";

    }
    EnableRestore();
}

function EnableRestore(){
    console.log("Se muestra el boton de restaurar");
    restore = document.getElementById("restore")

    if (filas_escondidas.length > 0) {
        console.log("Hay filas escondidas")
        restore.style.visibility = "visible";
    }
    else {
        restore.style.visibility = "hidden";
        document.getElementById("message").style.fontSize="0px";
        document.getElementById("message").style.visibility="hidden";
        document.getElementById("error_result").style.padding="0px";
    }
}

function removeFilter() {
    let u = 0;
    console.log("Remover filtro")
    while (u < filas_escondidas.length) {
        table.rows[filas_escondidas[u]].style.display = "";
        u++;
    }
    filas_escondidas = [];
    EnableRestore();
}

