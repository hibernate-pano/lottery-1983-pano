package kit.pano.lottery.domain.strategy.model.aggregates;


import kit.pano.lottery.infrastructure.po.Strategy;
import kit.pano.lottery.infrastructure.po.StrategyDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author pano
 */
@Data
@AllArgsConstructor
public class StrategyRich {

    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 策略配置
     */
    private Strategy strategy;
    /**
     * 策略明细
     */
    private List<StrategyDetail> strategyDetailList;
}
