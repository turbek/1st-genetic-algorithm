import java.util.ArrayList;

/**
 * Created by turbek on 27.02.17.
 */
public class Population {
    private Chromosome[] population;
//    private ArrayList<Chromosome> population = new ArrayList<>();
    private ArrayList<Chromosome> matingPool;
    private int popMax;
    private double mutation;
    private String target;
    private float maxFitness = 0.0f;

    Population(int popMax, Integer mutationRate, String target){
        this.popMax = popMax;
        this.mutation = mutationRate.doubleValue()/100;
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
                System.out.println("new maximum fitness: "+this.maxFitness);
            }
        }
    }

    public void matingPool() {
        this.matingPool = new ArrayList<>();
        for(int i = 0; i < this.popMax; i++) {
            Float mateNumFloat = this.population[i].fitness / maxFitness * 100;
            int mateNumInt = mateNumFloat.intValue();
            for(int j = 0; j < mateNumInt; j++) {
                this.matingPool.add(this.population[i]);
            }
        }
        System.out.println("mating pool size: "+this.matingPool.size());
    }

    public void generateNewPopulation() {
//        for (int i = 0; i < this.population.length; i++){
//            Chromosome parent1 = this.matingPool.get(new Random().nextInt(this.matingPool.size()+1));
//            Chromosome parent2 = this.matingPool.get(new Random().nextInt(this.matingPool.size()+1));
//            Chromosome child = parent1.crossover(parent2);
//            child.mutate();
//            this.population. = child;
//        }

//        parentA
//        parentB
//        crossover
//        mutation
//        addtopopulation
    }

    @Override
    public String toString() {
        return "Population{" +
                "population=" + population +
                '}';
    }
}
