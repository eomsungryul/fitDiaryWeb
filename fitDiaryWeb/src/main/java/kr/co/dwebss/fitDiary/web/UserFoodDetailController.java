package kr.co.dwebss.fitDiary.web;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import kr.co.dwebss.fitDiary.core.Result;
import kr.co.dwebss.fitDiary.core.ResultGenerator;
import kr.co.dwebss.fitDiary.model.UserFoodDetail;
import kr.co.dwebss.fitDiary.service.UserFoodDetailService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by 엄성렬 on 2018/10/04.
*/
@RestController
@RequestMapping("/user/food/detail")
public class UserFoodDetailController {
    @Resource
    private UserFoodDetailService userFoodDetailService;

    @PostMapping("/add")
    public Result add(UserFoodDetail userFoodDetail) {
        userFoodDetailService.save(userFoodDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userFoodDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserFoodDetail userFoodDetail) {
        userFoodDetailService.update(userFoodDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserFoodDetail userFoodDetail = userFoodDetailService.findById(id);
        return ResultGenerator.genSuccessResult(userFoodDetail);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserFoodDetail> list = userFoodDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
