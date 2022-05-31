package kit.pano.lottery.domain.strategy.repository;

import kit.pano.lottery.domain.strategy.model.aggregates.StrategyRich;
import kit.pano.lottery.domain.strategy.model.vo.AwardBriefVO;

import java.util.List;

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
    AwardBriefVO queryAwardInfo(String awardId);

    /**
     * 查询没有库存的奖品信息IDs
     *
     * @param strategyId 抽奖策略ID
     * @return 奖品IDs
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
