import java.util.Arrays;
import java.util.Random;

/**
 * Created by turbek on 27.02.17.
 */
public class Chromosome {
    private int length;
    private char[] genes;
    public float fitness;


    Chromosome(int length){
        this.length = length;
        this.genes = generateChromosome();
    }

    private char generateGene(){
        Random r = new Random();
        int value = r.nextInt((122 - 32) + 1) + 32;
        char randomChar = (char)value;
        return randomChar;
    }

    private char[] generateChromosome(){
        char[] genes = new char[this.length];
        for(int i = 0; i < this.length; i++){
            genes[i] = generateGene();
        }
        return genes;
    }

    public void checkFitness(String target){
        Integer score = 0;
        for(int i = 0; i < this.genes.length; i++){
            if(this.genes[i] == target.charAt(i))
                score++;
        }
        this.fitness = score.floatValue() / target.length();
    }

    public Chromosome crossover(Chromosome partner){
        Chromosome child = new Chromosome(this.genes.length);
        Random r = new Random();
        int midpoint = r.nextInt((this.genes.length)+1);
        for (int i = 0; i < this.genes.length; i++){
            if (i > midpoint)
                child.genes[i] = this.genes[i];
            else
                child.genes[i] = partner.genes[i];
        }
        return child;
    }

    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + Arrays.toString(genes) +
                '}';
    }
}

