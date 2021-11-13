package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;

public class LimiteMovimiento {
    static double LIMITE_RETIRO = 1000;
    static int LIMITE_DEPOSITO = 3;

    public static void limiteMovimiento(CuentaBancaria cuenta, MovimientoCuenta mov) {
            // Limite de depositos
        if (mov.getTipo().equals(TipoMovimiento.DEPOSITO) && cuenta.getMovimientos().stream()
                                                .filter(movimiento -> movimiento.getTipo().equals(TipoMovimiento.DEPOSITO) && movimiento.getFecha().equals(mov.getFecha()))
                                                .count() >= LIMITE_DEPOSITO) {
            throw new MaximaCantidadDepositosException("Ya excedio los " + 3 + " depositos diarios");
            // Limite de Retiro
        } else if (mov.getTipo().equals(TipoMovimiento.RETIRO)) {
            double monto = cuenta.getMovimientos().stream()
                    .filter(movimiento -> movimiento.getTipo().equals(TipoMovimiento.RETIRO) && movimiento.getFecha().equals(mov.getFecha()))
                    .mapToDouble(MovimientoCuenta::getMonto)
                    .sum();
            if (monto + mov.getMonto() > LIMITE_RETIRO) {
                throw new MaximoExtraccionDiarioException("No puede extraer mas de $ " + LIMITE_RETIRO + " diarios, límite: " + (LIMITE_RETIRO - mov.getMonto()));
            }
        }
    }
}
