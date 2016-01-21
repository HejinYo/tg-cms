package com.turingoal.cms.core.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.turingoal.cms.core.domain.Dict;
import com.turingoal.cms.core.domain.form.DictForm;
import com.turingoal.cms.core.domain.query.DictQuery;

/**
 * 数据字典Dao
 */
public interface DictDao {

    /**
     * 根据字典类型查询启用的数据字典
     */
    List<Dict> findEnabledByType(final String dictType);

    /**
     * 查询 数据字典
     */
    List<Dict> find(final DictQuery query);

    /**
     * 通过id得到一个 数据字典
     */
    Dict get(final String id);

    /**
     * 新增 数据字典
     */
    void add(final DictForm form);

    /**
     * 修改 数据字典
     */
    int update(final DictForm form);

    /**
     * 根据id删除一个 数据字典
     */
    int delete(final String id);

    /**
     * 修改是否可用
     */
    int changeEnabled(@Param("id") final String id, @Param("enabled") final Integer enabled);

    /**
     * 检测数据是否可编辑
     */
    int checkEditable(final String id);
}