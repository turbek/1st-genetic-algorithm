import java.util.ArrayList;

/**
 * Created by turbek on 27.02.17.
 */
public class Population {
    private ArrayList<Chromosome> population;
    private int popMax;
    private int mutation;
    private String target;

    Population(int popMax, int mutation, String target){
        this.popMax = popMax;
        this.mutation = mutation;
        this.target = target;
        generatePopulation();
    }

    private void generatePopulation() {
        for(int i = 0; i < this.popMax; i++){
            this.population.add(new Chromosome(target.length()));
        }
    }


}
