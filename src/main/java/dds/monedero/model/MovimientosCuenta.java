/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dds.monedero.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ERWIN AURIA
 */
public class MovimientosCuenta {
    
    private LocalDateTime fecha;
    private double monto;
    private TipoMovimiento tipo;
    
    public MovimientosCuenta (double monto, TipoMovimiento tipo) {
        this.fecha= LocalDateTime.now();
        this.monto = monto;
    }
    
    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
       
}
