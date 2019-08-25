package dominio;

import java.util.Date;

import dominio.excepcion.PrestamoException;
import dominio.negocio.CalcularFecha;
import dominio.negocio.ValidarIsbn;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;

public class Bibliotecario {

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String LIBRO_SOLO_PARA_BIBLIOTECA = "El libro solo se encuentra disponible para la biblioteca";
	public static final String SE_DEBE_AGREGAR_ISBN = "Se debe agregar un isbn";

	private RepositorioLibro repositorioLibro;
	private RepositorioPrestamo repositorioPrestamo;

	public Bibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
		this.repositorioLibro = repositorioLibro;
		this.repositorioPrestamo = repositorioPrestamo;

	}

	public void prestar(String isbn, String nombreUsuario) {
		Libro libro = this.repositorioLibro.obtenerPorIsbn(isbn);

		if (esPrestado(isbn) == false) {
			if (ValidarIsbn.validarIsbnPalindroma(libro.getIsbn()) == false) {
				Prestamo prestamo = new Prestamo(CalcularFecha.obtenerFechaActual(), libro,
						fechaEntrega(libro.getIsbn()), nombreUsuario);
				repositorioPrestamo.agregar(prestamo);
			} else {
				throw new PrestamoException(LIBRO_SOLO_PARA_BIBLIOTECA);
			}
		} else {
			throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
		}
	}

	public boolean esPrestado(String isbn) {

		return repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn) != null ? true : false;

	}

	public Date fechaEntrega(String isbn) {
		CalcularFecha calcularFecha = new CalcularFecha();

		int sumaDigitosIsbn = ValidarIsbn.sumarDigitosIsbn(isbn);

		if (sumaDigitosIsbn > 30) {
			return calcularFecha.generarFechaEntregaLibro();
		} else {
			return null;
		}
	}
}
