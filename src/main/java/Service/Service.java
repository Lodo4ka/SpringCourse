package Service;



public interface Service {

    <T>T getAll();

    <T> T getByName(String name);

    default <T> T getById(int id) {
        return null;
    }

}
