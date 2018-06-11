package vo;

public class Factura {
	
	private String codigoFactura;
	private int consumoActivo;
	private int subsidioNacion;
	private int alumbradoPublico;
	private int totalPagar;
	private String nombreUsuario;
	private String fechaFactura;
		
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public int getConsumoActivo() {
		return consumoActivo;
	}
	public void setConsumoActivo(int consumoActivo) {
		this.consumoActivo = consumoActivo;
	}
	public int getSubsidioNacion() {
		return subsidioNacion;
	}
	public void setSubsidioNacion(int subsidioNacion) {
		this.subsidioNacion = subsidioNacion;
	}
	public int getAlumbradoPublico() {
		return alumbradoPublico;
	}
	public void setAlumbradoPublico(int alumbradoPublico) {
		this.alumbradoPublico = alumbradoPublico;
	}
	public int getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(int totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	
	
	
}
