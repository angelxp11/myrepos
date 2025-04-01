import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadBlockView {

    public void displayBlocks() {
        List<Block> blocks = fetchBlocks();
        if (blocks.isEmpty()) {
            System.out.println("No blocks found.");
        } else {
            System.out.println("List of Blocks:");
            for (Block block : blocks) {
                System.out.println("ID: " + block.getId() + ", Name: " + block.getName() + 
                                   ", Created At: " + block.getCreatedAt() + 
                                   ", Status ID: " + block.getStatusId());
            }
        }
    }

    private List<Block> fetchBlocks() {
        List<Block> blocks = new ArrayList<>();
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM blocks");

            while (resultSet.next()) {
                Block block = new Block();
                block.setId(resultSet.getInt("id"));
                block.setName(resultSet.getString("name"));
                block.setCreatedAt(resultSet.getDate("createdAt"));
                block.setStatusId(resultSet.getInt("statusId"));
                blocks.add(block);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return blocks;
    }
}