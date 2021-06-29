package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "transactionAPIOfAdmin")
@RequestMapping("/api/transaction")
public class TransactionAPI {
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    private ResponseDTO save(@RequestBody TransactionDTO transactionDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(transactionService.save(transactionDTO));
        responseDTO.setMesager("success");
        return responseDTO;
    }

    @GetMapping("/{id}")
    private ResponseDTO findAllByCustomerId(@PathVariable("id") Long id){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(transactionService.findAllByCustomerId(id));
        responseDTO.setMesager("success");
        return responseDTO;
    }
}
