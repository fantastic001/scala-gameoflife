package gameoflife;
import Array._

class Simulation(first : Array[Array[Boolean]])
{
	var matrix = first;
	
	def step() : Array[Array[Boolean]] = 
	{
		val next : Array[Array[Boolean]] = ofDim[Boolean](10,10);
		for (i <- 0 to 9) 
		{
			for (j <- 0 to 9) 
			{
				var count = countActive(i,j);
				if (matrix(i)(j)) 
				{
					if (count < 2) next(i)(j) = false; 
					else if (count>3) next(i)(j) = false;
					else 
					{
						next(i)(j) = matrix(i)(j);
					}

				}
				if (!matrix(i)(j)) 
				{
					if (count == 3) next(i)(j) = true;
					else next(i)(j) = matrix(i)(j);
				}
			}
		}
		matrix = next; 
		return next;
	}

	def countActive(i:Int, j:Int) : Int = 
	{
		var count = 0;
		if (i>0 && matrix(i-1)(j)) count += 1;
		if (i<9 && matrix(i+1)(j)) count += 1;
		if (j>0 && matrix(i)(j-1)) count += 1;
		if (j<9 && matrix(i)(j+1)) count += 1;
		if (i>0 && j>0 && matrix(i-1)(j-1)) count += 1;
		if (i>0 && j<9 && matrix(i-1)(j+1)) count += 1;
		if (i<9 && j>0 && matrix(i+1)(j-1)) count += 1;
		if (i<9 && j<9 && matrix(i+1)(j+1)) count += 1;
		return count;
	}

	def getMatrix() : Array[Array[Boolean]] =
	{
		return matrix; 
	}
}
