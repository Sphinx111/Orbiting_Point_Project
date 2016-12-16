import java.awt.geom.Point2D;

public class orbitingPoint extends Point2D.Double{
	//Object for the orbiting point, with a name, coordinates, and velocity.
	//relies on Point2D.Double parent class to store x,y coordinates
	String name;
	double x_velocity;
	double y_velocity;
	double mass;
	
	orbitingPoint(String name, double x_coord, double y_coord, double x_velocity, double y_velocity, double mass) {
		//Create a new orbiting point, use superclass object to store 2D coordinates.
		this.name = name;
		this.x = x_coord;
		this.y = y_coord;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
	}
	
	double getVelocity() {
		double velocity = Math.sqrt((x_velocity * x_velocity) + (y_velocity * y_velocity));
		return velocity;
	}
	
	void updatePositionAndAcceleration(double massObject, double gravConstant, double x_coord, double y_coord){
		//update locations for 1 tick, using current velocities.
		this.x = (this.x - this.x_velocity);
		this.y = (this.y - this.y_velocity);
		
		//find distance between subject and object
		double distance = Point2D.distance(this.getX(), this.getY(), x_coord, y_coord);
		//calculates the acceleration upon the orbiting Point (metres per second per second if seconds = 1)
		double acceleration = (gravConstant * massObject) / (distance * distance);
		//finds direction of acceleration, as a modifier for X and modifier for Y.
		double xDiff = x_coord - this.getX(); //if point is to the right of centerMass, xDiff is positive
		double yDiff = y_coord - this.getY(); //if point is below center, yDiff is positive
		//find angle from orbiting point to center
		double oppOverAdj = yDiff / xDiff;
		double angleR = Math.atan(oppOverAdj);
		//share acceleration out between both vectors
		double xChange = Math.cos(angleR) * acceleration;
		double yChange = Math.sin(angleR) * acceleration;
		if (xDiff < 0) {
		//change velocity variables.
			this.x_velocity = this.x_velocity + xChange;
			this.y_velocity = this.y_velocity + yChange;
		} else {
			this.x_velocity = this.x_velocity - xChange;
			this.y_velocity = this.y_velocity - yChange;
		}
	}
	
	
	
}