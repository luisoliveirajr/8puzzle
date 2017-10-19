
package puzzle8;

import java.util.ArrayList;

public class No {
    int save;
    ArrayList<Integer> estado = new ArrayList<>();
    int numSucessores;
    ArrayList<No> sucessores = new ArrayList<>();
    ArrayList<No> ante = new ArrayList<>();
    ArrayList<Integer> saveEstados = new ArrayList<>();
    boolean valid = true;
    
    public void setEstado(ArrayList E){
        estado = E;
    }
    
    public No buscaLargura(No noInicial, No noFinal){
        
        noInicial.numSucessores = 0;
        
        
        if(String.valueOf(noInicial.estado) == null ? String.valueOf(noFinal.estado) == null : String.valueOf(noInicial.estado).equals(String.valueOf(noFinal.estado))){
            return noInicial;
        }else{
            
            if(up(noInicial).valid){
                noInicial.sucessores.add(up(noInicial));
                noInicial.numSucessores++;
            }
            
            if(down(noInicial).valid){
                noInicial.sucessores.add(down(noInicial));
                noInicial.numSucessores++;
            }
            
            if(left(noInicial).valid){
                noInicial.sucessores.add(left(noInicial));
                noInicial.numSucessores++;
            }

            if(right(noInicial).valid){
                noInicial.sucessores.add(right(noInicial));
                noInicial.numSucessores++;
            }
            
            
            for(int i = 0; i < noInicial.numSucessores; i++){
                buscaLargura(noInicial.sucessores.get(i), noFinal);
            }
            
            
        }
        
        return noInicial;
    }
    
    
    public No up(No n){ // Esta função deve verificar se é possível mover 0 para cima, se essa movimentação já não foi feita 
                        // em algum antepassado e caso isso seja possível, faz a movimentação.
        
        ante.add(n);
                        
        n.valid = true;
        
        saveEstados = n.estado;
        
        if((n.estado.get(0) != 0) && (n.estado.get(1) != 0) && (n.estado.get(2) != 0)){
            
            switch (n.estado.indexOf(0)) {
                case 3:
                    save = n.estado.get(0);
                    n.estado.set(0,0);
                    n.estado.set(3, save);
                    break;
                case 4:
                    save = n.estado.get(1);
                    n.estado.set(1,0);
                    n.estado.set(4, save);
                    break;
                case 5:
                    save = n.estado.get(2);
                    n.estado.set(2,0);
                    n.estado.set(5, save);
                    break;
                case 6:
                    save = n.estado.get(3);
                    n.estado.set(3,0);
                    n.estado.set(6, save);
                    break;
                case 7:
                    save = n.estado.get(4);
                    n.estado.set(4,0);
                    n.estado.set(7, save);
                    break;
                case 8:
                    save = n.estado.get(5);
                    n.estado.set(5,0);
                    n.estado.set(8, save);
                    break;
                default:
                    
                    break;
            }
            
            for(int i = 0; i < ante.size(); i++){
              
                if(String.valueOf(n.estado).equals(String.valueOf(ante.get(i).estado))){
                    
                    n.estado = saveEstados;
                    n.valid = false;
                    return n;
                }
            }
            
            return n;
        }else{
            n.valid = false;
            n.estado = saveEstados;
            return n;
        }
    }
    
    public No down(No n){
        ante.add(n);
        n.valid = true;
       
        saveEstados = n.estado;
        
        if((n.estado.get(6) != 0) && (n.estado.get(7) != 0) && (n.estado.get(8) != 0)){
           
            switch (n.estado.indexOf(0)) {
                case 0:
                    save = n.estado.get(3);
                    n.estado.set(3,0);
                    n.estado.set(0, save);
                    break;
                case 1:
                    save = n.estado.get(4);
                    n.estado.set(4,0);
                    n.estado.set(1, save);
                    break;
                case 2:
                    save = n.estado.get(5);
                    n.estado.set(5,0);
                    n.estado.set(2, save);
                    break;
                case 3:
                    save = n.estado.get(6);
                    n.estado.set(6,0);
                    n.estado.set(3, save);
                    break;
                case 4:
                    save = n.estado.get(7);
                    n.estado.set(7,0);
                    n.estado.set(4, save);
                    break;
                case 5:
                    save = n.estado.get(8);
                    n.estado.set(8,0);
                    n.estado.set(5, save);
                    break;
                default:
                    
                    break;
            }
            
            for(int i = 0; i < ante.size(); i++){
                
                if(String.valueOf(n.estado).equals(String.valueOf(ante.get(i).estado))){
                    n.estado = saveEstados;
                    n.valid = false;
                    
                    return n;
                }
            }
            
            return n;
        }else{
            n.valid = false;
            n.estado = saveEstados;
            return n;
        }    
    }
    
    public No left(No n){
        ante.add(n);
        n.valid = true;
       
        saveEstados = n.estado;
        
        if((n.estado.get(0) != 0) && (n.estado.get(3) != 0) && (n.estado.get(6) != 0)){
            
             switch (n.estado.indexOf(0)) {
                case 1:
                    save = n.estado.get(0);
                    n.estado.set(0,0);
                    n.estado.set(1, save);
                    break;
                case 2:
                    save = n.estado.get(1);
                    n.estado.set(1,0);
                    n.estado.set(2, save);
                    break;
                case 4:
                    save = n.estado.get(3);
                    n.estado.set(3,0);
                    n.estado.set(4, save);
                    break;
                case 5:
                    save = n.estado.get(4);
                    n.estado.set(4,0);
                    n.estado.set(5, save);
                    break;
                case 7:
                    save = n.estado.get(6);
                    n.estado.set(6,0);
                    n.estado.set(7, save);
                    break;
                case 8:
                    save = n.estado.get(7);
                    n.estado.set(7,0);
                    n.estado.set(8, save);
                    break;
                default:
                    
                    break;
            }
             
            for(int i = 0; i < ante.size(); i++){
                
                if(String.valueOf(n.estado).equals(String.valueOf(ante.get(i).estado))){
                    n.estado = saveEstados;
                    n.valid = false;
                    return n;
                }
                
            }
            
            return n;
        }else{
            n.valid = false;
            n.estado = saveEstados;
            return n;
        }
    }
    public No right(No n){
        ante.add(n);
        n.valid = true;
        
        saveEstados = n.estado;
        
        if((n.estado.get(2) != 0) && (n.estado.get(5) != 0) && (n.estado.get(8) != 0)){
             switch (n.estado.indexOf(0)) {
                case 0:
                    save = n.estado.get(1);
                    n.estado.set(1,0);
                    n.estado.set(0, save);
                    break;
                case 1:
                    save = n.estado.get(2);
                    n.estado.set(2,0);
                    n.estado.set(1, save);
                    break;
                case 3:
                    save = n.estado.get(4);
                    n.estado.set(4,0);
                    n.estado.set(3, save);
                    break;
                case 4:
                    save = n.estado.get(5);
                    n.estado.set(5,0);
                    n.estado.set(4, save);
                    break;
                case 6:
                    save = n.estado.get(7);
                    n.estado.set(7,0);
                    n.estado.set(6, save);
                    break;
                case 7:
                    save = n.estado.get(8);
                    n.estado.set(8,0);
                    n.estado.set(7, save);
                    break;
                default:
                    
                    break;
            }
            for(int i = 0; i < ante.size(); i++){
                
                if(String.valueOf(n.estado).equals(String.valueOf(ante.get(i).estado))){
                    n.estado = saveEstados;
                    n.valid = false;
                    return n;
                }
            }
           
            return n;
        }else{
            n.valid = false;
            n.estado = saveEstados;
            return n;
        }
    }
    
    
    
    
    
    //public No buscaProfundidade(No noInicial){
    
        
        
    
    //}
    
    

}
