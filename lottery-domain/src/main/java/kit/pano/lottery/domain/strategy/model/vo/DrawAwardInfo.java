package kit.pano.lottery.domain.strategy.model.vo;

import lombok.Data;

/**
 * 中奖奖品信息
 *
 * @author pano
 */
@Data
public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;

    public DrawAwardInfo(String rewardId, String awardName) {
        this.rewardId = rewardId;
        this.awardName = awardName;
    }

    public DrawAwardInfo() {
    }
}
