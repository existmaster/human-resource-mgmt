package human.resource.mgmt.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
    name = "schedule",
    url = "${api.url.schedule}",
    fallback = CalendarServiceImpl.class
)
public interface CalendarService {
    @RequestMapping(method = RequestMethod.GET, path = "/calendars/{userId}")
    public Calendar getCalendar(@PathVariable("userId") String userId);
}
