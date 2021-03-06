package kit.pano.lottery.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import kit.pano.lottery.domain.strategy.model.aggregates.StrategyRich;
import kit.pano.lottery.domain.strategy.model.vo.AwardBriefVO;
import kit.pano.lottery.domain.strategy.model.vo.StrategyBriefVO;
import kit.pano.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import kit.pano.lottery.domain.strategy.repository.IStrategyRepository;
import kit.pano.lottery.infrastructure.mapper.AwardMapper;
import kit.pano.lottery.infrastructure.mapper.StrategyDetailMapper;
import kit.pano.lottery.infrastructure.mapper.StrategyMapper;
import kit.pano.lottery.infrastructure.po.Award;
import kit.pano.lottery.infrastructure.po.Strategy;
import kit.pano.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pano
 * @date 2022/5/19
 **/
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private StrategyMapper strategyMapper;

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Resource
    private AwardMapper awardMapper;

    /**
     * 查询策略信息
     *
     * @param strategyId 策略ID
     * @return 策略信息 StrategyRich 对象
     */
    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        // 获取策略
        Strategy strategy = strategyMapper.selectOne(
                new LambdaQueryWrapper<Strategy>()
                        .eq(Strategy::getStrategyId, strategyId)
        );
        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtil.copyProperties(strategy, strategyBriefVO);
        // 获取策略详情
        List<StrategyDetail> strategyDetailList = strategyDetailMapper.selectList(
                new LambdaQueryWrapper<StrategyDetail>()
                        .eq(StrategyDetail::getStrategyId, strategyId)
        );
        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();
        BeanUtil.copyProperties(strategyDetailList, strategyDetailBriefVOList);
        // 返回结果
        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOList);
    }

    /**
     * 获取奖品信息
     *
     * @param awardId 奖品ID
     * @return 奖品 Award 对象
     */
    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {
        Award award = awardMapper.selectOne(
                new LambdaQueryWrapper<Award>()
                        .eq(Award::getAwardId, awardId)
        );
        AwardBriefVO vo = new AwardBriefVO();
        BeanUtil.copyProperties(award, vo);
        return vo;
    }

    /**
     * 查询没有库存的奖品信息IDs
     *
     * @param strategyId 抽奖策略ID
     * @return 奖品IDs
     */
    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        // 查询指定策略中，无库存的奖品ID集合
        List<StrategyDetail> detailList = strategyDetailMapper.selectList(
                new LambdaQueryWrapper<StrategyDetail>()
                        .eq(StrategyDetail::getStrategyId, strategyId)
                        .eq(StrategyDetail::getAwardSurplusCount, 0)
        );
        return detailList.stream().map(StrategyDetail::getAwardId).distinct().collect(Collectors.toList());
    }

    /**
     * 扣减库存
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 扣减结果
     */
    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        int count = strategyDetailMapper.deductStock(strategyId, awardId);
        return 1 == count;
    }
}
