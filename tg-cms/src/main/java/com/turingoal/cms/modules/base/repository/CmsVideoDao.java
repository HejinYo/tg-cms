package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.CmsVideo;
import com.turingoal.cms.modules.base.domain.form.CmsVideoForm;
import com.turingoal.cms.modules.base.domain.query.CmsVideoQuery;

/**
 * CmsVideoDao
 */
public interface CmsVideoDao {

    /**
     * 查询 CmsVideo
     */
    List<CmsVideo> find(final CmsVideoQuery query);

    /**
     * 通过id得到一个 CmsVideo
     */
    CmsVideo get(final String id);

    /**
     * 新增 CmsVideo
     */
    void add(final CmsVideoForm form);

    /**
     * 修改 CmsVideo
     */
    int update(final CmsVideoForm form);

    /**
     * 根据id删除一个 CmsVideo
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据md5获取
     */
    CmsVideoForm getByMd5(String md5str);

    /**
     * 获取所有文件的格式
     */
    List<CmsVideo> findFormat();

    /**
     * 根据ids获取
     */
    List<CmsVideo> findByIds(String[] str);
}