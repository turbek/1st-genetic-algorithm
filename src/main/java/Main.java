/**
 * Created by turbek on 27.02.17.
 */
public class Main {
    static String TARGET_STRING = "first try.";
    static int MUTATION_RATE = 1;
    static int POPULATION_MAX;

    public static void main(String[] args) {
        Population population = new Population(POPULATION_MAX, MUTATION_RATE, TARGET_STRING);
        population.generatePopulation();
        while(true) {
            population.calculateFitness();
            population.matingPool();
            population.chooseParents();
            population.generateNewPopulation();
        }
    }
}
