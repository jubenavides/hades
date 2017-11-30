/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.hades.controlador;

import ec.edu.espe.hades.vista.Reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Eduardo Vera
 */
public class controladorReserva implements ActionListener, WindowListener{

    Reserva reserva;

    public controladorReserva(Reserva reserva) {
        this.reserva = reserva;
        this.reserva.addWindowListener(this);
        this.reserva.btnGuardar.addActionListener(this);
        this.reserva.btnCancelar.addActionListener(this);
     
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(reserva.btnGuardar))
        {   
            System.out.println(reserva.cbIdenificacion.getSelectedItem());
            System.out.println(reserva.txtNombre.getText());
            System.out.println(reserva.txtNombre.getText());
            System.out.println(reserva.txtPais.getText());
            System.out.println(reserva.txtDireccion.getText());
            System.out.println(reserva.txtFono.getText());
            System.out.println(reserva.txtEmail.getText());
            System.out.println(reserva.cbCrucero.getSelectedItem());
            System.out.println(reserva.cbCamarote.getSelectedItem());
            System.out.println(reserva.cbRecorrido.getSelectedItem());
            System.out.println(reserva.cbAlimento.getSelectedItem());

        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
}
