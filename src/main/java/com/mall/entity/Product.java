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
 * 商品实体类
 * 
 * 表示电商系统中的商品信息，包括商品基本信息、库存、价格等
 * 支持JPA和MyBatis Plus双重ORM框架
 * 
 * @author wanjialiang68-byte
 * @version 1.0.0
 * @since 2024-05-25
 */
@Data
@Entity
@Table(name = \"product\", indexes = {\n    @Index(name = \"idx_product_name\", columnList = \"product_name\"),\n    @Index(name = \"idx_category\", columnList = \"category\"),\n    @Index(name = \"idx_status\", columnList = \"status\")\n})\n@TableName(\"product\")\n@Builder\n@NoArgsConstructor\n@AllArgsConstructor\npublic class Product implements Serializable {\n\n    private static final long serialVersionUID = 1L;\n\n    /**\n     * 商品ID\n     * 自增主键\n     */\n    @Id\n    @GeneratedValue(strategy = GenerationType.IDENTITY)\n    @TableId(type = IdType.AUTO)\n    private Long id;\n\n    /**\n     * 商品名称\n     * 非空，最长200字符\n     */\n    @Column(nullable = false, length = 200)\n    private String productName;\n\n    /**\n     * 商品分类\n     * 如：电子、服装、食品等\n     */\n    @Column(length = 100)\n    private String category;\n\n    /**\n     * 商品描述\n     */\n    @Column(columnDefinition = \"TEXT\")\n    private String description;\n\n    /**\n     * 商品价格\n     * 精度：两位小数\n     */\n    @Column(nullable = false, precision = 12, scale = 2)\n    private BigDecimal price;\n\n    /**\n     * 商品库存\n     * 非负整数\n     */\n    @Column(nullable = false, columnDefinition = \"INT DEFAULT 0\")\n    private Integer stock;\n\n    /**\n     * 已售数量\n     */\n    @Column(columnDefinition = \"INT DEFAULT 0\")\n    private Integer sold;\n\n    /**\n     * 商品状态\n     * 0 - 下架\n     * 1 - 上架\n     */\n    @Column(nullable = false, columnDefinition = \"TINYINT(1) DEFAULT 1\")\n    private Integer status;\n\n    /**\n     * 商品图片URL\n     */\n    @Column(length = 500)\n    private String imageUrl;\n\n    /**\n     * SKU（库存单位）\n     */\n    @Column(length = 100)\n    private String sku;\n\n    /**\n     * 商品品牌\n     */\n    @Column(length = 100)\n    private String brand;\n\n    /**\n     * 创建时间\n     * 自动生成\n     */\n    @CreationTimestamp\n    @Column(updatable = false)\n    private LocalDateTime createTime;\n\n    /**\n     * 更新时间\n     * 自动更新\n     */\n    @UpdateTimestamp\n    private LocalDateTime updateTime;\n}\n