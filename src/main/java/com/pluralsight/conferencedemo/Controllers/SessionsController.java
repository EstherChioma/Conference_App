package com.pluralsight.conferencedemo.Controllers;

import com.pluralsight.conferencedemo.Models.Session;
import com.pluralsight.conferencedemo.Repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this will respond as rest endpoints
@RestController
//tells the mapping what the url will look like
@RequestMapping("/api/v1/sessions")// all request will be centered to this controller
public class SessionsController {

    private SessionRepository sessionRepository;

    @GetMapping("/sessions")
    public List<Session> list(){
        return sessionRepository.findAll();
    }
    //ability to get a specific session by id

   // @RequestMapping("{id}")(
   @GetMapping("/session/{id]")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

   // @ResponseStatus(HttpStatus.CREATED)// with the http status, you can specify the exact reponse you want to occur method executing finishes

    @PostMapping("/create")
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    //@RequestMapping(value = "{id}", method = RequestMethod.DELETE )
    @DeleteMapping("/session/{id}")
    public void delete(@PathVariable Long id){
        //Also need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }

    //@RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @PutMapping("/update/{id}")
    public Session update (@PathVariable Long id, @RequestBody Session session){
        //because this is a PUT , we expect all attributes to be passsed in. A PATCH would only need what
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload

        //To update a record ,you have to first find the existing one, this line is use to find the existing record
        Session existingSession = sessionRepository.getOne(id);
        existingSession.setSession_name(session.getSession_name());
        existingSession.setSession_length(session.getSession_length());


        //The beanutils, copies the updated record into the existing records
        //copyproperties helps to ignore the properties you dont need, e.g primary key
       // BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);

    }





}
