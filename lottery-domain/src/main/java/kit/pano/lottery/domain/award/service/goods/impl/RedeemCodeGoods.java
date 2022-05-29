package kit.pano.lottery.domain.award.service.goods.impl;

import kit.pano.lottery.domain.award.model.req.GoodsReq;
import kit.pano.lottery.domain.award.model.res.DistributionRes;
import kit.pano.lottery.domain.award.service.goods.DistributionBase;
import kit.pano.lottery.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 兑换码类商品
 *
 * @author pano
 */
@Component
@Slf4j
public class RedeemCodeGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        return null;
    }
}
