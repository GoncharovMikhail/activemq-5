package activemq5.rest;

import activemq5.messaging.dispatcher.DispatcherService;
import activemq5.messaging.dispatcher.DispatcherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging")
public class MessagingRestController {
    private final DispatcherService dispatcherServiceImpl;

    @Autowired
    public MessagingRestController(DispatcherServiceImpl dispatcherServiceImpl) {
        this.dispatcherServiceImpl = dispatcherServiceImpl;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMsg(@RequestParam String msg) {
        dispatcherServiceImpl.sendMsg(msg);
        return ResponseEntity.ok(msg);
    }
}
