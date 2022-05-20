package kit.pano.lottery.domain.strategy.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import kit.pano.lottery.domain.strategy.model.aggregates.StrategyRich;
import kit.pano.lottery.domain.strategy.repository.IStrategyRepository;
import kit.pano.lottery.infrastructure.mapper.AwardMapper;
import kit.pano.lottery.infrastructure.mapper.StrategyDetailMapper;
import kit.pano.lottery.infrastructure.mapper.StrategyMapper;
import kit.pano.lottery.infrastructure.po.Award;
import kit.pano.lottery.infrastructure.po.Strategy;
import kit.pano.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pano
 * @date 2022/5/19
 **/
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private StrategyMapper strategyMapper;

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Resource
    private AwardMapper awardMapper;

    /**
     * 查询策略信息
     *
     * @param strategyId 策略ID
     * @return 策略信息 StrategyRich 对象
     */
    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        // 获取策略
        Strategy strategy = strategyMapper.selectOne(
                new LambdaQueryWrapper<Strategy>()
                        .eq(Strategy::getStrategyId, strategyId)
        );
        // 获取策略详情
        List<StrategyDetail> strategyDetailList = strategyDetailMapper.selectList(
                new LambdaQueryWrapper<StrategyDetail>()
                        .eq(StrategyDetail::getStrategyId, strategyId)
        );
        // 返回结果
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    /**
     * 获取奖品信息
     *
     * @param awardId 奖品ID
     * @return 奖品 Award 对象
     */
    @Override
    public Award queryAwardInfo(String awardId) {
        return awardMapper.selectOne(
                new LambdaQueryWrapper<Award>()
                        .eq(Award::getAwardId, awardId)
        );
    }
}
