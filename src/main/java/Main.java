/**
 * Created by turbek on 27.02.17.
 */
public class Main {
    static String TARGET_STRING = "My first try and I'm so proud!";
    static double MUTATION_RATE = 0.02;
    static int POPULATION_MAX = 1000;

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
