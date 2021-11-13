/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dds.monedero.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERWIN AURIA
 */
public class CuentaBancaria {
    
    private double saldo;
    private List<MovimientoCuenta> movimientos;
    private TipoCuenta t_cuenta;
    
    public CuentaBancaria(TipoCuenta t_cuenta){
        this.t_cuenta= t_cuenta;
        this.movimientos= new ArrayList();
        this.saldo=0;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<MovimientoCuenta> getMovimientos() {
        return movimientos;
    }

    public TipoCuenta getT_cuenta() {
        return t_cuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
