package kit.pano.lottery.domain.award.service.goods.impl;

import kit.pano.lottery.domain.award.model.req.GoodsReq;
import kit.pano.lottery.domain.award.model.res.DistributionRes;
import kit.pano.lottery.domain.award.service.goods.DistributionBase;
import kit.pano.lottery.domain.award.service.goods.IDistributionGoods;

/**
 * @author pano
 * @date 2022/5/29
 **/
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {
    /**
     * 奖品配送接口，奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     *
     * @param req 物品信息
     * @return 配送结果
     */
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        return null;
    }
}
