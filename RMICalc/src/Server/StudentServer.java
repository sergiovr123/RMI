/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Implement.StudentImplement;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author hrecaman
 */
public class StudentServer {
  public static void main(String []args) throws RemoteException
  { Registry reg=LocateRegistry.createRegistry(1099);
    StudentImplement StudentImplement=new StudentImplement(new String[0][0]);
    //nombre objeto
    reg.rebind("Student", StudentImplement);
    System.out.println("servidor iniciado");
  
  }
}
