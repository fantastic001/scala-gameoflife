package gameoflife; 

import scala.swing._
import scala.swing.BorderPanel.Position._
import event._
import Array._

object GameOfLife extends SimpleSwingApplication 
{
	var matrix = ofDim[Boolean](10, 10);
	
	println("filling in matrix")
	for (i <- 0 to 9) 
	{
		for (j <- 0 to 9) 
		{
			println(i + " " + j) 
			matrix(i)(j) = false;
		}
	}
	matrix(0)(0) = true; 
	matrix(5)(5) = true; 
	matrix(1)(1) = true;
	matrix(0)(1) = true;

	var simulation = new Simulation(matrix);

	def top = new MainFrame{
		title = "Game of life";

		val button = new Button {
			text = "Step";
			enabled = true;
		}
		val canvas = new Canvas {
			preferredSize = new Dimension(100, 100)
		}
		canvas.updateMatrix(matrix)


		contents = new BorderPanel {
			layout(button) = South;
			layout(canvas) = Center;
		}
		size = new Dimension(300, 200)

		listenTo(button)

		reactions += {
			case ButtonClicked(component) if component == button =>
				matrix = simulation.step();
				canvas.updateMatrix(matrix);
		}
	}
}
