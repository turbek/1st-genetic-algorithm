/**
 * Created by turbek on 27.02.17.
 */
public class Main {
    private static final String TARGET_STRING = "This is the target!!";
    private static final double MUTATION_RATE = 0.02;
    private static final int POPULATION_MAX = 1000;

    public static void main(String[] args) {
        Population population = new Population(POPULATION_MAX, MUTATION_RATE, TARGET_STRING);
        population.generatePopulation();
        while(!population.checkIfFinished()) {
            population.calculateFitness();
            population.matingPool();
            population.generateNewPopulation();
            if (population.getGenerationCount() % 500 == 0)
                System.out.println("generation count at: "+population.getGenerationCount());
        }
        System.out.println("finished in: "+population.getGenerationCount()+" generations.");
    }
}
