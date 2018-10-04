package kr.co.dwebss.fitDiary.web;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import kr.co.dwebss.fitDiary.core.Result;
import kr.co.dwebss.fitDiary.core.ResultGenerator;
import kr.co.dwebss.fitDiary.model.UserFood;
import kr.co.dwebss.fitDiary.service.UserFoodService;

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
@RequestMapping("/user/food")
public class UserFoodController {
    @Resource
    private UserFoodService userFoodService;

    @PostMapping("/add")
    public Result add(UserFood userFood) {
        userFoodService.save(userFood);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userFoodService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserFood userFood) {
        userFoodService.update(userFood);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserFood userFood = userFoodService.findById(id);
        return ResultGenerator.genSuccessResult(userFood);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserFood> list = userFoodService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
