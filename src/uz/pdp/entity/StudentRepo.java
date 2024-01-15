package uz.pdp.entity;

import uz.pdp.db.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements Repository<Student> {
    List<Student> students;
    private static  StudentRepo singleton;

    private StudentRepo(List<Student> students) {
        this.students = students;
    }

    public static StudentRepo getInstance(){
        if (singleton == null){
            return singleton = new StudentRepo(loadData());
        }else {
            return singleton;
        }
    }
@SuppressWarnings("unchecked")
    private static List<Student> loadData() {
        try (
                InputStream inputStream = new FileInputStream(PATH);
          ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                ){
           return (List<Student>)objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            return new ArrayList<>();
        }


}

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
