package interfaces;

import java.util.List;

public interface DAO <Entity> {
    void create(final Entity model);
    List<Entity> read();
    void update(Integer key, Entity model);
    void delete(Integer key);
}
