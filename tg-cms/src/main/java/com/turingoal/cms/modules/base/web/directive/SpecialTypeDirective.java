package com.turingoal.cms.modules.base.web.directive;

import java.util.List;
import com.turingoal.cms.modules.base.domain.SpecialType;

/**
 * SpecialTypeDirective
 */
public interface SpecialTypeDirective {

    /**
     * 获取专题类别列表信息
     * 
     * @return 返回专题列表集合
     */
    List<SpecialType> list();
}