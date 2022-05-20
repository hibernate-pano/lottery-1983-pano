package kit.pano.lottery.domain.strategy.service.draw;


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
public class DrawInitializer {

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();
    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;
    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    /**
     * 初始化，将当前两种抽奖算法放入静态算法map，方便子类调用
     * 如果后期有拓展，可以再此处新增
     */
    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }

}
