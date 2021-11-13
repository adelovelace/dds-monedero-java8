package dds.monedero.model;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;
import static dds.monedero.model.AgregarMovimiento.agregarMovimiento;
import static dds.monedero.model.LimiteMovimiento.limiteMovimiento;

public class ModificarSaldo {
    
    public static void poner(CuentaBancaria cuenta, double cuanto) {
        if (cuanto <= 0){
            throw new MontoNegativoException(cuanto + ": el monto a ingresar debe ser un valor positivo");
        }           
        MovimientoCuenta movimiento = new MovimientoCuenta(cuanto, TipoMovimiento.DEPOSITO);
        limiteMovimiento(cuenta, movimiento); 
        
        agregarMovimiento(cuenta, movimiento);  
        cuenta.setSaldo(cuenta.getSaldo() + cuanto);
    }

    public static void sacar(CuentaBancaria cuenta, double cuanto){
    if (cuanto <= 0) {
      throw new MontoNegativoException(cuanto + ": el monto a ingresar debe ser un valor positivo");
    }
    if (cuenta.getSaldo() - cuanto < 0) {
      throw new SaldoMenorException("No puede sacar mas de " + cuenta.getSaldo() + " $");
    }
    MovimientoCuenta movimiento = new MovimientoCuenta(cuanto, TipoMovimiento.RETIRO);
    limiteMovimiento(cuenta, movimiento); 
    
    agregarMovimiento(cuenta, movimiento);    
    cuenta.setSaldo(cuenta.getSaldo() - cuanto);
    }
}
