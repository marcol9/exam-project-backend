package examproject.services;

import examproject.entities.Party;
import examproject.repositories.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService implements IPartyService{
    @Autowired
    PartyRepo partyRepo;
    @Override
    public List<Party> getAllParties() {
        return partyRepo.findAll();
    }
}
