import java.net.Socket;
import java.io.*;

/**
*
* Clase abstracta socket basica Cliente con modulos definidos de lectura y esxritura son socket servidor.
* Es obigatorio crear en las clases heredadas un main, el método menú y demas métodos y atributos necesarios para la aplicación.
 */
public abstract class Cliente{

	public void hablaServer(Socket sc,String men)
	{
    try {
    		OutputStream salida = sc.getOutputStream();
            DataOutputStream flujo = new DataOutputStream(salida);
            flujo.writeUTF(men);
    	} catch (Exception e)
        {
    		System.out.println("Error: " + e.getMessage());
    	}
	}

	public String escuchaServer(Socket sc){
    	String res = "";
        try {
            InputStream in = sc.getInputStream();
            DataInputStream flujo = new DataInputStream(in);
            res = flujo.readUTF();
    	} catch (Exception e)
    	{
    	    System.out.println("Error: " + e.getMessage());
    	}
        return res;
	}

	public abstract void menu(int port_Server,String IP_Server);
}
