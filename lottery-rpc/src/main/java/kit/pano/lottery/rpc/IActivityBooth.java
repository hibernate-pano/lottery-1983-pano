package kit.pano.lottery.rpc;


import kit.pano.lottery.rpc.req.ActivityReq;
import kit.pano.lottery.rpc.res.ActivityRes;

/**
 * 活动展台
 * 1. 创建活动
 * 2. 更新活动
 * 3. 查询活动
 *
 * @author pano
 */
public interface IActivityBooth {

    /**
     * 通过活动ID查询活动信息
     *
     * @param req 活动请求类
     * @return 活动信息详情
     */
    ActivityRes queryActivityById(ActivityReq req);

}
