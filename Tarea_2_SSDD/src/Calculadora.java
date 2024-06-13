import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {

    public boolean resolving (double a, double b, double c) throws RemoteException; //metodo de la resolvente
    public boolean Tperfect (int a, int b, int c) throws RemoteException; //metodo de competacion al cuadrado
    public double getValue(int position) throws RemoteException;
    public int getValues(int position) throws RemoteException;
   

}
