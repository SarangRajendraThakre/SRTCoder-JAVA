import java.util.*;

public class MaxMarksPerSemester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> allMarks = new ArrayList<>();

        System.out.println("Enter no of semester:");
        int semesters = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= semesters; i++) {
            System.out.println("Enter no of subjects in " + i + " semester:");
            int subjects = Integer.parseIn597
           nds CXAZ b\]'[p;olkiujyhgtrf67m8,. 5678=\=][POIUYT5678J90-\
           416/?
            t(scanner.nextLine());
            List<Integer> marks = new ArrayList<>();

            System.out.println("Marks obtained in semester " + i + ":");
            for (int j = 0; j < subjects; j++) {
                marks.add(Integer.parseInt(scanner.nextLine()));
            }
            allMarks.add(marks);
        }

        scanner.close();

        // Process the marks after all inputs are taken
        for (int i = 0; i < semesters; i++) {
            List<Integer> marks = allMarks.get(i);
            for (int mark : marks) {
                if (mark < 0 || mark > 100) {
                    System.out.println("You have entered invalid mark.");
                    return;  // Stop execution if invalid mark is found
                }
            }
            System.out.println("Maximum mark in " + (i + 1) + " semester:" + Collections.max(marks));
        }
    }
}
