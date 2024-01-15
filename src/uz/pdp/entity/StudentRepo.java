package uz.pdp.entity;

import uz.pdp.db.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements Repository<Student> {
    List<Student> students;

    public static String PATH = "src/uz/pdp/db/db_students.txt";

    @Override
    public void save(Student student) {
        students.add(student);
        uploadData();
    }

    private void uploadData() {
        try(
                OutputStream outputStream  = new FileOutputStream(PATH);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
                ) {
            objectOutputStream.writeObject(students);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            new ArrayList<>();
        }
    }


    @Override
    public void update(Student student, Integer id) {

    }
}
