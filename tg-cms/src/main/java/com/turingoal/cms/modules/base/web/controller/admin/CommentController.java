package com.turingoal.cms.modules.base.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Comment;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.cms.modules.base.domain.form.CommentForm;
import com.turingoal.cms.modules.base.domain.query.CommentQuery;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;
import com.turingoal.cms.modules.base.domain.query.SpecialQuery;
import com.turingoal.cms.modules.base.service.CommentService;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.cms.modules.base.service.SpecialService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 评论Controller
 */
@Controller
@RequestMapping("/m/base/comment")
public class CommentController {
    private static final String LIST_PAGE = "modules/content/comment/list";
    // private static final String ADD_PAGE = "modules/content/comment/add";
    // private static final String EDIT_PAGE = "modules/content/comment/edit";

    @Autowired
    private CommentService commentService;
    @Autowired
    private NodeService nodeService;
    @Autowired
    private SpecialService specialService;

    /**
     * 评论列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        NodeQuery query = new NodeQuery();
        query.setLimit(null);
        mav.addObject("nodeTree", nodeService.getNodeTreeGird(query));
        return mav;
    }

    /**
     * 分页查询 文章
     */
    @RequestMapping(value = "/specialList.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean findByPage(final SpecialQuery query) throws BusinessException {
        Page<Special> result = specialService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 查询全部 Node栏目树
     */
    @RequestMapping(value = "/treeView.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean getNodeTreeGird() throws BusinessException {
        NodeQuery query = new NodeQuery();
        query.setLimit(null);
        return new JsonResultBean(nodeService.getNodeTreeGird(query));
    }

    /**
     * 分页查询 评论
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean findByPage(final CommentQuery query) throws BusinessException {
        Page<Comment> result = commentService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个 评论
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public final Comment get(@RequestParam("id") final String id) throws BusinessException {
        return commentService.get(id);
    }

    /**
     * 根据id删除 评论
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        commentService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 修改Comment
     */
    @RequestMapping(value = "/update")
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final CommentForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            commentService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id启用 评论
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        commentService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 评论
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        commentService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id屏蔽 评论
     */
    @RequestMapping(value = "/shield")
    @ResponseBody
    public final JsonResultBean shieldById(@RequestParam("id") final String id) throws BusinessException {
        commentService.shieldById(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id推荐 评论
     */
    @RequestMapping(value = "/recommend")
    @ResponseBody
    public final JsonResultBean recommendById(@RequestParam("id") final String id) throws BusinessException {
        commentService.recommendById(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantDateFormatTypes.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}