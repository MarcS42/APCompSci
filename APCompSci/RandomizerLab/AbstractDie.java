/**
 * 
 */
package RandomizerLab;

/**
 * @author MarcSherman
 *
 */
public abstract class AbstractDie implements Randomizer {
  
  protected int currentRandomValue;
  
  public abstract int getNumFaces();

  public int getCurrentValue()
  {
    return currentRandomValue;
  }
  
  public String getFace(int faceNum)
  {
    if(faceNum >= 1 && faceNum <= getNumFaces())
    {
      return ""+ (faceNum);
    }
  return "";
  }
  
  public String getCurrentFace()
  {
    return getFace(getCurrentValue());
  }
  
  public void randomize()
  {
    currentRandomValue=(int)(Math.random()*getNumFaces())+1;
  }
  
  public String toString()
  {
    return "d"+ getNumFaces()+ " = "+getCurrentValue();
  }
  

}
