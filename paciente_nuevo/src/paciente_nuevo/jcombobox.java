/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente_nuevo;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Alvaro
 */
public class jcombobox {
    public class Formulario extends JFrame implements ItemListener{
    private JComboBox combo1;
    public Formulario() {
        setLayout(null);
        combo1=new JComboBox();
        combo1.setBounds(10,10,80,20);
        add(combo1);
        combo1.addItem("Gastroenterología");
        combo1.addItem("Traumatología");
        combo1.addItem("Ginecología");
        combo1.addItem("Pediatría");
        combo1.addItem("Cardilogía");
        combo1.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==combo1) {
            String seleccionado=(String)combo1.getSelectedItem();
            setTitle(seleccionado);
        }
    }
    
//    public static void main(String[] ar) {
//        Formulario formulario1=new Formulario();
//        formulario1.setBounds(0,0,200,150);
//        formulario1.setVisible(true);
    }    
}
    
