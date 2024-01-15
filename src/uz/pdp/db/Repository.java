package uz.pdp.db;

import uz.pdp.entity.Student;

import java.util.List;

public interface Repository <T>{

    void save(T t);

    void uploadData();

    void update(T t, Integer id);
    List<T> findAll();
    void delete(T t);

}
