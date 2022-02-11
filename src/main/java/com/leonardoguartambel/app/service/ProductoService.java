package com.leonardoguartambel.app.service;

import java.util.List;
 
import com.leonardoguartambel.app.entity.Producto;

public interface ProductoService {
public List<Producto>findAll();
	
	public Producto save(Producto producto);
	
	public Producto findById(long codigo);
	
	public void delete (Long codigo);
}
