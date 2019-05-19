/**
 * 
 */
package RandomizerLab;

/**
 * @author MarcSherman
 *
 */
public interface Randomizer {
  
  /**
   * generates a new random value
   */
  public void randomize();
  
  /**
   * gets the current value
   */
  public int getCurrentValue();
  
  
  /**
   * @return gets the current face 
   *    of the randomizer
   */
  public String getCurrentFace();
  
  /**
  gets the number of possible 
  random value
   * @return
   */
  public int getNumFaces();
  
  
  /**
   * @param faceNumber
   * @return gets the face name for a 
   *     given possible value
   */
  public String getFace(int faceNum);
  
  

}
