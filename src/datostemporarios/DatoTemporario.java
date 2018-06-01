package datostemporarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatoTemporario {
	
	public final static String USUARIO = "daniel";
	final String regex = "^(.*(día).*(semana).*)|(.*(hora|día|fecha).*)$";
	Pattern p = Pattern.compile(regex);
	String respuesta = null;
	
	public String escuchar(String cadena) {
		Matcher m = p.matcher(cadena);
		
		if(m.matches() && m.group(5) != null && m.group(5).equals("hora"))	{	
			HoraYMinutos hm = new HoraYMinutos();
			respuesta = "@" + USUARIO + " son las " + hm.getHoraYMinutos();
			//System.out.println(respuesta);
		}
		
		else if(m.matches() && m.group(5) != null && (m.group(5).equals("fecha") || m.group(5).equals("día"))) {
			Fecha f = new Fecha();
			respuesta = "@" + USUARIO + " hoy es " + f.getDia() + " de " + f.getMes() + " de " + f.getAnio();
			//System.out.println(respuesta);
		}
		
		else if(m.matches() && m.group(3) != null) {
			DiaDeLaSemana ds = new DiaDeLaSemana(); 
			respuesta = "@" + USUARIO + " hoy es " + ds.getDiaDeLaSemana();
			//System.out.println(respuesta);
			}
		
		return respuesta;
	}	
	
	/*private String[] dias = { "domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado" };
	private String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
			"octubre", "noviembre", "diciebre" };

	private Calendar calendar;

	public DatoTemporario() {
		calendar = Calendar.getInstance();
	}

	public String getDiaDeLaSemana() {
		return dias[calendar.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public String getMes() {
		return meses[calendar.get(Calendar.MONTH) - 1];
	}

	public Integer getDia() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public Integer getAnio() {
		return calendar.get(Calendar.YEAR);
	}

	public String getHoraYMinutos() {
		return calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + " hs";
	}
	
//	public static void main(String[] args) {
//		DatoTemporario dt = new DatoTemporario();
//		System.out.println(dt.getDiaDeLaSemana());
//		System.out.println(dt.getMes());
//		System.out.println(dt.getDia());
//		System.out.println(dt.getAnio());
//		System.out.println(dt.getHoraYMinutos());
//	}*/
	
}