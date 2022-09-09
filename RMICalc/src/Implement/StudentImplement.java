/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Interface.StudentInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author hrecaman
 */
public class StudentImplement extends UnicastRemoteObject implements StudentInterface {

    public String[][] mat;
    public float mayor;
    public float menor;
    public float promedio;

    public float getMayor() {
        return mayor;
    }

    public void setMayor(float mayor) {
        this.mayor = mayor;
    }

    public float getMenor() {
        return menor;
    }

    public void setMenor(float menor) {
        this.menor = menor;
    }

    public StudentImplement(String[][] mat) throws RemoteException {
        this.mat = mat;
        this.mayor=0;
        this.menor=0;
        this.promedio=0;
    }

    

    @Override
    public String[][] calculateMayor(String[][] mat, int cestudiantes, int cnotas) throws RemoteException {
        System.out.println("Calculate mayor!");
        for (int i = 0; i < cestudiantes; i++) {
            System.out.println("Estudiante!:"+ mat[i][0].toString());
            for (int j = 1; j <= cnotas; j++) {
                if(mat[i][j]!=null && mat[i][j]!= ""){
                    if(Float.compare(Float.parseFloat(mat[i][j]), mayor)>0){
                        mayor = Float.parseFloat(mat[i][j]);
                    }
                }
                
            }
            mat[i][cnotas+1]=String.valueOf(mayor);
            System.out.println("nota mayor!" + mayor);
          }
          return mat;
    }

    @Override
    public String[][] calculateMenor(String[][] mat, int cestudiantes, int cnotas) throws RemoteException {
        System.out.println("Calculate menor!");
        for (int i = 0; i < cestudiantes; i++) {
            System.out.println("Estudiante!:"+ mat[i][0].toString());
            menor = Float.parseFloat(mat[i][1]);
            for (int j = 2; j <= cnotas; j++) {
                if(mat[i][j]!=null && mat[i][j]!= ""){
                    if(Float.compare(Float.parseFloat(mat[i][j]), menor)<0){
                        menor = Float.parseFloat(mat[i][j]);
                    }
                }
                
            }
            mat[i][cnotas+2]=String.valueOf(menor); 
            System.out.println("nota menor!" + mayor);
          }
          return mat;
    }

    @Override
    public String[][] calculatePromedio(String[][] mat, int cestudiantes, int cnotas) throws RemoteException {
        return new String[1][1];
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
