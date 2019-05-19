package RandomizerLab;

public class PolyhedralDie extends AbstractDie {
  
  private int numFaces;
  
  PolyhedralDie(){
    this.numFaces = 6;
    randomize();
  }
  
  PolyhedralDie(int numFaces){
    this.numFaces = numFaces;
    randomize();
  }

  @Override
  public int getNumFaces()
  {
    return numFaces;
  }

}
