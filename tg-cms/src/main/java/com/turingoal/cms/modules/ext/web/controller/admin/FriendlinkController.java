package com.turingoal.cms.modules.ext.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Friendlink;
import com.turingoal.cms.modules.ext.domain.FriendlinkType;
import com.turingoal.cms.modules.ext.domain.form.FriendlinkForm;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkQuery;
import com.turingoal.cms.modules.ext.domain.query.FriendlinkTypeQuery;
import com.turingoal.cms.modules.ext.service.FriendlinkService;
import com.turingoal.cms.modules.ext.service.FriendlinkTypeService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 友情链接Controller
 */
@Controller
@RequestMapping("/m/ext/friendlink")
public class FriendlinkController {

    private static final String LIST_PAGE = "modules/content/friendlink/list";
    private static final String ADD_PAGE = "modules/content/friendlink/add";
    private static final String EDIT_PAGE = "modules/content/friendlink/edit";

    @Autowired
    private FriendlinkService friendlinkService;
    @Autowired
    private FriendlinkTypeService friendlinkTypeService;

    /**
     * 返回友情链接查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        FriendlinkQuery query = new FriendlinkQuery();
        mav.addObject("friendlink", friendlinkService.find(query));
        return mav;
    }

    /**
     * 返回友情链接查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final FriendlinkQuery query) throws BusinessException {
        Page<Friendlink> result = friendlinkService.find(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 返回友情链接新增界面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView(ADD_PAGE);
        FriendlinkTypeQuery friendlinkTypeQuery = new FriendlinkTypeQuery();
        List<FriendlinkType> friendlinkType = friendlinkTypeService.findAll(friendlinkTypeQuery);
        mav.addObject("result", friendlinkType);
        return mav;
    }

    /**
     * 新增友情链接
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final FriendlinkForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            friendlinkService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 通过id得到一个 友情链接
     */
    @RequestMapping(value = "/get.gsp")
    @ResponseBody
    public Object get(@PathVariable("id") final String id) throws BusinessException {
        return friendlinkService.get(id);
    }

    /**
     * 返回友情链接修改界面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", friendlinkService.get(id));
        FriendlinkTypeQuery friendlinkTypeQuery = new FriendlinkTypeQuery();
        List<FriendlinkType> friendlinkType = friendlinkTypeService.findAll(friendlinkTypeQuery);
        mav.addObject("friendlinkType", friendlinkType);
        return mav;
    }

    /**
     * 返回友情链接修改界面
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final FriendlinkForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            friendlinkService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 友情链接
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        friendlinkService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 友情链接
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        friendlinkService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 友情链接
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        friendlinkService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id推荐 友情链接 修改推荐状态
     */
    @RequestMapping(value = "/changeRecommend.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean changeRecommend(final FriendlinkForm form) throws BusinessException {
        friendlinkService.changeRecommend(form);
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