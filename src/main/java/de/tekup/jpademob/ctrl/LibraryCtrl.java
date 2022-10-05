package de.tekup.jpademob.ctrl;

import de.tekup.jpademob.entities.LibraryEntity;
import de.tekup.jpademob.services.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LibraryCtrl {

    private LibraryService libraryService;

    public LibraryCtrl(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    @RequestMapping("/libraries/all")
    @ResponseBody
    public List<LibraryEntity> getAll(){
        return libraryService.selectAll();
    }
}
