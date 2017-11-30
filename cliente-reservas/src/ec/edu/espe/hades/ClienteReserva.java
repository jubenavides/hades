/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.hades;

import ec.edu.espe.hades.controlador.controladorReserva;
import ec.edu.espe.hades.vista.Reserva;

/**
 *
 * @author Eduardo Vera
 */
public class ClienteReserva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reserva form = new Reserva();
        controladorReserva control = new controladorReserva(form);
        //form.setSize(600,600);
        form.setVisible(true);
        //form.setLocationRelativeTo(null);
    }
    
}
