package uz.pdp;

import uz.pdp.entity.Student;
import uz.pdp.entity.StudentRepo;
import uz.pdp.util.Input;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentRepo studentRepo = StudentRepo.getInstance();
        while (true) {
            displayManu();
            switch (Input.input_Int("choose: ")) {
                case 1 -> studentRepo.save(new Student(Input.input_Str("Enter name: "), Input.input_Int("enter age: ")));
                case 2 -> studentRepo.update(new Student(Input.input_Str("enter name: "), Input.input_Int("enter age: ")),
                        Input.input_Int("enter id: "));
                case 3-> studentRepo.findAll();
                case 4-> studentRepo.delete(chooseStudent(studentRepo.findAll()));

                default ->{ System.out.println("error");
                    return;
                }
            }
        }
    }

    private static Student chooseStudent(List<Student> all) {
        int i = 0;
        for (Student student : all) {
            System.out.println(i+1+". "+ student);
            i++;
        }
        int index = Input.input_Int("choose student: ")-1;
        return all.get(index);
    }


    private static void displayManu() {
        System.out.println("""
                1 - save
                2 - update
                3 - findAll
                4 - delete
                """);
    }
}
