package Service;


import java.util.List;

public interface Service<T> {

    void save(T t);

    void remove(T t);

    List<T> getAll();

    T getByName(String name);

    default T getById(int id) {
        return null;
    }

}
