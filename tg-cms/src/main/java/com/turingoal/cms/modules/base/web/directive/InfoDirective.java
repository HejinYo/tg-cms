package com.turingoal.cms.modules.base.web.directive;

import java.util.List;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.common.bean.PageGridBean;

/**
 * InfoDirective
 */
public interface InfoDirective {

    /**
     * 获取文章列表信息
     * 
     * @param nodeCode
     *            栏目名称
     * @param attrCode
     *            属性名称
     * @param withImage
     *            是否包含图片；1：是，2：否
     * @param limit
     *            显示条数
     * @return 返回文章列表
     */
    List<Info> topByNode(final String nodeCode, final String attrCode, final Integer withImage, final Long limit);

    /**
     * 获取文章列表信息
     * 
     * @param tagId
     *            标签id
     * @param attrCode
     *            属性名称
     * @param withImage
     *            是否包含图片；1：是，2：否
     * @param limit
     *            显示条数
     * @return 返回文章列表
     */
    List<Info> topByTag(final String tagId, final String attrCode, final Integer withImage, final Long limit);

    /**
     * 根据id获取一篇文章
     * 
     * @param id
     *            文章id
     * @return 返回文章信息
     */
    Info getById(final String id);

    /**
     * 分页获取文章列表信息
     * 
     * @param nodeCode
     *            专题编码
     * @param attrCode
     *            属性编码
     * @param page
     *            当前页
     * @param withImage
     *            是否包含图片；1：是，2：否
     * @param pageSize
     *            每页显示条数
     * @return 返回分页文章信息集
     */
    PageGridBean pageListByNode(final String nodeCode, final String attrCode, final Integer withImage, final Long page, final Long pageSize);

    /**
     * 分页获取文章列表信息
     * 
     * @param specialId
     *            专题id
     * @param attrCode
     *            属性编码
     * @param page
     *            当前页
     * @param withImage
     *            是否包含图片；1：是，2：否
     * @param pageSize
     *            每页显示条数
     * @return 返回分页文章信息集
     */
    PageGridBean pageListBySpecial(final String specialId, final String attrCode, final Integer withImage, final Long page, final Long pageSize);

    /**
     * 分页获取文章列表信息
     * 
     * @param tagId
     *            标签id
     * @param attrCode
     *            属性编码
     * @param withImage
     *            是否包含图片；1：是，2：否
     * @param page
     *            当前页
     * @param pageSize
     *            每页显示条数
     * @return 返回分页文章信息集
     */
    PageGridBean pageListByTag(final String tagId, final String attrCode, final Integer withImage, final Long page, final Long pageSize);

    /**
     * 根据id获取上一篇文章
     * 
     * @param id
     *            文章id
     * @return 返回文章信息
     */
    Info prevOne(final String id);

    /**
     * 根据id获取下一篇文章
     * 
     * @param id
     *            文章id
     * @return 返回问章信息
     */
    Info nextOne(final String id);

    /**
     * 根据图片id获取图片地址
     * 
     * @param id
     * @return
     */
    String getImgById(final String id);

    /**
     * 根据id获取文件
     * 
     * @param id
     * @return
     */
    String getFileById(final String id);

    /**
     * 根据图片ids获取多张图片地址
     * 
     * @param id
     * @return
     */
    List<String> findImgsByIds(final String id);

    /**
     * getVideoById
     */
    String getVideoById(final String id);

    /**
     * getDocById
     */
    String getDocById(final String id);

    /**
     * 根据nodecode获取第一篇文章
     * 
     * @param nodeCode
     * @return
     */
    Info getFirstByNode(final String nodeCode);
}