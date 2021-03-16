package controller;

import model.Rest;
import model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.RestService;

import java.util.List;


@Controller
@RequestMapping("rest")
public class RestController {
    @Autowired
    RestService restService;

    @GetMapping("id/{id}")
    public ResponseEntity<RestResult> getById(@PathVariable("id") int id){
        RestResult rest = restService.getRestById(id);
        return new ResponseEntity<RestResult>(rest, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<RestResult>> getAll(){
        List<RestResult> listRest = restService.getAll();
        return new ResponseEntity<List<RestResult>>(listRest, HttpStatus.OK);
    }

    @PostMapping("/rest/")
    public ResponseEntity<RestResult> addRest(@RequestBody Rest rest){
        restService.addRest(rest);
        RestResult rest2 = restService.getRestById(restService.lastestInput());
        return new ResponseEntity<RestResult>(rest2,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResult> updateRest(@PathVariable("id") int id, @RequestBody Rest rest){
        restService.updateRest(rest,id);
        RestResult rest2 = restService.getRestById(id);
        return new ResponseEntity<RestResult>(rest2, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResult> deleteRest(@PathVariable("id") int id){
        RestResult rest2 = restService.getRestById(id);
        restService.deleteRestById(id);
        return new ResponseEntity<RestResult>(rest2,HttpStatus.OK);
    }
}