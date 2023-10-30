package servidor;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;

import thriftstubs.ServicioCalculadora;
import thriftstubs.ServicioCalculadora.Iface;

public class ServidorCalculadora {
    public static void main(String[] args) {
        try {
            TServerSocket serviceTransport = new TServerSocket(9090);
            ServicioCalculadora.Iface handler = new AdaptadorOperacionesCalculadora();
            TProcessor processor = new ServicioCalculadora.Processor<Iface>(handler);

            TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(serviceTransport);
            serverArgs.processor(processor);

            // TServer server = new TSimpleServer(new
            // TSimpleServer.Args(serviceTransport).processor(processor)); //para simple
            TServer server = new TThreadPoolServer(serverArgs);
            server.serve();
            System.out.println("Servidor iniciado...");
        } catch (TException e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
