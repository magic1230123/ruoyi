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
import com.ruoyi.client.domain.ClientBusiness;
import com.ruoyi.client.service.IClientBusinessService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 经营报表Controller
 *
 * @author magic
 * @date 2022-04-21
 */
@RestController
@RequestMapping("/client/business")
public class ClientBusinessController extends BaseController
{
    @Autowired
    private IClientBusinessService clientBusinessService;

    /**
     * 查询经营报表列表
     */
    @PreAuthorize("@ss.hasPermi('client:business:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClientBusiness clientBusiness)
    {
        startPage();
        List<ClientBusiness> list = clientBusinessService.selectClientBusinessList(clientBusiness);
        return getDataTable(list);
    }

    /**
     * 导出经营报表列表
     */
    @PreAuthorize("@ss.hasPermi('client:business:export')")
    @Log(title = "经营报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClientBusiness clientBusiness)
    {
        List<ClientBusiness> list = clientBusinessService.selectClientBusinessList(clientBusiness);
        ExcelUtil<ClientBusiness> util = new ExcelUtil<ClientBusiness>(ClientBusiness.class);
        util.exportExcel(response, list, "经营报表数据");
    }

    /**
     * 获取经营报表详细信息
     */
    @PreAuthorize("@ss.hasPermi('client:business:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(clientBusinessService.selectClientBusinessById(id));
    }

    /**
     * 新增经营报表
     */
    @PreAuthorize("@ss.hasPermi('client:business:add')")
    @Log(title = "经营报表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClientBusiness clientBusiness)
    {
        return toAjax(clientBusinessService.insertClientBusiness(clientBusiness));
    }

    /**
     * 修改经营报表
     */
    @PreAuthorize("@ss.hasPermi('client:business:edit')")
    @Log(title = "经营报表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClientBusiness clientBusiness)
    {
        return toAjax(clientBusinessService.updateClientBusiness(clientBusiness));
    }

    /**
     * 删除经营报表
     */
    @PreAuthorize("@ss.hasPermi('client:business:remove')")
    @Log(title = "经营报表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(clientBusinessService.deleteClientBusinessByIds(ids));
    }
}
