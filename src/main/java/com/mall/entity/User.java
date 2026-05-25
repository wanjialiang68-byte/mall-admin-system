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
import java.time.LocalDateTime;

/**
 * 用户实体类
 * 
 * 表示电商系统中的用户信息，支持用户认证和授权管理
 * 支持JPA和MyBatis Plus双重ORM框架
 * 
 * @author wanjialiang68-byte
 * @version 1.0.0
 * @since 2024-05-25
 */
@Data
@Entity
@Table(name = \"sys_user\", indexes = {\n    @Index(name = \"idx_username\", columnList = \"username\", unique = true),\n    @Index(name = \"idx_email\", columnList = \"email\", unique = true),\n    @Index(name = \"idx_status\", columnList = \"status\")\n})\n@TableName(\"sys_user\")\n@Builder\n@NoArgsConstructor\n@AllArgsConstructor\npublic class User implements Serializable {\n\n    private static final long serialVersionUID = 1L;\n\n    /**\n     * 用户ID\n     * 自增主键\n     */\n    @Id\n    @GeneratedValue(strategy = GenerationType.IDENTITY)\n    @TableId(type = IdType.AUTO)\n    private Long id;\n\n    /**\n     * 用户名\n     * 唯一，非空，最长50字符\n     * 用于登录\n     */\n    @Column(nullable = false, length = 50, unique = true)\n    private String username;\n\n    /**\n     * 密码\n     * 加密存储，最长255字符\n     */\n    @Column(nullable = false, length = 255)\n    private String password;\n\n    /**\n     * 邮箱\n     * 唯一，非空\n     */\n    @Column(nullable = false, length = 100, unique = true)\n    private String email;\n\n    /**\n     * 手机号\n     * 最长20字符\n     */\n    @Column(length = 20)\n    private String phone;\n\n    /**\n     * 真实姓名\n     */\n    @Column(length = 100)\n    private String realName;\n\n    /**\n     * 用户状态\n     * 0 - 禁用\n     * 1 - 启用\n     */\n    @Column(nullable = false, columnDefinition = \"TINYINT(1) DEFAULT 1\")\n    private Integer status;\n\n    /**\n     * 用户角色\n     * admin - 管理员\n     * seller - 卖家\n     * buyer - 买家\n     */\n    @Column(length = 50)\n    private String role;\n\n    /**\n     * 头像URL\n     */\n    @Column(length = 500)\n    private String avatarUrl;\n\n    /**\n     * 地址\n     */\n    @Column(length = 500)\n    private String address;\n\n    /**\n     * 个人简介\n     */\n    @Column(columnDefinition = \"TEXT\")\n    private String bio;\n\n    /**\n     * 创建时间\n     * 自动生成\n     */\n    @CreationTimestamp\n    @Column(updatable = false)\n    private LocalDateTime createTime;\n\n    /**\n     * 更新时间\n     * 自动更新\n     */\n    @UpdateTimestamp\n    private LocalDateTime updateTime;\n\n    /**\n     * 最后登录时间\n     */\n    @Column\n    private LocalDateTime lastLoginTime;\n}\n