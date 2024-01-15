package uz.pdp.db;

import java.util.List;

public interface Repository <T>{

    void save(T t);

    void update(T t, Integer id);

}
