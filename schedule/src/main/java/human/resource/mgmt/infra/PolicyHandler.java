package human.resource.mgmt.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import human.resource.mgmt.config.kafka.KafkaProcessor;
import human.resource.mgmt.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CalendarRepository calendarRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VacationRegistered'"
    )
    public void wheneverVacationRegistered_AddCalendar(
        @Payload VacationRegistered vacationRegistered
    ) {
        VacationRegistered event = vacationRegistered;
        System.out.println(
            "\n\n##### listener AddCalendar : " + vacationRegistered + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VacationCancelled'"
    )
    public void wheneverVacationCancelled_CancelCalendar(
        @Payload VacationCancelled vacationCancelled
    ) {
        VacationCancelled event = vacationCancelled;
        System.out.println(
            "\n\n##### listener CancelCalendar : " + vacationCancelled + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VacationRejected'"
    )
    public void wheneverVacationRejected_CancelCalendar(
        @Payload VacationRejected vacationRejected
    ) {
        VacationRejected event = vacationRejected;
        System.out.println(
            "\n\n##### listener CancelCalendar : " + vacationRejected + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='EmployeeJoined'"
    )
    public void wheneverEmployeeJoined_RegisterCalendar(
        @Payload EmployeeJoined employeeJoined
    ) {
        EmployeeJoined event = employeeJoined;
        System.out.println(
            "\n\n##### listener RegisterCalendar : " + employeeJoined + "\n\n"
        );
        // Sample Logic //

    }
}
