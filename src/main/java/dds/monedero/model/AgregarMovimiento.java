package dds.monedero.model;

public class AgregarMovimiento {
    
    public static void agregarMovimiento(CuentaBancaria cuenta, MovimientoCuenta movimiento) {
        cuenta.getMovimientos().add(movimiento);
    }    
}
