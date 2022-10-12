package de.tekup.jpademob.ctrl;

import de.tekup.jpademob.entities.LibraryEntity;
import de.tekup.jpademob.services.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibraryCtrl {

    private LibraryService libraryService;

    public LibraryCtrl(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    //@RequestMapping(value = "/libraries/all",method = RequestMethod.GET)
    @GetMapping("/libraries/all")
    @ResponseBody
    public List<LibraryEntity> getAll(){
        return libraryService.selectAll();
    }

    //@RequestMapping(path="/libraries/save",method = RequestMethod.POST)
    @PostMapping("/libraries/save")
    @ResponseBody
    public LibraryEntity addLibrary(@RequestBody LibraryEntity library){
        return libraryService.insertIntoDB(library);
    }
}
