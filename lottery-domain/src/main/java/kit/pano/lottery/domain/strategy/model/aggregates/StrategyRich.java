package kit.pano.lottery.domain.strategy.model.aggregates;


import kit.pano.lottery.domain.strategy.model.vo.StrategyBriefVO;
import kit.pano.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
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
    private StrategyBriefVO strategy;
    /**
     * 策略明细
     */
    private List<StrategyDetailBriefVO> strategyDetailList;
}
