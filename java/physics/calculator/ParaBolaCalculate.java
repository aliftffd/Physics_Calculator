package physics.calculator;

public class ParaBolaCalculate { 
    private final double g = 9.81; 

    public double calculateTimeOfflight(double velocity,double angle){
        return (2* velocity * Math.sin(Math.toRadians(angle))) / g; 
    }

    public double calculateRange(double velocity, double angle){
        return (velocity * velocity * Math.sin(2 * Math.toRadians(angle))) / g;
    }
}
