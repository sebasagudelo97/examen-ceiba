package dominio.negocio.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dominio.negocio.ValidarIsbn;

public class ValidarIsbnTest {
	public static final String ISBN_PALINDROMO = "TB7887BT";
	public static final String ISBN = "RUO312SDV55";
	public static final String COMPARAR_DIGITOS = "31255";
	public static final String ISBN_NO_PALINDROMO = "ZB7887BT";
	public static final int NUMERO_COMPARAR_ISBN = 16;

	@Test
	public void validarIsbnPalindromaTest() {

		assertTrue(ValidarIsbn.validarIsbnPalindroma(ISBN_PALINDROMO));

	}

	@Test
	public void validarIsbnNoPalindromaTest() {

		assertFalse(ValidarIsbn.validarIsbnPalindroma(ISBN_NO_PALINDROMO));

	}

	@Test
	public void sumarDigitosIsbnTest() {
		assertEquals(ValidarIsbn.sumarDigitosIsbn(ISBN), NUMERO_COMPARAR_ISBN);
	}

	@Test
	public void obtenerDigitosIsbnTest() {
		assertEquals(ValidarIsbn.obtenerDigitosIsbn(ISBN), COMPARAR_DIGITOS);

	}

}
