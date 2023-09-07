package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ${END}
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
/**
    * 支付信息表
    */
@TableName(value = "payment")
public class Payment {
    /**
     * 用户Id
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    private Long userId;

    /**
     * 秒杀奖品id
     */
    @TableField(value = "award_id")
    private Long awardId;

    /**
     * 状态标示：-1指无效，0指成功，1指已付款
     */
    @TableField(value = "`state`")
    private Integer state;

    /**
     * 金额
     */
    @TableField(value = "money")
    private Long money;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取秒杀奖品id
     *
     * @return award_id - 秒杀奖品id
     */
    public Long getAwardId() {
        return awardId;
    }

    /**
     * 设置秒杀奖品id
     *
     * @param awardId 秒杀奖品id
     */
    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    /**
     * 获取状态标示：-1指无效，0指成功，1指已付款
     *
     * @return state - 状态标示：-1指无效，0指成功，1指已付款
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态标示：-1指无效，0指成功，1指已付款
     *
     * @param state 状态标示：-1指无效，0指成功，1指已付款
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取金额
     *
     * @return money - 金额
     */
    public Long getMoney() {
        return money;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(Long money) {
        this.money = money;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}