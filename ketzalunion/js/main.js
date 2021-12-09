 
function traer_productos(){
    let url ="http://127.0.0.1:8080/api/productos";
    let promise=fetch(url,{ 
                            method: 'GET',
                            headers: { 'Content-Type': 'application/json'}
                        })
    promise
    .then(function(response){
        return response.json()
    })
    .then(function(data){
        desplejar_get(data)
    } );
}

function desplejar_get(data){
    for (const i in data) {
        let id=data[i].idProductos
        let idP=`Producto con id : ${data[i].idProductos}`
        let nombreP= `Nombre producto : ${data[i].nombre}`
        let imagenP= `Direccion de imagen : ${data[i].imagen}`;
        let productoP=`Descripcion del producto : ${data[i].descripcion}`;
        let precioP=`Precio del producto: ${data[i].precio} pesos.`
        let gramajeP=`Gramaje del producto: ${data[i].gramaje} gr.`;
        console.log("hola")
        crear_lista(id,idP,nombreP,imagenP,productoP,precioP,gramajeP);
      }    
}

function crear_lista(id,idP,nombreP,imagenP,productoP,precioP,gramajeP){
    let tarjetas=document.getElementById("tarjetas")
    tarjetas.innerHTML+=
    `                   <div class="col-6">
                            <ul class="list-group">
                            <li class="list-group-item list-group-item-success" aria-disabled="true">${idP}</li>
                            <li class="list-group-item list-group-item-danger">${nombreP}</li>
                            <li class="list-group-item list-group-item-danger">${imagenP}</li>
                            <li class="list-group-item list-group-item-danger">${productoP}</li>
                            <li class="list-group-item list-group-item-danger">${precioP}</li>
                            <li class="list-group-item list-group-item-danger">${gramajeP}</li>
                            <li class="list-group-item list-group-item-danger"><button type="button" class="btn btn-success" onclick="borrarProducto(${id})" >Eliminar</button></li>
                            <li class="list-group-item list-group-item-danger"><button type="button" class="btn btn-success" onclick="borrarProducto(${id})" >Update</button></li>

                            </ul>
                        <div>                          
    `
    }

function crear(){
    let url ="http://127.0.0.1:8080/api/productos";
    let data = {nombre:"huawei2",
                imagen:"/imagen/2",
                descripcion:"caldia3",
                precio:123.0,
                gramaje:323.0} ;

    let promise=fetch(url,{ method: 'POST',headers: { 'Content-Type': 'application/json'}, body: JSON.stringify(data)})
       promise
       .then(response =>{ 
           if (response.status=200){
               alert("Exitoso");
           }
       })
   

}

function borrarProducto(id){
    let url =`http://127.0.0.1:8080/api/productos/${id}`;
    let promiseDelete=fetch(url,{ 
                            method: 'DELETE',
                            headers: { 'Content-Type': 'application/json'}
                        })
    promiseDelete
    .then(function(){
        return alert("Producto eliminado")
    })
}

/* function update_producto(id,nombreP,imagenP,productoP,precioP,gramajeP){
    let url=`http://127.0.0.1:8080/api/productos/${id}?nombre=${nombreP}&imagen=${imagenP}&descripcion=${productoP}&precio=20&gramaje=29`
    let promiseDelete=fetch(url,{ 
        method: 'PUT',
        headers: { 'Content-Type': 'application/json'}
            })
        promiseDelete
        .then(function(){
        return alert("Producto Actualizado")
        })
} */



