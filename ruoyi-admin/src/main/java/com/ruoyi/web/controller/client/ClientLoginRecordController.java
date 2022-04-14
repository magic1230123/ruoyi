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
import com.ruoyi.client.domain.ClientLoginRecord;
import com.ruoyi.client.service.IClientLoginRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 登录记录Controller
 *
 * @author magic
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/client/loginRecord")
public class ClientLoginRecordController extends BaseController
{
    @Autowired
    private IClientLoginRecordService clientLoginRecordService;

    /**
     * 查询登录记录列表
     */
    @PreAuthorize("@ss.hasPermi('client:loginRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClientLoginRecord clientLoginRecord)
    {
        startPage();
        List<ClientLoginRecord> list = clientLoginRecordService.selectClientLoginRecordList(clientLoginRecord);
        return getDataTable(list);
    }

    /**
     * 导出登录记录列表
     */
    @PreAuthorize("@ss.hasPermi('client:loginRecord:export')")
    @Log(title = "登录记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClientLoginRecord clientLoginRecord)
    {
        List<ClientLoginRecord> list = clientLoginRecordService.selectClientLoginRecordList(clientLoginRecord);
        ExcelUtil<ClientLoginRecord> util = new ExcelUtil<ClientLoginRecord>(ClientLoginRecord.class);
        util.exportExcel(response, list, "登录记录数据");
    }

    /**
     * 获取登录记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('client:loginRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(clientLoginRecordService.selectClientLoginRecordById(id));
    }

    /**
     * 新增登录记录
     */
    @PreAuthorize("@ss.hasPermi('client:loginRecord:add')")
    @Log(title = "登录记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClientLoginRecord clientLoginRecord)
    {
        return toAjax(clientLoginRecordService.insertClientLoginRecord(clientLoginRecord));
    }

    /**
     * 修改登录记录
     */
    @PreAuthorize("@ss.hasPermi('client:loginRecord:edit')")
    @Log(title = "登录记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClientLoginRecord clientLoginRecord)
    {
        return toAjax(clientLoginRecordService.updateClientLoginRecord(clientLoginRecord));
    }

    /**
     * 删除登录记录
     */
    @PreAuthorize("@ss.hasPermi('client:loginRecord:remove')")
    @Log(title = "登录记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(clientLoginRecordService.deleteClientLoginRecordByIds(ids));
    }
}
