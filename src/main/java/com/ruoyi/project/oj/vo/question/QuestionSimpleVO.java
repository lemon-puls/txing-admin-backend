package com.ruoyi.project.oj.vo.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhiwei
 * @date 2024/4/7 23:05
 * 注释：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionSimpleVO {
    /** id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /** 名称 */
    private String title;
}
