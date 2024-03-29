package co.za.Controller;

import co.za.dto.ModuleDto;
import co.za.service.adminMOdule.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/module")
@AllArgsConstructor
public class ModulesController {

    AdminService adminService;

    @PostMapping
    public ResponseEntity<?> updateModule(ModuleDto moduleDto){
        adminService.updateModule(moduleDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> addModules(List<ModuleDto> moduleDtoList){
        adminService.addModules(moduleDtoList);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteModules(ModuleDto moduleDto){
        adminService.deleteModules(moduleDto);
        return ResponseEntity.ok().build();
    }


}
