package kr.co.dwebss.child.web;
import kr.co.dwebss.child.core.Result;
import kr.co.dwebss.child.core.ResultGenerator;
import kr.co.dwebss.child.model.UserGym;
import kr.co.dwebss.child.service.UserGymService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by 엄성렬 on 2018/10/02.
*/
@RestController
@RequestMapping("/user/gym")
public class UserGymController {
    @Resource
    private UserGymService userGymService;

    @RequestMapping("/add")
    public Result add(UserGym userGym) {
        userGymService.save(userGym);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userGymService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(UserGym userGym) {
        userGymService.update(userGym);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserGym userGym = userGymService.findById(id);
        return ResultGenerator.genSuccessResult(userGym);
    }

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserGym> list = userGymService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
