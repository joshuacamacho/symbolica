/*
 * Name: Alec Farfan
 * Date: 03/20/15
 * Purpose: Matrix Class
 * Description: Class representing a matrix object with various matrix 
 *              computations.
 *              - Matrix Addition
 *              - Matrix Subtraction
 *              - Matrix Multiplication
 *              - Scalar Multiplication
 *              - Matrix Transpose
 *              - Matrix Inverse
 *              - Row Echelon Form
 *              - Reduced Row Echelon Form
 *              - LU Factorization
 */


// Import libraries
import java.util.ArrayList;

public class Matrix{
    
    private float array[][];
    private int rows;
    private int collumns;

    
    public Matrix(){
        
    }
    public Matrix(int row,int collumn){
        array = new float[row][collumn];
        this.rows = row;
        this.collumns = collumn;
        
    }
    public void set_dimensions(int row, int collumn){
        array = new float[row][collumn];
        
    }
    public void set_element(float value,int row,int collumn){
        array[row][collumn] = value;
        
    }
    public void set_rows(int row){
        this.rows = row;
        
    }
    public void set_collumns(int collumn){
        this.collumns = collumn;
        
    }
    public float get_element(int row,int collumn){ 
        return array[row][collumn];
    
    }
    public int get_rows(){ 
        return rows;
    
    }
    public int get_collumns(){ 
        return collumns;
    
    }
    public void print(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<collumns;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        
    }
    public String println(){
        String output = "<html>";
        for(int i=0;i<rows;i++){
            for(int j=0;j<collumns;j++){
                output += array[i][j] + " ";
            }
            output += "<br>";
        }
        output += "</html>";
        
        return output;
    }
    public Matrix matrix_addition(Matrix a,Matrix b){
        
        Matrix result = new Matrix();
        
        if((a.get_rows()==b.get_rows())&&a.get_collumns()==b.get_collumns()){
            result.set_dimensions(rows, collumns);
            result.set_rows(rows);
            result.set_collumns(collumns);
            
            for(int i=0;i<rows;i++){
                for(int j=0;j<collumns;j++){
                    result.set_element(a.get_element(i,j) + b.get_element(i,j), i, j);
                }
            }
            
        }
        return result;
       
    }
    public Matrix matrix_subtraction(Matrix a,Matrix b){
        
        Matrix result = new Matrix();
        
        if((a.get_rows()==b.get_rows())&&a.get_collumns()==b.get_collumns()){
            result.set_dimensions(rows, collumns);
            result.set_rows(rows);
            result.set_collumns(collumns);
            
            for(int i=0;i<rows;i++){
                for(int j=0;j<collumns;j++){
                    result.set_element(a.get_element(i,j) - b.get_element(i,j),i,j);
                }
            }
            
        }
        return result;
       
    }
    public Matrix matrix_multiplication(Matrix a,Matrix b){
        Matrix result = new Matrix();
        if(a.get_collumns()==b.get_rows()){
            result.set_dimensions(a.get_rows(),b.get_collumns());
            result.set_rows(a.get_rows());
            result.set_collumns(b.get_collumns());
            
            int k = 0;
            for(int i=0;i<a.get_rows();i++){
                for(int j=0;j<b.get_collumns();j++){
                    float element = 0;
                    for(int l=0;l<b.get_rows();l++){
                        element += a.get_element(i,l)*b.get_element(l,k);
                    }
                    k++;
                    if(k>b.get_collumns()-1){
                        k = 0;
                    }
                    result.set_element(element,i,j);
                }
            }
        }
        
        return result;
        
    }
    public Matrix scalar_multiplication(Matrix a,float scalar){
        Matrix result = a;
        for(int i=0;i<rows;i++){
            for(int j=0;j<collumns;j++){
                result.set_element(scalar*result.get_element(i,j),i,j);
            }
        }
        
        return result;
    }
    public Matrix matrix_transpose(Matrix a){
        Matrix result = new Matrix(a.get_collumns(),a.get_rows());
        for(int i=0;i<result.get_rows();i++){
            for(int j=0;j<result.get_collumns();j++){
                result.set_element(a.get_element(j,i),i,j);
            }
        }
        return result;
        
    }
    public Matrix row_echelon_form(Matrix a){
        Matrix result = a;
        
        for(int i=0;i<rows;i++){
            boolean pivot_found = false;
            int pivot_row = 0;
            
            // Look for a 1 directly underneath
            for(int b=i;b<rows&&pivot_found==false;b++){
                if(array[b][i]==1){
                    pivot_found = true;
                    pivot_row = b;
                }
            }   
            // If no pivot is directly availible, find most divisible row
            if(!pivot_found){
                int max_frequency = 0;
                int index_of_max = i;
                for(int c=i;c<rows;c++){
                    int count = 0;
                    for(int d=i+1;d<collumns;d++){
                        if(array[c][i]<=array[c][d] && (array[c][d]%array[c][i])==0){
                            count++;
                        }
                    }
                    if(count>max_frequency){
                        max_frequency = count;
                        index_of_max = c;
                    }
                }
                pivot_row = index_of_max;
                result = reduce_pivot(result,pivot_row,array[pivot_row][i]);         
            }
            result = result.interchange_rows(result, pivot_row, i);
            for(int j=i+1;j<rows;j++){
                float scalar = (array[j][i]/array[i][i]);
                float new_row[] = scale_row(result,i,result.get_collumns(),(array[j][i]/array[i][i])*-1);
               result = add_row(result,j,new_row); 
            }
        }
        result = result.clear_negative_zeros(result);
        return result;
        
    }
    public Matrix reduced_row_echelon_form(Matrix a){
        Matrix result = a.row_echelon_form(a);
        
        for(int i=result.get_rows()-1;i>=0;i--){
            for(int j=i;j>0;j--){
                float scalar = result.get_element(j-1,i)/result.get_element(i,i);
                float new_row[] = scale_row(result,i,result.get_collumns(),scalar*-1);
                result = add_row(result,j-1,new_row);
            }
        }
        
        return result;
        
    }
    public Matrix interchange_rows(Matrix a,int row1,int row2){
        
        Matrix result = a;
        int cols = a.get_collumns();
        float temp_array[] = new float[cols];
        
        for(int i=0;i<cols;i++){
            temp_array[i] = result.get_element(row1,i);
        }
        for(int i=0;i<cols;i++){
            result.set_element(result.get_element(row2,i),row1,i);
        }
        for(int i=0;i<cols;i++){
            result.set_element(temp_array[i],row2,i);
        }
        
        return result;
        
    }
    public Matrix reduce_pivot(Matrix a,int row,float scalar){
        Matrix result = a;
        for(int i=0;i<result.get_collumns();i++){
            result.set_element(result.get_element(row,i)/scalar, row,i);
        }
        return result;
        
    }
    public float[] scale_row(Matrix a,int row_num, int size,float scalar){
        float new_row[] = new float[size];
        
        for(int i=0;i<size;i++){
            new_row[i] = a.get_element(row_num, i) * scalar;
        }
        return new_row;
        
    }
    public Matrix add_row(Matrix a,int row_num,float[] row){
        Matrix result = a;
        for(int i=0;i<result.get_collumns();i++){
            result.set_element(result.get_element(row_num,i)+row[i],row_num,i);
        }
        return result;
        
    }
    public Matrix clear_negative_zeros(Matrix a){
        Matrix result = a;
        for(int i=0;i<rows;i++){
            for(int j=0;j<collumns;j++){
                if(result.get_element(i,j)==-0.0){
                    result.set_element(0,i,j);
                }
            }
        }
        
        return result;
    }
    public Matrix matrix_inverse(Matrix a){
        Matrix merge = new Matrix(a.get_rows(),a.get_collumns()*2);
        for(int i=0;i<a.get_rows();i++){
            for(int j=0;j<a.get_collumns();j++){
                merge.set_element(a.get_element(i,j),i,j);
            }
        }
        int modulo = merge.get_rows();
        for(int i=0;i<merge.get_rows();i++){
            for(int j=a.get_collumns();j<merge.get_collumns();j++){
                if(j%modulo==0){
                    merge.set_element(1,i,j);
                }
                else{
                    merge.set_element(0,i,j);
                }
            }
            modulo++;
        }
        merge = reduced_row_echelon_form(merge);
        Matrix result = new Matrix(a.get_rows(),a.get_collumns());
        for(int i=0;i<result.get_rows();i++){
            for(int j=0;j<result.get_collumns();j++){
                result.set_element(merge.get_element(i,j+result.get_rows()),i,j);
            }
        }
        return result;
        
    }
    public ArrayList<Matrix> lu_decompisition(Matrix a){
        ArrayList<Matrix> lu = new ArrayList();
        ArrayList<Matrix> elementaries = new ArrayList();
        
        Matrix result = a;
        for(int i=0;i<rows-1;i++){
            elementaries.add(a.identity_matrix(a));
            boolean pivot_found = false;
            int pivot_row = 0;
            
            // Look for a 1 directly underneath
            for(int b=i;b<rows&&pivot_found==false;b++){
                if(array[b][i]==1){
                    pivot_found = true;
                    pivot_row = b;
                }
            }   
            // If no pivot is directly availible, find most divisible row
            if(!pivot_found){
                int max_frequency = 0;
                int index_of_max = i;
                for(int c=i;c<rows;c++){
                    int count = 0;
                    for(int d=i+1;d<collumns;d++){
                        if(array[c][i]<=array[c][d] && (array[c][d]%array[c][i])==0){
                            count++;
                        }
                    }
                    if(count>max_frequency){
                        max_frequency = count;
                        index_of_max = c;
                    }
                }
                pivot_row = index_of_max;
            }
            result = result.interchange_rows(result, pivot_row, i);
            elementaries.set(i,elementaries.get(i).interchange_rows(elementaries.get(i),pivot_row,i));
            for(int j=i+1;j<rows;j++){
                float scalar = (array[j][i]/array[i][i]);
                if(scalar!=0){
                    float result_new_row[] = scale_row(result,i,result.get_collumns(),(array[j][i]/array[i][i])*-1);
                    float elementary_new_row[] = scale_row(elementaries.get(i),i,elementaries.get(i).get_collumns(),(array[j][i]/array[i][i])*-1);
                    result = add_row(result,j,result_new_row); 
                    elementaries.set(i,add_row(elementaries.get(i),j,elementary_new_row));
                }       
            }
        }
        result.clear_negative_zeros(result);
        for(int i=0;i<elementaries.size();i++){
            elementaries.set(i,elementaries.get(i).clear_negative_zeros(elementaries.get(i)));
            elementaries.set(i,elementaries.get(i).matrix_inverse(elementaries.get(i)));
        }
        Matrix l = elementaries.get(0);
        for(int i=1;i<elementaries.size();i++){
            l = l.matrix_multiplication(l,elementaries.get(i));
        }   
        lu.add(l);
        lu.add(result);
     
        return lu;
        
    }
    public Matrix identity_matrix(Matrix a){
        Matrix result = new Matrix(a.get_rows(),a.get_collumns());    
        
        result.set_element(1,0,0);
        for(int i=1;i<result.get_collumns();i++){
             result.set_element(0,i,i);    
        }

        int modulo = 1;
        for(int i=1;i<result.get_rows();i++){
            for(int j=1;j<result.get_collumns();j++){
                if(j==i){
                    result.set_element(1,i,j);   
                }
                else{
                    result.set_element(0,i,j);
                }
            }
            modulo++;
        }
        return result;
        
    }
    public float determinant(Matrix a){
        if(a.get_rows()==2){
            return (a.get_element(0,0)*a.get_element(1,1)-a.get_element(0,1)*a.get_element(1,1));
        }
        else{
            float best[] = find_best(a);
            for(int i=0;i<a.get_collumns();i++){
                Matrix new_determinant = a.reduce_determinant(a,best[a.get_collumns()-3],best[a.get_collumns()-2],i);
                best[i] *= new_determinant.determinant(new_determinant);
            }
        }
        
        return 0;
    }
    public float[] find_best(Matrix a){
        float best[] = new float[a.get_rows()+2];
        int max = 0, place = 0, position = 0;
        
        for(int i=0;i<a.get_rows();i++){
            int row_zeros = 0, collumn_zeros = 0;
            for(int j=0;j<a.get_collumns();j++){
                if(a.get_element(i,j)==0){
                    row_zeros++;
                }
                if(a.get_element(j,i)==0){
                    collumn_zeros++;
                }
            }
            if(row_zeros>max){
                max = row_zeros;
                place = i;
                position = 0;
            }
            if(collumn_zeros>max){
                max = collumn_zeros;
                place = i;
                position = 1;
            }
            
        }
        if(position==0){
            for(int i=0;i<a.get_rows();i++){
                for(int j=0;j<a.get_rows();j++){
                    if(i==place){
                        best[j] = a.get_element(i,j);
                    }
                }
            }
        }
        else{
            for(int i=0;i<a.get_rows();i++){
                for(int j=0;j<a.get_rows();j++){
                    if(j==place){
                        best[i] = a.get_element(i,j);
                    }
                }
            }
        }
        best[a.get_rows()] = place;
        best[a.get_rows()+1] = position;
        
        return best;
        
    }
    public Matrix reduce_determinant(Matrix a,float place,float position,int index){
        Matrix result = new Matrix(a.get_rows()-1,a.get_rows()-1);
        
        if(position==0){
            for(int i=0;i<a.get_rows();i++){
                for(int j=0;j<a.get_collumns();j++){
                    if(!(i==place||j==index)){
                        result.set_element(a.get_element(i,j),i,j);
                    }
                }
            }
        }
        else{
            for(int i=0;i<a.get_rows();i++){
                for(int j=0;j<a.get_collumns();j++){
                    if(!(j==place||i==index)){
                        result.set_element(a.get_element(i,j),i,j);
                    }
                }
            }
        }
        
        return result;
    }
    
}
