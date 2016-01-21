package com.turingoal.cms.core.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.turingoal.cms.core.domain.MonitorSysinfo;
import com.turingoal.cms.core.service.MonitorSysinfoService;

/**
 * 系统信息
 */
@Service
public class MonitorSysinfoServiceImpl implements MonitorSysinfoService {

    /**
     * 获得硬盘总空间
     */
    public long getHdTotal() {
        long totalSize = 0L;
        File[] roots = File.listRoots(); // 获取磁盘分区列表
        for (File file : roots) {
            totalSize += file.getTotalSpace();
        }
        return totalSize / 1024 / 1024 / 1024;
    }

    /**
     * 获得硬盘剩余空间
     */
    public long getHdFreeTotal() {
        long totalSize = 0L;
        File[] roots = File.listRoots(); // 获取磁盘分区列表
        for (File file : roots) {
            totalSize += file.getFreeSpace();
        }
        return totalSize / 1024 / 1024 / 1024;
    }

    /**
     * 系统信息
     */
    public List<MonitorSysinfo> getInfo(final HttpServletRequest request) {
        Properties p = System.getProperties();
        ServletContext servletContext = request.getSession(false).getServletContext();
        List<MonitorSysinfo> list = new ArrayList<MonitorSysinfo>();
        // 服务器相关参数
        list.add(new MonitorSysinfo("服务器相关参数", "服务器名称", request.getServerName()));
        list.add(new MonitorSysinfo("服务器相关参数", "服务器IP", request.getLocalAddr()));
        list.add(new MonitorSysinfo("服务器相关参数", "服务器端口", String.valueOf(request.getServerPort())));
        list.add(new MonitorSysinfo("服务器相关参数", "服务器操作系统", p.getProperty("os.name") + "( 版本：" + p.getProperty("os.version") + ")"));
        list.add(new MonitorSysinfo("服务器相关参数", "操作系统类型", p.getProperty("os.arch")));
        // list.add(new Sysinfo("服务器相关参数", "操作系统类型", p.getProperty("os.arch"))); os.getAvailableProcessors()
        list.add(new MonitorSysinfo("服务器相关参数", "操作系统模式", p.getProperty("sun.arch.data.model") + "位"));
        list.add(new MonitorSysinfo("服务器相关参数", "服务器所在地区", p.getProperty("user.country")));
        list.add(new MonitorSysinfo("服务器相关参数", "服务器语言", p.getProperty("user.language")));
        list.add(new MonitorSysinfo("服务器相关参数", "服务器时区", p.getProperty("user.timezone")));

        list.add(new MonitorSysinfo("服务器相关参数", "当前用户", p.getProperty("user.name")));
        list.add(new MonitorSysinfo("服务器相关参数", "用户目录", p.getProperty("user.dir")));
        list.add(new MonitorSysinfo("服务器相关参数", "应用服务器", servletContext.getServerInfo()));
        list.add(new MonitorSysinfo("服务器相关参数", "WEB根路径", servletContext.getRealPath("/")));
        list.add(new MonitorSysinfo("服务器相关参数", "Servlet版本", servletContext.getMajorVersion() + "." + servletContext.getMinorVersion()));

        list.add(new MonitorSysinfo("服务器相关参数", "硬盘总空间", getHdTotal() + " G"));
        list.add(new MonitorSysinfo("服务器相关参数", "硬盘剩余空间", getHdFreeTotal() + " G"));

        // 系统JAVA相关参数
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA运行环境", p.getProperty("java.runtime.name")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA运行环境版本", p.getProperty("java.runtime.version")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA运行环境说明书", p.getProperty("java.specification.name")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA运行环境说明书版本", p.getProperty("java.specification.version")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA虚拟机名称", p.getProperty("java.vm.name")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA虚拟机版本", p.getProperty("java.vm.version")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA虚拟机说明书", p.getProperty("java.vm.specification.name")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA虚拟机说明书版本", p.getProperty("java.vm.specification.version")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA虚拟机安装路径", p.getProperty("java.home")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA虚拟机分配内存", String.valueOf(Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M")));
        list.add(new MonitorSysinfo("系统JAVA相关参数", "JAVA虚拟机剩余内存", String.valueOf(Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M")));
        // 客户端相关参数
        list.add(new MonitorSysinfo("客户端相关参数", "客户端名称", request.getRemoteHost()));
        list.add(new MonitorSysinfo("客户端相关参数", "客户端IP", request.getRemoteAddr()));
        list.add(new MonitorSysinfo("客户端相关参数", "客户端端口", String.valueOf(request.getRemotePort())));
        list.add(new MonitorSysinfo("客户端相关参数", "客户端信息", request.getHeader("user-agent")));
        return list;
    }

    @Override
    public Map<String, Object> getDiskInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        long total = getHdTotal();
        long freeTotal = getHdFreeTotal();
        map.put("total", total);
        map.put("free", freeTotal);
        map.put("residue", total - freeTotal);
        return map;
    }

    @Override
    public Map<String, Object> getMemoryInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        long total = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long freeTotal = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        map.put("total", total);
        map.put("free", freeTotal);
        map.put("residue", total - freeTotal);
        return map;
    }
}
