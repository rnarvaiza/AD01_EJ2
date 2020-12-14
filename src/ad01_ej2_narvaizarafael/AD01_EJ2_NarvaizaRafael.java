/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad01_ej2_narvaizarafael;

/**
 *
 * @author s0ck3
 */

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AD01_EJ2_NarvaizaRafael {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, NullPointerException, NumberFormatException{
        // TODO code application logic here

        Service sc = null;
        Scanner scanner=new Scanner(System.in);
        int orderPosition = 0;
        int updatedCost = 0;
        
        int [] order = new int[]{4,3,1,2};
        String [] code = new String[]{"LMS","PLA","LIN","MAN"};
        String [] service = new String[]{"Limpieza en seco","Planchado","Limpieza normal","Manchas"};
        String [] worker = new String[]{"Juan Martinez","Ángel López","Ana Fernández","María Cifuentes"};
        int [] cost = new int[]{100,30,60,35};
        
       FileEditor fe = new FileEditor("services.dat"); 
       
       for (int i = 0; i<=3; i++){
           Service employee = new ServiceRecord(order[i],code[i],service[i],worker[i],cost[i]);
           fe.insertRecord((ServiceRecord) employee);
       }
       fe.showRecords();

       try{
           do{
               System.out.println("Please put your desired order: ");
               orderPosition=scanner.nextInt();
           } while(orderPosition < 1 || orderPosition > order.length);
       }catch (InputMismatchException e){
           System.out.println(e.getMessage());
           scanner.next();
       }

       try{
           sc = fe.getServiceRecord(orderPosition);
           System.out.println(sc);
       }catch (IOException e){
           System.out.println(e.getMessage());
       }


       try{
           do{
               System.out.println("Please put the new cost: ");
               updatedCost=scanner.nextInt();
           } while(updatedCost<1);
       } catch (InputMismatchException | NullPointerException e){
           System.out.println(e.getMessage());
           scanner.next();
       }

       try{
           sc.setCost(updatedCost);
           fe.insertRecord((ServiceRecord) sc);
       } catch (IOException | NullPointerException e){
           System.out.println(e.getMessage());
       }

        fe.showRecords();
        scanner.close();
        fe.close();
        
    }
    
}
