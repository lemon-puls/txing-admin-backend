package com.ruoyi.project.oj.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhiwei
 * @date 2024/4/5 19:36
 * 注释：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudgeConfig {
    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（KB）
     */
    private Long memoryLimit;
}
