package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    public SpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl - No args constructor invoked");
    }

    public SpeakerServiceImpl(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl - repository constructor invoked");
        this.repository = repository;
    }

    /**
     * <p>
     *     Renamed the method to <tt>setSpeakerRepository</tt> to match with the
     *     <tt>property</tt> name configured in the <tt>applicationContext.xml</tt>
     *     file. It is defined as 'speakerRepository and <b>NOT</b> 'repository'.
     * </p>
     * <p>
     *     The differences if any on the method name for the Setter, can be ignored
     *     and still executed if we set the 'autowire' <tt>byType</tt> as the argument
     *     to the setter method is looked for the type of the object. In case, we set
     *     the 'autowire' <tt>byName</tt>, the exact name is being looked for a match,
     *     else it throws an exception further.
     * </p>
     * @param repository
     */
    public void setSpeakerRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl - setSpeakerRepository() invoked");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
