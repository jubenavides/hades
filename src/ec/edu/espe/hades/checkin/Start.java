/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.hades.checkin;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliana Vasquez
 */
public class Start {

    public static String getMD5(String cadena) throws Exception {
 
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(cadena.getBytes());
 
        int size = b.length;
        StringBuilder h = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
 
            int u = b[i] & 255;
 
            if (u < 16)
            {
                h.append("0").append(Integer.toHexString(u));
            }
            else
            {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }
    
    public static void main(String args[]){
        
        
        
try{
            String server= "localhost";
            Integer port=2000;
            CheckInCliente client = new CheckInCliente(server, port);
            client.connect();
            Scanner scanner=new Scanner(System.in); 
            
            String id_mensaje= "";                
            String mensaje =""; String tipoMensaje ="RQ"; String originador = "CHIN";
            Date date = new Date();
            DateFormat fechaHora = new SimpleDateFormat("yyyyMMddHHmmss");
	    String fecha = fechaHora.format(date);
            int tamano=0; String hash="";
            int opc=0;
            
                       
            do
             { 
                System.out.println("Menu");
                System.out.println("1.Mostrar Lista de Touristas");
                System.out.println("2.Registro de Peso de Maletas");
                System.out.println("3.Salir");     
                
                String line= scanner.nextLine();
                opc=Integer.parseInt(line);
                
                    switch(opc)
                    {
                        case 1: 
                        {
                            id_mensaje= "LISTTURRES";                            
                            System.out.println("LISTA DE TURISTAS ");
                            
                            
                            System.out.println("Ingrese el codigo de la reserva: ");
                            String codigoReserva =scanner.nextLine();
                                                                                    
                            try {
                                hash= getMD5(codigoReserva);
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            } 
                            
                            tamano= codigoReserva.length();
                            String tam =String.valueOf(tamano);
                            
                            mensaje=tipoMensaje.concat(originador).concat(fecha).concat(id_mensaje).concat(tam).concat(hash).concat(codigoReserva);
                            client.send(mensaje);
                            
                        }
                        break;
                        
                        case 2: 
                        { 
                            id_mensaje= "REGPESOMAL";
                            
                            System.out.println("REGISTRO DE MALETAS ");
                            System.out.println("Ingrese la identificacion del turista: ");
                            String identificacionTurista =scanner.nextLine();
                            
                            try {
                                Integer.parseInt(identificacionTurista);
                                System.out.println("Ingrese el peso de las maletas: ");
                                String pesoMaletas =scanner.nextLine();

                                try {
                                    Integer.parseInt(pesoMaletas);

                                } catch (NumberFormatException nfe){
                                    System.out.println("Error, ingrese un valor numerico");                                
                                }

                                String mensaje1=identificacionTurista.concat(pesoMaletas);

                                try {
                                    hash= getMD5(mensaje1);
                                } catch (Exception ex) {
                                    System.out.println(ex.getMessage());
                                } 

                                tamano= mensaje1.length();
                                String tam =String.valueOf(tamano);

                                mensaje=tipoMensaje.concat(originador).concat(fecha).concat(id_mensaje).concat(tam).concat(hash).concat(mensaje1);
                                client.send(mensaje);
                            
                                
                            } catch (NumberFormatException nfe){
                                System.out.println("Error, identificacion no valida");                                
                            }
                          
                            //System.out.println(mensaje);
                            
                        }
                        break;
                        
                        case 3: 
                        {                           
                            break;
                               
                        }
                      
                        default: System.out.println("Opcion incorrecta");
                        break;
                    }
                }while(opc!=3);   
               
           }
 
        catch(IOException e)
        {
            LOG.log(Level.SEVERE,"Ocurrio un error",e);
        }
        
    }
            
        
    private static final Logger LOG = Logger.getLogger(Start.class.getName());

}



    
    
    