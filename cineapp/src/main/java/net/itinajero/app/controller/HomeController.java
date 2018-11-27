package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	
	// Creamos una variable de instancia para la fecha del sistema
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		
		System.out.println("Buscando las peliculas para la fecha " + fecha);
		
		// Todo esto se pega del método mostrar principal para que se pinten las fechas en el formulario
		// Al hacer click. Como el parámetro fecha le viene del formulario, cambiamos el atributo del modelo
		// para que envie lo que le venga por el parámetro fecha
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = getLista();
		
		// Añadimos una a una las peliculas
//		peliculas.add("Rapido y furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		
		// Pasamos la lista al modelo de datos
		// Pasamos tambien la fecha de sistema
		// Agregamos al modelo la lista de fechas
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		
		return "home";
		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = getLista();
		
		// Añadimos una a una las peliculas
//		peliculas.add("Rapido y furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		
		// Pasamos la lista al modelo de datos
		// Pasamos tambien la fecha de sistema
		// Agregamos al modelo la lista de fechas
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);

		return "home";
	}
	
	// @RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
		public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		
		// PROBAR LA URL DINAMICA
		System.out.println("Buscando horarios para la pelicula: " + idPelicula);
		System.out.println("para la fecha " + fecha);
		
		// TODO - Buscar en la BBDD los horarios
		
//		// Creamos variables con la informacion a mostrar de cada pelicula
//		String tituloPelicula = "Rapidos y furiosos";
//		int duracion = 136;
//		double precioEntrada = 50;
//		
//		// Para agregar las variables al modelo, usamos el objeto model
//		// con el metodo addAtribute
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio", precioEntrada);
		
		// Vamos a devolver el nombre de la vista, por lo que habrá que crear un archivo
		// .jsp con el nombre de la vista
		return "detalle";
	}
	
	// Metodo para generar una lista de objetos pelicula
	private List<Pelicula> getLista() {
		// Creamos un objeto formateador de Date
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		// Creamos la lista que devolveremos en el método
		List<Pelicula> lista = null;
		
		try {
			lista = new LinkedList<>();
			
			// Creamos las peliculas
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
			pelicula2.setImagen("bella.png");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
			pelicula3.setImagen("contratiempo.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong La Isla Calavera");
			pelicula4.setDuracion(118);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion y Aventura");
			pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("inactiva");
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("10-06-2017"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");
			
			
			// Agregamos las peliculas a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
			
			return lista;
			
		}
		catch(ParseException p_exc) {
			System.out.println("Error: " + p_exc.getMessage());
			return null;
		}		
	}
	
}
