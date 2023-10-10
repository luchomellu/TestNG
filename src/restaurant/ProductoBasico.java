package restaurant;

public class ProductoBasico extends Producto implements Consumible {
	private int stock;
	public ProductoBasico(String nombre, float precioUnitarioCompra, float precioUnitarioVenta) {
		super(nombre, precioUnitarioCompra, precioUnitarioVenta);
	}

	@Override
	public void consumirStock(int cantidad) {
		this.stock -= cantidad;
	}

	@Override
	public void reponerStock(int cantidad) {
		this.stock += cantidad;
	}

	@Override
	public int getStock() {
		return this.stock;
	}
	public String toString() {
		return nombre;
	}

	//@Override
	public void despachar(int cantidad) {
		Almacen.ExtraerConsumibles(this, cantidad);
	}

	@Override
	public float getPrecioCompra() {
		return this.precioUnitarioCompra;
	}
}
