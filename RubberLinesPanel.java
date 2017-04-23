
//  RubberLinesPanel.java      

//  Represents the primary drawing panel for the RubberLines program.


import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class RubberLinesPanel extends JPanel
{
//   private Point point1 = null, point2 = null;
   private Point[] point1= new Point[100];
   private Point[] point2= new Point[100];
  //change to array//


   //  Constructor: Sets up this panel to listen for mouse events.
   
   public RubberLinesPanel()
   {
      LineListener listener = new LineListener();
      addMouseListener (listener);
      addMouseMotionListener (listener);

      setBackground (Color.black);
      setPreferredSize (new Dimension(400, 200));
   }

 
   //  Draws the current line from the intial mouse-pressed point to
   //  the current position of the mouse.
  
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.yellow);

     
      if(point1[0] != null && point2[0] != null){
      for (int i=0; i<point1.length; i++){
      if (point1[i] != null && point2[i] != null)
         page.drawLine (point1[i].x, point1[i].y, point2[i].x, point2[i].y);
      	
      }
      }
   }
   // here must has a loop//

   //  Represents the listener for all mouse events.
   
   private class LineListener implements MouseListener,
                                         MouseMotionListener
   {
	   public int count=0;

      //  Captures the initial position at which the mouse button is
      //  pressed.

      public void mousePressed (MouseEvent event)
      {
         point1[count] = event.getPoint();
      }

     
      //  Gets the current position of the mouse as it is dragged and
      //  redraws the line to create the rubberband effect.

      public void mouseDragged (MouseEvent event)
      {
    	  point2[count]=event.getPoint();
    	  repaint();
    	  
      }


      //  Provide empty definitions for unused event methods.

      public void mouseClicked (MouseEvent event) {
    	 
      }
      public void mouseReleased (MouseEvent event) {
    	  point2[count]=event.getPoint();
    	  repaint();
    	  count++;
    	  
      }
      public void mouseEntered (MouseEvent event) {}
      public void mouseExited (MouseEvent event) {}
      public void mouseMoved (MouseEvent event) {}
   }
}