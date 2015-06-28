package tp2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
@Path("/calcular")
public class Calculador {
	
	public static Map <String, Saldo> saldosFinales = new HashMap <String, Saldo> ();
	
	@Path("/registro")
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public static Response procesarRegistro ( Registro r ) {
		
		BigDecimal valor = new BigDecimal("0");
		Saldo datosTemp = new Saldo (); 
		datosTemp.setSaldo(r.getSaldo());
		datosTemp.setTope(r.getTope());
		datosTemp.setUuid(r.getUuid());
		
		if ( saldosFinales.containsKey(r.getUuid()) ){
			
			datosTemp = saldosFinales.get(r.getUuid());
			datosTemp.saldo = datosTemp.saldo.add(r.getCreditos()).subtract(r.getDebitos());
			
			if ( r.getCreditos().compareTo(valor) > 0){
				datosTemp.setCantCreditos(datosTemp.getCantCreditos() + 1);
			}
			if ( r.getDebitos().compareTo(valor) > 0 ) {
				datosTemp.setCantDebitos(datosTemp.getCantDebitos() + 1);
			}
			
			saldosFinales.put(r.getUuid(),datosTemp); 
		}else{
			//El cliente está siendo procesado por primera vez. Se agrega el cliente al MAP.
			if ( r.getCreditos().compareTo(valor) > 0){
				datosTemp.setCantCreditos(datosTemp.getCantCreditos() + 1);
			}
			if ( r.getDebitos().compareTo(valor) > 0 ) {
				datosTemp.setCantDebitos(datosTemp.getCantDebitos() + 1);
			}
			
			datosTemp.saldo = datosTemp.saldo.add(r.getCreditos()).subtract(r.getDebitos());
			saldosFinales.put(r.getUuid(),datosTemp);
		}	
	
	System.out.println("Ingreso movimiento"); 
	return Response.ok().build();
	}

	@Path("/saldos")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public Response obtenerSaldosFinales (){

		ArrayList <SaldoFinal> listaFinales = new ArrayList <SaldoFinal> ();
		
		for (Saldo datosTemp : saldosFinales.values()) {
		
			SaldoFinal aux = new SaldoFinal();
			aux.setUuid(datosTemp.getUuid());
			aux.setSaldo(datosTemp.getSaldo());
 
			listaFinales.add(aux);
		}
	
	return Response.status(200).entity(listaFinales).build();
	}
	
	@Path("/cuentaspasadas")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public Response superanTope (){
	
		ArrayList <Tope> listaTope = new ArrayList <Tope> ();
		
		for (Saldo datosTemp : saldosFinales.values()) {
			
			Tope aux = new Tope();
			
			if ( datosTemp.getSaldo().compareTo(datosTemp.getTope()) == 1){
				aux.setUuid(datosTemp.getUuid());
				aux.setSaldo(datosTemp.getSaldo().subtract(datosTemp.getTope()));
				listaTope.add(aux);
			}
	
		}
		
	return Response.status(200).entity(listaTope).build();
	}
	
	@Path("/estadisticas")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public Response cantidadDebYCred (){
		
		ArrayList <Estadistica> listaDebCred = new ArrayList <Estadistica> ();

		for (Saldo datosTemp : saldosFinales.values()) {
			
			Estadistica aux = new Estadistica();
			aux.setUuid(datosTemp.getUuid());
			aux.setCreditos(datosTemp.getCantCreditos());
			aux.setDebitos(datosTemp.getCantDebitos());
 
			listaDebCred.add(aux);
		}
					
	return Response.status(200).entity(listaDebCred).build();	
	}
}