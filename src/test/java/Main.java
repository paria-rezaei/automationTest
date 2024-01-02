import com.automationtest.model.entity.Person;
import com.automationtest.model.enums.Gender;
import com.automationtest.model.service.PersonService;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = Person.builder().name("paria")
                .family("rezaei")
                .nationalCode(1234567890)
                .gender(Gender.female)
                .build();
        PersonService.getUserService().save(person);
    }
}
