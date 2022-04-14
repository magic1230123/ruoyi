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
import com.ruoyi.client.domain.ClientProduct;
import com.ruoyi.client.service.IClientProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品Controller
 *
 * @author magic
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/client/product")
public class ClientProductController extends BaseController
{
    @Autowired
    private IClientProductService clientProductService;

    /**
     * 查询产品列表
     */
    @PreAuthorize("@ss.hasPermi('client:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClientProduct clientProduct)
    {
        startPage();
        List<ClientProduct> list = clientProductService.selectClientProductList(clientProduct);
        return getDataTable(list);
    }

    /**
     * 导出产品列表
     */
    @PreAuthorize("@ss.hasPermi('client:product:export')")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClientProduct clientProduct)
    {
        List<ClientProduct> list = clientProductService.selectClientProductList(clientProduct);
        ExcelUtil<ClientProduct> util = new ExcelUtil<ClientProduct>(ClientProduct.class);
        util.exportExcel(response, list, "产品数据");
    }

    /**
     * 获取产品详细信息
     */
    @PreAuthorize("@ss.hasPermi('client:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(clientProductService.selectClientProductById(id));
    }

    /**
     * 新增产品
     */
    @PreAuthorize("@ss.hasPermi('client:product:add')")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClientProduct clientProduct)
    {
        return toAjax(clientProductService.insertClientProduct(clientProduct));
    }

    /**
     * 修改产品
     */
    @PreAuthorize("@ss.hasPermi('client:product:edit')")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClientProduct clientProduct)
    {
        return toAjax(clientProductService.updateClientProduct(clientProduct));
    }

    /**
     * 删除产品
     */
    @PreAuthorize("@ss.hasPermi('client:product:remove')")
    @Log(title = "产品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(clientProductService.deleteClientProductByIds(ids));
    }

    /**
     * 修改产品状态
     */
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PutMapping(value ="/updateProductState")
    public AjaxResult updateProductState(@RequestBody ClientProduct clientProduct)
    {
        return toAjax(clientProductService.updateProductState(clientProduct));
    }
}
