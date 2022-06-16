package com.example.demo.api;

import com.example.demo.api.output.NewOutput;
import com.example.demo.dto.NewDTO;
import com.example.demo.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
public class NewAPI {
    @Autowired
    private INewService newService;
    @GetMapping(value = "/new")
    public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page,
                             @RequestParam(value = "limit",required = false) Integer limit) {
        NewOutput result = new NewOutput();
        if (page != null&&limit!=null){
            result.setPage(page);
            Pageable pageable = PageRequest.of(page - 1, limit);
            result.setListResult(newService.findAll(pageable));
            result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
        }else {
            result.setListResult(newService.findAll());
        }
        return result;
    }

    @PostMapping("/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return newService.save(model);
    }

    @PutMapping("/new")
    public NewDTO updateNew(@RequestBody NewDTO model){
        return newService.update(model);
    }

    @DeleteMapping("/new")
    public void deleteNew(@RequestBody long[]ids){
        newService.delete(ids);
    }
}
