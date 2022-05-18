package kit.pano.lottery.interfaces;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import kit.pano.lottery.common.Constants;
import kit.pano.lottery.common.Result;
import kit.pano.lottery.infrastructure.domain.Activity;
import kit.pano.lottery.infrastructure.mapper.ActivityMapper;
import kit.pano.lottery.rpc.IActivityBooth;
import kit.pano.lottery.rpc.dto.ActivityDto;
import kit.pano.lottery.rpc.req.ActivityReq;
import kit.pano.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 * <p>
 * 活动展台
 */
@DubboService
public class ActivityBooth implements IActivityBooth {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityMapper.selectOne(
                new LambdaQueryWrapper<Activity>()
                        .eq(Activity::getActivityId, req.getActivityId())
        );

        ActivityDto activityDto = new ActivityDto();
        BeanUtil.copyProperties(activity, activityDto);

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }

}
