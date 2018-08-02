package com.asesoftware.pruebapiloto.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCTOS database table.
 * 
 */
@Entity
@Table(name="PRODUCTOS")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_PRODUCTO")
	private long codigoProducto;

	private String descripcion;

	private String nombre;

	@Column(name="PRECIO_UNIDAD")
	private BigDecimal precioUnidad;

	private BigDecimal stock;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="CODIGO_CATEGORIA")
	private Categoria categoria;

	public Producto() {
	}

	public long getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioUnidad() {
		return this.precioUnidad;
	}

	public void setPrecioUnidad(BigDecimal precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public BigDecimal getStock() {
		return this.stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}