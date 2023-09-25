package com.palacio.productos.service;

import com.palacio.productos.model.Producto;
import com.palacio.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos (){
        return productoRepository.findAll();
    }

    public Producto saveProducto (Producto producto) {
        return productoRepository.save(producto);
    }

    public ResponseEntity<Producto> deleteProducto (Long id) {
        try {
            productoRepository.deleteById(id);
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public Optional<Producto> findProductoById (Long id) {
        return productoRepository.findById(id);
    }

}
