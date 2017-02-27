import java.util.ArrayList;

/**
 * Created by turbek on 27.02.17.
 */
public class Population {
    private ArrayList<Chromosome> population = new ArrayList<>();
    private ArrayList<Chromosome> matingPool;
    private int popMax;
    private double mutation;
    private String target;
    private float maxFitness = 0.0f;

    Population(int popMax, Integer mutationRate, String target){
        this.popMax = popMax;
        this.mutation = mutationRate.doubleValue()/100;
        this.target = target;
    }

    public void generatePopulation() {
        for(int i = 0; i < this.popMax; i++){
            this.population.add(new Chromosome(target.length()));
        }
    }

    public void calculateFitness() {
        for(int i = 0; i < this.popMax; i++) {
            this.population.get(i).checkFitness(this.target);
            if(this.population.get(i).fitness > this.maxFitness){
                this.maxFitness = this.population.get(i).fitness;
            }
        }
    }

    public void matingPool() {
        this.matingPool = new ArrayList<>();
        for(int i = 0; i < this.popMax; i++) {

        }
    }

    @Override
    public String toString() {
        return "Population{" +
                "population=" + population +
                '}';
    }
}
