package human.resource.mgmt.infra;

import human.resource.mgmt.config.kafka.KafkaProcessor;
import human.resource.mgmt.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class VacationDaysStatusViewHandler {

    @Autowired
    private VacationDaysStatusRepository vacationDaysStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVacationDaysIntialized_then_CREATE_1(
        @Payload VacationDaysIntialized vacationDaysIntialized
    ) {
        try {
            if (!vacationDaysIntialized.validate()) return;

            // view 객체 생성
            VacationDaysStatus vacationDaysStatus = new VacationDaysStatus();
            // view 객체에 이벤트의 Value 를 set 함
            vacationDaysStatus.setUserId(vacationDaysIntialized.getUserId());
            vacationDaysStatus.setDaysLeft(
                vacationDaysIntialized.getDayCount()
            );
            // view 레파지 토리에 save
            vacationDaysStatusRepository.save(vacationDaysStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVacationDaysAdded_then_UPDATE_1(
        @Payload VacationDaysAdded vacationDaysAdded
    ) {
        try {
            if (!vacationDaysAdded.validate()) return;
            // view 객체 조회
            Optional<VacationDaysStatus> vacationDaysStatusOptional = vacationDaysStatusRepository.findByUserId(
                vacationDaysAdded.getUserId()
            );

            if (vacationDaysStatusOptional.isPresent()) {
                VacationDaysStatus vacationDaysStatus = vacationDaysStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                vacationDaysStatus.setDaysLeft(
                    vacationDaysStatus.getDaysLeft() +
                    vacationDaysAdded.getDayCount()
                );
                // view 레파지 토리에 save
                vacationDaysStatusRepository.save(vacationDaysStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVacationDaysUsed_then_UPDATE_2(
        @Payload VacationDaysUsed vacationDaysUsed
    ) {
        try {
            if (!vacationDaysUsed.validate()) return;
            // view 객체 조회
            Optional<VacationDaysStatus> vacationDaysStatusOptional = vacationDaysStatusRepository.findByUserId(
                vacationDaysUsed.getUserId()
            );

            if (vacationDaysStatusOptional.isPresent()) {
                VacationDaysStatus vacationDaysStatus = vacationDaysStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                vacationDaysStatus.setDaysLeft(
                    vacationDaysStatus.getDaysLeft() -
                    vacationDaysUsed.getDayCount()
                );
                // view 레파지 토리에 save
                vacationDaysStatusRepository.save(vacationDaysStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
