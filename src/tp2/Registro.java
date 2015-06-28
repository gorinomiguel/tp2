package tp2;

import java.math.BigDecimal;

public class Registro {
		
		String uuid;
		String nombre;
		String apellido;
		BigDecimal saldo;
		BigDecimal debitos;
		BigDecimal creditos;
		BigDecimal tope;
		
		int cantidadCreditos;
		int cantidadDebitos;

		public int getcantidadCreditos() {
			return cantidadCreditos;
		}
		
		public void setcantidadCreditos(int cantidadCreditos) {
			this.cantidadCreditos = cantidadCreditos;
		}
		
		public int getcantidadDebitos() {
			return cantidadDebitos;
		}
		public void setCantidadDebitos(int CantidadDebitos) {
			this.cantidadDebitos = CantidadDebitos;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public BigDecimal getSaldo() {
			return saldo;
		}

		public void setSaldo(BigDecimal saldo) {
			this.saldo = saldo;
		}

		public BigDecimal getDebitos() {
			return debitos;
		}

		public void setDebitos(BigDecimal debitos) {
			this.debitos = debitos;
		}

		public BigDecimal getCreditos() {
			return creditos;
		}

		public void setCreditos(BigDecimal creditos) {
			this.creditos = creditos;
		}

		public BigDecimal getTope() {
			return tope;
		}

		public void setTope(BigDecimal tope) {
			this.tope = tope;
		}
}

