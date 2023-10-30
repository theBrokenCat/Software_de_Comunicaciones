package calculadora;

import CalculadoraGUI.ICalculadora;

/** Esta clase sirve para adaptar la interfaz de la clase calculadora.OperacionesCalculadora a la interfaz
 * de CalculadoraGUI.ICalculadora.
 * Se peude utilizar un adaptador de clase o de objeto.
 */
public class AdaptadorOperacionesCalculadoraGUI extends OperacionesCalculadora implements ICalculadora {

	@Override
    public double sumar(double a, double b) {
        return super.implementacionSumar(a, b);
        //return ICalculadora.super.sumar(a, b);
        //return implementacionSumar(a, b); //ya que contiene este método tb
    }

    @Override
    public double restar(double a, double b) {
        return super.implementacionRestar(a, b);
    }

    @Override
    public double multiplicar(double a, double b) {
        return super.implementacionMultiplicar(a, b);
    }

    @Override
    public double dividir(double a, double b) throws Exception{
        return super.implementacionDividir(a, b);
    }

    @Override
    public double elevarAlCuadrado(double a) {
        return super.implementacionCuadrado(a);
    }

    @Override
    public double obtenerUltimoResultado() {
        return super.implementacionUR();
    }

    @Override
    public void memoriaLimpiar() {
        super.implementacionML();
    }

    @Override  
    public void memoriaAniadir() {
        super.implementacionMA();
    }

    @Override
    public double memoriaObtener() {
        return super.implementacionMO();
    }

}
