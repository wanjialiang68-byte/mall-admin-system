package com.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单实体类\n *\n * 表示电商系统中的订单信息，包括订单状态、支付状态、用户信息等\n * 支持JPA和MyBatis Plus双重ORM框架\n * \n * @author wanjialiang68-byte\n * @version 1.0.0\n * @since 2024-05-25\n */\n@Data\n@Entity\n@Table(name = \"orders\", indexes = {\n    @Index(name = \"idx_order_number\", columnList = \"order_number\", unique = true),\n    @Index(name = \"idx_user_id\", columnList = \"user_id\"),\n    @Index(name = \"idx_status\", columnList = \"status\")\n})\n@TableName(\"orders\")\n@Builder\n@NoArgsConstructor\n@AllArgsConstructor\npublic class Order implements Serializable {\n\n    private static final long serialVersionUID = 1L;\n\n    /**\n     * 订单ID\n     * 自增主键\n     */\n    @Id\n    @GeneratedValue(strategy = GenerationType.IDENTITY)\n    @TableId(type = IdType.AUTO)\n    private Long id;\n\n    /**\n     * 订单号\n     * 唯一，用于订单追踪\n     * 格式: yyyyMMddHHmmssXXXX (时间戳+随机数)\n     */\n    @Column(nullable = false, length = 64, unique = true)\n    private String orderNumber;\n\n    /**\n     * 用户ID\n     * 外键关联sys_user表\n     */\n    @Column(nullable = false)\n    private Long userId;\n\n    /**\n     * 商品ID\n     * 外键关联product表\n     */\n    @Column(nullable = false)\n    private Long productId;\n\n    /**\n     * 购买数量\n     */\n    @Column(nullable = false, columnDefinition = \"INT DEFAULT 1\")\n    private Integer quantity;\n\n    /**\n     * 订单总金额\n     * 精度：两位小数\n     */\n    @Column(nullable = false, precision = 12, scale = 2)\n    private BigDecimal totalAmount;\n\n    /**\n     * 订单状态\n     * 0 - 待付款\n     * 1 - 待发货\n     * 2 - 已发货\n     * 3 - 已完成\n     * 4 - 已取消\n     */\n    @Column(nullable = false, columnDefinition = \"TINYINT(1) DEFAULT 0\")\n    private Integer status;\n\n    /**\n     * 支付状态\n     * 0 - 未支付\n     * 1 - 已支付\n     * 2 - 支付失败\n     */\n    @Column(columnDefinition = \"TINYINT(1) DEFAULT 0\")\n    private Integer paymentStatus;\n\n    /**\n     * 支付方式\n     * alipay - 支付宝\n     * wechat - 微信支付\n     * card - 银行卡\n     */\n    @Column(length = 32)\n    private String paymentMethod;\n\n    /**\n     * 收货地址\n     */\n    @Column(length = 500)\n    private String deliveryAddress;\n\n    /**\n     * 备注\n     */\n    @Column(columnDefinition = \"TEXT\")\n    private String remarks;\n\n    /**\n     * 创建时间\n     * 自动生成\n     */\n    @CreationTimestamp\n    @Column(updatable = false)\n    private LocalDateTime createTime;\n\n    /**\n     * 更新时间\n     * 自动更新\n     */\n    @UpdateTimestamp\n    private LocalDateTime updateTime;\n\n    /**\n     * 支付时间\n     */\n    @Column\n    private LocalDateTime paymentTime;\n\n    /**\n     * 发货时间\n     */\n    @Column\n    private LocalDateTime deliveryTime;\n}\n