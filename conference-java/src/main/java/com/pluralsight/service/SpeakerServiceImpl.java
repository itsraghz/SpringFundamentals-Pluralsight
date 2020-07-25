package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@Service("speakerService")
@Profile("dev")
/**
 * <p>
 *     To use the active profiles, Spring added a way to specify the VM option.
 *     <tt>-Dspring.profiles.active=<dev/prod></tt>, to pick up the environment
 *     specific flavor.
 * </p>
 * @author Raghavan Muthu
 * @since 25 July 2020 Saturday
 */
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository ;

    public SpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl() - no args constructor invoked");
    }

    @Autowired
    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerServiceImpl repository constructor invoked " +
                "with Reference " + speakerRepository);
        this.repository = speakerRepository;
    }

    @PostConstruct
    private void initialize() {
        System.out.println("initialize() method called after the constructors");
    }

    @Autowired
    public void setRepository(SpeakerRepository repository) {
        Objects.requireNonNull(repository);
        System.out.println("Setter of SpeakerServiceImpl invoked " +
                "with repository reference " + repository);
        this.repository = repository;
    }

    @Override
    public String toString() {
        return "SpeakerServiceImpl{" +
                "hashCode [" + hashCode() +
                "], repository=" + repository +
                '}';
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
