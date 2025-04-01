import java.util.Scanner;

public class CreateBlockView {
    private Scanner scanner;

    public CreateBlockView() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        System.out.println("Create a New Block");
        System.out.print("Enter block name: ");
        String name = scanner.nextLine();
        
        // Assuming BlockController is available to handle the creation
        BlockController blockController = new BlockController();
        boolean success = blockController.createBlock(name);

        if (success) {
            System.out.println("Block created successfully!");
        } else {
            System.out.println("Error creating block. Please try again.");
        }
    }
}