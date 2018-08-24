/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microorder;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jhuset
 */
public class MicroOrder extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Ordenamiento.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public ArrayList<Integer> iData;
    public ArrayList<Integer> GData;
	
	public MicroOrder(){
		iData = new ArrayList<Integer>();
                GData = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getData() {
		return iData;
	}

	public void setData(ArrayList<Integer>data) {
		this.iData = data;
	}
        
        public ArrayList<Integer> getGData() {
		return GData;
	}

	public void setGData(ArrayList<Integer>data) {
		this.GData = data;
	}
	
	
	public void OrderMergeSort(int A[],int izq, int der){
		   if (izq<der){
		            int m=(izq+der)/2;
		            OrderMergeSort(A,izq, m);
		            OrderMergeSort(A,m+1, der);
		            merge(A,izq, m, der);
		    }
	}
	
	public static void merge(int A[],int izq, int m, int der){
		   int i, j, k;
		   int [] B = new int[A.length]; //array auxiliar
		   for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar
		             B[i]=A[i];

		             i=izq; j=m+1; k=izq;
		             while (i<=m && j<=der) //copia el siguiente elemento más grande
		             if (B[i]<=B[j])
		                     A[k++]=B[i++];
		             else
		                     A[k++]=B[j++];
		             while (i<=m) //copia los elementos que quedan de la
		                           A[k++]=B[i++]; //primera mitad (si los hay)
		 }
	


	public void OrderQuickSort(int[] A, int izq, int der){

			  int pivote=A[izq]; // tomamos primer elemento como pivote
			  int i=izq; // i realiza la búsqueda de izquierda a derecha
			  int j=der; // j realiza la búsqueda de derecha a izquierda
			  int aux;
			 
			  while(i<j){            // mientras no se crucen las búsquedas
			     while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
			     while(A[j]>pivote) j--;         // busca elemento menor que pivote
			     if (i<j) {                      // si no se han cruzado                      
			         aux= A[i];                  // los intercambia
			         A[i]=A[j];
			         A[j]=aux;
			     }
			   }
			   A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
			   A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
			   if(izq<j-1)
				   OrderQuickSort(A,izq,j-1); // ordenamos subarray izquierdo
			   if(j+1 <der)
				   OrderQuickSort(A,j+1,der); // ordenamos subarray derecho
			}
	

	public int[] CountingSort(int[] array){
		
		int [ ] aux =  new  int [ array.length ] ;
			 
			    int min = array [ 0 ] ; 
			    int max = array [ 0 ] ; 
			    for  ( int i =  1 ; i < array. length ; i ++ )  { 
			      if  ( array [ i ]  < min )  { 
			        min = array [ i ] ; 
			      }  else  if ( array [ i ]  > max )  { 
			        max = array [ i ] ; 
			      } 
			    }
			 
			    
			    int [ ] counts =  new  int [ max - min +  1 ] ;
			 
			   
			    for ( int i =  0 ;   i < array.length ; i ++ )  { 
			    	counts [ array [ i ]  - min ] ++; 
			    }
			 
			    for  ( int i =  1 ; i < counts. length ; i ++ )  { 
			      counts [ i ]  = counts [ i ]  + counts [ i - 1 ] ; 
			    }
			    for  ( int i = array. length  -  1 ; i >=  0 ; i-- )  { 
			        aux [ counts [ array [ i ]  - min ] ]  = array [ i ] ; 
			    }
			 
			    return aux ; 
	}

	
	public void ingresar(int dato){
		iData.add(dato);
	}
	

	public void generar(int n){
        int[] matriz = new int[n];
        for(int i =0;i<matriz.length;i++){
            int numero = 0;
            numero = (int)(Math.random()*100)+1;
            matriz[i]=numero;
        }
        for(int i =0;i<matriz.length;i++){
            GData.add(matriz[i]);
        }
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
