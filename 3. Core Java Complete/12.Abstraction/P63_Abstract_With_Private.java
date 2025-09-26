
abstract class Report {

    private void logTimestamp() {

        System.out.println("Log created at: " + new java.util.Date());
    }

    public abstract void generateContent();

    public void generateReport() {
        System.out.println("--- Report Generation Started ---");
        logTimestamp();
        generateContent();
        System.out.println("--- Report Generation Finished ---");
    }
}

class SalesReport extends Report {
    @Override
    public void generateContent() {
        System.out.println("Content: Displaying annual sales figures...");
    }
}

public class P63_Abstract_With_Private {
    public static void main(String[] args) {
        Report myReport = new SalesReport();
        myReport.generateReport();
    }
}