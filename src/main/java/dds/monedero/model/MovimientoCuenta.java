package dds.monedero.model;

import java.time.LocalDate;

public class MovimientoCuenta {
    
    private LocalDate fecha;
    private double monto;
    private TipoMovimiento tipo;
    
    public MovimientoCuenta (double monto, TipoMovimiento tipo) {
        this.fecha= LocalDate.now();
        this.monto = monto;
    }
    
    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }       
}
