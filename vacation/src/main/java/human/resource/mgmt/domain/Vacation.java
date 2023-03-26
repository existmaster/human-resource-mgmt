package human.resource.mgmt.domain;

import human.resource.mgmt.VacationApplication;
import human.resource.mgmt.domain.VacationRegistered;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Vacation_table")
@Data
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Date startDate;

    private Date endDate;

    private String reason;

    private String userId;

    private Integer days;

    private String status;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        human.resource.mgmt.external.AddCalendarCommand addCalendarCommand = new human.resource.mgmt.external.AddCalendarCommand();
        // mappings goes here
        VacationApplication.applicationContext
            .getBean(human.resource.mgmt.external.CalendarService.class)
            .addCalendar(/* get???(), */addCalendarCommand);

        VacationRegistered vacationRegistered = new VacationRegistered(this);
        vacationRegistered.publishAfterCommit();
        // Get request from Vacation
        //human.resource.mgmt.external.Vacation vacation =
        //    Application.applicationContext.getBean(human.resource.mgmt.external.VacationService.class)
        //    .getVacation(/** mapping value needed */);

    }

    public static VacationRepository repository() {
        VacationRepository vacationRepository = VacationApplication.applicationContext.getBean(
            VacationRepository.class
        );
        return vacationRepository;
    }

    public void cancel() {
        VacationCancelled vacationCancelled = new VacationCancelled(this);
        vacationCancelled.publishAfterCommit();
    }

    public void approve(ApproveCommand approveCommand) {
        VacationApproved vacationApproved = new VacationApproved(this);
        vacationApproved.publishAfterCommit();
    }

    public void confirmUsed() {
        VacationUsed vacationUsed = new VacationUsed(this);
        vacationUsed.publishAfterCommit();
    }

    public void update() {
        VacationRejected vacationRejected = new VacationRejected(this);
        vacationRejected.publishAfterCommit();
    }
}
