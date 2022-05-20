package kit.pano.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 奖品概率信息，奖品编号、库存、概率
 *
 * @author pano
 */
@Data
@AllArgsConstructor
public class AwardRateInfo {

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
}
