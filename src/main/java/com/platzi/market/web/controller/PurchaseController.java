package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @ApiOperation("Get all purchases")
    @ApiResponse(code = 200,  message = "OK")
    public ResponseEntity<List<Purchase>> getAll(){
        return  new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    @ApiOperation("Get purchases by client")
    @ApiResponses({
            @ApiResponse(code=200,message = "OK"),
            @ApiResponse(code=404,message = "Doesn't exist purchases with this client")
    })
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId){
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases,HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save purchase")
    @ApiResponse(code = 201,message = "Purchase created")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }
}
