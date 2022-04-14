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
import com.ruoyi.client.domain.ClientRequestRecord;
import com.ruoyi.client.service.IClientRequestRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 请求记录
Controller
 *
 * @author magic
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/client/requestUrl")
public class ClientRequestRecordController extends BaseController
{
    @Autowired
    private IClientRequestRecordService clientRequestRecordService;

    /**
     * 查询请求记录列表
     */
    @PreAuthorize("@ss.hasPermi('client:requestUrl:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClientRequestRecord clientRequestRecord)
    {
        startPage();
        List<ClientRequestRecord> list = clientRequestRecordService.selectClientRequestRecordList(clientRequestRecord);
        return getDataTable(list);
    }

    /**
     * 导出请求记录列表
     */
    @PreAuthorize("@ss.hasPermi('client:requestUrl:export')")
    @Log(title = "请求记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClientRequestRecord clientRequestRecord)
    {
        List<ClientRequestRecord> list = clientRequestRecordService.selectClientRequestRecordList(clientRequestRecord);
        ExcelUtil<ClientRequestRecord> util = new ExcelUtil<ClientRequestRecord>(ClientRequestRecord.class);
        util.exportExcel(response, list, "请求记录数据");
    }

    /**
     * 获取请求记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('client:requestUrl:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(clientRequestRecordService.selectClientRequestRecordById(id));
    }

    /**
     * 新增请求记录

     */
    @PreAuthorize("@ss.hasPermi('client:requestUrl:add')")
    @Log(title = "请求记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClientRequestRecord clientRequestRecord)
    {
        return toAjax(clientRequestRecordService.insertClientRequestRecord(clientRequestRecord));
    }

    /**
     * 修改请求记录
     */
    @PreAuthorize("@ss.hasPermi('client:requestUrl:edit')")
    @Log(title = "请求记录 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClientRequestRecord clientRequestRecord)
    {
        return toAjax(clientRequestRecordService.updateClientRequestRecord(clientRequestRecord));
    }

    /**
     * 删除请求记录
     */
    @PreAuthorize("@ss.hasPermi('client:requestUrl:remove')")
    @Log(title = "请求记录 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(clientRequestRecordService.deleteClientRequestRecordByIds(ids));
    }
}
