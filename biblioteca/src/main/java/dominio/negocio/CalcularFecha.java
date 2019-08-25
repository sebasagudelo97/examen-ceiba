package dominio.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalcularFecha {

	public static Date obtenerFechaActual() {
		return new Date();
	}
	public static Date sumarDiasFechaActual(Date obtenerFechaAcual) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(obtenerFechaAcual);
		calendar.add(Calendar.DAY_OF_MONTH, 15);

		if (calendar.get(Calendar.DAY_OF_MONTH) == Calendar.SUNDAY) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
		String nuevaFecha = formatoFecha.format(calendar.getTime());
		Date fecha = null;

		try {
			fecha = formatoFecha.parse(nuevaFecha);
		} catch (ParseException e) {
			System.out.println(e);
		}

		return fecha;
	}
	
	public static Date generarFechaEntregaLibro() {
		return sumarDiasFechaActual(obtenerFechaActual());
	}

}
