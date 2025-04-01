public class UpdateBlockView {
    
    private BlockController blockController;

    public UpdateBlockView(BlockController blockController) {
        this.blockController = blockController;
    }

    public void displayUpdateBlockForm(int blockId) {
        // Logic to display the form for updating a block
        Block block = blockController.readBlock(blockId);
        if (block != null) {
            System.out.println("Updating Block: " + block.getId());
            System.out.println("Current Name: " + block.getName());
            // Gather new data from user input (e.g., using Scanner)
            // Update the block using blockController.updateBlock(updatedBlock);
        } else {
            System.out.println("Block not found.");
        }
    }

    public void showSuccessMessage() {
        System.out.println("Block updated successfully.");
    }

    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}