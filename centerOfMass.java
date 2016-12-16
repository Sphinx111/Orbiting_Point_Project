import java.awt.geom.Point2D;

public class centerOfMass extends Point2D.Double{
	double mass;
	
	centerOfMass (double x, double y, double mass) {
		//create a new centerOfMass, at location with given mass.
		this.mass = mass;
		super.x = x;
		super.y = y;
	}
	
	public double getMass () {
		return this.mass;
	}
	
}
