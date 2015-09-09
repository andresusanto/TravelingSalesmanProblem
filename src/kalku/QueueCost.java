/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kalku;

/**
 *
 * @author Andre
 */
public class QueueCost {
    private int cost[];
    private MatrixTSP[] data;
    private int cp[];
    private int level[];
    
    private int count;
    private int size;
    
    
    QueueCost(int size){
        this.size = size;
        cost = new int[size];
        data = new MatrixTSP[size];   
        cp = new int[size];
        level = new int[size];
    }
    
    QueueCost(){
        this.size = 9999999;
        cost = new int[9999999];
        data = new MatrixTSP[9999999];
        cp = new int[9999999];
        level = new int[9999999];
    }
    
    public int getSize(){
        return size;
    }
    
    public int getCount(){
        return count;
    }
    
    public void insert(MatrixTSP mat, int Cost, int Cp, int Level){
        data[count] = mat;
        cost[count] = Cost;
        cp[count] = Cp;
        level[count] = Level;
        
        count++;
    }
    
    public boolean notnull(){
        if (count > 0)
            return true;
        else
            return false;
    }
    
    public Tupel pop(){
        Tupel tup = new Tupel();
        int i, min;
        
        min = 0;
        for (i=1; i<count; i++){
            if (cost[i] < cost[min]){
                min = i;
            }
        }
        
        tup.mat = data[min];
        tup.cost = cost[min];
        tup.cp = cp[min];
        tup.level = level[min];
        
        for(i=min;i<count;i++){
            data[i] = data[i+1];
            cost[i] = cost[i+1];
            cp[i] = cp[i+1];
            level[i] = level[i+1];
        }
        count--;
                
        return tup;
    }    
}
