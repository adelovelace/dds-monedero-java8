/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;
import java.time.LocalDate;

/**
 *
 * @author ERWIN AURIA
 */
public class ModificarSaldo {
    
    public void poner(CuentaBancaria cuenta, double cuanto) {
        if (cuanto <= 0){
            throw new MontoNegativoException(cuanto + ": el monto a ingresar debe ser un valor positivo");
        }
        
        if (cuenta.getMovimientos().stream().filter(movimiento -> movimiento.isDeposito()).count() >= 3) {
            throw new MaximaCantidadDepositosException("Ya excedio los " + 3 + " depositos diarios");
        }
        
        new Movimiento(LocalDate.now(), cuanto, true).agregateA(this);
    }

    public void sacar(double cuanto){
    if (cuanto <= 0) {
      throw new MontoNegativoException(cuanto + ": el monto a ingresar debe ser un valor positivo");
    }
    if (getSaldo() - cuanto < 0) {
      throw new SaldoMenorException("No puede sacar mas de " + getSaldo() + " $");
    }
    double montoExtraidoHoy = getMontoExtraidoA(LocalDate.now());
    double limite = 1000 - montoExtraidoHoy;
    if (cuanto > limite) {
      throw new MaximoExtraccionDiarioException("No puede extraer mas de $ " + 1000
          + " diarios, límite: " + limite);
    }
    new Movimiento(LocalDate.now(), cuanto, false).agregateA(this);
    }
  }

}
