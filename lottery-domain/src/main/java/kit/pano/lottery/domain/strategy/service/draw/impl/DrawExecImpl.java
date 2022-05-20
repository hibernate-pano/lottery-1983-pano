package kit.pano.lottery.domain.strategy.service.draw.impl;

import kit.pano.lottery.domain.strategy.model.aggregates.StrategyRich;
import kit.pano.lottery.domain.strategy.model.req.DrawReq;
import kit.pano.lottery.domain.strategy.model.res.DrawResult;
import kit.pano.lottery.domain.strategy.repository.IStrategyRepository;
import kit.pano.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import kit.pano.lottery.domain.strategy.service.draw.DrawBase;
import kit.pano.lottery.domain.strategy.service.draw.IDrawExec;
import kit.pano.lottery.infrastructure.po.Award;
import kit.pano.lottery.infrastructure.po.Strategy;
import kit.pano.lottery.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 具体抽奖执行实现类
 *
 * @author pano
 */
@Service("drawExec")
@Slf4j
public class DrawExecImpl extends DrawBase implements IDrawExec {

    @Resource
    private IStrategyRepository strategyRepository;

    /**
     * 执行抽奖
     *
     * @param req 抽奖req
     * @return 抽奖结果
     */
    @Override
    public DrawResult doDrawExec(DrawReq req) {
        log.info("执行策略抽奖开始，strategyId：{}", req.getStrategyId());
        // 1.获取抽奖策略配置数据
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();
        // 2.检验和初始化数据
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);
        // 3.根据策略方式抽奖
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());
        // 4.获取奖品信息
        Award award = strategyRepository.queryAwardInfo(awardId);
        if (award != null) {
            log.info("执行策略抽奖完成，抽奖用户：{} 奖品ID：{} 奖品名称：{}", req.getUId(), awardId, award.getAwardName());
            // 5.返回结果
            return new DrawResult(req.getUId(), req.getStrategyId(), awardId, award.getAwardName());
        } else {
            log.info("执行策略抽奖完成，抽奖用户：{} 未中奖", req.getUId());
            return new DrawResult(req.getUId(), req.getStrategyId(), awardId, "很遗憾，未中奖");
        }
    }
}