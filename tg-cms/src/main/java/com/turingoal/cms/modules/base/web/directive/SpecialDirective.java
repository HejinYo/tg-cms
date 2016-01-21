package com.turingoal.cms.modules.base.web.directive;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.common.bean.PageGridBean;

/**
 * SpecialDirective
 */
public interface SpecialDirective {

    /**
     * 获取专题列表信息
     * 
     * @param typeId
     *            专题类别id
     * @param withImage
     *            是否包含图片；1：是，2：否
     * @param recommend
     *            是否推荐；1：是，2：否
     * @param limit
     *            显示条数
     * @return 返回专题列表集
     */
    List<Special> top(final String typeId, final Integer withImage, final Integer recommend, final Long limit);

    /**
     * 根据id获取一个专题
     * 
     * @param id
     *            专题id
     * @return 返回专题信息
     */
    Special getById(final String id);

    /**
     * 分页获取专题列表信息
     * 
     * @param typeId
     *            专题类别id
     * @param withImage
     *            是否包含图片；1：是，2：否
     * @param recommend
     *            是否推荐；1：是，2：否
     * @param page
     *            当前页
     * @param pageSize
     *            每页显示条数
     * @return 返回分页专题信息集
     */
    PageGridBean pageList(final String typeId, final Integer withImage, final Integer recommend, final Long page, final Long pageSize);
}