package de.tekup.jpademob.services;

import de.tekup.jpademob.entities.LibraryEntity;
import de.tekup.jpademob.repos.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryEntity insertIntoDB(LibraryEntity libraryEntity){
        return libraryRepository.save(libraryEntity);
    }

    public List<LibraryEntity> selectAll(){
        return (List<LibraryEntity>) libraryRepository.findAll();
    }

    //TODO add a method to retrieve library by ID

}
