package kalku;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class MatrixTSP {
    private int d[][];
    private int size;
    private int pengurang;
    
    public int getSize(){
        return size;
    }
    
    MatrixTSP(int size){
        this.size = size;
        d = new int[size][];
        for(int i = 0; i<size; i++)
            d[i] = new int[size];
    }
    
    public void setData(int row, int col, int val){
        d[row][col] = val;
    }
    
    public int getData(int row, int col){
        return d[row][col];
    }
    
    public void reduce(){
        int i, j, tmpmin = 0;
        
        pengurang = 0;
        
        for(i=0;i<size;i++){
            tmpmin = 999999999;
            
            for(j=0;j<size;j++){
                if (d[i][j] != -999 && d[i][j] < tmpmin){
                    tmpmin = d[i][j];
                }
            }
            
            if (tmpmin != 999999999)
                pengurang += tmpmin;
            for(j=0;j<size;j++){
                if (d[i][j] != -999)
                    d[i][j] -= tmpmin;
            }
        }
        
        for(i=0;i<size;i++){
            tmpmin = 999999999;
            
            for(j=0;j<size;j++){
                if (d[j][i] != -999 && d[j][i] < tmpmin){
                    tmpmin = d[j][i];
                }
            }
            
            if (tmpmin != 999999999)
                pengurang += tmpmin;
            
            for(j=0;j<size;j++){
                if (d[j][i] != -999)
                    d[j][i] -= tmpmin;
            }
        }

    }
    
    public MatrixTSP getNewMat(int row, int col){
        int i, j;
        MatrixTSP tmp = new MatrixTSP(this.size);
        
        for (i=0;i<size; i++){
            
            for (j=0;j<size;j++){
                
                if (i == row || j == col || (j == row && i == col)){
                    tmp.setData(i, j, -999);
                }else{
                    tmp.setData(i, j, d[i][j]);
                }
                
            }
            
        }
        
        tmp.size = this.size;
        tmp.pengurang = 0;
        
        return tmp;
    }
    
    public int getPengurang(){
        return pengurang;
    }
}
