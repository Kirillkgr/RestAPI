package com.kirillzhdanov.learningrestapi.controllers;


import com.kirillzhdanov.learningrestapi.models.Insait;
import com.kirillzhdanov.learningrestapi.models.InsaitRepository;
import com.kirillzhdanov.learningrestapi.models.OutSait;
import com.kirillzhdanov.learningrestapi.models.OutSaitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class resatableController {
    @Autowired
    InsaitRepository insaitRepository;
    @Autowired
    OutSaitRepository outSaitRepository;

//    @PostConstruct
//    public void StartTest(){
//        OutSait o = new OutSait();
//        Insait i = o.getInsait();
//        if(i==null)
//            i = new Insait();
//        i.setTestInDate("Date in saite");
//
//
//        o.setInsait(i);
//        o.setOutSatteDate("Date Out saite");
//    //    outSaitRepository.save(o);
//        List<OutSait> outSaitList = new ArrayList<>();
//        outSaitList.add(o);
//        i.setOutSaitList(outSaitList);
//     //   outSaitRepository.save(o);
//        insaitRepository.save(i);
//    }
}
