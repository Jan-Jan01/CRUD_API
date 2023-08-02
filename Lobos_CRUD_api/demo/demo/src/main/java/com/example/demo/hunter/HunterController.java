package com.example.demo.hunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/hunter")
public class HunterController {

    private final HunterService hunterService;
    @Autowired
    public HunterController(HunterService hunterService){
        this.hunterService = hunterService;
    }
    @GetMapping
    public List<Hunter> getHunter(){
        return hunterService.getHunter();
    }
    @PostMapping
    public void registerNewHunter(@RequestBody Hunter hunter){
        hunterService.addNewHunter(hunter);
    }
    @DeleteMapping(path = "{hunterId}")
    public void deleteHunter(@PathVariable("hunterId")Long hunterId){
        hunterService.deleteHunter(hunterId);
    }
    @PutMapping(path = "{hunterId}")
    public void updateHunter(
            @PathVariable("hunterId") Long hunterId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String job,
            @RequestParam(required = false) String rank){
        hunterService.updateHunter(hunterId,name,email,job,rank);
    }
}
