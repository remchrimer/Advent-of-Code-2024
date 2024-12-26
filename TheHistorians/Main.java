package TheHistorians;
import TheHistorians.controllers.OperationController;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("TXT file is not given");
            System.out.println("Available operations are --calculateScore, --calculateReports, --calculateMultiplication");
            return;
        }

        String file = args[0];
        String operation = args[1];

        try {
            OperationController controller = new OperationController(file);
            controller.executeOperation(operation);
        } catch (Exception e) {
            System.err.println("From MAIN: " + e.getMessage());
        }
    }
}