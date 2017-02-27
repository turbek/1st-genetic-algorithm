import java.util.ArrayList;

/**
 * Created by turbek on 27.02.17.
 */
public class Population {
    private ArrayList<Chromosome> population = new ArrayList<>();
    private int popMax;
    private double mutation;
    private String target;

    Population(int popMax, Integer mutationRate, String target){
        this.popMax = popMax;
        this.mutation = mutationRate.doubleValue()/100;
        this.target = target;
        generatePopulation();
    }

    private void generatePopulation() {
        for(int i = 0; i < this.popMax; i++){
            this.population.add(new Chromosome(target.length()));
        }
    }

    @Override
    public String toString() {
        return "Population{" +
                "population=" + population +
                '}';
    }
}
