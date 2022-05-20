package kit.pano.lottery.domain.strategy.service.draw;

import kit.pano.lottery.domain.strategy.model.req.DrawReq;
import kit.pano.lottery.domain.strategy.model.res.DrawResult;

/**
 * 抽奖执行接口
 *
 * @author pano
 */
public interface IDrawExec {

    /**
     * 执行抽奖
     *
     * @param req 抽奖req
     * @return 抽奖结果
     */
    DrawResult doDrawExec(DrawReq req);

}