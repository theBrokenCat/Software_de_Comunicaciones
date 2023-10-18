package cliente;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import CalculadoraGUI.ICalculadora;
import thriftstubs.CalculadoraExcepcion;
import thriftstubs.ServicioCalculadora;

/**
 * Esta clase sirve para adaptar la interfaz de la clase
 * calculadora.OperacionesCalculadora a la interfaz
 * de CalculadoraGUI.ICalculadora.
 * Se peude utilizar un adaptador de clase o de objeto.
 */

// ahora usa thrift
// en la clase servicioCalculadora están los stubs con stub cliente
public class AdaptadorOperacionesCalculadoraGUI implements ICalculadora {

    private ServicioCalculadora.Iface stubClient;

    public AdaptadorOperacionesCalculadoraGUI() {
        try {
            final TTransport transporte;
            transporte = new TSocket("localhost", 9090);
            transporte.open();
            final TProtocol protocolo = new TBinaryProtocol(transporte);
            this.stubClient = new ServicioCalculadora.Client(protocolo);
        } catch (TTransportException e) {
            System.exit(1); // si no se puede conectar, se sale del programa
        }

    }

    @Override
    public double sumar(double a, double b) {
        try {
            return stubClient.sumar(a, b);
        } catch (TException e) {
            e.printStackTrace();
            return 0; // como alternativa
        }
        // return ICalculadora.super.sumar(a, b);
        // return implementacionSumar(a, b); //ya que contiene este método tb
    }

    @Override
    public double restar(double a, double b) {
        try {
            return stubClient.restar(a, b);
        } catch (TException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double multiplicar(double a, double b) {
        try {
            return stubClient.multiplicar(a, b);
        } catch (TException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public double dividir(double a, double b) throws Exception {
        try {
            return stubClient.dividir(a, b);
        } catch (CalculadoraExcepcion e) {
            throw new Exception(e.getMensaje()); // si o si ********************* lo he definido en el .thrift
        } catch (TException e) {
            return 0;
        }
    }

    @Override
    public double elevarAlCuadrado(double a) {
        try {
            return stubClient.elevarAlCuadrado(a);
        } catch (TException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double obtenerUltimoResultado() {
        try {
            return stubClient.obtenerUltimoResultado();
        } catch (TException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void memoriaLimpiar() {
        try {
            stubClient.memoriaLimpiar();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void memoriaAniadir() {
        try {
            stubClient.memoriaAniadir();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double memoriaObtener() {
        try {
            return stubClient.memoriaObtener();
        } catch (TException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
