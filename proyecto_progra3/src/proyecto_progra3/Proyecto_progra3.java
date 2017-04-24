/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_progra3;

/**
 *
 * @author Alvaro
 */
public class Proyecto_progra3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        package clases;
 import java.sql.*;
 import java.util.*;


public class HistoriaClinica{
 public String id_Paciente;
 public String ced_Paciente;
 public String tipo_Sangre;
 public String peso;
 public String altura;
 public String riesgo;
 public String antecedentes;
 public String motivo;
 public int cont=0;
 public int result;

public int nuevaHistoriaClinica(String cedPaciente,String tipoSangre,String peso,String altura,String riesgo,String antecedentes, String motivo){

bean b=new bean();
 CallableStatement stm=null;
 //cont++;
 try{
 b.connect();
 stm = b.getCon().prepareCall(“{CALL phclinica.ingresar_hc(?,?,?,?,?,?,?)}”);
stm.setString(1,cedPaciente);
 stm.setString(2,tipoSangre);
 stm.setString(3,peso);
 stm.setString(4,altura);
 stm.setString(5,riesgo);
 stm.setString(6,antecedentes);
 stm.setString(7,motivo);
 stm.executeQuery();
 stm.close();
 b.close();

return 1;

}catch(Exception e){return 0;}

}

public ArrayList nomHC(){

//String datos=”<table border=1 align=center> <tr>”;
bean b = new bean();
 ArrayList y = new ArrayList();
 CallableStatement stm = null;
 ResultSet rs ;
 // this.cont++;
 try{

b.connect();
 stm = b.getCon().prepareCall(“{CALL phclinica.nomHC(?)}”);
stm.registerOutParameter(1,OracleTypes.CURSOR);
 stm.executeQuery();
 rs= (ResultSet)stm.getObject(1);

ResultSetMetaData rm = null ;
 rm=rs.getMetaData();
 int numCol=rm.getColumnCount();
 while(rs.next()){
 for(int i=1;i<=numCol;i++){
 y.add(rs.getString(i));
 }
 }
 }catch(Exception e){
 System.out.print(“se cayo”);
 }
b.close();
 return y;
 }

public ArrayList consultaxCedula(String cedula){

//String datos=”<table border=1 align=center> <tr>”;
bean b = new bean();
 ArrayList y = new ArrayList();
 CallableStatement stm = null;
 ResultSet rs ;
 // this.cont++;
 try{

b.connect();
 stm = b.getCon().prepareCall(“{CALL phclinica.consultarXid(?,?)}”);
stm.setString(1,cedula);
 stm.registerOutParameter(2,OracleTypes.CURSOR);
 stm.executeQuery();
 rs= (ResultSet)stm.getObject(2);

ResultSetMetaData rm = null ;
 rm=rs.getMetaData();
 int numCol=rm.getColumnCount();
 while(rs.next()){
 for(int i=1;i<=numCol;i++){
 y.add(rs.getString(i));
 }
 }
 }catch(Exception e){
 System.out.print(“se cayo”);
 }
b.close();
 return y;
 }

public String consultarHC(String nombre, String apellido){
 String datos=”<table border=1 align=center> <tr>”;
bean b = new bean();
 ArrayList y = new ArrayList();
 CallableStatement stm = null;
 ResultSet rs ;
 this.ced_Paciente=null;
 // this.cont++;
 try{

b.connect();
 stm = b.getCon().prepareCall(“{CALL phclinica.consultar_hc(?,?,?)}”);
stm.setString(1,nombre);
 stm.setString(2,apellido);
 stm.registerOutParameter(3,OracleTypes.CURSOR);
 stm.executeQuery();
 rs= (ResultSet)stm.getObject(3);

ResultSetMetaData rm = null ;
 rm=rs.getMetaData();
 int numCol=rm.getColumnCount();

for(int i=2;i<=numCol;i++){
 datos=datos + “<td>” + rm.getColumnName(i)+”</td>”;
 }
datos = datos + “</tr>” ;

while(rs.next()){
 datos=datos + “<tr>”;
for(int i=2;i<=numCol;i++){
 datos=datos + “<td>”+rs.getString(i)+”</td>”;

}
this.ced_Paciente=rs.getString(1);

}
 if(this.ced_Paciente.equals(null))
 {

return null;
 }

String compl=”modificarHC.jsp?par=” + this.ced_Paciente;
 datos=datos +”<td><a href=”+compl+”>Modificar</td>”+”</tr>”;

datos=datos + “</table>”;

}catch(Exception e){}

return datos;

}

public int modificarHC(String id,String peso,String altura,String riesgo,String antecedentes, String motivo){

bean b = new bean();
 CallableStatement stm = null;

try{

b.connect();
 stm = b.getCon().prepareCall(“{CALL phclinica.modificar_hc(?,?,?,?,?,?)}”);

stm.setString(1,id);
 stm.setString(2,peso);
 stm.setString(3,altura);
 stm.setString(4,riesgo);
 stm.setString(5,antecedentes);
 stm.setString(6,motivo);
 stm.executeQuery();
 stm.close();
 b.close();

return 1;

}catch(Exception e){return 0;}

}

public String consultaHC(){
 String datos=”<table border=1 align=center> <tr>”;
bean b = new bean();
 CallableStatement stm = null;
 ResultSet rs;
 try{

b.connect();
 stm = b.getCon().prepareCall(“{CALL phclinica.tbhc(?)}”);
stm.registerOutParameter(1,OracleTypes.CURSOR);
 stm.executeQuery();
 rs= (ResultSet)stm.getObject(1);

ResultSetMetaData rm = null ;
 rm=rs.getMetaData();
 int numCol=rm.getColumnCount();

for(int i=1;i<=numCol;i++){
 datos=datos + “<td>” + rm.getColumnName(i)+”</td>”;
 }
datos = datos + “</tr>” ;

while(rs.next()){
 datos=datos + “<tr>”;
for(int i=1;i<=numCol;i++){
 datos=datos + “<td>”+rs.getString(i)+”</td>”;
 }
datos=datos + “</tr>” ;
 }
datos=datos + “</table>”;

}catch(Exception e){}
 return datos;

}
    }
    
}
