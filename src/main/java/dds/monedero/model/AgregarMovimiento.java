/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dds.monedero.model;

/**
 *
 * @author ERWIN AURIA
 */
public class AgregarMovimiento {
    
    
    public AgregarMovimiento(CuentaBancaria cuenta,Movimiento movimiento){
        cuenta.getMovimientos().add(movimiento);
    }
    
}