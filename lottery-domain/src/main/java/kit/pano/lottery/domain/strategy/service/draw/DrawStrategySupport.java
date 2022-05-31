package kit.pano.lottery.domain.strategy.service.draw;

import kit.pano.lottery.domain.strategy.model.aggregates.StrategyRich;
import kit.pano.lottery.domain.strategy.model.vo.AwardBriefVO;
import kit.pano.lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

/**
 * 抽奖算法支撑类，保存一些通用的数据服务
 *
 * @author pano
 */
public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品ID
     * @return 中奖详情
     */
    protected AwardBriefVO queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }

}
