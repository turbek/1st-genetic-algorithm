/**
 * Created by turbek on 27.02.17.
 */
public class Main {
    static String TARGET_STRING = "Balazs olyan okos!";
    static double MUTATION_RATE = 0.01;
    static int POPULATION_MAX = 200;

    public static void main(String[] args) {
        Population population = new Population(POPULATION_MAX, MUTATION_RATE, TARGET_STRING);
        population.generatePopulation();
        while(!population.checkIfFinished()) {
            population.calculateFitness();
            population.matingPool();
            population.generateNewPopulation();
        }
        System.out.println("finished in: "+population.getGenerationCount()+" generations.");
    }
}
