package kit.pano.lottery.domain.strategy.service.algorithm.impl;

import kit.pano.lottery.domain.strategy.service.algorithm.BaseDrawAlgorithm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 【推荐】单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 *
 * @author pano
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseDrawAlgorithm {

    /**
     * SecureRandom 生成随机数，索引到对应的奖品信息返回结果
     *
     * @param strategyId      策略ID
     * @param excludeAwardIds 排除掉已经不能作为抽奖的奖品ID，留给风控和空库存使用
     * @return 中奖结果
     */
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;
        // 随机索引
        int randomVal = super.generateSecureRandomIntCode(100);
        int idx = super.hashIdx(randomVal);
        // 返回结果
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) {
            return null;
        }
        return awardId;
    }
}