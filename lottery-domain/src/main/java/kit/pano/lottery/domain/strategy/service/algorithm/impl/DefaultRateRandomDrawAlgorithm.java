package kit.pano.lottery.domain.strategy.service.algorithm.impl;

import kit.pano.lottery.domain.strategy.model.vo.AwardRateInfo;
import kit.pano.lottery.domain.strategy.service.algorithm.BaseDrawAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 必中奖策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 *
 * @author pano
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseDrawAlgorithm {

    /**
     * SecureRandom 生成随机数，索引到对应的奖品信息返回结果
     *
     * @param strategyId      策略ID
     * @param excludeAwardIds 排除掉已经不能作为抽奖的奖品ID，留给风控和空库存使用
     * @return 中奖结果
     */
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal differenceDenominator = BigDecimal.ZERO;
        // 排除掉不在抽奖范围的奖品ID集合
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardRateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            // 剩余奖品信息集合
            differenceAwardRateList.add(awardRateInfo);
            // 剩余总的中奖概率
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }
        // 前置判断
        // 当所有奖品都被抽完后，返回 null
        if (differenceAwardRateList.size() == 0) {
            return null;
        }
        // 当只剩最后一个奖品时，直接返回该奖品ID
        if (differenceAwardRateList.size() == 1) {
            return differenceAwardRateList.get(0).getAwardId();
        }
        // 获取随机概率值
        int randomVal = super.generateSecureRandomIntCode(100);

        // 循环获取奖品
        String awardId = null;
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate()
                    .divide(differenceDenominator, 2, RoundingMode.UP)
                    .multiply(new BigDecimal(100))
                    .intValue();
            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }
        // 返回中奖结果
        return awardId;
    }
}