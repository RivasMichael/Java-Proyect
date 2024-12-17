
package CORREO;

import java.net.Socket;

public class ComprobarConexionInternet {
    public boolean test()
    {
        String dirWeb = "www.google.com";
        int puerto= 80;
        try
        {
            Socket s = new Socket(dirWeb, puerto);
            if(s.isConnected()){
                System.out.println("Conexión establecida con la dirección: " + dirWeb + " a través del pueto: " + puerto);
            }
        }
        catch (Exception e)
        {
            System.err.println("No se pudo establecer conexión con: " + dirWeb + " a través del puerto: " + puerto);
            return false;
        }
        return true;
    }
}    

