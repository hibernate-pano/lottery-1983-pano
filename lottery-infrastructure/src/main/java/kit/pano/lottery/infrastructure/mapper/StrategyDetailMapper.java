package kit.pano.lottery.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import kit.pano.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Param;

/**
 * @author pano
 * @description 针对表【strategy_detail(策略明细)】的数据库操作Mapper
 * @createDate 2022-05-19 23:08:54
 * @Entity kit.pano.lottery.infrastructure.po.StrategyDetail
 */
public interface StrategyDetailMapper extends BaseMapper<StrategyDetail> {

    /**
     * 扣除库存
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 是否扣除成功
     */
    int deductStock(@Param("strategyId") Long strategyId, @Param("awardId") String awardId);
}




