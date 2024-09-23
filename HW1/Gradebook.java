public class Gradebook {
    private int[] grades;
    public Gradebook(int size) {
        grades = new int[size];
        for (int i = 0; i < size; i++) {
            grades[i] = 0;
        }
    }
    public void updateGrade(int index, int grade) {
        grades[index] = grade;
        return;
    }
    public double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }
    public int calculateMax() {
        int max = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }
    public void applyCurve() {
        int maxGrade = calculateMax();
        for (int i = 0; i < grades.length; i++) {
            grades[i] += (100 - maxGrade);
        }
        return;
    }
    public char[] assignLetterGrade() {
        char[] letterGrades = new char[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 90) {
                letterGrades[i] = 'A';
            } else if (grades[i] >= 80) {
                letterGrades[i] = 'B';
            } else if (grades[i] >= 70) {
                letterGrades[i] = 'C';
            } else if (grades[i] >= 60) {
                letterGrades[i] = 'D';
            } else {
                letterGrades[i] = 'F';
            }
        }
        return letterGrades;
    }
}