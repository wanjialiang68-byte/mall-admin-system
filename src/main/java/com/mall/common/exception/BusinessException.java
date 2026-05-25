package com.mall.common.exception;

/**
 * 业务异常类
 * 
 * 用于处理业务逻辑中的异常情况
 * 提供自定义的错误代码和错误消息
 * 
 * @author wanjialiang68-byte
 * @version 1.0.0
 * @since 2024-05-25
 */
public class BusinessException extends RuntimeException {\n\n    private static final long serialVersionUID = 1L;\n\n    /**\n     * 错误代码\n     */\n    private int code;\n\n    /**\n     * 错误消息\n     */\n    private String message;\n\n    /**\n     * 构造函数\n     */\n    public BusinessException() {\n        super();\n        this.code = 500;\n        this.message = \"业务异常\";\n    }\n\n    /**\n     * 构造函数\n     * \n     * @param message 错误消息\n     */\n    public BusinessException(String message) {\n        super(message);\n        this.code = 500;\n        this.message = message;\n    }\n\n    /**\n     * 构造函数\n     * \n     * @param code 错误代码\n     * @param message 错误消息\n     */\n    public BusinessException(int code, String message) {\n        super(message);\n        this.code = code;\n        this.message = message;\n    }\n\n    /**\n     * 构造函数\n     * \n     * @param message 错误消息\n     * @param cause 异常原因\n     */\n    public BusinessException(String message, Throwable cause) {\n        super(message, cause);\n        this.code = 500;\n        this.message = message;\n    }\n\n    /**\n     * 构造函数\n     * \n     * @param code 错误代码\n     * @param message 错误消息\n     * @param cause 异常原因\n     */\n    public BusinessException(int code, String message, Throwable cause) {\n        super(message, cause);\n        this.code = code;\n        this.message = message;\n    }\n\n    // Getter and Setter methods\n    public int getCode() {\n        return code;\n    }\n\n    public void setCode(int code) {\n        this.code = code;\n    }\n\n    @Override\n    public String getMessage() {\n        return message;\n    }\n\n    public void setMessage(String message) {\n        this.message = message;\n    }\n}\n