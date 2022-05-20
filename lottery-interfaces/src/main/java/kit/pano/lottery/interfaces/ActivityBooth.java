package kit.pano.lottery.interfaces;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import kit.pano.lottery.common.Constants;
import kit.pano.lottery.common.Result;
import kit.pano.lottery.infrastructure.mapper.ActivityMapper;
import kit.pano.lottery.infrastructure.po.Activity;
import kit.pano.lottery.rpc.IActivityBooth;
import kit.pano.lottery.rpc.dto.ActivityDto;
import kit.pano.lottery.rpc.req.ActivityReq;
import kit.pano.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 活动展台
 *
 * @author pano
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
