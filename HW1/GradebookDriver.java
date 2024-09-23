import java.util.Random;
public class GradebookDriver {
    public static void main(String[] args) {
        Gradebook grades = new Gradebook(10);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randInt = rand.nextInt(98) + 1;
            grades.updateGrade(i, randInt);
        }
        grades.calculateAverage();
        grades.calculateMax();
        grades.applyCurve();
        grades.assignLetterGrade();
    }
}
