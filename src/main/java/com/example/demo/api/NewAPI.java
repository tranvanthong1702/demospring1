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
//    @GetMapping("/new")
//    public NewOutput showNew(@RequestParam("page")int page,
//                             @RequestParam("limit") int limit){
//        NewOutput results=new NewOutput();
//        results.setPage(page);
//        Pageable pageable = PageRequest.of(page, limit);
//        results.setListResult(newService.findAll(pageable));
//        results.setTotalPage((int) Math.ceil((double) (newService.totalItem()/limit)));
//        return results;
//    }
    @GetMapping // hiển thị danh mục sản phẩm Product
    
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
