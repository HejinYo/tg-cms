package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.CmsImage;
import com.turingoal.cms.modules.base.domain.form.CmsImageForm;
import com.turingoal.cms.modules.base.domain.query.CmsImageQuery;

/**
 * ImageDao
 */
public interface CmsImageDao {

    /**
     * 查询 Image
     */
    List<CmsImage> find(final CmsImageQuery query);

    /**
     * 通过id得到一个 Image
     */
    CmsImage get(final String id);

    /**
     * 通过ids得到 Image
     */
    List<CmsImage> findByIds(final String[] ids);

    /**
     * 新增 Image
     */
    void add(final CmsImageForm form);

    /**
     * 修改 Image
     */
    int update(final CmsImageForm form);

    /**
     * 根据id删除一个 Image
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据md5查找图片
     * 
     * @param md5
     * @return
     */
    List<CmsImageForm> getByMd5(String md5);
    
    /**
     * 获取所有文件的格式
     */
    List<CmsImage> findFormat();
}