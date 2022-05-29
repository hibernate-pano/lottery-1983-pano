package kit.pano.lottery.domain.award.service.factory;

import kit.pano.lottery.common.Constants;
import kit.pano.lottery.domain.award.service.goods.IDistributionGoods;
import kit.pano.lottery.domain.award.service.goods.impl.CouponGoods;
import kit.pano.lottery.domain.award.service.goods.impl.DescGoods;
import kit.pano.lottery.domain.award.service.goods.impl.PhysicalGoods;
import kit.pano.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 初始化类
 * 在项目启动时，将奖品类保存入 ConcurrentHashMap
 *
 * @author pano
 * @date 2022/5/29
 **/
public class GoodsConfig {

    /**
     * 奖品发放策略组
     */
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    /**
     * 初始化操作，保存奖品信息到内存
     * 可拓展，增加新的奖品类型时可在此注入
     */
    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DescriptionGoods.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }
}
