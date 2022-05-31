package kit.pano.lottery.domain.award.service.goods.impl;

import kit.pano.lottery.common.Constants;
import kit.pano.lottery.domain.award.model.req.GoodsReq;
import kit.pano.lottery.domain.award.model.res.DistributionRes;
import kit.pano.lottery.domain.award.service.goods.DistributionBase;
import kit.pano.lottery.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 优惠券奖品
 *
 * @author pano
 * @date 2022/5/29
 **/
@Slf4j
@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {
    /**
     * 奖品配送接口，奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     *
     * @param req 物品信息
     * @return 配送结果
     */
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        // 更新用户领奖结果
        super.updateUserAwardState(req.getUId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
        // 返回结果
        return new DistributionRes(req.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    /**
     * 获取配送奖品名称
     *
     * @return 奖品名称
     */
    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.CouponGoods.getCode();
    }
}
