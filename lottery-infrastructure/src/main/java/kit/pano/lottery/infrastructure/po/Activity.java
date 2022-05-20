package kit.pano.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动配置
 *
 * @author pano
 * @TableName activity
 */
@TableName(value = "activity")
@Data
public class Activity implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动描述
     */
    private String activityDesc;
    /**
     * 开始时间
     */
    private Date beginDateTime;
    /**
     * 结束时间
     */
    private Date endDateTime;
    /**
     * 库存
     */
    private Integer stockCount;
    /**
     * 库存剩余
     */
    private Integer stockSurplusCount;
    /**
     * 每人可参与次数
     */
    private Integer takeCount;
    /**
     * 抽奖策略ID
     */
    private Long strategyId;
    /**
     * 活动状态：1编辑、2提审、3撤审、4通过、5运行(审核通过后worker扫描状态)、6拒绝、7关闭、8开启
     */
    private Integer state;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}