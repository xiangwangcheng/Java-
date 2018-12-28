package com.study.conditionalonmissingbean;

import com.study.cxw.service.DepartmentService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

/**
 * @author chengxiangwang
 * @create 2018/12/19
 */
@Component
@ConditionalOnMissingBean(DepartmentService.class)
public class ClassWIthComponent {

    private String attr;

    public ClassWIthComponent() {
    }

    public ClassWIthComponent(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }
}

