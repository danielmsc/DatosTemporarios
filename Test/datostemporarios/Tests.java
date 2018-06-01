package datostemporarios;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import datostemporarios.DatoTemporario;

public class Tests {

	public final static String USUARIO = "daniel";
	private Calendar calendar;
	private String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
								"octubre", "noviembre", "diciebre" };
	private String[] dias = { "domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado" };

	//public final static Date FECHA_HORA = new GregorianCalendar(2018, 3, 1, 15, 15, 0).getTime();
	
	
//	Asistente jenkins;
	DatoTemporario dt;
	
	@Before
	public void setup() {
		dt = new DatoTemporario();
		calendar = Calendar.getInstance();
	}
	
	@Test
	public void hora() {
		String[] mensajes = {
				"¿qué hora es, @jenkins?",
				"@jenkins, la hora por favor",
				"me decís la hora @jenkins?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@daniel son las " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ((calendar.get(Calendar.AM_PM) == Calendar.PM) ? " PM":" AM"),
					dt.escuchar(mensaje)
//					jenkins.escuchar(mensaje)
			);
		}
	}
	
	@Test
	public void fecha() {
		String[] mensajes = {
				"¿qué día es, @jenkins?",
				"@jenkins, la fecha por favor",
				"me decís la fecha @jenkins?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@daniel hoy es " + calendar.get(Calendar.DAY_OF_MONTH) + " de " + meses[calendar.get(Calendar.MONTH)] + " de " + calendar.get(Calendar.YEAR),
					dt.escuchar(mensaje)
//					jenkins.escuchar(mensaje) 
			);
		}
	}
	
	@Test
	public void diaDeLaSemana() {
		String[] mensajes = {
				"¿qué día de la semana es hoy, @jenkins?"
		};
		for (String mensaje : mensajes) {
			Assert.assertEquals(
					"@daniel hoy es " + dias[calendar.get(Calendar.DAY_OF_WEEK) - 1],
					dt.escuchar(mensaje)
//					jenkins.escuchar(mensaje)
			);
		}
	}
	
}