package org.example.springmvc.homecontroller.minitest2;

import org.example.springmvc.model.bai6_7.Blog;
import org.example.springmvc.model.dto.ProvinceDTO;
import org.example.springmvc.model.minitest2.Province;
import org.example.springmvc.model.minitest2.ResponseObject;
import org.example.springmvc.model.minitest2.Tour2;
import org.example.springmvc.model.minitest2.TourForm2;
import org.example.springmvc.services.minitest2.MiniTest2ProvinceService;
import org.example.springmvc.services.minitest2.Minitest2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.SystemException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/minitest2")
public class ControllerMinitest2 {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private Minitest2Service minitest2Service;
    @Autowired
    MiniTest2ProvinceService minitest2ProvinceService;

    //    @GetMapping("/showTour")
//    public ModelAndView showTour(@RequestParam(defaultValue = "10") int page,
//                                 @RequestParam(defaultValue = "3") int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "code"));
//        Page<Tour2> tour2Page = minitest2Service.tour2Page(pageable);
//        ModelAndView modelAndView = new ModelAndView("listMinitest2");
//        modelAndView.addObject("tour2", tour2Page.getContent());
//        modelAndView.addObject("currentPage", tour2Page.getNumber());
//        modelAndView.addObject("totalPages", tour2Page.getTotalPages());
//        modelAndView.addObject("size", size);
//        return modelAndView;
//    }
    @GetMapping("/List")
    List<Tour2> getAllProducts() {
        return minitest2Service.listTour();
    }

    @GetMapping("findById/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id) {
        Optional<Tour2> tour2 = Optional.ofNullable(minitest2Service.findById(id));
        return tour2.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("success",tour2,"ok"))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
    }

    @PostMapping("/addTour/{tour}")
    public ResponseEntity<ResponseObject> addTour(@RequestBody Tour2 tour2) {
        if (tour2.getProvince() != null) {
            Province province = minitest2ProvinceService.findById(tour2.getProvince().getId());
            if (province != null) {
                tour2.setProvince(province);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("error", "Province not found", "not found"));
            }
        }

        minitest2Service.saveTour(tour2);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Successfully added", tour2, "ok"));
    }

    // Xóa tour theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteTour(@PathVariable int id) {
        minitest2Service.deleteTour(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Successfully deleted", null, "ok"));
    }

    // Cập nhật tour theo ID
    @PutMapping("/updateTour/{id}")
    public ResponseEntity<ResponseObject> updateTour(@PathVariable int id, @RequestBody Tour2 tour2) {
        Optional<Tour2> tour2Optional = Optional.ofNullable(minitest2Service.findById(id));
        if (tour2Optional.isPresent()) {
            Tour2 tour2Exist = tour2Optional.get();
            tour2Exist.setCode(tour2.getCode());
            tour2Exist.setDestination(tour2.getDestination());
            tour2Exist.setStart(tour2.getStart());

            if (tour2.getProvince() != null) {
                Province province = minitest2ProvinceService.findById(tour2.getProvince().getId());
                if (province != null) {
                    tour2Exist.setProvince(province);
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("error", "Province not found", "not found"));
                }
            }

            minitest2Service.saveTour(tour2Exist);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Successfully updated", tour2Exist, "ok"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteProvince(@PathVariable int id) {
        Province province = minitest2ProvinceService.findById(id);
        if (province != null) {
            minitest2ProvinceService.removeById(id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Successfully deleted", province, "ok"));
    }

    @GetMapping("/province")
    List<ProvinceDTO> getAllProvince() {
        return minitest2ProvinceService.listProvinceDTOs();
    }


//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("addTour2");
//        modelAndView.addObject("tourForm2", new TourForm2());
//        modelAndView.addObject("provinces", minitest2ProvinceService.provinceDTOs());
//        return modelAndView;
//    }
//
//    @PostMapping("/save")
//    public String saveProduct(@ModelAttribute TourForm2 tourForm2) {
//        MultipartFile multipartFile = tourForm2.getImg();
//        String fileName = multipartFile != null ? multipartFile.getOriginalFilename() : "";
//        try {
//            if (multipartFile != null) {
//                assert fileName != null;
//                if (!fileName.isEmpty()) {
//                    FileCopyUtils.copy(tourForm2.getImg().getBytes(), new File(fileUpload + fileName));
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        Tour2 tour2 = new Tour2(tourForm2.getId(), tourForm2.getCode(),
//                tourForm2.getDestination(), tourForm2.getStart(), fileName);
//        minitest2Service.saveTour(tour2);
//
//        return "redirect:/minitest2/showTour";
//    }

//    @GetMapping("/delete/{id}")
//    public String deleteTour(@PathVariable("id") int id) {
//        minitest2Service.deleteTour(id);
//        return "redirect:/minitest2/showTour";
//    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showUpdateForm(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("editTour2");
//        Tour2 tour2 = minitest2Service.getTourById(id);
//        TourForm2 tourForm2 = new TourForm2(tour2.getId(), tour2.getCode(), tour2.getDestination(), tour2.getStart(), null);
//        modelAndView.addObject("tour2", tourForm2);
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/update/{id}")
//    public String editTour(@ModelAttribute TourForm2 tourForm2, @PathVariable("id") int id) {
//        MultipartFile file = tourForm2.getImg();
//        String fileName = file != null ? file.getOriginalFilename() : "";
//        try {
//            if (file != null) {
//                assert fileName != null;
//                if (!fileName.isEmpty()) {
//                    FileCopyUtils.copy(tourForm2.getImg().getBytes(), new File(fileUpload + fileName));
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        Tour2 tour2 = new Tour2(tourForm2.getId(), tourForm2.getCode(),
//                tourForm2.getDestination(), tourForm2.getStart(), fileName);
//        minitest2Service.updateTour(tour2);
//
//        return "redirect:/minitest2/showTour";
//    }


}


//    @GetMapping("/search")
//    public ModelAndView searchBlogs(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
//        Page<Tour2> tour2Page = minitest2Service.searchTour(query, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "code")));
//        ModelAndView modelAndView = new ModelAndView("listMinitest2");
//        modelAndView.addObject("tour2", tour2Page.getContent());
//        modelAndView.addObject("currentPage", tour2Page.getNumber());
//        modelAndView.addObject("totalPages", tour2Page.getTotalPages());
//        modelAndView.addObject("size", size);
//        modelAndView.addObject("query", query);
//        return modelAndView;
//    }
//}
