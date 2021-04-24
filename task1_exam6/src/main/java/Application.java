import Entity.Student;
import Enum.Gender;
import Util.HibernateUtil;
import org.hibernate.Session;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Student student1 = Student.builder().name("Rudolf").averageMark(4.3).age(22).gender(Gender.MALE).build();
        Student student2 = Student.builder().name("Smith").averageMark(3.4).age(19).gender(Gender.MALE).build();
        Student student3 = Student.builder().name("Kate").averageMark(3.1).age(18).gender(Gender.FEMALE).build();
        Student student4 = Student.builder().name("Monica").averageMark(4.7).age(23).gender(Gender.FEMALE).build();
        Student student5 = Student.builder().name("Robert").averageMark(4.1).age(24).gender(Gender.MALE).build();
        Student student6 = Student.builder().name("Jeremy").averageMark(2.3).age(22).gender(Gender.MALE).build();
        Student student7 = Student.builder().name("Emma").averageMark(3.8).age(21).gender(Gender.FEMALE).build();
        Student student8 = Student.builder().name("Elizabeth").averageMark(5.0).age(18).gender(Gender.FEMALE).build();
        Student student9 = Student.builder().name("William").averageMark(4.9).age(21).gender(Gender.MALE).build();
        Student student10 = Student.builder().name("Jennifer").averageMark(3.6).age(19).gender(Gender.FEMALE).build();

        create(student1);
        create(student2);
        create(student3);
        create(student4);
        create(student5);
        create(student6);
        create(student7);
        create(student8);
        create(student9);
        create(student10);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5,
                                                  student6, student7, student8, student9, student10);

        System.out.println(getNamesList(studentList));

        System.out.println(getNamesListByAge(studentList, 20));

        printAnonymously(studentList);

        System.out.println(getNamesFirstLetterList(studentList));
    }

    public static<T> void create(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
    }

    public static List<String> getNamesList(List<Student> students) {
        return students.stream().map(Student::getName).collect(Collectors.toList());
    }

    public static List<String> getNamesListByAge(List<Student> students, Integer minAge) {
        return students.stream().filter(x -> x.getAge() > minAge).map(Student::getName).collect(Collectors.toList());
    }

    public static void printAnonymously(List<Student> students) {
        students.stream().map(x -> "ID: " + x.getId() + ", Средняя оценка: " + x.getAverageMark()).forEach(System.out::println);
    }

    public static List<String> getNamesFirstLetterList(List<Student> students) {
        return students.stream().map(x -> x.getName().substring(0, 1) + x.getName().length()).collect(Collectors.toList());
    }
}
