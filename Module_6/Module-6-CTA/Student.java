//This file defines the Student class and contains the "main" method, which creates an arraylist of 10 students, prints them unsorted, sorts them first by name, then by roll #, and then prints out the sorted list.

import java.util.ArrayList;

public class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + name + ", Address: " + address;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        // Adding 10 student objects, i will use characteers from a childhood game I enjoyed.
        students.add(new Student(1, "Kazuya", "Mishima Style Fighting Karate"));
        students.add(new Student(2, "Jin", "Mishima Style Fighting Karate, Kyokushin Karate"));
        students.add(new Student(3, "Paul", "Martial Arts"));
        students.add(new Student(4, "Law", "Martial Arts"));
        students.add(new Student(5, "Yoshimitsu", "Manji Ninjutsu"));
        students.add(new Student(6, "King", "Vale Tudo"));
        students.add(new Student(7, "Hwoarang", "Tae Kwon Do"));
        students.add(new Student(8, "Xiaoyu", "Various Chinese Martial Arts, including Baguazhang and Piguaquan"));
        students.add(new Student(9, "Lili", "Street Fighting"));
        students.add(new Student(10, "Asuka", "Kazama Style Traditional Martial Arts"));

        
        System.out.println("Before sorting:");
        for (Student s : students) {
            System.out.println(s);
        }
        
        // Sort by name using selection sort with NameComparator
        SelectionSort.selectionSort(students, new NameComparator());
        System.out.println("\nAfter sorting by name:");
        for (Student s : students) {
            System.out.println(s);
        }
        
        // Sort by roll number using selection sort with RollnoComparator
        SelectionSort.selectionSort(students, new RollnoComparator());
        System.out.println("\nAfter sorting by roll number:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
