import Entity.Human;
import Entity.Medicine;
import Entity.Virus;
import Entity.VirusMedicine;
import Enum.Gender;
import Util.HibernateUtil;
import org.hibernate.Session;
public class Application {
    public static void main(String[] args) {
        Virus virus1 = Virus.builder().name("Virus1").build();
        Virus virus2 = Virus.builder().name("Virus2").build();
        Virus virus3 = Virus.builder().name("Virus3").build();

        create(virus1);
        create(virus2);
        create(virus3);

        Human human1 = Human.builder().fullName("Human1").age(22).gender(Gender.FEMALE).virus(virus1).build();
        Human human2 = Human.builder().fullName("Human2").age(16).gender(Gender.MALE).virus(virus2).build();
        Human human3 = Human.builder().fullName("Human3").age(29).gender(Gender.MALE).virus(virus3).build();

        create(human1);
        create(human2);
        create(human3);

        Medicine medicine1 = Medicine.builder().name("Medicine1").virus(virus1).build();
        Medicine medicine2 = Medicine.builder().name("Medicine2").virus(virus2).build();
        Medicine medicine3 = Medicine.builder().name("Medicine3").virus(virus3).build();

        create(medicine1);
        create(medicine2);
        create(medicine3);

        VirusMedicine virusMedicine1 = VirusMedicine.builder().virus(virus1).medicine(medicine2).build();
        VirusMedicine virusMedicine2 = VirusMedicine.builder().virus(virus3).medicine(medicine2).build();
        VirusMedicine virusMedicine3 = VirusMedicine.builder().virus(virus2).medicine(medicine3).build();

        create(virusMedicine1);
        create(virusMedicine2);
        create(virusMedicine3);
    }

    public static<T> void create(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
    }
}
