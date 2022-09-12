/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote{
    public String[][] calculateMayor(String[][] mat, int cestudiantes, int cnotas) throws RemoteException;
    public String[][] calculateMenor(String[][] mat, int cestudiantes, int cnotas) throws RemoteException;
    public String[][] calculatePromedio(String[][] mat,  int cestudiantes, int cnotas) throws RemoteException;
    public String[][] calculatePromedioGrupo(String[][] mat,  int cestudiantes, int cnotas) throws RemoteException;
}
