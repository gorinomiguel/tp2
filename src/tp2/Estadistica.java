package tp2;

public class Estadistica {
	
	String uuid;
	public int getDebitos() {
		return debitos;
	}
	public void setDebitos(int debitos) {
		this.debitos = debitos;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	int debitos;
	int creditos;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
