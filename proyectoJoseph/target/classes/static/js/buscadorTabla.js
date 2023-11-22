function searchTable() {
    let input, filter, table, tr, td, i, j, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("cuerpoTabla");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        let found = false;
        for (j = 1; j <= 2; j++) { // Busca en las columnas 1 y 2
            td = tr[i].getElementsByTagName("td")[j];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            tr[i].style.display = "";
        } else {
            tr[i].style.display = "none";
        }
    }
}

document.addEventListener('DOMContentLoaded', function() {
    let numVisitas = 0;

    // Obtén la cookie llamada "visita"
    let cookieVisita = document.cookie.split('; ').find(row => row.startsWith('visita='));

    if (cookieVisita) {
        // Si la cookie existe, incrementa su valor en 1
        numVisitas = parseInt(cookieVisita.split('=')[1]) + 1;
    } else {
        // Si la cookie no existe, crea una nueva con un valor de 1
        numVisitas = 1;
    }

    // Escribe el número de visitas en la etiqueta HTML
    document.getElementById('numVisitas').textContent = numVisitas;

    // Crea o actualiza la cookie "visita" con el nuevo valor
    document.cookie = 'visita=' + numVisitas + '; path=/';
});

// Función para eliminar la cookie "visita"
function eliminarCookieVisita() {
    document.cookie = 'visita=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
}



