package gameoflife

import scala.swing.Panel
import java.awt.{ Graphics2D, Color }

import Array._

class Canvas extends Panel 
{
	var myMatrix = ofDim[Boolean](10,10);

	override def paintComponent(g: Graphics2D) {
		g.clearRect(0, 0, size.width, size.height);

		g.setColor(Color.white)
		g.fillRect(0,0,size.width, size.height)
		
		g.setColor(Color.black);
		for (i <- 0 to 9) 
		{
			for (j <- 0 to 9) 
			{
				if (myMatrix(i)(j)) {
					g.fillRect(10*i, 10*j, 10, 10);
				}
			}
		}
	}
	def updateMatrix(matrix : Array[Array[Boolean]]) 
	{
		for (i <- 0 to 9) {
			for (j <- 0 to 9 ) 
			{
				myMatrix(i)(j) = matrix(i)(j);
			}
		}
		repaint();
	}
}
