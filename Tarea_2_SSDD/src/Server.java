import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Server {

    private static int PORT = 1099; // puerto para el uso del servidor

    public static void main(String[] args) {

        try {
            Registry registry = java.rmi.registry.LocateRegistry.createRegistry(PORT);
            registry.bind("Calculadora", new rmi());
            JOptionPane.showMessageDialog(null, "Servidor escuchando por el puerto '" + PORT +"'");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay conexión al puerto" + e);
        }
    }

}
