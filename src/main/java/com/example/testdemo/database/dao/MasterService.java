package com.example.testdemo.database.dao;

import com.example.testdemo.database.entities.Master;
import com.example.testdemo.database.perository.MasterRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MasterService extends AbstractService<Master, MasterRepository> {

    public MasterService(MasterRepository repository) {
        super(repository);
    }

    @Transactional
    public void deleteByFirsNameAndLastName(Master master){
        repository.deleteByFirstNameAndAndLastName(master.getFirstName(), master.getLastName());
    }

    @Transactional
    public Master getByFirstNameLastNamePhoneNumber(String firstName, String lastName, String phoneNumber){
        return repository.findMasterByFirstNameAndAndLastNameAndAndPhoneNumber(firstName, lastName, phoneNumber)
                .orElseThrow(() -> new RuntimeException("Can't find Master with following parameters: "+
                        firstName+" "+lastName+" "+phoneNumber));
    }
}
