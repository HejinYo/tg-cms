package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.form.NodeForm;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;

/**
 * NodeDao 
 */
public interface NodeDao {
    
    /**
     * 查询 Node
     */
    List<Node> find(final NodeQuery query);

    /**
     * 通过id得到一个 Node
     */
    Node get(final String id);
    
    /**
     * 通过codeNum得到一个 Node
     */
    Node getByCode(final NodeQuery query);
    
    /**
     * 新增 Node
     */
    void add(final NodeForm form);

    /**
     * 修改 Node
     */
    int update(final NodeForm form);
    
    /**
     * 根据id删除一个 Node
     */
    int delete(final String id);
    
    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}