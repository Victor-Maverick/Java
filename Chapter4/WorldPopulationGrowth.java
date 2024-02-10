public class WorldPopulationGrowth{
	public static void main(String... args){
	
	double worldPopulation = 7975105156.00;
	double increaseRate = 0.89;
	double expectedPopulation = worldPopulation;
	double increase = 1.00;
	System.out.printf("%s	%s	%s%n", "Year", "Expected population", "Numerical increase");	

	for(int count=1; count<=75; count++){
	increase = 0.0089 * expectedPopulation;
	expectedPopulation +=increase;

	System.out.printf("%3d		%.0f		%.0f%n", count, expectedPopulation, increase);
	count++;
	}
	}

}