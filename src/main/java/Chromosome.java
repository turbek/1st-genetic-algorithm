import java.util.Arrays;
import java.util.Random;

/**
 * Created by turbek on 27.02.17.
 */
public class Chromosome {
    int length;
    char[] genes;

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

    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + Arrays.toString(genes) +
                '}';
    }
}

