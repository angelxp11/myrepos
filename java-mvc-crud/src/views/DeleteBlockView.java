public class DeleteBlockView {
    
    public void displayDeleteConfirmation(int blockId) {
        System.out.println("Are you sure you want to delete the block with ID: " + blockId + "? (yes/no)");
    }

    public void displaySuccessMessage() {
        System.out.println("Block deleted successfully.");
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}