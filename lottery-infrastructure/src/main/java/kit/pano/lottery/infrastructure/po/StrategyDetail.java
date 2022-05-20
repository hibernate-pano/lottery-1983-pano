package kit.pano.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 策略明细
 *
 * @author pano
 * @TableName strategy_detail
 */
@TableName(value = "strategy_detail")
@Data
public class StrategyDetail implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 奖品ID
     */
    private String awardId;
    /**
     * 奖品描述
     */
    private String awardName;
    /**
     * 奖品库存
     */
    private Integer awardCount;
    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;
    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}