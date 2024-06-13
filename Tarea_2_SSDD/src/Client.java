import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client {
    private static int PORT = 1099;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", PORT);
            Calculadora c = (Calculadora) Naming.lookup("//localhost/Calculadora");

            while (true) {
                String main = JOptionPane.showInputDialog("Calculadora de ecuaciones cuadráticas 'ax^2+bx+c'\n"
                        + "1: Método de la resolvente\n"
                        + "2: Método de trinomio cuadrado perfecto");

                switch (main) {
                    case "1": {
                        int x = Integer.parseInt(JOptionPane.showInputDialog("Valor de a"));
                        int y = Integer.parseInt(JOptionPane.showInputDialog("Valor de b"));
                        int z = Integer.parseInt(JOptionPane.showInputDialog("Valor de c"));

                        if (c.resolving(x, y, z)) {

                            JOptionPane.showMessageDialog(null, "X1: " + c.getValue(0) +
                                    "\nX2: " + c.getValue(1));
                        }
                        break;
                    }
                    case "2": {
                        int x = Integer.parseInt(JOptionPane.showInputDialog("Valor de a"));
                        int y = Integer.parseInt(JOptionPane.showInputDialog("Valor de b"));
                        int z = Integer.parseInt(JOptionPane.showInputDialog("Valor de c"));

                        if (c.Tperfect(x, y, z)) {

                            String sign = (y >= 0) ? "+" : "-";

                            JOptionPane.showMessageDialog(null, "( " + c.getValues(0) + "X " + sign + " "
                                    + c.getValues(1) + " )^2");
                        }
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "No existe la opción " + main);
                        break;
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Servidor no conectado \n" + e);
        }
    }

}
