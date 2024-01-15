package uz.pdp;

import uz.pdp.entity.Student;
import uz.pdp.entity.StudentRepo;
import uz.pdp.util.Input;

public class Main {
    public static void main(String[] args) {
        StudentRepo studentRepo = StudentRepo.getInstance();
        while (true) {
            displayManu();
            switch (Input.input_Int("choose: ")) {
                case 1 -> studentRepo.save(new Student(Input.input_Str("Enter name: "), Input.input_Int("enter age: ")));
                case 2 -> studentRepo.update(new Student(Input.input_Str("enter name: "), Input.input_Int("enter age: ")),
                        Input.input_Int("enter id: "));

                default ->{ System.out.println("error");
                    return;
                }

            }
        }
    }

    private static void displayManu() {
        System.out.println("""
                1 - save
                2 - update
                """);
    }
}
