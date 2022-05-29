package kit.pano.lottery.domain.strategy.service.draw;


import kit.pano.lottery.common.Constants;
import kit.pano.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽奖初始化类
 *
 * @author pano
 */
public class DrawInitConfig {

    /**
     * 抽奖策略组
     */
    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmGroup = new ConcurrentHashMap<>();
    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;
    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    /**
     * 初始化，将当前两种抽奖算法放入静态算法 ConcurrentHashMap，方便子类调用
     * 如果后期有拓展，可以再此处新增
     */
    @PostConstruct
    public void init() {
        drawAlgorithmGroup.put(Constants.StrategyMode.SINGLE.getCode(), defaultRateRandomDrawAlgorithm);
        drawAlgorithmGroup.put(Constants.StrategyMode.ENTIRETY.getCode(), singleRateRandomDrawAlgorithm);
    }

}
