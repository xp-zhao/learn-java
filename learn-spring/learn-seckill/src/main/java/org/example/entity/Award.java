package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ${END}
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
/**
    * 奖品表
    */
@TableName(value = "award")
public class Award {
    /**
     * 奖品id
     */
    @TableId(value = "award_id", type = IdType.INPUT)
    private Long awardId;

    /**
     * 商品名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 奖品数量
     */
    @TableField(value = "award_count")
    private Integer awardCount;

    /**
     * 秒杀开启时间
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 版本号
     */
    @Version
    @TableField(value = "version")
    private Integer version;

    /**
     * 获取奖品id
     *
     * @return award_id - 奖品id
     */
    public Long getAwardId() {
        return awardId;
    }

    /**
     * 设置奖品id
     *
     * @param awardId 奖品id
     */
    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取奖品数量
     *
     * @return award_count - 奖品数量
     */
    public Integer getAwardCount() {
        return awardCount;
    }

    /**
     * 设置奖品数量
     *
     * @param awardCount 奖品数量
     */
    public void setAwardCount(Integer awardCount) {
        this.awardCount = awardCount;
    }

    /**
     * 获取秒杀开启时间
     *
     * @return start_time - 秒杀开启时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置秒杀开启时间
     *
     * @param startTime 秒杀开启时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取秒杀结束时间
     *
     * @return end_time - 秒杀结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置秒杀结束时间
     *
     * @param endTime 秒杀结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}