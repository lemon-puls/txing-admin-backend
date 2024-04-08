package com.ruoyi.project.oj.vo.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseVideoVO {
    /**
     * id
     */
    private Long id;

    /**
     * 课程总表记录id
     */
    private Long courseId;
    /**
     * 名称
     */
    private String name;
    /**
     * 序号
     */
    private Integer orderNo;
    /**
     * 时长
     */
    private Long times;
    /**
     * 封面URL
     */
    private String coverUrl;
    /**
     * 视频URL
     */
    private String videoUrl;
    /**
     * fileId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long fileId;

}
