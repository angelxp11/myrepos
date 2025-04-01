import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlockController {
    private DatabaseConnection databaseConnection;

    public BlockController() {
        this.databaseConnection = new DatabaseConnection();
    }

    public void createBlock(String name) {
        String query = "INSERT INTO blocks (name, createdAt, statusId) VALUES (?, NOW(), 1)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Block readBlock(int id) {
        String query = "SELECT * FROM blocks WHERE id = ?";
        Block block = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                block = new Block();
                block.setId(resultSet.getInt("id"));
                block.setName(resultSet.getString("name"));
                block.setCreatedAt(resultSet.getDate("createdAt"));
                block.setStatusId(resultSet.getInt("statusId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return block;
    }

    public List<Block> readAllBlocks() {
        List<Block> blocks = new ArrayList<>();
        String query = "SELECT * FROM blocks";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
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
        }
        return blocks;
    }

    public void updateBlock(int id, String name) {
        String query = "UPDATE blocks SET name = ? WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBlock(int id) {
        String query = "DELETE FROM blocks WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}