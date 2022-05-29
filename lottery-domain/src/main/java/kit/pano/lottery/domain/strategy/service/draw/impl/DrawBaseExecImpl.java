package kit.pano.lottery.domain.strategy.service.draw.impl;

import cn.hutool.json.JSONUtil;
import kit.pano.lottery.domain.strategy.repository.IStrategyRepository;
import kit.pano.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import kit.pano.lottery.domain.strategy.service.draw.AbstractDrawBase;
import kit.pano.lottery.domain.strategy.service.draw.IDrawExec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 具体抽奖执行实现类
 *
 * @author pano
 */
@Service("drawExec")
@Slf4j
public class DrawBaseExecImpl extends AbstractDrawBase implements IDrawExec {

    @Resource
    private IStrategyRepository strategyRepository;

    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等，这类数据是含有业务逻辑的，所以需要由具体的实现方决定
     *
     * @param strategyId 策略ID
     * @return 该策略下被排除的奖品IDs
     */
    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> list = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        log.info("执行抽奖策略 strategyId：{}，无库存排除奖品列表ID集合 awardList：{}", strategyId, JSONUtil.toJsonPrettyStr(list));
        return list;
    }

    /**
     * 执行抽奖算法
     *
     * @param strategyId      抽奖策略ID
     * @param drawAlgorithm   抽奖算法模型
     * @param excludeAwardIds 被排除的奖品IDs
     * @return 中奖奖品ID
     */
    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        //奖品ID
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);
        // 判断抽奖结果
        if (awardId == null) {
            return null;
        }
        // 通过锁表的形式扣减库存
        // 后面优化通过redis的分布式锁
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);
        // 返回结果，库存扣减成功返回奖品ID，否则返回NULL
        // 在实际的业务场景中，如果中奖奖品库存为空，则会发送兜底奖品，比如各类券」
        return isSuccess ? awardId : null;
    }
}