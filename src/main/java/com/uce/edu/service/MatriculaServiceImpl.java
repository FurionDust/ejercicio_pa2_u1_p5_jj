package com.uce.edu.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRerpository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	IMatriculaRerpository iMatriculaRerpository;
	@Autowired
	IPropietarioRepository iPropietarioRepository;
	@Autowired
	IVehiculoRepository iVehiculoRepository;

	@Override
	public Matricula seleccionar(String cedula) {
		// TODO Auto-generated method stub
		return this.iMatriculaRerpository.seleccionar(cedula);
	}

	@Override
	public Matricula seleccionarEliminar(String cedula) {
		// TODO Auto-generated method stub
		return this.iMatriculaRerpository.seleccionar(cedula);
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRerpository.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRerpository.actualizar(matricula);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iMatriculaRerpository.eliminar(cedula);
	}

	@Override
	public void crearMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario propietario = this.iPropietarioRepository.seleccionar(cedula);
		Vehiculo vehiculo = this.iVehiculoRepository.seleccionar(placa);
		BigDecimal valorPesado = new BigDecimal(0.25);
		BigDecimal valorLiviano = new BigDecimal(0.20);
		BigDecimal valorMatricula = new BigDecimal(0);
		BigDecimal precio = vehiculo.getPrecio();
		BigDecimal descuento = new BigDecimal(0.95);
		BigDecimal valorMatriculaSup = new BigDecimal(2200);
		
		switch(vehiculo.getTipo()) {
		case "pesado":
		case "PESADO":
		case "Pesado":
			valorMatricula = precio.multiply(valorPesado);
			break;
		case "liviano":
		case "LIVIANO":
		case "Liviano":
			valorMatricula = precio.multiply(valorLiviano);
			break;
		}
		if(valorMatricula.compareTo(valorMatriculaSup)>=1) {
			valorMatricula= valorMatricula.multiply(descuento).setScale(2,RoundingMode.HALF_EVEN);
		}
		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setPropietario(propietario);
		matricula.setValorMatricula(valorMatricula);
		matricula.setVehiculo(vehiculo);
		this.iMatriculaRerpository.insertar(matricula);
		System.out.println("Matricula creada con exito!!");
		
		
	}

}