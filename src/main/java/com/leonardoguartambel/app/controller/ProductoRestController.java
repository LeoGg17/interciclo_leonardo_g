package com.leonardoguartambel.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.leonardoguartambel.app.entity.Producto;
import com.leonardoguartambel.app.repository.IProductoDAO;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
	@Autowired
	private IProductoDAO iproductodao;

/////////////////////////// LISTA TODOS LOS PRODUCTOS //////////////////////////
	@GetMapping
	public ResponseEntity<List<Producto>> getEstudiante() {
		List<Producto> productos = iproductodao.findAll();
		return ResponseEntity.ok(productos);
	}

////////////////////////// LISTA AL PRODUCTO UNICAMENTE POR ID ////////////////
	@RequestMapping(value = "{codigo}")
	public ResponseEntity<Producto> getProductoById(@PathVariable("codigo") Long codigo) {
		Optional<Producto> optionalProducto = iproductodao.findById(codigo);
		if (optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

//////////////////////// CREA UN REGISTRO PARA LA TABLA PRODUCTO /////////////
	@PostMapping
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
	 double c=0; 
			c=producto.getPrecio()*producto.getCantidad();
			if(c>50) {
				c=c*0.90*1.12;
			} 
			producto.setCalculo(c);
			Producto nuevoProducto = iproductodao.save(producto);
			return ResponseEntity.ok(nuevoProducto);
		 
		
	}

////////////////////////ACTUALIZA UN REGISTRO VALIENDOSE DE SU CODIGO /////////////
	@PutMapping
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
		Optional<Producto> optionalProducto =iproductodao.findById(producto.getCodigo());
		if (optionalProducto.isPresent()) {
			Producto actualizar = optionalProducto.get();
			actualizar.setDescripcion(producto.getDescripcion());
			actualizar.setPrecio(producto.getPrecio());
			actualizar.setCantidad(producto.getCantidad());
			actualizar.setCalculo(producto.getCalculo());
			iproductodao.save(actualizar);
			return ResponseEntity.ok(actualizar);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
 
////////////////////////ELIMINA UN REGISTRO DE LA TABLA PRODUCTOS /////////////
	@DeleteMapping(value = "{codigo}")
	public ResponseEntity<Void> deleteEstudiante(@PathVariable("codigo") Long codigo) {
		iproductodao.deleteById(codigo);
		return ResponseEntity.ok(null);
	}
}
