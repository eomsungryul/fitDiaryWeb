package kr.co.dwebss.fitDiary.web;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import kr.co.dwebss.fitDiary.core.Result;
import kr.co.dwebss.fitDiary.core.ResultGenerator;
import kr.co.dwebss.fitDiary.model.UserHealth;
import kr.co.dwebss.fitDiary.service.UserHealthService;

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
@RequestMapping("/user/health")
public class UserHealthController {
    @Resource
    private UserHealthService userHealthService;

    @PostMapping("/add")
    public Result add(UserHealth userHealth) {
        userHealthService.save(userHealth);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userHealthService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserHealth userHealth) {
        userHealthService.update(userHealth);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserHealth userHealth = userHealthService.findById(id);
        return ResultGenerator.genSuccessResult(userHealth);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserHealth> list = userHealthService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
