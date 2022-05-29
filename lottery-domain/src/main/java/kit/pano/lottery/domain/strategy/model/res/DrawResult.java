package kit.pano.lottery.domain.strategy.model.res;

import kit.pano.lottery.common.Constants;
import kit.pano.lottery.domain.strategy.model.vo.DrawAwardInfo;
import lombok.Data;

/**
 * 抽奖response对象
 *
 * @author pano
 */
@Data
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

    /**
     * 中奖奖品信息
     */
    private DrawAwardInfo drawAwardInfo;

    /**
     * 中奖状态：0未中奖、1已中奖、2兜底奖 Constants.DrawState
     */
    private Integer drawState = Constants.DrawState.FAIL.getCode();

    public DrawResult() {
    }

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawAwardInfo = drawAwardInfo;
        this.drawState = drawState;
    }
}
