/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente_nuevo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;



/**
 *
 * @author Alvaro
 */
public class Formulario_paciente_nuevo extends JPanel implements ActionListener {
    
    private JLabel texto0;
    private JLabel texto1;
    private JLabel texto2;
    private JLabel texto3;
    private JLabel texto4;
    private JLabel texto5;
    private JLabel texto6;
    private JLabel texto7;
    private JTextField caja1;
    private JTextField caja2;
    private JTextField caja3;
    private JTextField caja4;
    private JTextField caja5;
    private JTextField caja6;
    private JButton btnCrear;
    private JButton btnMostrar;              
    private JLabel lblTemporal;             
    private Timer time;
    private JTextArea pantalla;              
    private JScrollPane ampliar;
    private JPanel contenedor;
    private final File informacion;
    private FileWriter escribir;
    private PrintWriter linea;
    private FileReader leer;
    private BufferedReader leerLinea;
    
    
    
    public Formulario_paciente_nuevo() {
        super();
        configurarFormulario_paciente_nuevo();
        inicializarComponentes();
        informacion = new File("Pacientes_nuevos.txt");
    }

    private void configurarFormulario_paciente_nuevo() {
//        this.setTitle("Creando paciente nuevo");
        this.setSize(900, 600);
//        this.setLocationRelativeTo(null);
        this.setLayout(null);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void inicializarComponentes() {
        texto0 = new JLabel();
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        texto4 = new JLabel();
        texto5 = new JLabel();
        texto6 = new JLabel();
        texto7 = new JLabel();
        caja1 = new JTextField();
        caja2 = new JTextField();
        caja3 = new JTextField();
        caja4 = new JTextField();
        caja5 = new JTextField();
        caja6 = new JTextField();
        
        btnCrear = new JButton();
        lblTemporal = new JLabel();
        btnMostrar = new JButton();  //Agregando nuevo boton
        pantalla = new JTextArea(5, 25);  // creando un nuevo textArea


        texto0.setText("CREANDO PACIENTE NUEVO");
        texto1.setText("Insertar nombre del paciente:");
        texto2.setText("Insertar edad del paciente:");
        texto3.setText("Insertar Médico solicitante:");
        texto4.setText("Insertar motivo de consulta:");
        texto5.setText ("Insertar fecha de exploracion:");
        texto6.setText("Insertar telefono del paciente:");
        texto7.setText("Escoger Especialidad:");
        
        texto0.setBounds(30, 20, 300, 25);
        texto1.setBounds(30, 70, 300, 25);
        caja1.setBounds(230, 70, 500, 25);
        texto2.setBounds(30, 110, 300, 25);
        caja2.setBounds(230, 110, 500, 25);
        texto3.setBounds(30, 150, 500, 25);
        caja3.setBounds(230, 150, 500, 25);
        texto4.setBounds(30, 190, 300, 25);
        caja4.setBounds(230, 190, 500, 25);
        texto5.setBounds(30, 230, 500, 25);
        caja5.setBounds(230, 230, 500, 25);
        texto6.setBounds(30, 270, 500, 25);
        caja6.setBounds(230, 270, 500, 25);
        texto7.setBounds(30, 310, 500, 25);
        
        
        
        btnCrear.setText("Crear paciente");
        btnCrear.setBounds(30, 500, 150, 30);
        btnCrear.addActionListener(this);
        lblTemporal.setText("Datos guardados con exito!");
        lblTemporal.setBounds(30, 175, 180, 30);
        lblTemporal.setVisible(false);
        pantalla.setEditable(false);


        this.add(texto0);
        this.add(texto1);
        this.add(texto2);
        this.add(texto3);
        this.add(texto4);
        this.add(texto5);
        this.add(texto6);
        this.add(texto7);
        this.add(caja1);
        this.add(caja2);
        this.add(caja3);
        this.add(caja4);
        this.add(caja5);
        this.add(caja6);
        this.add(btnCrear);
        this.add(lblTemporal);
        this.add(btnMostrar);


    }
    
    //Metodo guardarInformacion guardará los datos capturados en las cajas de texto
    public void guardarInformacion(String nombre) {
        try {
            // Crear un objeto de tipo FileWriter, para escribir en el documento.
            escribir = new FileWriter(informacion, true);
            // crear un objeto de tipo PrintWriter, para escribir una linea.
            linea = new PrintWriter(escribir);
            if (!informacion.exists()) {
                informacion.createNewFile();
            }
            linea.println(nombre);      //escribir el nombre ingresado
            linea.close();              // cerrar el objeto linea
            escribir.close();           //cerrar el objeto escribir
            lblTemporal.setVisible(true);

            caja1.setText("");
            time.start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCrear) {
            String nombre_paciente = caja1.getText();      //Captura el texto de esta caja
            String edad_paciente = caja2.getText();        //Captura el texto de esta caja
            String medico_solicitante = caja3.getText();   //Captura el texto de esta caja
            String motivo_consulta = caja4.getText();      //Captura el texto de esta caja
            String fecha_exploracion = caja5.getText();    //Captura el texto de esta caja
            String telefono_paciente = caja6.getText();    //Captura el texto de esta caja
            guardarInformacion(nombre_paciente);
            guardarInformacion(edad_paciente);
            guardarInformacion(medico_solicitante);
            guardarInformacion(motivo_consulta);
            guardarInformacion(fecha_exploracion);
            guardarInformacion(telefono_paciente);
             time = new Timer(3000, (ActionEvent ae1) -> {
                lblTemporal.setVisible(false);
                time.stop();
            });
          
        }
    }
    
    
}
    