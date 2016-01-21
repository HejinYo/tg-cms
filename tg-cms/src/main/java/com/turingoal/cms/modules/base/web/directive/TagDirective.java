package com.turingoal.cms.modules.base.web.directive;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Tag;

/**
 * 标签Directive
 */
public interface TagDirective {
    /**
     * 获取标签
     * 
     * @param refers
     *            文档数量
     * @param limit
     *            查询条数
     * @return 返回标签列表
     */
    List<Tag> list(final Integer refers, final Long limit);
}