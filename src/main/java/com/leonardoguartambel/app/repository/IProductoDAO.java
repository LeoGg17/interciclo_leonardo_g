package com.leonardoguartambel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.leonardoguartambel.app.entity.Producto;

public interface IProductoDAO extends JpaRepository<Producto,Long> {

}
