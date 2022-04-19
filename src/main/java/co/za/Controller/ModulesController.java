package co.za.Controller;

import co.za.dto.ModuleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/modules")
public class ModulesController {

    private final CourseService<ModuleDto> courseService;

    public ModulesController(CourseService<ModuleDto> courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<List<ModuleDto>> getModules(){
        return ResponseEntity.ok(courseService.getList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDto> getModule(@PathVariable String id){
        return ResponseEntity.ok(courseService.get(Long.parseLong(id)));
    }

    @PutMapping("")
    public ResponseEntity<?> addModule(@RequestBody ModuleDto moduleDto){
        courseService.add(moduleDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable String id){
        courseService.delete(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

}
