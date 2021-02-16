package com.pluralsight.conferencedemo.Controllers;


import com.pluralsight.conferencedemo.Models.Speaker;
import com.pluralsight.conferencedemo.Repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;


    @GetMapping("/speakers")
    public List<Speaker> speakers(){
    return speakerRepository.findAll();

}
    @GetMapping("speaker/{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PostMapping("/speaker")
    public Speaker create(@RequestBody Speaker speaker){
        return speakerRepository.save(speaker);
    }

    @DeleteMapping("speaker/{id}")
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

        @PutMapping("/speaker/{id}")
        public Speaker update( @RequestBody Speaker speaker, @PathVariable Long id){

        Speaker existingSpeaker = speakerRepository.getOne(id);
        existingSpeaker.setFirst_name(speaker.getFirst_name());
        existingSpeaker.setLast_name(speaker.getLast_name());
        existingSpeaker.setCompany(speaker.getCompany());
       // BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.save(speaker);
    }

}
