import java.net.*;
import java.io.*;
/**
 * Clase que define el comprotamiento base de los hilos que usaran los servidores concurrentes en cada aplicación.
 * Con modulos basicos de lectura y escritura con sockets clientes.
 * Y el moulo run de la clase therad necesario para ejecutar el hilo.
 */
public abstract class HiloServidor extends Thread{

    private Socket cliente;

    public HiloServidor(Socket s){
        this.cliente = s;
    }

    public void hablaCliente(String resp){

        try
        {
            OutputStream out = cliente.getOutputStream();
            DataOutputStream flujo = new DataOutputStream(out);
            flujo.writeUTF(resp);
        } catch (Exception e)
        {
	        System.out.println("Error: " + e.getMessage());
        }
    }

    public String escuchaCliente()
    {
        String datos = "";
        try {
            InputStream in = this.cliente.getInputStream();
            DataInputStream flujo = new DataInputStream(in);
            datos = flujo.readUTF();

        } catch (Exception e)
        {
	        System.out.println("Error: " + e.getMessage());
        }
        return datos;
    }

    public abstract void run();
}
