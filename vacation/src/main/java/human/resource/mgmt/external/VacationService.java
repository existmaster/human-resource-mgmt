package human.resource.mgmt.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
    name = "vacation",
    url = "${api.url.vacation}",
    fallback = VacationServiceImpl.class
)
public interface VacationService {
    @RequestMapping(method = RequestMethod.POST, path = "/vacations")
    public void registerVacation(@RequestBody Vacation vacation);
}
