import java.util.ArrayList;
import java.util.Random;

/**
 * Created by turbek on 27.02.17.
 */
public class Population {
    private Chromosome[] population;
    private ArrayList<Chromosome> matingPool;
    private int popMax;
    private double mutation;
    private String target;
    private double maxFitness = 0.0;
    private int generationCount = 0;


    Population(int popMax, double mutation, String target){
        this.popMax = popMax;
        this.mutation = mutation;
        this.target = target;
        this.population = new Chromosome[popMax];
    }

    public void generatePopulation() {
        for(int i = 0; i < this.popMax; i++){
            this.population[i] = new Chromosome(target.length());
        }
    }

    public void calculateFitness() {
        for(int i = 0; i < this.popMax; i++) {
            this.population[i].checkFitness(this.target);
            if(this.population[i].fitness > this.maxFitness){
                this.maxFitness = this.population[i].fitness;
                System.out.println("new maximum fitness: "+this.maxFitness+"\nchromosome:"+this.population[i].toString()+"\n");
            }
        }
    }

    public void matingPool() {

        this.matingPool = new ArrayList<>();
        for(int i = 0; i < this.popMax; i++) {
            Double mateNumFloat = this.population[i].fitness / maxFitness * 100;
            int mateNumInt = mateNumFloat.intValue();
            for(int j = 0; j < mateNumInt; j++) {
                this.matingPool.add(this.population[i]);
            }
        }
    }

    public void generateNewPopulation() {
        for (int i = 0; i < this.population.length; i++){
            Chromosome parent1 = this.matingPool.get(new Random().nextInt(this.matingPool.size()));
            Chromosome parent2 = this.matingPool.get(new Random().nextInt(this.matingPool.size()));
            Chromosome child = parent1.crossover(parent2);
            child.mutate(this.mutation);
            this.population[i] = child;
        }
        generationCount++;
    }

    public boolean checkIfFinished(){
        return this.maxFitness == 1.0;
    }

    public int getGenerationCount() {
        return generationCount;
    }

    @Override
    public String toString() {
        return "Population{" +
                "population=" + population +
                '}';
    }
}
