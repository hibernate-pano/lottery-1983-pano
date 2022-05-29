package kit.pano.lottery.domain.strategy.model.req;

import lombok.Data;

/**
 * 抽奖request对象
 *
 * @author pano
 */
@Data
public class DrawReq {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 策略ID
     */
    private Long strategyId;

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }
}
