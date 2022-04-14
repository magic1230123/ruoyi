package com.ruoyi.web.controller.client;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.client.domain.ClientConfig;
import com.ruoyi.client.service.IClientConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 配置Controller
 *
 * @author magic
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/client/config")
public class ClientConfigController extends BaseController
{
    @Autowired
    private IClientConfigService clientConfigService;

    /**
     * 查询配置列表
     */
    @PreAuthorize("@ss.hasPermi('client:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClientConfig clientConfig)
    {
        startPage();
        List<ClientConfig> list = clientConfigService.selectClientConfigList(clientConfig);
        return getDataTable(list);
    }

    /**
     * 导出配置列表
     */
    @PreAuthorize("@ss.hasPermi('client:config:export')")
    @Log(title = "配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClientConfig clientConfig)
    {
        List<ClientConfig> list = clientConfigService.selectClientConfigList(clientConfig);
        ExcelUtil<ClientConfig> util = new ExcelUtil<ClientConfig>(ClientConfig.class);
        util.exportExcel(response, list, "配置数据");
    }

    /**
     * 获取配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('client:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(clientConfigService.selectClientConfigById(id));
    }

    /**
     * 新增配置
     */
    @PreAuthorize("@ss.hasPermi('client:config:add')")
    @Log(title = "配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClientConfig clientConfig)
    {
        return toAjax(clientConfigService.insertClientConfig(clientConfig));
    }

    /**
     * 修改配置
     */
    @PreAuthorize("@ss.hasPermi('client:config:edit')")
    @Log(title = "配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClientConfig clientConfig)
    {
        return toAjax(clientConfigService.updateClientConfig(clientConfig));
    }

    /**
     * 删除配置
     */
    @PreAuthorize("@ss.hasPermi('client:config:remove')")
    @Log(title = "配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(clientConfigService.deleteClientConfigByIds(ids));
    }
}
