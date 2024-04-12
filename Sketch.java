

import processing.core.PApplet;
import java.util.Random;

public class Sketch extends PApplet {

  Random random = new Random();

  public void settings() {
    size(500, 500);
  }

  public void setup() {
    background(255, 255, 255);
  }

  int intRandOne = random.nextInt(255);
  int intRandTwo = random.nextInt(255);
  int intRandThree = random.nextInt(255);

  public void draw() {

    // For loop creates multiple flowers with drawFlower function
    for(int intFlowerX = 50; intFlowerX < width; intFlowerX = intFlowerX + 100){
      for(int intFlowerY = 50; intFlowerY < height; intFlowerY = intFlowerY + 100){
        drawFlower(intFlowerX, intFlowerY, 55, 200, 0);
        
      }
    } 

    // For loop creates multiple eyes with drawEye function
    for(int intEyeX = 100; intEyeX < width - 50; intEyeX += 50){
      for(int intEyeY = 100; intEyeY < height - 50; intEyeY += 50){
        drawEyeInner(intEyeY, intEyeX);
        
      }
    }
  }

  /**
   * This method draws a flower using two parameters.
   * 
   * @param intCircle1
   * @param intCircle2
   * @void
   * @Koline2024
   */

   private void drawFlower(int intCircle1, int intCircle2, int intRed, int intGreen, int intBlue){

    fill(intRed, intGreen, intBlue);
    ellipse(intCircle1 + 20, intCircle2 + 20, width/15, height/15);
    ellipse(intCircle1 + 20, intCircle2 - 20, width/15, height/15);
    ellipse(intCircle1 - 20, intCircle2 + 20, width/15, height/15);
    ellipse(intCircle1 - 20, intCircle2 - 20, width/15, height/15);
    fill(255,255,0);
    ellipse(intCircle1, intCircle2, width/10, height/10); 
   } 

  /**
   * This method draws the outer eye.
   * 
   * @param intEye1
   * @param intEye2
   * @return boolean
   * @Koline2024
   */
   
   public boolean drawEye(int intEye1, int intEye2){   
    fill(255, 255, 255);
    ellipse(intEye1, intEye2, width/30, height/30);
    if (intEye1 % 3 == 0 || intEye2 % 3 == 0) {
      return true;
    } else {
      return false;
    }
   }

   /**
    * This method draws the whole eye, alternating colours using outer eye function. 
    *
    * @param intInnerEye1
    * @param intInnerEye2
    * @return void
    * @Koline2024
   */
  
   public void drawEyeInner(int intInnerEye1, int intInnerEye2){
    boolean blnFill = drawEye(intInnerEye1, intInnerEye2);
    if (blnFill == true) {
      fill(intRandOne, 0, 0);
      ellipse(intInnerEye1 + 3, intInnerEye2 + 3, width/60, height/60);
    } else {
      fill(0, intRandThree, 0);
      ellipse(intInnerEye1 + 3, intInnerEye2 + 3, width/60, height/60);
    }
  }
}