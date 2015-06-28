package tp2;

import java.math.BigDecimal;

public class Saldo {
	
	String uuid;
	BigDecimal saldo;
	int cantDebitos;
	int cantCreditos;
	BigDecimal tope;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public int getCantDebitos() {
		return cantDebitos;
	}
	public void setCantDebitos(int cantDebitos) {
		this.cantDebitos = cantDebitos;
	}
	public int getCantCreditos() {
		return cantCreditos;
	}
	public void setCantCreditos(int cantCreditos) {
		this.cantCreditos = cantCreditos;
	}
	public BigDecimal getTope() {
		return tope;
	}
	public void setTope(BigDecimal tope) {
		this.tope = tope;
	}
	
}
