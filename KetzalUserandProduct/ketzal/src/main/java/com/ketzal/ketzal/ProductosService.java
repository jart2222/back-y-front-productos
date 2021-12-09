package com.ketzal.ketzal;
import com.ketzal.ketzal.model.productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {
    private final ProductosRepository productosRepository;

    @Autowired
    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }
    public List<productos> getAllProductos(){
        return productosRepository.findAll();
    }

    public productos getProductos(Long id){
        return productosRepository.findById(id).orElseThrow(()-> new IllegalStateException("El producto con el id" +id+" no existe"));
    }
    public void deleteProductos(Long id){
        if (productosRepository.existsById(id)){
            productosRepository.deleteById(id);
        }else {
            throw new IllegalStateException("El producto con el id"+id+
                    "no existe");
        }

    }
    public void addProductos(productos producto){
        Optional<productos> prodByName=
                productosRepository.findByName(producto.getNombre());
        if (prodByName.isPresent()){
            throw new IllegalStateException("El producto con el nombre "+
                    producto.getNombre()+"ya existe");
        }
        productosRepository.save(producto);

    }
    @Transactional
    public void updateProductos(Long id,String nombre,String imagen,String descripcion,
                                double precio,double gramaje){
        productos producto= productosRepository.findById(id).
                orElseThrow(()-> new IllegalStateException("El producto con el id "+id+
                        "no existe"));
        if ((nombre != null))
            if ((!nombre.isEmpty())) {
                producto.setNombre(nombre);
            }

        if (descripcion !=null)
            if ((!descripcion.isEmpty()) &&
                    (!descripcion.equals(producto.getDescripcion())) ){
                producto.setDescripcion(descripcion);
            }
        if ((imagen != null))
            if ((!imagen.isEmpty())) {
                producto.setImagen(imagen);
            }
        if ((gramaje>0) ){
            producto.setGramaje(gramaje);
        }
        if ((precio>0)&&(precio != producto.getPrecio()) ){
            producto.setPrecio(precio);
        }


    }



}