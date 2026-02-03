import java.sql.Connection;
import java.util.List;

public interface ClientRepository {
    void create(Connection conn, String name, int age) throws Exception;
    List<String> readAll(Connection conn) throws Exception;
    void updateAge(Connection conn, int id, int newAge) throws Exception;
    void delete(Connection conn, int id) throws Exception;
}


