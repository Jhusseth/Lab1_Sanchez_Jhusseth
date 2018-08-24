/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microorder;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JComboBox;

/**
 *
 * @author jhuset
 */
public class OrdenamientoController implements Initializable {
    
    private Label label;
    @FXML
    private TextField entradaI;
    @FXML
    private TextArea Resultados;
    @FXML
    private TextField EntradaG;
    
    private MicroOrder micro;
    
    private String arreglo;
    @FXML
    private TextField cant;
    @FXML
    private CheckBox float_Ingre;
    @FXML
    private CheckBox int_Gen;
    @FXML
    private CheckBox float_gen;
    @FXML
    private CheckBox int_Ingre;
    @FXML
    private Button CountingOrder;
    @FXML
    private Button MergeOrder;
    @FXML
    private Button QuickOrder;
    @FXML
    private Button generate;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        micro = new MicroOrder();
        arreglo =""; 
        int_Gen = new CheckBox();
        float_gen = new CheckBox();
        int_Ingre = new CheckBox();
        float_Ingre = new CheckBox();
        CountingOrder = new Button();
        MergeOrder = new Button();
        QuickOrder = new Button();
        generate = new Button();
    }    

    @FXML
    private void clic_Ingrear(ActionEvent event) {
        ingresar();
    }

    @FXML
    private void clic_generar(ActionEvent event) {
        generarValores();
    }


    @FXML
    private void clic_Limpiar(ActionEvent event) {
        limpiar();
    }


    @FXML
    private void float_Ing(ActionEvent event) {
    }

    @FXML
    private void int_Gen(ActionEvent event) {
    }

    @FXML
    private void float_gen(ActionEvent event) {
    }

    
    public String getTextEntradaI(){
        return entradaI.getText();
    }
    
    public String getTextResultado(){
        return Resultados.getText();
    }
    
    public String getTextEntradaG(){
        return EntradaG.getText();
    }
    
    public void setTextEntradaI(String text){
        this.entradaI.setText(text);
    }
    
    public void setTextResultados(String text){
        this.Resultados.setText(text);
    }
    public void setTextEntradaG(String text){
        this.EntradaG.setText(text);
    }
    
    public String getTextCant(){
        return cant.getText();
    }
    
    public void setTextCant(String text){
        this.cant.setText(text);
    }
    
    
    public void ingresar(){
		try{
		String cadena = getTextEntradaI();
		char[] a = new char[cadena.length()];
		for(int i =0;i<cadena.length();i++){
			if(cadena.charAt(i)!=','){
			a[i]=cadena.charAt(i);
			int dato = Integer.parseInt("" + a[i]);
			micro.ingresar(dato);
			}
		}
		
		for(int i =0;i<a.length;i++){
			arreglo += String.valueOf(a[i]);
		}
		setTextEntradaG(arreglo);
		}
		catch(NumberFormatException e ){
		}
		setTextEntradaI("");
	}
    
    
    public void mostrar(){
	String cadena = "";
        for(int i =0;i<micro.getData().size();i++){
            cadena += micro.getData().get(i);
	}
	setTextResultados(cadena);
		
	}
    
    public void mostrarGenerados(){
	String cadena = "";
        for(int i =0;i<micro.getGData().size();i++){
            cadena += micro.getGData().get(i);
	}
	setTextEntradaG(cadena);
		
	}

    
    public void Order(){
		int[] n = new int[micro.getData().size()];
		for(int i =0;i<micro.getData().size();i++){
			n[i]=micro.getData().get(i);
		}
		micro.CountingSort(n);
	}
    
    public void limpiar(){
        setTextResultados("");
        setTextEntradaI("");
        setTextEntradaG("");
        setTextCant("");
    }
    
    public void validarValores(){
        
    }

    @FXML
    private void Clic_OrdenarCounting(ActionEvent event) {
    }

    @FXML
    private void Clic_OrdenarMerge(ActionEvent event) {
    }

    @FXML
    private void Clic_OrdenarQuick(ActionEvent event) {
    }

    @FXML
    private void int_In(ActionEvent event) {
        
    }
    
    public void generarValores(){
        try{
            int cantidad = Integer.parseInt(getTextCant());
            micro.generar(cantidad);
            mostrarGenerados();
            
        }
        catch(Exception e){
            
        }
    }
}

