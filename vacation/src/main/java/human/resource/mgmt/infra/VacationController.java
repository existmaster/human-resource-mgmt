package human.resource.mgmt.infra;

import human.resource.mgmt.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/vacations")
@Transactional
public class VacationController {

    @Autowired
    VacationRepository vacationRepository;

    @RequestMapping(
        value = "vacations/{id}/cancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Vacation cancel(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /vacation/cancel  called #####");
        Optional<Vacation> optionalVacation = vacationRepository.findById(id);

        optionalVacation.orElseThrow(() -> new Exception("No Entity Found"));
        Vacation vacation = optionalVacation.get();
        vacation.cancel();

        vacationRepository.save(vacation);
        return vacation;
    }

    @RequestMapping(
        value = "vacations/{id}/approve",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Vacation approve(
        @PathVariable(value = "id") String id,
        @RequestBody ApproveCommand approveCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /vacation/approve  called #####");
        Optional<Vacation> optionalVacation = vacationRepository.findById(id);

        optionalVacation.orElseThrow(() -> new Exception("No Entity Found"));
        Vacation vacation = optionalVacation.get();
        vacation.approve(approveCommand);

        vacationRepository.save(vacation);
        return vacation;
    }

    @RequestMapping(
        value = "vacations/{id}/confirmused",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Vacation confirmUsed(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /vacation/confirmUsed  called #####");
        Optional<Vacation> optionalVacation = vacationRepository.findById(id);

        optionalVacation.orElseThrow(() -> new Exception("No Entity Found"));
        Vacation vacation = optionalVacation.get();
        vacation.confirmUsed();

        vacationRepository.save(vacation);
        return vacation;
    }

    @RequestMapping(
        value = "vacations/{id}/update",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Vacation update(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /vacation/update  called #####");
        Optional<Vacation> optionalVacation = vacationRepository.findById(id);

        optionalVacation.orElseThrow(() -> new Exception("No Entity Found"));
        Vacation vacation = optionalVacation.get();
        vacation.update();

        vacationRepository.save(vacation);
        return vacation;
    }
}
