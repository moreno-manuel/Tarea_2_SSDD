import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

public class rmi extends UnicastRemoteObject implements Calculadora {

    private double[] value;// arreglo para numeros con dcimales
    private int[] values;// arreglo para numeros enteros

    public rmi() throws RemoteException {

        value = new double[2];
        values = new int[2];

    }

    // metodo de la resolvente
    public boolean resolving(double a, double b, double c) throws RemoteException {

        if (a == 0) {// el valor de a no puede ser 0
            JOptionPane.showMessageDialog(null,
                    "El valor de 'a' no puede ser 0");
            return false;
        }

        // double determinante = Math.pow(b, 2) - (4 * a * c);

        if (Math.pow(b, 2) - (4 * a * c) >= 0) {
            setValue((((-1 * b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a)), 0);
            setValue((((-1 * b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a)), 1);
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "No existe una solución por el método de la resolvente");
        }
    return false;
    }

    // metodo de trinomio cuadrado perfecto
    public boolean Tperfect(int a, int b, int c) throws RemoteException {

        // convierte los numeros negativos a positivos
        a = Math.abs(a);
        c = Math.abs(c);

        if (a == 0 && c == 0) {// el valor de a no puede ser 0
            JOptionPane.showMessageDialog(null,
                    "El valor de 'a' y 'c 'no pueden ser 0");
            return false;
        }

        else if (((int) ((Math.sqrt(c) * Math.sqrt(c)))) == c) {// determina si la raiz es exacta
            if (((int) ((Math.sqrt(a) * Math.sqrt(a)))) == a) {
                values[0] = (int) Math.sqrt(a);
                values[1] = (int) Math.sqrt(c);
                return true;
            } else
                JOptionPane.showMessageDialog(null,
                        "No existe una solución por el método de trinomio cuadrado perfecto");

        } else {
            JOptionPane.showMessageDialog(null, "No existe una solución por el método de trinomio cuadrado perfecto");

        }
    return false;
    }


    // setea lo valores en el arreglo
    private void setValue(double val, int position) {

        val = Math.round(val * 100.0) / 100.0;// dos decimales
        value[position] = val;
    }

    // retorna los valores obtenidos de la resolvente
    public double getValue(int position) throws RemoteException {
        return value[position];
    }

    // retona los valores obtenidos de del trinomio cuadrado perfecto
    public int getValues(int position) throws RemoteException {
        return values[position];
    }

}
