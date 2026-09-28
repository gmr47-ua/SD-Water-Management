import java.net.*;
import java.io.*;

/**
* Clase abstracta socket basica Servidor concurrente.
* Es obigatorio crear en las clases heredadas un main, el método menú y demas métodos y atributos necesarios para la aplicación.
 */
public abstract class Servidor {





    public abstract void menu(int port_server);

    public abstract void procesarPeticion(HiloServidor hilo);

}
