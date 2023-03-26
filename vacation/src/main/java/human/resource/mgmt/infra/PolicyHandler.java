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
    VacationRepository vacationRepository;

    @Autowired
    VacationDaysLeftRepository vacationDaysLeftRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VacationRegistered'"
    )
    public void wheneverVacationRegistered_Use(
        @Payload VacationRegistered vacationRegistered
    ) {
        VacationRegistered event = vacationRegistered;
        System.out.println(
            "\n\n##### listener Use : " + vacationRegistered + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VacationCancelled'"
    )
    public void wheneverVacationCancelled_Add(
        @Payload VacationCancelled vacationCancelled
    ) {
        VacationCancelled event = vacationCancelled;
        System.out.println(
            "\n\n##### listener Add : " + vacationCancelled + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VacationRejected'"
    )
    public void wheneverVacationRejected_Add(
        @Payload VacationRejected vacationRejected
    ) {
        VacationRejected event = vacationRejected;
        System.out.println(
            "\n\n##### listener Add : " + vacationRejected + "\n\n"
        );
        // Sample Logic //

    }

    @Autowired
    human.resource.mgmt.external.FindByUserIdService findByUserIdService;

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='EmployeeJoined'"
    )
    public void wheneverEmployeeJoined_RegisterUser(
        @Payload EmployeeJoined employeeJoined
    ) {
        EmployeeJoined event = employeeJoined;
        System.out.println(
            "\n\n##### listener RegisterUser : " + employeeJoined + "\n\n"
        );
        // REST Request Sample

        // findByUserIdService.getFindByUserId(/** mapping value needed */);

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VacationDaysInsufficient'"
    )
    public void wheneverVacationDaysInsufficient_Update(
        @Payload VacationDaysInsufficient vacationDaysInsufficient
    ) {
        VacationDaysInsufficient event = vacationDaysInsufficient;
        System.out.println(
            "\n\n##### listener Update : " + vacationDaysInsufficient + "\n\n"
        );
        // Sample Logic //

    }
}
