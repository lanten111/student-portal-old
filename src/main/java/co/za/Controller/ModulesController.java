package co.za.Controller;

import co.za.dto.ModuleDto;
import co.za.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/modules")
public class ModulesController {

    private final Service<ModuleDto> service;

    public ModulesController(Service<ModuleDto> service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<ModuleDto>> getBooks(){
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDto> getModule(@PathVariable String id){
        return ResponseEntity.ok(service.get(Long.parseLong(id)));
    }

    @PutMapping("")
    public ResponseEntity<?> addNewCourse(@RequestBody ModuleDto moduleDto){
        service.add(moduleDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable String id){
        service.delete(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

}
