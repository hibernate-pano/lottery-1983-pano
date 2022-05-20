package kit.pano.lottery.domain.strategy.service.draw;


import kit.pano.lottery.domain.strategy.model.vo.AwardRateInfo;
import kit.pano.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import kit.pano.lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽奖执行器抽象类
 *
 * @author pano
 */
public class DrawBase extends DrawInitializer {

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        // TODO 2022-05-20 15:46:43 为啥1不行。1是必中奖策略抽奖
        if (1 != strategyMode) {
            return;
        }
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);
        // 判断该抽奖策略已初始化
        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) {
            return;
        }
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

}
