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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Vote;
import com.turingoal.cms.modules.ext.domain.VoteOption;
import com.turingoal.cms.modules.ext.domain.form.VoteForm;
import com.turingoal.cms.modules.ext.domain.form.VoteOptionForm;
import com.turingoal.cms.modules.ext.domain.query.VoteOptionQuery;
import com.turingoal.cms.modules.ext.domain.query.VoteQuery;
import com.turingoal.cms.modules.ext.service.VoteService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 投票Controller
 */
@Controller
@RequestMapping("/m/ext/vote")
public class VoteController {
    private static final String LIST_PAGE = "modules/content/vote/list";
    private static final String ADD_PAGE = "modules/content/vote/add";
    private static final String EDIT_PAGE = "modules/content/vote/edit";
    private static final String EDIT_OPTION_PAGE = "modules/content/vote/optionEdit";
    private static final String ADD_OPTION_PAGE = "modules/content/vote/optionAdd";

    @Autowired
    private VoteService voteService;

    /**
     * 返回投票信息查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 返回投票信息查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final VoteQuery query) throws BusinessException {
        Page<Vote> result = voteService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个投票信息
     */
    @RequestMapping(value = "/get.gsp")
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return voteService.get(id);
    }

    /**
     * 返回投票信息新增界面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增投票信息
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final VoteForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            voteService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 返回投票信息修改界面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", voteService.get(id));
        return mav;
    }

    /**
     * 修改投票信息
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final VoteForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            voteService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除投票信息
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        voteService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 返回投票信息查询信息
     */
    @RequestMapping(value = "/OptionList_{voteId}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean optionList(final VoteOptionQuery query) throws BusinessException {
        List<VoteOption> result = voteService.findOption(query);
        return new PageGridBean(result);
    }

    /**
     * 修改 VoteOption
     */
    @RequestMapping(value = "/updateOption")
    public final JsonResultBean updateOption(final VoteOptionForm form) throws BusinessException {
        // 数据校验
        voteService.updateOption(form);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 查询根据投票id查询投票选项
     */
    @RequestMapping(value = "/findOption")
    public Object findOption(final VoteOptionQuery query) throws BusinessException {
        return voteService.findAllOption(query);
    }

    /**
     * 返回投票选项信息新增界面
     */
    @RequestMapping(value = "/addOption_{voteId}.gsp", method = RequestMethod.GET)
    public ModelAndView addOptionPage(@PathVariable("voteId") final String voteId) {
        ModelAndView mav = new ModelAndView(ADD_OPTION_PAGE);
        mav.addObject("voteId", voteId);
        return mav;
    }

    /**
     * 新增投票选项信息
     */
    @RequestMapping(value = "/addOption.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean addOption(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final VoteOptionForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            voteService.addOption(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 返回投票选项信息修改界面
     */
    @RequestMapping(value = "/editOption_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editOptionPage(final VoteOptionQuery query) {
        ModelAndView mav = new ModelAndView(EDIT_OPTION_PAGE);
        mav.addObject("result", voteService.getOption(query.getId()));
        return mav;
    }

    /**
     * 修改投票信息
     */
    @RequestMapping(value = "/editOption.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final VoteOptionForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            voteService.updateOption(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除投票选项信息
     */
    @RequestMapping(value = "/deleteOption_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteOption(@PathVariable("id") final String id) throws BusinessException {
        voteService.deleteOption(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 投票
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        voteService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用投票
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        voteService.disable(id);
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