package com.palacio.productos.controller;

import com.palacio.productos.model.Producto;
import com.palacio.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getProductos () {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @GetMapping("/{id}")
    public Optional<Producto> findProductoById (@PathVariable Long id) {
        return productoService.findProductoById(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<Producto> insertProducto (@RequestBody Producto producto) {
        Producto productoTemporal = productoService.saveProducto(producto);
        try {
            return ResponseEntity.created(new URI("/api/producto" + productoTemporal.getId())).body(productoTemporal);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Producto> updateProducto (@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoTemporal = productoService.saveProducto(producto);
        try {
            return ResponseEntity.created(new URI("/api/producto" + productoTemporal.getId())).body(productoTemporal);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producto> deleteProducto (@PathVariable Long id) {
        return productoService.deleteProducto(id);
    }
}
