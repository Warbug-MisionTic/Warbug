package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Profile;
import com.misiontic.warbug.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private IProfileService service;

    @GetMapping
    public List<Profile> readAll() throws Exception {
        return service.readAll();
    }

    @PostMapping
    public Profile create(@RequestBody Profile profile) throws Exception {
        return service.create(profile);
    }

    @GetMapping("/{id}")
    public Profile readById(@PathVariable("id") Long id) throws Exception {
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public Profile update(@RequestBody Profile profile, @PathVariable("id") Long id) throws Exception {
        return service.update(profile, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
    }
}
