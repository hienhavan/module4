package org.example.springmvc.services.minitest2;

import org.example.springmvc.model.minitest2.Province;
import org.example.springmvc.repository.Minitest2ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniTest2ProvinceService {
    @Autowired
    private Minitest2ProvinceRepository provinceRepository;
    public List<Province> provinceDTOs(){
        return provinceRepository.findAll();
    }
    public Province findById(int id){
        return provinceRepository.findById(id).orElse(null);
    }
}
