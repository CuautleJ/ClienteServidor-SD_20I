import java.net.*;
import java.io.*;

public class Cliente {
    
    public static void main(String[] args){
        
        //Definición del IP y el puerto para realizar la conexión
        final String HOST = "localhost";
        final int PUERTO = 5000;
        
        //Definición de diferentes flujos de entrada y salida de datos
        DataInputStream stringIn;
        DataInputStream intIn;
        DataInputStream floatIn;
        DataInputStream boolIn;
        
        DataOutputStream stringOut;
        DataOutputStream intOut;
        DataOutputStream floatOut;
        DataOutputStream boolOut;
        
        try{
            Socket socket = new Socket(HOST, PUERTO);
            
            stringIn = new DataInputStream(socket.getInputStream());
            intIn = new DataInputStream(socket.getInputStream());
            floatIn = new DataInputStream(socket.getInputStream());
            boolIn = new DataInputStream(socket.getInputStream());
            
            stringOut = new DataOutputStream(socket.getOutputStream());
            intOut = new DataOutputStream(socket.getOutputStream());
            floatOut = new DataOutputStream(socket.getOutputStream());
            boolOut = new DataOutputStream(socket.getOutputStream());
            
            stringOut.writeUTF("¡Hola servidor!");
            intOut.writeInt(64000);
            floatOut.writeFloat((float)2.718281);
            boolOut.writeBoolean(false);
            
            String mensaje = stringIn.readUTF();
            int entero = intIn.readInt();
            float real = floatIn.readFloat();
            boolean binario = boolIn.readBoolean();
            
            System.out.println("***Datos recibidos desde el Servidor***");
            System.out.println("Esto es un 'String': "+mensaje);
            System.out.println("Esto es un 'int': "+entero);
            System.out.println("Esto es un 'float': "+real);
            System.out.println("Esto es un 'boolean': "+binario);
            
            socket.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
