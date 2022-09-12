/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface.StudentInterface;

public class StudentClient {

    public static void main(String[] args) throws IOException, NotBoundException {
        int cestudiantes = 0 ;
        int cnotas = 0 ;
        
        float n1, n2, res; int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("1. Calcular");
            System.out.println("2. Salir    ");
            System.out.println("OPCION:");
            choice=Integer.parseInt(br.readLine());
            if (choice!=2)
            {   try {
                System.out.println("Ingrese cantidad de estudiantes");
                cestudiantes= Integer.parseInt(br.readLine());
                System.out.println("Ingrese cantidad de notas por estudiante");
                cnotas= Integer.parseInt(br.readLine());
                
                String[][] mat = new String[cestudiantes][cnotas+4];
                for (int i = 0; i < cestudiantes; i++) {
                    System.out.println("Ingrese nombre del estudiante");
                    mat[i][0]= br.readLine().toString();
                    for (int j = 1; j <= cnotas; j++) {
                        mat[i][j]= String.valueOf(getRandomFloat());
                    }
                  }

                  StudentInterface studentinterface= (StudentInterface)Naming.lookup("Student");
                  mat = studentinterface.calculateMayor(mat, cestudiantes, cnotas);
                  mat = studentinterface.calculateMenor(mat, cestudiantes, cnotas);
                  mat = studentinterface.calculatePromedio(mat, cestudiantes, cnotas);
                  mat = studentinterface.calculatePromedioGrupo(mat, cestudiantes, cnotas);
		
                } catch ( MalformedURLException | RemoteException ex) {
                    Logger.getLogger(StudentClient.class.getName()).log(Level.SEVERE, null, ex);
                }                    
            }
        } while (choice != 2);

    }

    public static void imprimirMat(String[][] mat, int cestudiantes, int cnotas){
        for (int i = 0; i < cestudiantes; i++) {
            System.out.println("Estudiante:"+ mat[i][0].toString());
            for (int j = 1; j <= cnotas; j++) {
                System.out.println("nota" + mat[i][j].toString());
            }
          }
    }

    public static float getRandomFloat(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Random r = new Random();
        float random = 0 + r.nextFloat() * (5 - 0); 
        System.out.println("Nota generada" + df.format(random));
        return random;
    }
     

}
