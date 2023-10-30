package servidor;

import org.apache.thrift.TException;

import calculadora.OperacionesCalculadora;
import thriftstubs.CalculadoraExcepcion;
import thriftstubs.ServicioCalculadora.Iface;

/**
 * Esta clase sirve para adaptar la interfaz de la clase
 * calculadora.OperacionesCalculadora a la interfaz
 * de CalculadoraGUI.ICalculadora.
 * Se peude utilizar un adaptador de clase o de objeto.
 */
public class AdaptadorOperacionesCalculadora extends OperacionesCalculadora implements Iface {

    public double sumar(double a, double b) {
        return this.implementacionSumar(a, b); // que viene del extends de OperacionesCalculadora
        // return ICalculadora.super.sumar(a, b);
        // return implementacionSumar(a, b); //ya que contiene este método tb
    }

    public double restar(double a, double b) {
        return this.implementacionRestar(a, b);
    }

    public double multiplicar(double a, double b) {
        return this.implementacionMultiplicar(a, b);
    }

    public double dividir(double a, double b) throws CalculadoraExcepcion, TException {
        try {
            return this.implementacionDividir(a, b); // se me debería quejar porque debería lanzar Exception
        } catch (Exception e) {
            throw new CalculadoraExcepcion(e.getMessage()); // el error que le llegará al cliente
        }
    }

    public double elevarAlCuadrado(double a) {
        return this.implementacionCuadrado(a);
    }

    public double obtenerUltimoResultado() {
        return this.implementacionUR();
    }

    public void memoriaLimpiar() {
        this.implementacionML();
    }

    public void memoriaAniadir() {
        this.implementacionMA();
    }

    public double memoriaObtener() {
        return this.implementacionMO();
    }

}
