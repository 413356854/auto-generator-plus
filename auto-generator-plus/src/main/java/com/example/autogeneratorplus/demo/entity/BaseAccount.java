package com.example.autogeneratorplus.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 基础账户
 * </p>
 *
 * @author luolita
 * @since 2021-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_base_account")
public class BaseAccount extends Model<BaseAccount> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 货币ID
     */
    private Integer currencyId;

    /**
     * 可用金额
     */
    private BigDecimal availableAmount;

    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount;

    private Date createTime;

    private Date updateTime;


    public static final String USER_ID = "user_id";

    public static final String CURRENCY_ID = "currency_id";

    public static final String AVAILABLE_AMOUNT = "available_amount";

    public static final String FROZEN_AMOUNT = "frozen_amount";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
