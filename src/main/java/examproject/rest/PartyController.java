package examproject.rest;

import examproject.entities.Party;
import examproject.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PartyController {
    @Autowired
    PartyService partyService;

    @GetMapping("/parties")
    public List<Party> getAllParties(){
        return partyService.getAllParties();
    }
}
