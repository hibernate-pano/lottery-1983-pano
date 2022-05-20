package kit.pano.lottery.domain.strategy.repository;

import kit.pano.lottery.domain.strategy.model.aggregates.StrategyRich;
import kit.pano.lottery.infrastructure.po.Award;

/**
 * @author pano
 * @date 2022/5/19
 **/
public interface IStrategyRepository {

    /**
     * 查询策略信息
     *
     * @param strategyId 策略ID
     * @return 策略信息 StrategyRich 对象
     */
    StrategyRich queryStrategyRich(Long strategyId);

    /**
     * 获取奖品信息
     *
     * @param awardId 奖品ID
     * @return 奖品 Award 对象
     */
    Award queryAwardInfo(String awardId);
}
