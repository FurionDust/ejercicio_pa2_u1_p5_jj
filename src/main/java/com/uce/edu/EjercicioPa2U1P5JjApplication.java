package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5JjApplication implements CommandLineRunner {

	@Autowired
	IVehiculoService iVehiculoService;
	@Autowired
	IPropietarioService iPropietarioService;
	@Autowired
	IMatriculaService iMatriculaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5JjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Vehiculo vehiculo1 = new Vehiculo();
		vehiculo1.setPlaca("PDH-9652");
		vehiculo1.setMarca("Hyundai");
		vehiculo1.setPrecio(new BigDecimal(15000));
		vehiculo1.setTipo("liviano");
		this.iVehiculoService.insertar(vehiculo1);

		Propietario propietario1 = new Propietario();
		propietario1.setCedula("1719608729");
		propietario1.setNombre("Alejandro");
		propietario1.setApellido("Jimenez");
		propietario1.setGenero("Masculino");
		this.iPropietarioService.insertar(propietario1);

		propietario1.setCedula("1719608728");
		propietario1.setApellido("Loor");
		this.iPropietarioService.actualizar(propietario1);

		this.iMatriculaService.crearMatricula("1719608728", "PDH-9652");

		System.out.println(this.iMatriculaService.seleccionar("1719608728"));

	}

}
