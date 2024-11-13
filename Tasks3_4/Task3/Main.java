package Tasks3_4.Task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Viet Tran", 24);
        Course course = new Course("Python", "Beginners Python", "Jarkko");

        // Serialize the instances to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            out.writeObject(student);
            out.writeObject(course);
            System.out.println("Objects serialized and saved to enrollments.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the instances from the file and print their information
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            Student deserializedStudent = (Student) in.readObject();
            Course deserializedCourse = (Course) in.readObject();

            System.out.println("Deserialized Student: " + deserializedStudent);
            System.out.println("Deserialized Course: " + deserializedCourse);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
