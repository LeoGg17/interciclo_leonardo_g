package com.leonardoguartambel.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	@Column(name = "precio", nullable = false, scale=2)
	private double precio;
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	@Column(name = "calculo", scale=2)
	private double calculo;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCalculo() {
		return calculo;
	}
	public void setCalculo(double calculo) {
		this.calculo = calculo;
	}
	 
	
}
