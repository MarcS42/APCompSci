package APCompSciProblems;

public class ReverseMatrixFrq {
  
  private static int[][] mat;
  
  public ReverseMatrixFrq(int rows,int cols) {
    mat=generateMatrix(rows, cols);
  }
  
  public int[][] generateMatrix(int rows, int cols)
  {
    int[][] mat = new int[rows][cols];
    for(int r=0; r<rows; r++)
    {
      for(int c=0; c<cols; c++)
      {
        mat[r][c]=(int)(Math.random()*101+1);
      }
    }
    print2D(mat); 
    return mat;
  }
  
  public int[] reverseRow(int[] row)
  {
    int[] reversed = new int[row.length];
    for(int i=row.length-1; i >=0; i--)
    {
      reversed[row.length-1-i]=row[i];
    }
    return reversed;
  }
  
  public void rowReversed(int[][] mat)
  {
    int j=0;
    for(int[] r:mat)
    {
      mat[j++]=reverseRow(r);
    }
    print2D(mat);
  }
  
  public void matrixReversed(int[][] mat)
  {
    int[][] matReversed = new int[mat.length][mat[0].length];
    for(int r=0; r<mat.length;r++)
    {
      if(r%2==0)
      {
        int row[]=mat[mat.length-1-r];
        matReversed[r]=reverseRow(row);
      }else {
        matReversed[r]=reverseRow(mat[r]);
      }
    }
    print2D(matReversed);
  }

  public static void print2D(int[][] rmf)
  {
    for(int[] r:rmf)
    {
      printRow(r);
    }
    System.out.println();
  }

  private static void printRow(int[] row)
  {
    for(int r=0; r< row.length; r++)
    {
      System.out.print(row[r] + "\t");
    }
    System.out.println();
  }

  public static void main(String[] args)
  {
    ReverseMatrixFrq rmf = new ReverseMatrixFrq(3,5);
    rmf.matrixReversed(mat);
//    int[] row1 = {99,70,92,60,54};
//    System.out.println("Row1 "+Arrays.toString(row1)+" reversed is: \n"
//        + Arrays.toString(rmf.reverseRow(row1)));

    
  }

}
