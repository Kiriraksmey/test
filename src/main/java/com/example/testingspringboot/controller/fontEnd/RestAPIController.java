package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.entities.CourseSearch;
import com.example.testingspringboot.response.AjaxCourseResponseBody;
import com.example.testingspringboot.service.CourseDetailService;
import com.example.testingspringboot.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class RestAPIController {

    private final CourseService courseService;
    private final CourseDetailService courseDetailService;
    public RestAPIController(CourseService courseService, CourseDetailService courseDetailService) {
        this.courseService = courseService;
        this.courseDetailService = courseDetailService;
    }

    @RequestMapping("hi")
    public String hi(){
        return "hi";
    }


    @RequestMapping("/getCourseTotalPrice")
    public ResponseEntity<?> getSearchResultViaAjax(@Validated @RequestBody CourseSearch courseSearch, Errors errors) {
        Double amount = 0D;
        List arrCourseId = courseSearch.getCourseId();
        List<Long> cID = new ArrayList<>();
        AjaxCourseResponseBody result = new AjaxCourseResponseBody();

        if(arrCourseId == null){
            result.setMessage("No course to select ");
            result.setAmount(0D);
            return ResponseEntity.ok(result);
        }
        if (arrCourseId.size() > 0) {
            for (int i = 0; i < arrCourseId.size(); i++) {
                cID.add(Long.parseLong((String) arrCourseId.get(i)));
            }
            amount = courseDetailService.getTotalPriceCourse(cID);
        }
        if (errors.hasErrors()) {
            result.setMessage("Not found 404 ");
            return ResponseEntity.badRequest().body(result);
        }

        result.setAmount(amount);
        //If error, just return a 400 bad request, along with the error message
        result.setMessage("success");
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/getCourseTotalPrices")
    public  ResponseEntity<?> getSearchResultViaAjax(@Validated @RequestBody  CourseSearch courseSearch) {

        String co = courseSearch.getCourseIdStr();

        return ResponseEntity.ok("ok");
    }

}
