package kit.pano.lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 抽奖response对象
 *
 * @author pano
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawResult {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 奖品ID
     */
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;
}
