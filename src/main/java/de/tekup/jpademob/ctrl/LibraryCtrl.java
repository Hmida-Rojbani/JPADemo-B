package de.tekup.jpademob.ctrl;

import de.tekup.jpademob.entities.LibraryEntity;
import de.tekup.jpademob.services.LibraryService;
import org.springframework.dao.DataIntegrityViolationException;
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


    //add a GET method to call the service of retrieve library by ID
    @GetMapping("/libraries/{id}")
    @ResponseBody
    public LibraryEntity getOneLibrary(@PathVariable("id") int libId){
            return libraryService.getLibraryById(libId);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException e){
        return e.getMessage();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public String handleDataIntegrityViolationException(DataIntegrityViolationException e){
        return "Error in saving in DB :"+e.getMessage();
    }

}
